package com.alpersad.loltomes.Ashe;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class AsheEnchantment extends Enchantment {

    public AsheEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentType.BOW, new EquipmentSlotType[] { EquipmentSlotType.MAINHAND });
    }

    @Override
    public void onEntityDamaged(LivingEntity user, Entity target, int level) {
        super.onEntityDamaged(user, target, level);
        if(target instanceof LivingEntity){
            ((LivingEntity) target).addPotionEffect(new EffectInstance(Effects.SLOWNESS, 50, 0, false, true));
        }
    }
}
