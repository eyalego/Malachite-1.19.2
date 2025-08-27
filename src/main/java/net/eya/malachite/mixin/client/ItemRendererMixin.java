package net.eya.malachite.mixin.client;

import net.eya.malachite.Malachite;
import net.eya.malachite.item.ModItems;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useRubyStaffModel(BakedModel value, ItemStack stack, ModelTransformation.Mode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (stack.isOf(ModItems.MALACHITE_LONGSWORD)) {
            assert stack.getNbt() != null;
            if (stack.getNbt().getInt("Charge") == 3 && !renderMode.equals(ModelTransformation.Mode.GUI)) {
                return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(Malachite.id("malachite_longsword_charged"), "charged"));
            }
            if (renderMode.equals(ModelTransformation.Mode.GUI)) {
                if (stack.getNbt().getInt("Charge") == 5) {
                    return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(Malachite.id("malachite_longsword_charged_icon"), "inventory_charged"));
                }
                return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(Malachite.id("malachite_longsword_icon"), "inventory"));
            }
        }
        return value;
    }
}