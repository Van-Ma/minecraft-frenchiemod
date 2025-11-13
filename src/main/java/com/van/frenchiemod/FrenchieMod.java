package com.van.frenchiemod;

import com.mojang.logging.LogUtils;
import com.van.frenchiemod.entities.ModEntities;
import com.van.frenchiemod.client.ClientEvents; 
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(FrenchieMod.MODID)
public class FrenchieMod {
    public static final String MODID = "frenchiemod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public FrenchieMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModEntities.register(modEventBus);
    }
}