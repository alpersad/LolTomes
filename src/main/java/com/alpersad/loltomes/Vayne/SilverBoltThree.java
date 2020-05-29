package com.alpersad.loltomes.Vayne;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.DamageSource;

public class SilverBoltThree extends Effect {

    public static String name = "SILVER BOLT III";

    public SilverBoltThree() {
        super(EffectType.HARMFUL, 0);
    }

    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
        System.out.println(name);
        entityLivingBaseIn.attackEntityFrom(DamageSource.OUT_OF_WORLD, entityLivingBaseIn.getMaxHealth()/4);
    }

    @Override
    public String getName() {
        return new String(name);

    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean isInstant() {
        return true;
    }

}
