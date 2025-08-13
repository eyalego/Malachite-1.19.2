package net.eya.malachite.mixin;

import net.eya.malachite.item.ModItems;
import net.eya.malachite.potion.ModPotions;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BrewingRecipeRegistry.class)
public class BrewingRecipeRegistryMixin {
    @Inject(method = "registerDefaults", at = @At("TAIL"))
    private static void addCustomBrewing(CallbackInfo ci) {
        BrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, ModItems.MALACHITE, ModPotions.MAGIC_RESISTANCE_POTION);
        BrewingRecipeRegistry.registerPotionRecipe(ModPotions.MAGIC_RESISTANCE_POTION, Items.REDSTONE, ModPotions.LONG_MAGIC_RESISTANCE_POTION);
    }
}