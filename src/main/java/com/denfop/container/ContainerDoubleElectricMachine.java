package com.denfop.container;

import com.denfop.tiles.base.EnumDoubleElectricMachine;
import com.denfop.tiles.base.TileEntityDoubleElectricMachine;
import ic2.core.slot.SlotInvSlot;
import net.minecraft.entity.player.EntityPlayer;

import java.util.List;

public class ContainerDoubleElectricMachine<T extends TileEntityDoubleElectricMachine> extends ContainerBaseDoubleElectricMachine<T> {
    public ContainerDoubleElectricMachine(EntityPlayer entityPlayer, T tileEntity1, EnumDoubleElectricMachine type) {
        this(entityPlayer, tileEntity1, 166, type.dischangeX, type.dischangeY, type.inputx, type.inputy, type.inputx1, type.inputy1, 152, 8, type.register, type.outputx, type.outputy);
    }


    public ContainerDoubleElectricMachine(EntityPlayer entityPlayer, T tileEntity1, int height, int dischargeX,
                                          int dischargeY, int inputX1, int inputY1, int inputX2, int inputY2, int upgradeX, int upgradeY, boolean register, int outputx, int outputy) {
        super(entityPlayer, tileEntity1, height, dischargeX, dischargeY, register);
        if (tileEntity1.inputSlotA != null)
            addSlotToContainer(new SlotInvSlot(tileEntity1.inputSlotA,
                    1, inputX2, inputY2));

        if (tileEntity1.inputSlotA != null)
            addSlotToContainer(new SlotInvSlot(tileEntity1.inputSlotA,
                    0, inputX1, inputY1));
        if (tileEntity1.outputSlot != null)
            addSlotToContainer(new SlotInvSlot(tileEntity1.outputSlot,
                    0, outputx, outputy));
        for (int i = 0; i < 4; i++)
            addSlotToContainer(new SlotInvSlot(tileEntity1.upgradeSlot,
                    i, upgradeX, upgradeY + i * 18));
    }

    public List<String> getNetworkedFields() {
        List<String> ret = super.getNetworkedFields();
        ret.add("guiProgress");
        return ret;
    }
}
