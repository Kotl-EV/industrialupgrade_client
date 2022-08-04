package com.denfop.invslot;

import com.denfop.api.IWitherMaker;
import com.denfop.api.Recipes;
import com.denfop.tiles.mechanism.TileEntityWitherMaker;
import ic2.api.recipe.RecipeOutput;
import ic2.core.block.TileEntityInventory;
import ic2.core.block.invslot.InvSlotProcessable;
import ic2.core.util.StackUtil;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InvSlotProcessableWitherMaker extends InvSlotProcessable {

    public InvSlotProcessableWitherMaker(TileEntityInventory base1, String name1, int oldStartIndex1, int count) {
        super(base1, name1, oldStartIndex1, count);

    }

    public Map<IWitherMaker.Input, RecipeOutput> getRecipeList() {
        return Recipes.withermaker.getRecipes();
    }

    public boolean accepts(ItemStack itemStack) {
        for (Map.Entry<IWitherMaker.Input, RecipeOutput> entry : getRecipeList().entrySet()) {
            if ((entry.getKey()).container.matches(itemStack)
                    || (entry.getKey()).fill.matches(itemStack) || (entry.getKey()).fill2.matches(itemStack) || (entry.getKey()).fill3.matches(itemStack) || (entry.getKey()).container1.matches(itemStack) || (entry.getKey()).fill1.matches(itemStack))
                return itemStack != null;
        }
        return false;

    }

    public void consume(int number, int amount) {
        this.consume(number, amount, false, false);
    }

    public void consume(int number, int amount, boolean simulate, boolean consumeContainers) {
        ItemStack ret = null;


        ItemStack stack = this.get(number);
        if (stack != null && stack.stackSize >= 1 && this.accepts(stack) && (ret == null || StackUtil.isStackEqualStrict(stack, ret)) && (stack.stackSize == 1 || consumeContainers || !stack.getItem().hasContainerItem(stack))) {
            int currentAmount = Math.min(amount, stack.stackSize);
            if (!simulate) {
                if (stack.stackSize == currentAmount) {
                    if (!consumeContainers && stack.getItem().hasContainerItem(stack)) {
                        this.put(number, stack.getItem().getContainerItem(stack));
                    } else {
                        this.put(number, null);
                    }
                } else {
                    stack.stackSize -= currentAmount;
                }
            }

            if (ret == null) {
            } else {
                ret.stackSize += currentAmount;
            }


        }


    }

    protected RecipeOutput getOutput(ItemStack container, ItemStack fill, ItemStack fill1, ItemStack fill2,
                                     ItemStack container1, ItemStack fill3, ItemStack fill4, boolean adjustInput) {

        return Recipes.withermaker.getOutputFor(container, fill, fill1, fill2, container1, fill3, fill4, adjustInput,
                false);

    }

    protected RecipeOutput getOutputFor(ItemStack input, ItemStack input1, ItemStack input2, ItemStack input3,
                                        ItemStack input4, ItemStack input5,
                                        ItemStack input6, boolean adjustInput) {
        return getOutput(input, input1, input2, input3, input4, input5, input6, adjustInput);
    }

    public RecipeOutput process() {
        ItemStack input = ((TileEntityWitherMaker) this.base).inputSlotA.get(0);
        ItemStack input1 = ((TileEntityWitherMaker) this.base).inputSlotA.get(1);
        ItemStack input2 = ((TileEntityWitherMaker) this.base).inputSlotA.get(2);
        ItemStack input3 = ((TileEntityWitherMaker) this.base).inputSlotA.get(3);
        ItemStack input4 = ((TileEntityWitherMaker) this.base).inputSlotA.get(4);
        ItemStack input5 = ((TileEntityWitherMaker) this.base).inputSlotA.get(5);
        ItemStack input6 = ((TileEntityWitherMaker) this.base).inputSlotA.get(6);
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
        RecipeOutput output = getOutputFor(input, input1, input2, input3, input4, input5, input6, false);
        if (output == null)
            return null;
        List<ItemStack> itemsCopy = new ArrayList<>(output.items.size());
        itemsCopy.addAll(output.items);
        return new RecipeOutput(output.metadata, itemsCopy);
    }


    public void consume() {

        ItemStack input = ((TileEntityWitherMaker) this.base).inputSlotA.get(0);
        ItemStack input1 = ((TileEntityWitherMaker) this.base).inputSlotA.get(1);
        ItemStack input2 = ((TileEntityWitherMaker) this.base).inputSlotA.get(2);
        ItemStack input3 = ((TileEntityWitherMaker) this.base).inputSlotA.get(3);
        ItemStack input4 = ((TileEntityWitherMaker) this.base).inputSlotA.get(4);
        ItemStack input5 = ((TileEntityWitherMaker) this.base).inputSlotA.get(5);
        ItemStack input6 = ((TileEntityWitherMaker) this.base).inputSlotA.get(6);
        getOutputFor(input, input1, input2, input3, input4, input5, input6, true);

        if (input != null && input.stackSize <= 0)
            ((TileEntityWitherMaker) this.base).inputSlotA.put(0, null);
        if (input1 != null && input1.stackSize <= 0)
            ((TileEntityWitherMaker) this.base).inputSlotA.put(1, null);
        if (input2 != null && input2.stackSize <= 0)
            ((TileEntityWitherMaker) this.base).inputSlotA.put(2, null);
        if (input3 != null && input3.stackSize <= 0)
            ((TileEntityWitherMaker) this.base).inputSlotA.put(3, null);
        if (input4 != null && input4.stackSize <= 0)
            ((TileEntityWitherMaker) this.base).inputSlotA.put(4, null);
        if (input5 != null && input5.stackSize <= 0)
            ((TileEntityWitherMaker) this.base).inputSlotA.put(5, null);
        if (input6 != null && input6.stackSize <= 0)
            ((TileEntityWitherMaker) this.base).inputSlotA.put(6, null);

    }


}
