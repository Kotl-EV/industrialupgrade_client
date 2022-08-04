package com.denfop.recipes;

import com.denfop.IUItem;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import ic2.core.Ic2Items;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class CentrifugeRecipe {

    public static void init() {
        addcentrifuge(IUItem.reactorDepletedamericiumDual, new ItemStack(IUItem.radiationresources, 2));
        addcentrifuge(IUItem.reactorDepletedamericiumQuad, new ItemStack(IUItem.radiationresources, 4));
        addcentrifuge(IUItem.reactorDepletedamericiumSimple, new ItemStack(IUItem.radiationresources, 1));

        addcentrifuge(IUItem.reactorDepletedneptuniumDual, new ItemStack(IUItem.radiationresources, 2, 1));
        addcentrifuge(IUItem.reactorDepletedneptuniumQuad, new ItemStack(IUItem.radiationresources, 4, 1));
        addcentrifuge(IUItem.reactorDepletedneptuniumSimple, new ItemStack(IUItem.radiationresources, 1, 1));

        addcentrifuge(IUItem.reactorDepletedcuriumDual, new ItemStack(IUItem.radiationresources, 2, 2));
        addcentrifuge(IUItem.reactorDepletedcuriumQuad, new ItemStack(IUItem.radiationresources, 4, 2));
        addcentrifuge(IUItem.reactorDepletedcuriumSimple, new ItemStack(IUItem.radiationresources, 1, 2));

        addcentrifuge(IUItem.reactorDepletedcaliforniaDual, new ItemStack(IUItem.radiationresources, 2, 3));
        addcentrifuge(IUItem.reactorDepletedcaliforniaQuad, new ItemStack(IUItem.radiationresources, 4, 3));
        addcentrifuge(IUItem.reactorDepletedcaliforniaSimple, new ItemStack(IUItem.radiationresources, 1, 3));

        addcentrifuge(IUItem.reactorDepletedmendeleviumDual, new ItemStack(IUItem.radiationresources, 2, 5));
        addcentrifuge(IUItem.reactorDepletedmendeleviumQuad, new ItemStack(IUItem.radiationresources, 4, 5));
        addcentrifuge(IUItem.reactorDepletedmendeleviumSimple, new ItemStack(IUItem.radiationresources, 1, 5));

        addcentrifuge(IUItem.reactorDepletedberkeliumDual, new ItemStack(IUItem.radiationresources, 2, 6));
        addcentrifuge(IUItem.reactorDepletedberkeliumQuad, new ItemStack(IUItem.radiationresources, 4, 6));
        addcentrifuge(IUItem.reactorDepletedberkeliumSimple, new ItemStack(IUItem.radiationresources, 1, 6));

        addcentrifuge(IUItem.reactorDepletedeinsteiniumDual, new ItemStack(IUItem.radiationresources, 2, 7));
        addcentrifuge(IUItem.reactorDepletedeinsteiniumQuad, new ItemStack(IUItem.radiationresources, 4, 7));
        addcentrifuge(IUItem.reactorDepletedeinsteiniumSimple, new ItemStack(IUItem.radiationresources, 1, 7));

        addcentrifuge(IUItem.reactorDepleteduran233Dual, new ItemStack(IUItem.radiationresources, 2, 8));
        addcentrifuge(IUItem.reactorDepleteduran233Quad, new ItemStack(IUItem.radiationresources, 4, 8));
        addcentrifuge(IUItem.reactorDepleteduran233Simple, new ItemStack(IUItem.radiationresources, 1, 8));

        addcentrifuge(IUItem.reactorDepletedtoriyDual, new ItemStack(IUItem.toriy, 2));
        addcentrifuge(IUItem.reactorDepletedtoriyQuad, new ItemStack(IUItem.toriy, 4));
        addcentrifuge(IUItem.reactorDepletedtoriySimple, new ItemStack(IUItem.toriy, 1));

        addcentrifuge(IUItem.reactorDepletedprotonDual, new ItemStack(IUItem.proton, 2));
        addcentrifuge(IUItem.reactorDepletedprotonQuad, new ItemStack(IUItem.proton, 4));
        addcentrifuge(IUItem.reactorDepletedprotoneit, new ItemStack(IUItem.proton, 8));
        addcentrifuge(IUItem.reactorDepletedprotonSimple, new ItemStack(IUItem.proton, 1));

        addcentrifuge(0, null);
        addcentrifuge(1, new ItemStack(Blocks.sand));
        addcentrifuge(2, new ItemStack(Ic2Items.smallLeadDust.getItem(), 1, 5));
        addcentrifuge(3, new ItemStack(IUItem.smalldust, 1, 16));
        addcentrifuge(6, new ItemStack(Ic2Items.smallLeadDust.getItem(), 1, 1));
        addcentrifuge(7, new ItemStack(IUItem.smalldust, 1, 16));
        addcentrifuge(8, new ItemStack(Ic2Items.smallLeadDust.getItem(), 1, 0));
        addcentrifuge(9, new ItemStack(Ic2Items.smallLeadDust.getItem(), 1, 2));
        addcentrifuge(10, new ItemStack(Ic2Items.smallLeadDust.getItem(), 1, 0));
        addcentrifuge(11, new ItemStack(Ic2Items.smallLeadDust.getItem(), 1, 5));
        addcentrifuge(12, new ItemStack(IUItem.smalldust, 1, 10));
        addcentrifuge(15, new ItemStack(Ic2Items.smallLeadDust.getItem(), 1, 5));
        addcentrifuge(16, null);
        addcentrifuge(17, new ItemStack(IUItem.smalldust, 1, 9));
        addcentrifuge(18, new ItemStack(IUItem.smalldust, 1, 15));

        addcentrifuge1(0, null);
        addcentrifuge1(1, new ItemStack(Blocks.sand));
        addcentrifuge1(2, new ItemStack(Ic2Items.smallLeadDust.getItem(), 1, 5));
        addcentrifuge1(3, new ItemStack(IUItem.smalldust, 1, 16));
        addcentrifuge1(6, new ItemStack(Ic2Items.smallLeadDust.getItem(), 1, 1));
        addcentrifuge1(7, new ItemStack(IUItem.smalldust, 1, 16));
        addcentrifuge1(8, new ItemStack(Ic2Items.smallLeadDust.getItem(), 1, 0));
        addcentrifuge1(9, new ItemStack(Ic2Items.smallLeadDust.getItem(), 1, 2));
        addcentrifuge1(10, new ItemStack(Ic2Items.smallLeadDust.getItem(), 1, 0));
        addcentrifuge1(11, new ItemStack(Ic2Items.smallLeadDust.getItem(), 1, 5));
        addcentrifuge1(12, new ItemStack(IUItem.smalldust, 1, 10));
        addcentrifuge1(15, new ItemStack(Ic2Items.smallLeadDust.getItem(), 1, 5));
        addcentrifuge1(16, null);
        addcentrifuge1(17, new ItemStack(IUItem.smalldust, 1, 9));
        addcentrifuge1(18, new ItemStack(IUItem.smalldust, 1, 15));

    }

    public static void addcentrifuge(ItemStack stack, ItemStack output) {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setShort("minHeat", (short) 5000);
        Recipes.centrifuge.addRecipe(new RecipeInputItemStack(stack), nbt, output);

    }

    public static void addcentrifuge(int meta, ItemStack output) {
        ItemStack[] stack;
        if (output != null)
            stack = new ItemStack[3];
        else {
            stack = new ItemStack[2];

        }
        stack[0] = new ItemStack(IUItem.iudust, 1, meta);
        stack[1] = Ic2Items.stoneDust;
        if (output != null)
            stack[2] = output;
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setShort("minHeat", (short) 2000);
        Recipes.centrifuge.addRecipe(new RecipeInputItemStack(new ItemStack(IUItem.crushed, 1, meta)), nbt, stack);

    }

    public static void addcentrifuge1(int meta, ItemStack output) {
        ItemStack[] stack;
        if (output != null)
            stack = new ItemStack[2];
        else {
            stack = new ItemStack[1];

        }
        stack[0] = new ItemStack(IUItem.iudust, 1, meta);

        if (output != null)
            stack[1] = output;
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setShort("minHeat", (short) 2000);
        Recipes.centrifuge.addRecipe(new RecipeInputItemStack(new ItemStack(IUItem.purifiedcrushed, 1, meta)), nbt, stack);

    }
}
