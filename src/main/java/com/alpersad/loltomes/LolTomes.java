package com.alpersad.loltomes;

import com.alpersad.loltomes.ModRegistry.ModEnchants;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(LolTomes.MOD_ID)
public class LolTomes {

    public static final String MOD_ID = "loltomes";

    public LolTomes() {

        ModEnchants.ENCHANTMENT.register(FMLJavaModLoadingContext.get().getModEventBus());

    }

}
