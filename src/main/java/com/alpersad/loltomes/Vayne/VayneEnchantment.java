package com.alpersad.loltomes.Vayne;

import com.alpersad.loltomes.ModRegistry.ModEffects;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;

import java.util.Collection;

public class VayneEnchantment extends Enchantment {

    public static String name = "Vayne";
    private int bugchecktwice = 0; // Checks for issue where onEntityDamaged is called twice

    public VayneEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentType.CROSSBOW, new EquipmentSlotType[] { EquipmentSlotType.MAINHAND });
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void onEntityDamaged(LivingEntity user, Entity target, int level) {

        // Ignores one execution of onEntityDamaged.
        // Cause of issue is unresolved.
        if(bugchecktwice != 0){
            bugchecktwice--;
            return;
        }
        bugchecktwice++;

        if (target instanceof LivingEntity) {
            LivingEntity livingentity = (LivingEntity) target;
            if (!livingentity.isInvulnerableTo(DamageSource.OUT_OF_WORLD)) {
                Collection<EffectInstance> potionlist = livingentity.getActivePotionEffects();
                if( potionlist.isEmpty() ) {
                    livingentity.addPotionEffect(new EffectInstance(ModEffects.SILVERBOLTONE, 400));
                }else {
                    for( EffectInstance potion : potionlist ){
                        if( potion.getEffectName().equals(SilverBoltOne.name)){
                            livingentity.removePotionEffect(potion.getPotion());
                            livingentity.addPotionEffect(new EffectInstance(ModEffects.SILVERBOLTTWO, 100));
                            break;
                        }else if(potion.getEffectName().equals(SilverBoltTwo.name)){
                            livingentity.removePotionEffect(potion.getPotion());
                            livingentity.addPotionEffect(new EffectInstance(ModEffects.SILVERBOLTTHREE, 10));
                            break;
                        }else{
                            livingentity.addPotionEffect(new EffectInstance(ModEffects.SILVERBOLTONE, 100));
                            break;
                        }
                    }
                }
            }
        }
    }

    @Override
    protected boolean canApplyTogether(Enchantment ench) {
        return super.canApplyTogether(ench) && ench != Enchantments.PIERCING;
    }

}