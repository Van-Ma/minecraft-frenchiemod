package com.van.frenchiemod.entities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.Mob;

public class PeanutEntity extends Wolf {

    public PeanutEntity(EntityType<? extends Wolf> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 5000.0D)      
            .add(Attributes.MOVEMENT_SPEED, 0.3D)    
            .add(Attributes.ATTACK_DAMAGE, 5.0D);    
    }
}