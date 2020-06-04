package com.alpersad.loltomes.Singed;

import com.alpersad.loltomes.Darkhax.EnchantmentTicking;
import com.alpersad.loltomes.ModRegistry.ModEffects;
import com.alpersad.loltomes.Vayne.SilverBoltOne;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import org.lwjgl.system.CallbackI;

import java.util.Collection;

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
    public void onItemTick(LivingEntity user, int level, ItemStack item, EquipmentSlotType slot) {
        if(!user.world.isRemote()) {
            Collection<EffectInstance> potionlist = user.getActivePotionEffects();
            for (EffectInstance effect : potionlist) {
                if (effect.getEffectName().equals(PoisonTrail.name)) {
                    item.damageItem(1, user, (p_220039_0_) -> {
                        p_220039_0_.sendBreakAnimation(EquipmentSlotType.CHEST);
                    });
                    return;
                }
            }
            user.addPotionEffect(new EffectInstance(ModEffects.POISONTRAIL, 50, 0, false, true));
        }
    }
}
