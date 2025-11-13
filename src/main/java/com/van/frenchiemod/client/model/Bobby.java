package com.van.frenchiemod.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel; 
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.animal.Wolf;

import com.van.frenchiemod.entities.BobbyEntity; 


public class Bobby<T extends Wolf> extends HierarchicalModel<T> {

	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("frenchiemod", "peanut"), "main");
    private final ModelPart root;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart left_front_leg;
	private final ModelPart right_front_leg;
	private final ModelPart left_hind_leg;
	private final ModelPart right_hind_leg;
	private final ModelPart mane;
	private final ModelPart tail;

	public Bobby(ModelPart root) {
        this.root = root;
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.left_front_leg = root.getChild("left_front_leg");
		this.right_front_leg = root.getChild("right_front_leg");
		this.left_hind_leg = root.getChild("left_hind_leg");
		this.right_hind_leg = root.getChild("right_hind_leg");
		this.mane = root.getChild("mane");
		this.tail = root.getChild("tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(8, 0).addBox(-3.0F, -12.0F, -7.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(22, 10).addBox(1.0F, -14.0F, -5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(22, 16).addBox(-3.0F, -14.0F, -5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 18).addBox(-3.0F, -11.0F, -1.0F, 6.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(26, 0).addBox(-1.0F, -10.0F, 7.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition left_front_leg = partdefinition.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(0, 11).addBox(1.0F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition left_hind_leg = partdefinition.addOrReplaceChild("left_hind_leg", CubeListBuilder.create().texOffs(0, 19).addBox(1.0F, -5.0F, 5.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition right_hind_leg = partdefinition.addOrReplaceChild("right_hind_leg", CubeListBuilder.create().texOffs(0, 4).addBox(-3.0F, -5.0F, 5.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition right_front_leg = partdefinition.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(0, 4).addBox(-3.0F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition mane = partdefinition.addOrReplaceChild("mane", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

@Override
public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    if (entity.isInSittingPose()) {
          float sittingRotation = -(float) Math.PI/2; 

        this.body.xRot = sittingRotation;
        this.body.y = 17.0F;
        this.body.z = 0F;
        this.head.y = 22F;
        this.head.z = 12F;

        this.left_front_leg.xRot = sittingRotation;
        this.right_front_leg.xRot = sittingRotation;

        this.left_front_leg.y = 17F;
        this.right_front_leg.y = 17F;

        this.left_hind_leg.y = 15F;
        this.right_hind_leg.y = 15F;
        

        this.left_front_leg.x = 0F;    
        this.right_front_leg.x = 0F;   
        this.left_hind_leg.x = 0F;
        this.right_hind_leg.x = 0F;

        this.left_hind_leg.xRot = sittingRotation;
        this.right_hind_leg.xRot = sittingRotation;
        this.tail.xRot = sittingRotation;
        this.mane.xRot = sittingRotation;


   } else {
    //walking
        this.body.xRot = 0.0F;
		this.left_front_leg.xRot = Mth.cos(limbSwing * 0.6662F) * 0.4F * limbSwingAmount;
		this.right_hind_leg.xRot = Mth.cos(limbSwing * 0.6662F) * 0.1F * limbSwingAmount;

		this.right_front_leg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.4F * limbSwingAmount;
		this.left_hind_leg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.1F * limbSwingAmount;

        this.tail.xRot = 0.0F;
        this.mane.xRot = 0.0F;

        this.body.y = 24.0F;
        this.body.z = 0F;
        this.left_front_leg.y = 24F;
        this.right_front_leg.y = 24F;
        
        this.left_hind_leg.y = 23F;
        this.right_hind_leg.y = 23F;

        this.head.y = 25F;
        this.head.z = 0F;

        
        this.left_front_leg.x = 0F;
        this.right_front_leg.x = 0F;
        this.left_hind_leg.x = 0F;
        this.right_hind_leg.x = 0F;

    }
}

@Override
public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
    this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
}

@Override
public ModelPart root() {
    return this.root;
}

}