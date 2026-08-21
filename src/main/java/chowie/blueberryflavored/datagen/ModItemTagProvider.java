package chowie.blueberryflavored.datagen;

import chowie.blueberryflavored.item.ModItemIds;
import chowie.blueberryflavored.item.tags.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
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
        builder(ItemTags.HEAD_ARMOR)
                .add(ModItemIds.ROSE_GOLD_HELMET);
        builder(ItemTags.CHEST_ARMOR)
                .add(ModItemIds.ROSE_GOLD_CHESTPLATE);
        builder(ItemTags.LEG_ARMOR)
                .add(ModItemIds.ROSE_GOLD_LEGGINGS);
        builder(ItemTags.FOOT_ARMOR)
                .add(ModItemIds.ROSE_GOLD_BOOTS);
    }
}
