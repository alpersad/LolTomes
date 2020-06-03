package com.alpersad.loltomes.Singed;

import com.alpersad.loltomes.ModRegistry.ModEffects;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.Vec3d;

public class PoisonTrail extends Effect {

    public PoisonTrail() {
        super(EffectType.NEUTRAL, 0);
    }

    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
        super.performEffect(entityLivingBaseIn, amplifier);

        AreaEffectCloudEntity areaeffectcloudentity = new AreaEffectCloudEntity(entityLivingBaseIn.getEntityWorld(), entityLivingBaseIn.getPositionVector().x, entityLivingBaseIn.getPositionVector().y, entityLivingBaseIn.getPositionVector().z);
        areaeffectcloudentity.setOwner(entityLivingBaseIn);
        areaeffectcloudentity.setColor(0x127c06);
        areaeffectcloudentity.setDuration(100);
        areaeffectcloudentity.setRadius(2.0f);
        areaeffectcloudentity.addEffect(new EffectInstance(Effects.POISON, 100));
        entityLivingBaseIn.getEntityWorld().addEntity(areaeffectcloudentity);

    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        int k = 50 >> amplifier;
        if (k > 0) {
            return duration % k == 0;
        } else {
            return true;
        }
    }


}
