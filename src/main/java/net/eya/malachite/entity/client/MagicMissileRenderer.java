package net.eya.malachite.entity.client;

import net.eya.malachite.Malachite;
import net.eya.malachite.entity.custom.MagicMissileEntity;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;


public class MagicMissileRenderer extends EntityRenderer<MagicMissileEntity> {
    private static final Identifier TEXTURE = new Identifier(Malachite.MOD_ID, "textures/entity/magic_missile.png");
    private final MagicMissileModle model;

    public MagicMissileRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        this.model = new MagicMissileModle(ctx.getPart(MagicMissileModle.MAGIC_MISSILE));
    }

    @Override
    public void render(MagicMissileEntity entity, float yaw, float tickDelta, MatrixStack matrices, net.minecraft.client.render.VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();

        matrices.translate(0.0f, 0.2f, 0.0f);

        matrices.scale(0.7f, 0.7f, 0.7f);

        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getEntityCutout(TEXTURE));
        this.model.render(matrices, vertexConsumer, light, net.minecraft.client.render.OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);

        matrices.pop();
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }

    @Override
    public Identifier getTexture(MagicMissileEntity entity) {
        return TEXTURE;
    }
}
