package com.van.frenchiemod.client;

import com.van.frenchiemod.FrenchieMod; 
import com.van.frenchiemod.entities.ModEntities;

import com.van.frenchiemod.client.render.PeanutRenderer;
import com.van.frenchiemod.client.model.Peanut;

import com.van.frenchiemod.client.render.BobbyRenderer;
import com.van.frenchiemod.client.model.Bobby;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.client.event.EntityRenderersEvent;

@Mod.EventBusSubscriber(modid = FrenchieMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            EntityRenderers.register(ModEntities.PEANUT.get(), PeanutRenderer::new);
            EntityRenderers.register(ModEntities.BOBBY.get(), BobbyRenderer::new); 
        });
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(Peanut.LAYER_LOCATION, Peanut::createBodyLayer); 
        event.registerLayerDefinition(Bobby.LAYER_LOCATION, Bobby::createBodyLayer);   
    }
}
