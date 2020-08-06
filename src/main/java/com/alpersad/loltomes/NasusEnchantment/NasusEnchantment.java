package com.alpersad.loltomes.NasusEnchantment;

import com.alpersad.loltomes.ModRegistry.ModEnchants;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

public class NasusEnchantment extends Enchantment {

    public NasusEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentType.WEAPON, new EquipmentSlotType[]{EquipmentSlotType.MAINHAND});
        MinecraftForge.EVENT_BUS.addListener(NasusEnchantment::applyNasusDamage);
    }

    @Override
    public String getName() {
        String name = "Nasus";
        return name;
    }

    private static void applyNasusDamage(LivingAttackEvent event){
        Entity attacker = event.getSource().getTrueSource();
        LivingEntity attacked = event.getEntityLiving();
        if(attacker instanceof PlayerEntity){
            ItemStack itemStack = ((PlayerEntity) attacker).getHeldItemMainhand();
            int enchantmentLevel = EnchantmentHelper.getEnchantmentLevel(ModEnchants.NASUS.get(), itemStack);
            if(enchantmentLevel > 0) {
                int experienceLevel = ((PlayerEntity) attacker).experienceLevel;
                attacked.attackEntityFrom(DamageSource.GENERIC, experienceLevel);
                event.setCanceled(true);
            }
        }
    }
}
