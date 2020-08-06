package com.alpersad.loltomes.Nidalee;

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
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

public class NidaleeEnchantment extends Enchantment {

    public NidaleeEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentType.TRIDENT, new EquipmentSlotType[]{EquipmentSlotType.MAINHAND});
        MinecraftForge.EVENT_BUS.addListener(NidaleeEnchantment::applyNidaleeDamage);
    }

    @Override
    public String getName() {
        String name = "Nidalee";
        return name;
    }

    private static void applyNidaleeDamage(LivingAttackEvent event){
        Entity weaponOfAttack = event.getSource().getImmediateSource();
        Entity attacker = event.getSource().getTrueSource();
        LivingEntity attacked = event.getEntityLiving();
        if(attacker instanceof PlayerEntity && weaponOfAttack instanceof TridentEntity){
            ItemStack itemStack = ((PlayerEntity) attacker).getHeldItemMainhand();
            int enchantmentLevel = EnchantmentHelper.getEnchantmentLevel(ModEnchants.NIDALEE.get(), itemStack);
            if(enchantmentLevel > 0) {
                double distance =  attacker.getPositionVec().distanceTo(attacked.getPositionVec());
                System.out.println("Distance: "+distance);
                int damage = 2;
                if(distance > 50){
                    damage = 40;
                }else if(distance > 40){
                    damage = 30;
                }else if(distance > 30){
                    damage = 20;
                }else if(distance > 20){
                    damage = 10;
                }else if(distance > 10){
                    damage = 5;
                }
                System.out.println("Damage: " + damage);
                attacked.attackEntityFrom(DamageSource.MAGIC, damage);
                event.setCanceled(true);
            }
        }
    }

}
