package com.denfop.item.armour;

import com.denfop.Constants;
import com.denfop.IUCore;
import com.denfop.IUItem;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import ic2.api.item.IMetalArmor;
import ic2.core.IC2;
import ic2.core.Ic2Items;
import ic2.core.audio.AudioSource;
import ic2.core.audio.PositionSpec;
import ic2.core.util.StackUtil;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;

import java.util.List;

public class ItemAdvJetpack extends ItemArmor implements IElectricItem, ISpecialArmor, IMetalArmor {
    protected static AudioSource audioSource;
    private static boolean lastJetpackUsed = false;
    private final String armorName;
    private final int maxStorage;
    private final int TransferLimit;
    private final int tier;

    public ItemAdvJetpack(String internalName, int maxStorage, int TransferLimit, int tier) {
        super(ItemArmor.ArmorMaterial.DIAMOND, IC2.platform.addArmor(internalName), 1);
        this.setMaxDamage(27);
        this.setMaxStackSize(1);
        this.setNoRepair();
        this.setUnlocalizedName(internalName);
        this.armorName = internalName;
        setCreativeTab(IUCore.tabssp2);
        setMaxStackSize(1);
        this.maxStorage = maxStorage;
        this.TransferLimit = TransferLimit;
        this.tier = tier;

        GameRegistry.registerItem(this, internalName);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        String name = this.getUnlocalizedName();
        if (name != null && name.length() > 4) {
        }

        this.itemIcon = iconRegister.registerIcon(Constants.TEXTURES + ":" + name);
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        int suffix = this.armorType == 2 ? 2 : 1;
        return Constants.TEXTURES + ":textures/armor/" + this.armorName + "_" + suffix + ".png";
    }

    public String getUnlocalizedName() {
        return super.getUnlocalizedName().substring(5);
    }

    public String getUnlocalizedName(ItemStack itemStack) {
        return this.getUnlocalizedName();
    }

    public String getItemStackDisplayName(ItemStack itemStack) {
        return StatCollector.translateToLocal(this.getUnlocalizedName(itemStack) + ".name");
    }

    public double getCharge(ItemStack itemStack) {
        return ElectricItem.manager.getCharge(itemStack);
    }

    public void use(ItemStack itemStack, double amount) {
        ElectricItem.manager.discharge(itemStack, amount, 2147483647, true, false, false);
    }


    public boolean useJetpack(EntityPlayer player, boolean hoverMode) {
        ItemStack jetpack = player.inventory.armorInventory[2];
        if (this.getCharge(jetpack) <= 0.0D) {
            return false;
        } else {
            boolean electric = jetpack.getItem() != Ic2Items.jetpack.getItem();
            float power = 1.0F;
            float dropPercentage = 0.2F;
            if (electric) {
                power = 0.7F;
                dropPercentage = 0.05F;
            }

            if (this.getCharge(jetpack) / this.getMaxCharge(jetpack) <= (double) dropPercentage) {
                power = (float) ((double) power * (this.getCharge(jetpack) / (this.getMaxCharge(jetpack) * (double) dropPercentage)));
            }

            if (IC2.keyboard.isForwardKeyDown(player)) {
                float retruster = 0.15F;
                if (hoverMode) {
                    retruster = 1.0F;
                }

                if (electric) {
                    retruster += 0.15F;
                }

                float forwardpower = power * retruster * 2.0F;
                if (forwardpower > 0.0F) {
                    player.moveFlying(0.0F, 0.4F * forwardpower, 0.02F);
                }
            }

            int worldHeight = IC2.getWorldHeight(player.worldObj);
            int maxFlightHeight = electric ? (int) ((float) worldHeight / 1.28F) : worldHeight;
            double y = player.posY;
            if (y > (double) (maxFlightHeight - 25)) {
                if (y > (double) maxFlightHeight) {
                    y = maxFlightHeight;
                }

                power = (float) ((double) power * (((double) maxFlightHeight - y) / 25.0D));
            }

            double prevmotion = player.motionY;
            player.motionY = Math.min(player.motionY + (double) (power * 0.2F), 0.6000000238418579D);
            if (hoverMode) {
                float maxHoverY = 0.0F;
                if (IC2.keyboard.isJumpKeyDown(player)) {
                    if (electric) {
                        maxHoverY = 0.1F;
                    } else {
                        maxHoverY = 0.2F;
                    }
                }

                if (IC2.keyboard.isSneakKeyDown(player)) {
                    if (electric) {
                        maxHoverY = -0.1F;
                    } else {
                        maxHoverY = -0.2F;
                    }
                }

                if (player.motionY > (double) maxHoverY) {
                    player.motionY = maxHoverY;
                    if (prevmotion > player.motionY) {
                        player.motionY = prevmotion;
                    }
                }
            }

            int consume = 2;
            if (hoverMode) {
                consume = 1;
            }

            if (electric) {
                consume += 6;
            }

            if (!player.onGround) {
                this.use(jetpack, consume);
            }

            player.fallDistance = 0.0F;
            player.distanceWalkedModified = 0.0F;
            IC2.platform.resetPlayerInAirTime(player);
            return true;
        }
    }

