package com.alpersad.loltomes.Singed;

import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.util.Direction;
import net.minecraft.util.math.Vec3d;

public class PoisonTrail extends Effect {

    public static String name = "PoisonTrail";

    public PoisonTrail() {
        super(EffectType.NEUTRAL, 0);
    }

    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
        super.performEffect(entityLivingBaseIn, amplifier);

        Direction entityfacing = entityLivingBaseIn.getHorizontalFacing().getOpposite();
        Vec3d cloudentitypos = new Vec3d(entityLivingBaseIn.getPositionVector().getX() + entityfacing.getXOffset(),
                entityLivingBaseIn.getPositionVector().getY(),
                entityLivingBaseIn.getPositionVec().getZ() + entityfacing.getZOffset());

        AreaEffectCloudEntity areaeffectcloudentity = new AreaEffectCloudEntity(entityLivingBaseIn.getEntityWorld(), cloudentitypos.getX(), cloudentitypos.getY(), cloudentitypos.getZ());
        areaeffectcloudentity.setOwner(entityLivingBaseIn);
        areaeffectcloudentity.setColor(0x127c06);
        areaeffectcloudentity.setDuration(50);
        areaeffectcloudentity.setRadius(2.0f);
        areaeffectcloudentity.addEffect(new EffectInstance(Effects.POISON, 100));
        entityLivingBaseIn.getEntityWorld().addEntity(areaeffectcloudentity);

    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        int k = 10 >> amplifier;
        if (k > 0) {
            return duration % k == 0;
        } else {
            return true;
        }
    }

    @Override
    public String getName() {
        return new String(name);
    }
}
