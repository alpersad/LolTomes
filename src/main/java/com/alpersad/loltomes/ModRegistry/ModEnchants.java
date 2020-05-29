package com.alpersad.loltomes.ModRegistry;

import com.alpersad.loltomes.LolTomes;
import com.alpersad.loltomes.Vayne.VayneEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEnchants {

    public static final DeferredRegister<Enchantment> ENCHANTMENT = new DeferredRegister<>(ForgeRegistries.ENCHANTMENTS, LolTomes.MOD_ID);

    public static final RegistryObject<Enchantment> VAYNE = ENCHANTMENT.register("vayne", VayneEnchantment::new);

}
