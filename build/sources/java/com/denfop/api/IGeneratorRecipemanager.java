package com.denfop.api;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidStack;

import java.util.Map;

public interface IGeneratorRecipemanager {
    void addRecipe(NBTTagCompound var2, FluidStack var3);

    Map<NBTTagCompound, FluidStack> getRecipes();
}
