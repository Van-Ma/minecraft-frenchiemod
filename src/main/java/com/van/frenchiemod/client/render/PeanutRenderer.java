package com.van.frenchiemod.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.van.frenchiemod.client.model.Peanut; 
import com.van.frenchiemod.entities.PeanutEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PeanutRenderer extends MobRenderer<PeanutEntity, Peanut<PeanutEntity>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation("frenchiemod", "textures/entity/peanuttexture.png");

    public PeanutRenderer(EntityRendererProvider.Context context) {
        super(context, new Peanut<>(context.bakeLayer(Peanut.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public void render(PeanutEntity entity, float entityYaw, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, matrixStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(PeanutEntity entity) {
        return TEXTURE;
    }
}
