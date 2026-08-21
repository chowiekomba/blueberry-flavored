package chowie.blueberryflavored.item;

import chowie.blueberryflavored.BlueberryFlavored;
import chowie.blueberryflavored.item.armor.RoseGoldArmorMaterial;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.function.Function;

public class ModItems {
    public static final Item COPPER_SHEET = register(ModItemIds.COPPER_SHEET, Item::new, new Item.Properties());

    public static final Item GOLD_SHEET = register(ModItemIds.GOLD_SHEET, Item::new, new Item.Properties());

    public static final Item IRON_SHEET = register(ModItemIds.IRON_SHEET, Item::new, new Item.Properties());
    // -18, 25
    public static final Item ROSE_GOLD_SHEET = register(ModItemIds.ROSE_GOLD_SHEET, Item::new, new Item.Properties());
    public static final Item ROSE_GOLD_INGOT = register(ModItemIds.ROSE_GOLD_INGOT, Item::new, new Item.Properties());
    public static final Item ROSE_GOLD_HELMET = register(ModItemIds.ROSE_GOLD_HELMET, Item::new, new Item.Properties()
            .humanoidArmor(RoseGoldArmorMaterial.INSTANCE, ArmorType.HELMET));
    public static final Item ROSE_GOLD_CHESTPLATE= register(ModItemIds.ROSE_GOLD_CHESTPLATE, Item::new, new Item.Properties()
            .humanoidArmor(RoseGoldArmorMaterial.INSTANCE, ArmorType.CHESTPLATE));
    public static final Item ROSE_GOLD_LEGGINGS = register(ModItemIds.ROSE_GOLD_LEGGINGS, Item::new, new Item.Properties()
            .humanoidArmor(RoseGoldArmorMaterial.INSTANCE, ArmorType.LEGGINGS));
    public static final Item ROSE_GOLD_BOOTS = register(ModItemIds.ROSE_GOLD_BOOTS, Item::new, new Item.Properties()
            .humanoidArmor(RoseGoldArmorMaterial.INSTANCE, ArmorType.BOOTS));
    public static final Item ROSE_GOLD_SWORD = register(ModItemIds.ROSE_GOLD_SWORD, Item::new, new Item.Properties()
            .sword(ToolMaterial.IRON, 3, -2.4F)
            .delayedHolderComponent(DataComponents.DAMAGE_TYPE, DamageTypes.MAGIC));
    public static final Item ROSE_GOLD_SHOVEL = register(ModItemIds.ROSE_GOLD_SHOVEL, settings ->
            new ShovelItem(ToolMaterial.IRON, 1.5F, -3, settings), new Item.Properties());
    public static final Item ROSE_GOLD_PICKAXE = register(ModItemIds.ROSE_GOLD_PICKAXE, Item::new, new Item.Properties()
            .pickaxe(ToolMaterial.IRON, 1, -2.8F));
    public static final Item ROSE_GOLD_AXE = register(ModItemIds.ROSE_GOLD_AXE, settings ->
            new AxeItem(ToolMaterial.IRON, 6, -3.1F, settings), new Item.Properties()
            .delayedHolderComponent(DataComponents.DAMAGE_TYPE, DamageTypes.MAGIC));
    public static final Item ROSE_GOLD_HOE = register(ModItemIds.ROSE_GOLD_HOE, settings ->
            new HoeItem(ToolMaterial.IRON, -2, -1, settings), new Item.Properties());
    public static final Item ROSE_GOLD_SPEAR = register(ModItemIds.ROSE_GOLD_SPEAR, Item::new, new Item.Properties()
            .spear(ToolMaterial.IRON, 0.95F, 0.95F, 0.6F, 2.5F, 11,
                    6.75F, 5.1F, 11.25F, 4.6F));

    public static final Item IRON_GOLD_SHEET = register(ModItemIds.IRON_GOLD_SHEET, Item::new, new Item.Properties());

    public static final Item DIAMOND_SHEET = register(ModItemIds.DIAMOND_SHEET, Item::new, new Item.Properties());

    public static final Item TITANIUM_SHEET = register(ModItemIds.TITANIUM_SHEET, Item::new, new Item.Properties());

    // creative mode tabs and keys
    public static final ResourceKey<CreativeModeTab> MOD_INGREDIENTS_TAB_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), BlueberryFlavored.id("mod_tab")
    );
    public static final CreativeModeTab MOD_TAB = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.IRON_SHEET))
            .title(Component.translatable("creativeTab.modTab"))
            .displayItems(((_, output) -> {
                output.accept(COPPER_SHEET);
                output.accept(GOLD_SHEET);
                output.accept(IRON_SHEET);
                output.accept(ROSE_GOLD_SHEET);
                output.accept(ROSE_GOLD_INGOT);
                output.accept(IRON_GOLD_SHEET);
                output.accept(DIAMOND_SHEET);
                output.accept(TITANIUM_SHEET);
                output.accept(ROSE_GOLD_HELMET);
                output.accept(ROSE_GOLD_CHESTPLATE);
                output.accept(ROSE_GOLD_LEGGINGS);
                output.accept(ROSE_GOLD_BOOTS);
                output.accept(ROSE_GOLD_SWORD);
                output.accept(ROSE_GOLD_SHOVEL);
                output.accept(ROSE_GOLD_PICKAXE);
                output.accept(ROSE_GOLD_AXE);
                output.accept(ROSE_GOLD_HOE);
                output.accept(ROSE_GOLD_SPEAR);
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
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, MOD_INGREDIENTS_TAB_KEY, MOD_TAB);
    }
}
