package com.denfop.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityStreak extends Entity {
    public EntityLivingBase parent;

    public long lastUpdate;

    public EntityStreak(World world) {
        super(world);
        setSize(0.1F, 0.1F);
        this.lastUpdate = world.getWorldTime();
        this.ignoreFrustumCheck = true;
        this.renderDistanceWeight = 10.0D;
    }

    public EntityStreak(World world, EntityLivingBase parent) {
        super(world);
        setSize(0.1F, 0.1F);
        this.parent = parent;
        setLocationAndAngles(this.parent.posX, this.parent.boundingBox.minY, this.parent.posZ, this.parent.rotationYaw,
                this.parent.rotationPitch);
        this.lastUpdate = world.getWorldTime();
        this.ignoreFrustumCheck = true;
        this.renderDistanceWeight = 10.0D;
    }

    public void onUpdate() {
        this.ticksExisted++;
        if (this.parent != null && this.parent.isEntityAlive() && !this.parent.isChild()) {
            this.lastUpdate = this.worldObj.getWorldTime();
        } else {
            setDead();
        }
    }

    public boolean shouldRenderInPass(int pass) {
        return (pass == 1);
    }

    public int getBrightnessForRender(float par1) {
        return 15728880;
    }

    public boolean writeToNBTOptional(NBTTagCompound p_70037_1_) {
        return false;
    }

    public void entityInit() {
    }

    public void readEntityFromNBT(NBTTagCompound p_70037_1_) {
    }

    public void writeEntityToNBT(NBTTagCompound p_70014_1_) {
    }
}
