package com.van.frenchiemod.entities;

import com.van.frenchiemod.FrenchieMod;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FrenchieMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, FrenchieMod.MODID);

    // Register Peanut 
    public static final RegistryObject<EntityType<PeanutEntity>> PEANUT = ENTITIES.register("peanut",
            () -> EntityType.Builder.of(PeanutEntity::new, MobCategory.CREATURE)
                    .sized(0.6f, 0.85f)
                    .build(new ResourceLocation(FrenchieMod.MODID, "peanut").toString()));

    // Register Bobby 
    public static final RegistryObject<EntityType<BobbyEntity>> BOBBY = ENTITIES.register("bobby",
            () -> EntityType.Builder.of(BobbyEntity::new, MobCategory.CREATURE)
                    .sized(0.6f, 0.85f) 
                    .build(new ResourceLocation(FrenchieMod.MODID, "bobby").toString()));

    public static void register(net.minecraftforge.eventbus.api.IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(PEANUT.get(), PeanutEntity.createAttributes().build());
        event.put(BOBBY.get(), BobbyEntity.createAttributes().build());
    }
}
