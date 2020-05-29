package com.alpersad.loltomes.Vayne;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class SilverBoltOne extends Effect {

    public static String name = "SILVER BOLT I";

    public SilverBoltOne() {
        super(EffectType.HARMFUL, 0);
    }

    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
        System.out.println(name);
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

    @Override
    public String getName() {
        return new String(name);
    }
}
