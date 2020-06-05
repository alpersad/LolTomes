package com.alpersad.loltomes.ModRegistry;

import com.alpersad.loltomes.Ashe.AsheEnchantment;
import com.alpersad.loltomes.LolTomes;
import com.alpersad.loltomes.Mundo.MundoEnchantment;
import com.alpersad.loltomes.Singed.SingedEnchantment;
import com.alpersad.loltomes.Vayne.VayneEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEnchants {

    public static final DeferredRegister<Enchantment> ENCHANTMENT = new DeferredRegister<>(ForgeRegistries.ENCHANTMENTS, LolTomes.MOD_ID);

    public static final RegistryObject<Enchantment> VAYNE = ENCHANTMENT.register("vayne", VayneEnchantment::new);
    public static final RegistryObject<Enchantment> SINGED = ENCHANTMENT.register("singed", SingedEnchantment::new);
    public static final RegistryObject<Enchantment> ASHE = ENCHANTMENT.register("ashe", AsheEnchantment::new);
    public static final RegistryObject<Enchantment> MUNDO = ENCHANTMENT.register("mundo", MundoEnchantment::new);

}
