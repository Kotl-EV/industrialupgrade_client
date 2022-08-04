package com.denfop.events.de_mf;

import com.brandon3055.draconicevolution.common.container.ContainerDissEnchanter;
import com.denfop.Config;
import com.denfop.IUItem;
import com.denfop.item.energy.EnergyAxe;
import com.denfop.item.energy.EnergyPickaxe;
import com.denfop.item.energy.EnergyShovel;
import com.denfop.utils.NBTData;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import ic2.core.Ic2Items;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.living.LivingEvent;
import powercrystals.minefactoryreloaded.gui.container.ContainerAutoDisenchanter;
import powercrystals.minefactoryreloaded.gui.container.ContainerAutoEnchanter;

import java.util.Map;

public class IUDEMFEventHandler {

    @SubscribeEvent
    public void onPlayerInteract(LivingEvent.LivingUpdateEvent event) {
        if (!(event.entityLiving instanceof EntityPlayer))
            return;

        EntityPlayer player = (EntityPlayer) event.entity;
        // TODO start for
        for (int i = 0; i < player.inventory.mainInventory.length; i++) {
            // TODO start Check inventory
            if (player.inventory.mainInventory[i] != null
                    && (player.inventory.mainInventory[i].getItem() == IUItem.ultDDrill
                    || player.inventory.mainInventory[i].getItem() instanceof EnergyAxe
                    || player.inventory.mainInventory[i].getItem() instanceof EnergyPickaxe
                    || player.inventory.mainInventory[i].getItem() instanceof EnergyShovel
                    || player.inventory.mainInventory[i].getItem() == Ic2Items.iridiumDrill.getItem())) {
                ItemStack input = player.inventory.mainInventory[i];
                NBTTagCompound nbtData = NBTData.getOrCreateNbtData(input);

                Map<Integer, Integer> map;
                EnchantmentHelper.getEnchantments(input);
                map = EnchantmentHelper.getEnchantments(input);
                int id = 0;
                int lvl = 0;
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    id = entry.getKey();
                    lvl = entry.getValue();
                }
                if (id != 0)
                    nbtData.setInteger("ID", id);
                if (lvl != 0)
                    nbtData.setInteger("Level", lvl);
                // map.put(arg0, arg1)

                Map<Integer, Integer> map1 = map;
                if (Config.Draconic && Config.EnableMineFactory)
                    if (player.openContainer instanceof ContainerAutoDisenchanter) {
                        map1.clear();
                        EnchantmentHelper.setEnchantments(map1, input);
                    } else if (player.openContainer instanceof ContainerAutoEnchanter) {
                        map1.clear();
                        EnchantmentHelper.setEnchantments(map1, input);
                    } else if (player.openContainer instanceof ContainerDissEnchanter) {
                        map1.clear();
                        EnchantmentHelper.setEnchantments(map1, input);
                    } else {
                        if (nbtData.getInteger("ID") != 0 && nbtData.getInteger("Level") != 0) {
                            map.put(nbtData.getInteger("ID"), nbtData.getInteger("Level"));
                            EnchantmentHelper.setEnchantments(map, input);
                        }
                    }
                else if (Config.EnableMineFactory)
                    if (player.openContainer instanceof ContainerAutoDisenchanter) {
                        map1.clear();
                        EnchantmentHelper.setEnchantments(map1, input);
                    } else if (player.openContainer instanceof ContainerAutoEnchanter) {
                        map1.clear();
                        EnchantmentHelper.setEnchantments(map1, input);
                    } else {
                        if (nbtData.getInteger("ID") != 0 && nbtData.getInteger("Level") != 0) {
                            map.put(nbtData.getInteger("ID"), nbtData.getInteger("Level"));
                            EnchantmentHelper.setEnchantments(map, input);
                        }
                    }
                else if (Config.Draconic)
                    if (player.openContainer instanceof ContainerDissEnchanter) {
                        map1.clear();
                        EnchantmentHelper.setEnchantments(map1, input);
                    } else {
                        if (nbtData.getInteger("ID") != 0 && nbtData.getInteger("Level") != 0) {
                            map.put(nbtData.getInteger("ID"), nbtData.getInteger("Level"));
                            EnchantmentHelper.setEnchantments(map, input);
                        }
                    }
                else
                    return;
            }
            // TODO end Check inventory
        }
        // TODO end for
    }

}
