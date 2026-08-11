package chowie.blueberryflavored.item;

import chowie.blueberryflavored.BlueberryFlavored;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.function.Function;

public class ModItems {
    public static final Item COPPER_SHEET = register(ModItemIds.COPPER_SHEET, Item::new, new Item.Properties());
    public static final Item GOLD_SHEET = register(ModItemIds.GOLD_SHEET, Item::new, new Item.Properties());
    public static final Item IRON_SHEET = register(ModItemIds.IRON_SHEET, Item::new, new Item.Properties());
    // -18, 25
    public static final Item ROSE_GOLD_SHEET = register(ModItemIds.ROSE_GOLD_SHEET, Item::new, new Item.Properties());
    public static final Item IRON_GOLD_SHEET = register(ModItemIds.IRON_GOLD_SHEET, Item::new, new Item.Properties());
    public static final Item DIAMOND_SHEET = register(ModItemIds.DIAMOND_SHEET, Item::new, new Item.Properties());
    public static final Item TITANIUM_SHEET = register(ModItemIds.TITANIUM_SHEET, Item::new, new Item.Properties());

    // creative mode tabs and keys
    public static final ResourceKey<CreativeModeTab> MOD_INGREDIENTS_TAB_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), BlueberryFlavored.id("mod_ingredients_tab")
    );
    public static final CreativeModeTab MOD_INGREDIENTS_TAB = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.IRON_SHEET))
            .title(Component.translatable("creativeTab.modIngredients"))
            .displayItems(((_, output) -> {
                output.accept(COPPER_SHEET);
                output.accept(GOLD_SHEET);
                output.accept(IRON_SHEET);
                output.accept(ROSE_GOLD_SHEET);
                output.accept(IRON_GOLD_SHEET);
                output.accept(DIAMOND_SHEET);
                output.accept(TITANIUM_SHEET);
            }))
            .build();

    public static Item register(ResourceKey<Item> itemKey, Function<Item.Properties, Item> itemFactory, Item.Properties settings) {
        // Create the item instance
        Item item = itemFactory.apply(settings.setId(itemKey));

        // register the item
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    public static void init() {
        BlueberryFlavored.LOGGER.info("Registering items for {}", BlueberryFlavored.MOD_ID);
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, MOD_INGREDIENTS_TAB_KEY, MOD_INGREDIENTS_TAB);
    }
}
