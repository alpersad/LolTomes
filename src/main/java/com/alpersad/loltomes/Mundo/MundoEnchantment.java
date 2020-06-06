package com.alpersad.loltomes.Mundo;

import com.alpersad.loltomes.ModRegistry.ModEnchants;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class MundoEnchantment extends Enchantment {

    public static final String name = "Mundo";

    public MundoEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentType.ARMOR_CHEST, new EquipmentSlotType[]{ EquipmentSlotType.CHEST});
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    protected boolean canApplyTogether(Enchantment ench) {
        return super.canApplyTogether(ench) && ench != ModEnchants.SINGED.get();
    }

    @Override
    public void onUserHurt(LivingEntity user, Entity attacker, int level) {
        super.onUserHurt(user, attacker, level);
        if(user.getHealth() <= 5){
            user.addPotionEffect(new EffectInstance(Effects.REGENERATION, 120, 2, false, true));
            user.getItemStackFromSlot(EquipmentSlotType.CHEST).damageItem(10, user, (p_220039_0_) -> {
                p_220039_0_.sendBreakAnimation(EquipmentSlotType.CHEST);
            });
        }
    }
}
