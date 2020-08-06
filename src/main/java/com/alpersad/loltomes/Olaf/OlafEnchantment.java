package com.alpersad.loltomes.Olaf;

import com.alpersad.loltomes.Darkhax.EnchantmentTicking;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

import java.util.Collection;

public class OlafEnchantment extends EnchantmentTicking {

    public static String name = "Olaf";

    public OlafEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentType.ARMOR_HEAD, EquipmentSlotType.HEAD);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void onUserTick(LivingEntity user, int level) {
        if (user.world.isRemote || level == 0)
            return;

        Collection<EffectInstance> potionlist = user.getActivePotionEffects();
        if (potionlist.isEmpty()) {
            return;
        }
        for (EffectInstance potion : potionlist) {
            if (!potion.getPotion().isBeneficial()) {
                user.removePotionEffect(potion.getPotion());
                user.addPotionEffect(new EffectInstance(Effects.SPEED, 50, 2, false, true));
                return;
            }
        }
    }
}
