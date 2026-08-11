package chowie.blueberryflavored.datagen;

import chowie.blueberryflavored.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import org.jspecify.annotations.NonNull;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(@NonNull BlockModelGenerators blockModelGenerators) {

    }

    @Override
    public void generateItemModels(@NonNull ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.COPPER_SHEET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.GOLD_SHEET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.IRON_SHEET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.IRON_GOLD_SHEET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ROSE_GOLD_SHEET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.DIAMOND_SHEET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.TITANIUM_SHEET, ModelTemplates.FLAT_ITEM);
    }

    @Override
    public @NonNull String getName() {
        return "BlueberryFlavoredModelProvider";
    }
}