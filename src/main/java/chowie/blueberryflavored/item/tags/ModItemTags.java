package chowie.blueberryflavored.item.tags;

import chowie.blueberryflavored.BlueberryFlavored;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
    public static final TagKey<Item> REPAIRS_ROSE_GOLD_ARMOR = bind("repairs_rose_gold_armor");
    public static final TagKey<Item> ROSE_GOLD_TOOLS = bind("rose_gold_tools");
    public static final TagKey<Item> SHEETS = bind("sheets");
    public static final TagKey<Item> HAMMERS = bind("hammers");
    public static final TagKey<Item> REQUIRES_STONE_HAMMER = bind("requires_stone_hammer");
    public static final TagKey<Item> REQUIRES_COPPER_HAMMER = bind("requires_copper_hammer");
    public static final TagKey<Item> REQUIRES_IRON_HAMMER = bind("requires_iron_hammer");
    public static final TagKey<Item> REQUIRES_DIAMOND_HAMMER = bind("requires_diamond_hammer");

    private static TagKey<Item> bind(final String name) {
        return TagKey.create(Registries.ITEM, BlueberryFlavored.id(name));
    }
}