    public boolean canProvideEnergy(ItemStack itemStack) {
        return false;
    }

    public Item getChargedItem(ItemStack itemStack) {
        return this;
    }

    public Item getEmptyItem(ItemStack itemStack) {
        return this;
    }

    public double getMaxCharge(ItemStack itemStack) {
        return maxStorage;
    }

    public int getTier(ItemStack itemStack) {
        return this.tier;
    }

    public double getTransferLimit(ItemStack itemStack) {
        return this.TransferLimit;
    }

    public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean b) {
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(final Item item, final CreativeTabs var2, final List var3) {
        final ItemStack var4 = new ItemStack(this, 1);
        ElectricItem.manager.charge(var4, 2.147483647E9, Integer.MAX_VALUE, true, false);
        var3.add(var4);
        var3.add(new ItemStack(this, 1, this.getMaxDamage()));
    }

    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        if (player.inventory.armorInventory[2] == itemStack) {
            NBTTagCompound nbtData = StackUtil.getOrCreateNbtData(itemStack);
            boolean hoverMode = nbtData.getBoolean("hoverMode");
            byte toggleTimer = nbtData.getByte("toggleTimer");
            boolean jetpackUsed = false;
            if (IC2.keyboard.isJumpKeyDown(player) && IC2.keyboard.isModeSwitchKeyDown(player) && toggleTimer == 0) {
                toggleTimer = 10;
                hoverMode = !hoverMode;
                if (IC2.platform.isSimulating()) {
                    nbtData.setBoolean("hoverMode", hoverMode);
                    if (hoverMode) {
                        IC2.platform.messagePlayer(player, "Hover Mode enabled.");
                    } else {
                        IC2.platform.messagePlayer(player, "Hover Mode disabled.");
                    }
                }
            }
            boolean jetpack;
            if (nbtData.getBoolean("jetpack")) {
                if (ElectricItem.manager.canUse(itemStack, 10) && !player.onGround) {
                    ElectricItem.manager.use(itemStack, 10, null);
                }
            }
            jetpack = nbtData.getBoolean("jetpack");
            if ((IC2.keyboard.isJumpKeyDown(player) || hoverMode) && !jetpack) {
                jetpackUsed = this.useJetpack(player, hoverMode);
            }
            if (IUCore.keyboard.isFlyModeKeyDown(player) && toggleTimer == 0 && itemStack.getItem().equals(IUItem.perjetpack)) {
                toggleTimer = 10;
                jetpack = !jetpack;
                if (IC2.platform.isSimulating()) {

                    nbtData.setBoolean("jetpack", jetpack);
                    if (jetpack) {
                        IC2.platform.messagePlayer(player, "Creative jetpack enabled.");
                        player.capabilities.isFlying = true;

                        player.capabilities.allowFlying = true;
                        player.fallDistance = 0.0F;
                        player.distanceWalkedModified = 0.0F;
                    } else {
                        IC2.platform.messagePlayer(player, "Creative jetpack disabled.");

                    }
                }
            }
            if (IC2.platform.isSimulating() && toggleTimer > 0) {
                --toggleTimer;
                nbtData.setByte("toggleTimer", toggleTimer);
            }

            if (IC2.platform.isRendering() && player == IC2.platform.getPlayerInstance()) {
                if (lastJetpackUsed != jetpackUsed) {
                    if (jetpackUsed) {
                        if (audioSource == null) {
                            audioSource = IC2.audioManager.createSource(player, PositionSpec.Backpack, "Tools/Jetpack/JetpackLoop.ogg", true, false, IC2.audioManager.getDefaultVolume());
                        }

                        if (audioSource != null) {
                            audioSource.play();
                        }
                    } else if (audioSource != null) {
                        audioSource.remove();
                        audioSource = null;
                    }

                    lastJetpackUsed = jetpackUsed;
                }

                if (audioSource != null) {
                    audioSource.updatePosition();
                }
            }

            if (jetpackUsed) {
                player.inventoryContainer.detectAndSendChanges();
            }

        }
    }

    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
        return false;
    }

    @Override
    public boolean isMetalArmor(ItemStack itemstack, EntityPlayer player) {
        return true;
    }

    public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot) {
        return new ArmorProperties(0, 0.0D, 0);
    }

    public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
        return 0;
    }

    public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {
    }

}
