package com.denfop.invslot;

import com.denfop.api.IMicrochipFarbricatorRecipeManager;
import com.denfop.api.Recipes;
import com.denfop.tiles.mechanism.TileEntityGenerationMicrochip;
import ic2.api.recipe.RecipeOutput;
import ic2.core.block.TileEntityInventory;
import ic2.core.block.invslot.InvSlotProcessable;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InvSlotProcessableGenerationMicrochip extends InvSlotProcessable {

    public InvSlotProcessableGenerationMicrochip(TileEntityInventory base1, String name1, int oldStartIndex1, int count) {
        super(base1, name1, oldStartIndex1, count);

    }

    public Map<IMicrochipFarbricatorRecipeManager.Input, RecipeOutput> getRecipeList() {
        return Recipes.GenerationMicrochip.getRecipes();
    }

    public boolean accepts(ItemStack itemStack) {
        for (Map.Entry<IMicrochipFarbricatorRecipeManager.Input, RecipeOutput> entry : getRecipeList().entrySet()) {
            if (entry.getKey().container.matches(itemStack)
                    || entry.getKey().fill.matches(itemStack) || entry.getKey().fill1.matches(itemStack) || entry.getKey().container1.matches(itemStack) || entry.getKey().fill2.matches(itemStack))
                return itemStack != null || !(itemStack.getItem() instanceof ic2.core.item.ItemUpgradeModule);
        }

        return false;
    }

    protected RecipeOutput getOutput(ItemStack container, ItemStack fill, ItemStack fill1, ItemStack fill2,
                                     ItemStack container1, boolean adjustInput) {

        return Recipes.GenerationMicrochip.getOutputFor(container, fill, fill1, fill2, container1, adjustInput,
                false);

    }

    protected RecipeOutput getOutputFor(ItemStack input, ItemStack input1, ItemStack input2, ItemStack input3,
                                        ItemStack input4, boolean adjustInput) {
        return getOutput(input, input1, input2, input3, input4, adjustInput);
    }

    public RecipeOutput process() {
        ItemStack input = ((TileEntityGenerationMicrochip) this.base).inputSlotA.get(0);
        ItemStack input1 = ((TileEntityGenerationMicrochip) this.base).inputSlotA.get(1);
        ItemStack input2 = ((TileEntityGenerationMicrochip) this.base).inputSlotA.get(2);
        ItemStack input3 = ((TileEntityGenerationMicrochip) this.base).inputSlotA.get(3);
        ItemStack input4 = ((TileEntityGenerationMicrochip) this.base).inputSlotA.get(4);
        if (input == null)
            return null;
        if (input1 == null)
            return null;
        if (input2 == null)
            return null;
        if (input3 == null)
            return null;
        if (input4 == null)
            return null;
        RecipeOutput output = getOutputFor(input, input1, input2, input3, input4, false);
        if (output == null)
            return null;
        List<ItemStack> itemsCopy = new ArrayList<>(output.items.size());
        itemsCopy.addAll(output.items);
        return new RecipeOutput(output.metadata, itemsCopy);
    }


    public void consume() {

        ItemStack input = ((TileEntityGenerationMicrochip) this.base).inputSlotA.get(0);
        ItemStack input1 = ((TileEntityGenerationMicrochip) this.base).inputSlotA.get(1);
        ItemStack input2 = ((TileEntityGenerationMicrochip) this.base).inputSlotA.get(2);
        ItemStack input3 = ((TileEntityGenerationMicrochip) this.base).inputSlotA.get(3);
        ItemStack input4 = ((TileEntityGenerationMicrochip) this.base).inputSlotA.get(4);
        getOutputFor(input, input1, input2, input3, input4, true);

        if (input != null && input.stackSize <= 0)
            ((TileEntityGenerationMicrochip) this.base).inputSlotA.put(0, null);
        if (input1 != null && input1.stackSize <= 0)
            ((TileEntityGenerationMicrochip) this.base).inputSlotA.put(1, null);
        if (input2 != null && input2.stackSize <= 0)
            ((TileEntityGenerationMicrochip) this.base).inputSlotA.put(2, null);
        if (input3 != null && input3.stackSize <= 0)
            ((TileEntityGenerationMicrochip) this.base).inputSlotA.put(3, null);
        if (input4 != null && input4.stackSize <= 0)
            ((TileEntityGenerationMicrochip) this.base).inputSlotA.put(4, null);

    }


}
