package com.van.frenchiemod.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.van.frenchiemod.client.model.Bobby; 
import com.van.frenchiemod.entities.BobbyEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BobbyRenderer extends MobRenderer<BobbyEntity, Bobby<BobbyEntity>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation("frenchiemod", "textures/entity/bobbytexture.png");

    public BobbyRenderer(EntityRendererProvider.Context context) {
        super(context, new Bobby<>(context.bakeLayer(Bobby.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public void render(BobbyEntity entity, float entityYaw, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, matrixStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(BobbyEntity entity) {
        return TEXTURE;
    }
}