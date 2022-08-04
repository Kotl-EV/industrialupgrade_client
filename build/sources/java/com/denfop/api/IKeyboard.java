package com.denfop.api;

import net.minecraft.entity.player.EntityPlayer;

public interface IKeyboard {
    boolean isChangeKeyDown(final EntityPlayer p0);

    boolean isStreakKeyDown(final EntityPlayer p0);

    boolean isVerticalMode(final EntityPlayer p0);

    boolean isFlyModeKeyDown(final EntityPlayer p0);

    boolean isSaveModeKeyDown(final EntityPlayer p0);
}
