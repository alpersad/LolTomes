package com.alpersad.loltomes.Blitzcrank;

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
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

public class BlitzcrankEnchantment extends Enchantment {
    public BlitzcrankEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentType.TRIDENT, new EquipmentSlotType[]{EquipmentSlotType.MAINHAND});
        MinecraftForge.EVENT_BUS.addListener(BlitzcrankEnchantment::applyBlitzcrankPull);
    }

    @Override
    public String getName() {
        String name = "Blitzcrank";
        return name;
    }

    private static void applyBlitzcrankPull(LivingAttackEvent event){
        Entity weaponOfAttack = event.getSource().getImmediateSource();
        Entity attacker = event.getSource().getTrueSource();
        LivingEntity attacked = event.getEntityLiving();
        if(attacker instanceof PlayerEntity && weaponOfAttack instanceof TridentEntity){
            ItemStack itemStack = ((PlayerEntity) attacker).getHeldItemMainhand();
            int enchantmentLevel = EnchantmentHelper.getEnchantmentLevel(ModEnchants.BLITZCRANK.get(), itemStack);
            if(enchantmentLevel > 0) {
                Vec3d attackerDirection =  attacker.getPositionVector().add(attacker.getLookVec());
                attacked.setPosition(attackerDirection.getX(), attackerDirection.getY(), attackerDirection.getZ());
            }
        }
    }
}
