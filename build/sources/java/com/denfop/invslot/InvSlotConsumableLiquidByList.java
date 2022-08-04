//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.denfop.invslot;

import ic2.core.block.TileEntityInventory;
import ic2.core.block.invslot.InvSlotConsumableLiquid;
import net.minecraftforge.fluids.Fluid;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InvSlotConsumableLiquidByList extends InvSlotConsumableLiquid {
    private final Set<Fluid> acceptedFluids;

    public InvSlotConsumableLiquidByList(TileEntityInventory base1, String name1, int oldStartIndex1, Access access1, int count, InvSide preferredSide1, OpType opType, Fluid... fluidlist) {
        super(base1, name1, oldStartIndex1, access1, count, preferredSide1, opType);
        this.acceptedFluids = new HashSet(Arrays.asList(fluidlist));
    }

    protected boolean acceptsLiquid(Fluid fluid) {
        return true;
    }

    protected Iterable<Fluid> getPossibleFluids() {
        return this.acceptedFluids;
    }
}
