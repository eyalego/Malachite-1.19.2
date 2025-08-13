package net.eya.malachite.item;

import net.eya.malachite.Malachite;
import net.eya.malachite.item.Items.MalachiteSwordItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {


    public static final Item MALACHITE = registerItem("malachite",
            new Item(new FabricItemSettings().group(ItemGroup.MISC)));

    public static final Item MALACHITE_SWORD = registerItem("malachite_sword",
            new MalachiteSwordItem(ToolMaterials.DIAMOND, 5, -3.5f,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));


    private static Item registerItem(String name, Item CamaraOfTheOtherSideItem) {
        return Registry.register(Registry.ITEM, new Identifier(Malachite.MOD_ID, name), CamaraOfTheOtherSideItem);
    }

    public static void registerModItems() {
        Malachite.LOGGER.debug("Registering Mod Items for " + Malachite.MOD_ID);
    }
}

