package com.alpersad.loltomes.Singed;

import com.alpersad.loltomes.Darkhax.EnchantmentTicking;
import com.alpersad.loltomes.ModRegistry.ModEffects;
import com.alpersad.loltomes.ModRegistry.ModEnchants;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

import java.util.Collection;

public class SingedEnchantment extends EnchantmentTicking {

    private static final String name = "Singed";

    public SingedEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentType.ARMOR_CHEST, EquipmentSlotType.CHEST);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    protected boolean canApplyTogether(Enchantment ench) {
        return super.canApplyTogether(ench) && ench != Enchantments.THORNS && ench != ModEnchants.MUNDO.get();
    }

    @Override
    public void onUserTick(LivingEntity user, int level) {
        if (user.world.isRemote || level == 0)
            return;
        Collection<EffectInstance> potionlist = user.getActivePotionEffects();

        // Removes poison from the user with the Singed enchantment
        // Effectively grants immunity to poison
        for (EffectInstance effect : potionlist) {
            if (effect.getPotion() == Effects.POISON) {
                user.removePotionEffect(effect.getPotion());
            }
        }
    }

    @Override
    public void onItemTick(LivingEntity user, int level, ItemStack item, EquipmentSlotType slot) {
        if (!user.world.isRemote()) {
            Collection<EffectInstance> potionlist = user.getActivePotionEffects();

            // reduce durability of armor while poison trail effect is active
            for (EffectInstance effect : potionlist) {
                if (effect.getEffectName().equals(PoisonTrail.name)) {
                    item.damageItem(1, user, (p_220039_0_) -> {
                        p_220039_0_.sendBreakAnimation(EquipmentSlotType.CHEST);
                    });
                    return;
                }
            }

            // Add poison trail effect
            user.addPotionEffect(new EffectInstance(ModEffects.POISONTRAIL, 50, 0, false, true));
        }
    }
}
