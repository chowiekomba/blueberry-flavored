package chowie.blueberryflavored.item.tags;

import chowie.blueberryflavored.BlueberryFlavored;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
    public static final TagKey<Item> REPAIRS_ROSE_GOLD_ARMOR = bind("repairs_rose_gold_armor");

    private static TagKey<Item> bind(final String name) {
        return TagKey.create(Registries.ITEM, BlueberryFlavored.id(name));
    }
}
