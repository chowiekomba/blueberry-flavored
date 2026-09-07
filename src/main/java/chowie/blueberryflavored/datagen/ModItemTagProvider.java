package chowie.blueberryflavored.datagen;

import chowie.blueberryflavored.item.ModItemIds;
import chowie.blueberryflavored.item.tags.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.references.ItemIds;
import net.minecraft.tags.ItemTags;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider registries) {
        builder(ModItemTags.REPAIRS_ROSE_GOLD_ARMOR)
                .add(ModItemIds.ROSE_GOLD_INGOT);

        builder(ModItemTags.ROSE_GOLD_TOOLS)
                .add(ModItemIds.ROSE_GOLD_SWORD)
                .add(ModItemIds.ROSE_GOLD_SHOVEL)
                .add(ModItemIds.ROSE_GOLD_PICKAXE)
                .add(ModItemIds.ROSE_GOLD_AXE)
                .add(ModItemIds.ROSE_GOLD_SPEAR);

        builder(ModItemTags.SHEETS)
                .add(ModItemIds.COPPER_SHEET)
                .add(ModItemIds.GOLD_SHEET)
                .add(ModItemIds.IRON_SHEET)
                .add(ModItemIds.IRON_GOLD_SHEET)
                .add(ModItemIds.ROSE_GOLD_SHEET)
                .add(ModItemIds.DIAMOND_SHEET);

        builder(ConventionalItemTags.INGOTS)
                .add(ItemIds.COPPER_INGOT)
                .add(ItemIds.GOLD_INGOT)
                .add(ItemIds.IRON_INGOT)
                .add(ItemIds.DIAMOND)
                .add(ModItemIds.ROSE_GOLD_INGOT)
                .add(ModItemIds.IRON_GOLD_INGOT);

        builder(ModItemTags.HAMMERS)
                .add(ModItemIds.STONE_HAMMER)
                .add(ModItemIds.COPPER_HAMMER)
                .add(ModItemIds.IRON_HAMMER)
                .add(ModItemIds.DIAMOND_HAMMER);

        builder(ModItemTags.REQUIRES_STONE_HAMMER)
                .add(ItemIds.COPPER_INGOT);
        builder(ModItemTags.REQUIRES_COPPER_HAMMER)
                .add(ItemIds.IRON_INGOT)
                .add(ItemIds.GOLD_INGOT)
                .addTag(ModItemTags.REQUIRES_STONE_HAMMER);
        builder(ModItemTags.REQUIRES_IRON_HAMMER)
                .add(ItemIds.DIAMOND)
                .add(ModItemIds.IRON_GOLD_INGOT)
                .add(ModItemIds.ROSE_GOLD_INGOT)
                .addTag(ModItemTags.REQUIRES_COPPER_HAMMER);
        builder(ModItemTags.REQUIRES_DIAMOND_HAMMER)
                .addTag(ModItemTags.REQUIRES_IRON_HAMMER);

        builder(ItemTags.HEAD_ARMOR)
                .add(ModItemIds.ROSE_GOLD_HELMET);
        builder(ItemTags.CHEST_ARMOR)
                .add(ModItemIds.ROSE_GOLD_CHESTPLATE);
        builder(ItemTags.LEG_ARMOR)
                .add(ModItemIds.ROSE_GOLD_LEGGINGS);
        builder(ItemTags.FOOT_ARMOR)
                .add(ModItemIds.ROSE_GOLD_BOOTS);

        builder(ItemTags.DURABILITY_ENCHANTABLE)
                .addTag(ModItemTags.HAMMERS);
    }
}
