package com.denfop.item.base;

import com.denfop.IUCore;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ItemBlockTank extends ItemBlock {
    private final List<String> itemNames;

    public ItemBlockTank(final Block b) {
        super(b);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        this.itemNames = new ArrayList<>();
        this.addItemsNames();
        this.setCreativeTab(IUCore.tabssp);
    }

    public int getMetadata(final int i) {
        return i;
    }


    public String getUnlocalizedName(final ItemStack itemstack) {
        return this.itemNames.get(itemstack.getItemDamage());
    }

    public void addItemsNames() {
        this.itemNames.add("BlockTank");
        this.itemNames.add("BlockAdvTank");
        this.itemNames.add("BlockImpTank");
        this.itemNames.add("BlockPerTank");
    }

    @Override
    public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
        for (int i = 0; i < this.itemNames.size(); i++) {
            par3List.add(new ItemStack(par1, 1, i));
        }
    }

    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(final ItemStack itemstack) {
        return EnumRarity.epic;
    }
}
