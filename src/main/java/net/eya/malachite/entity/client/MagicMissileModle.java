package net.eya.malachite.entity.client;

import net.eya.malachite.Malachite;
import net.eya.malachite.entity.custom.MagicMissileEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class MagicMissileModle extends EntityModel<MagicMissileEntity> {
	public static final EntityModelLayer MAGIC_MISSILE = new EntityModelLayer(Identifier.of(Malachite.MOD_ID, "tomahawk"), "main");
	private final ModelPart bb_main;

	public MagicMissileModle(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create().uv(-1, 0).cuboid(-5.0F, 0.0F, -7.0F, 10.0F, 0.0F, 14.0F, new Dilation(0.0F))
				.uv(0, 1).cuboid(0.0F, -5.0F, -7.0F, 0.0F, 10.0F, 14.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(MagicMissileEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bb_main.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}
