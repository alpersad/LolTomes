package com.alpersad.loltomes.Evelynn;

import com.alpersad.loltomes.Darkhax.EnchantmentTicking;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class EvelynnEnchantment extends EnchantmentTicking {

    private static String name = "Evelynn";

    public EvelynnEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentType.ARMOR_FEET, EquipmentSlotType.FEET);
    }

    @Override
    public void onItemTick(LivingEntity user, int level, ItemStack item, EquipmentSlotType slot) {
        if(!user.getEntityWorld().isRemote()){
            user.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 40, 0, false, false));
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
