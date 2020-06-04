package com.alpersad.loltomes.Singed;

import com.alpersad.loltomes.Darkhax.EnchantmentTicking;
import com.alpersad.loltomes.ModRegistry.ModEffects;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.EffectInstance;

public class SingedEnchantment extends EnchantmentTicking {

    private static String name = "Singed";

    public SingedEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentType.ARMOR_CHEST, new EquipmentSlotType[]{ EquipmentSlotType.CHEST });
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    protected boolean canApplyTogether(Enchantment ench) {
        return super.canApplyTogether(ench) && ench != Enchantments.THORNS;
    }

    @Override
    public void onUserTick(LivingEntity user, int level) {
        user.addPotionEffect(new EffectInstance(ModEffects.POISONTRAIL, 100));
    }
}
