package com.denfop.container;

import com.denfop.tiles.base.TileEntityBasePlasticCreator;
import ic2.core.block.machine.container.ContainerElectricMachine;
import ic2.core.slot.SlotInvSlot;
import net.minecraft.entity.player.EntityPlayer;

import java.util.List;

public class ContainerPlasticCreator<T extends TileEntityBasePlasticCreator> extends ContainerElectricMachine<T> {
    public ContainerPlasticCreator(EntityPlayer entityPlayer, T tileEntity1) {
        this(entityPlayer, tileEntity1, 166, 56, 53, 56, 17, 116, 35, 152, 8);
    }

    public ContainerPlasticCreator(EntityPlayer entityPlayer, T tileEntity1, int height, int dischargeX,
                                   int dischargeY, int inputX, int inputY, int outputX, int outputY, int upgradeX, int upgradeY) {
        super(entityPlayer, tileEntity1, height, dischargeX, dischargeY);
        if (tileEntity1.inputSlotA != null)
            addSlotToContainer(new SlotInvSlot(tileEntity1.inputSlotA,
                    1, inputX - 18, inputY));

        if (tileEntity1.inputSlotA != null)
            addSlotToContainer(new SlotInvSlot(tileEntity1.inputSlotA,
                    0, inputX + 18, inputY));
        if (tileEntity1.outputSlot != null)
            addSlotToContainer(new SlotInvSlot(tileEntity1.outputSlot,
                    0, outputX, outputY));

        addSlotToContainer(new SlotInvSlot(tileEntity1.fluidSlot,
                0, 8, 62));
        for (int i = 0; i < 4; i++)
            addSlotToContainer(new SlotInvSlot(tileEntity1.upgradeSlot,
                    i, upgradeX, upgradeY + i * 18));
    }

    public List<String> getNetworkedFields() {
        List<String> ret = super.getNetworkedFields();
        ret.add("guiProgress");
        ret.add("fluidTank");
        return ret;
    }
}
