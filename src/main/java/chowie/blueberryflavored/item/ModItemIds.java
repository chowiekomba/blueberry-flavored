package chowie.blueberryflavored.item;

import chowie.blueberryflavored.BlueberryFlavored;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class ModItemIds {
    public static final ResourceKey<Item> COPPER_SHEET = create("copper_sheet");

    public static final ResourceKey<Item> GOLD_SHEET = create("gold_sheet");

    public static final ResourceKey<Item> IRON_SHEET = create("iron_sheet");

    public static final ResourceKey<Item> ROSE_GOLD_SHEET = create("rose_gold_sheet");
    public static final ResourceKey<Item> ROSE_GOLD_INGOT = create("rose_gold_ingot");
    public static final ResourceKey<Item> ROSE_GOLD_HELMET = create("rose_gold_helmet");
    public static final ResourceKey<Item> ROSE_GOLD_CHESTPLATE = create("rose_gold_chestplate");
    public static final ResourceKey<Item> ROSE_GOLD_LEGGINGS = create("rose_gold_leggings");
    public static final ResourceKey<Item> ROSE_GOLD_BOOTS = create("rose_gold_boots");

    public static final ResourceKey<Item> IRON_GOLD_SHEET = create("iron_gold_sheet");

    public static final ResourceKey<Item> DIAMOND_SHEET = create("diamond_sheet");

    public static final ResourceKey<Item> TITANIUM_SHEET = create("titanium_sheet");

    public static ResourceKey<Item> create (String name) {
        // create the item key
        return ResourceKey.create(Registries.ITEM, BlueberryFlavored.id(name));
    }
}
