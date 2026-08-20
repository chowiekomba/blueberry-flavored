package chowie.blueberryflavored.datagen;

import chowie.blueberryflavored.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected @NonNull RecipeProvider createRecipeProvider(HolderLookup.@NonNull Provider registries, @NonNull RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                shaped(RecipeCategory.COMBAT, ModItems.ROSE_GOLD_HELMET)
                        .pattern("RHR")
                        .pattern("R R")
                        .define('R', ModItems.ROSE_GOLD_SHEET)
                        .define('H', Items.LEATHER_HELMET)
                        .unlockedBy(getHasName(ModItems.ROSE_GOLD_SHEET), has(ModItems.ROSE_GOLD_SHEET))
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.ROSE_GOLD_CHESTPLATE)
                        .pattern("R R")
                        .pattern("RCR")
                        .pattern("RRR")
                        .define('R', ModItems.ROSE_GOLD_SHEET)
                        .define('C', Items.LEATHER_CHESTPLATE)
                        .unlockedBy(getHasName(ModItems.ROSE_GOLD_SHEET), has(ModItems.ROSE_GOLD_SHEET))
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.ROSE_GOLD_LEGGINGS)
                        .pattern("RLR")
                        .pattern("R R")
                        .pattern("R R")
                        .define('R', ModItems.ROSE_GOLD_SHEET)
                        .define('L', Items.LEATHER_LEGGINGS)
                        .unlockedBy(getHasName(ModItems.ROSE_GOLD_SHEET), has(ModItems.ROSE_GOLD_SHEET))
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.ROSE_GOLD_BOOTS)
                        .pattern("RBR")
                        .pattern("R R")
                        .define('R', ModItems.ROSE_GOLD_SHEET)
                        .define('B', Items.LEATHER_BOOTS)
                        .unlockedBy(getHasName(ModItems.ROSE_GOLD_SHEET), has(ModItems.ROSE_GOLD_SHEET))
                        .save(output);

                shapeless(RecipeCategory.MISC, Items.LEATHER)
                        .requires(Items.RABBIT_HIDE, 4)
                        .unlockedBy(getHasName(Items.RABBIT_HIDE), has(Items.RABBIT_HIDE))
                        .save(output);
                shapeless(RecipeCategory.MISC, Items.RABBIT_HIDE, 4)
                        .requires(Items.LEATHER, 1)
                        .unlockedBy(getHasName(Items.LEATHER), has(Items.LEATHER))
                        .save(output);
            }
        };
    }

    @Override
    public String getName() {
        return "BlueberryFlavoredRecipeProvider";
    }
}
