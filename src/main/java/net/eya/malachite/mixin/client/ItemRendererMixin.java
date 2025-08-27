package net.eya.malachite.mixin.client;

import net.eya.malachite.Malachite;
import net.eya.malachite.item.ModItems;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.Map;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {

    //Btw the inv texture is the base malachite_sword.json
    //The alt is the 32x32 texture in here cause that what i have been using for Flosetira, Azara and Community Arsenal.
    //And wasn't about to switch it up :D
    private static final Map<Item, String> ALT_MODELS = Map.ofEntries(
            Map.entry(ModItems.MALACHITE_LONGSWORD, "malachite_longsword_alt")

    );

    //if it has 5 charges the texture changes
    private static final Map<Item, String> CHARGE_5 = Map.ofEntries(
            Map.entry(ModItems.MALACHITE_LONGSWORD, "malachite_longsword_charged_alt")
    );

    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useLongSwordModel(
            BakedModel originalModel,
            ItemStack stack,
            ModelTransformation.Mode renderMode,
            boolean leftHanded,
            MatrixStack matrices,
            VertexConsumerProvider vertexConsumers,
            int light,
            int overlay
    ) {
        if (renderMode == ModelTransformation.Mode.GUI) {
            return originalModel;
        }

        int modelStage = stack.getOrCreateNbt().getInt("Charge");
        Item item = stack.getItem();

        String modelName = null;

        //Model stage code, if in the future you want more weapons that aren't using the charge nbt or using different amount of charge.
        //You have to change this otherwise for normal big sword it's fine.
        if (modelStage <= 4) {
            modelName = ALT_MODELS.get(item);
        } else if (modelStage > 4) {
            modelName = CHARGE_5.get(item);
        }

        if (modelName != null) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager()
                    .getModel(new ModelIdentifier(Malachite.MOD_ID, modelName, "inventory"));
        }

        return originalModel;
    }

}