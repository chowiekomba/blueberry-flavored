package chowie.blueberryflavored.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Items;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class VanillaRecipeProvider extends FabricRecipeProvider {
    public VanillaRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected @NonNull RecipeProvider createRecipeProvider(HolderLookup.@NonNull Provider registries, @NonNull RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                // remove all stone tools
                shaped(RecipeCategory.TOOLS, Items.STONE_PICKAXE)
                        .pattern("e")
                        .define('e', Items.EGG)
                        .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
                        .save(output);
                shaped(RecipeCategory.TOOLS, Items.STONE_AXE)
                        .pattern("e")
                        .define('e', Items.EGG)
                        .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
                        .save(output);
                shaped(RecipeCategory.TOOLS, Items.STONE_SHOVEL)
                        .pattern("e")
                        .define('e', Items.EGG)
                        .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
                        .save(output);
                shaped(RecipeCategory.TOOLS, Items.STONE_HOE)
                        .pattern("e")
                        .define('e', Items.EGG)
                        .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
                        .save(output);
                shaped(RecipeCategory.TOOLS, Items.STONE_SWORD)
                        .pattern("e")
                        .define('e', Items.EGG)
                        .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
                        .save(output);
                shaped(RecipeCategory.TOOLS, Items.STONE_SPEAR)
                        .pattern("e")
                        .define('e', Items.EGG)
                        .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
                        .save(output);

                // leather armor
                shaped(RecipeCategory.COMBAT, Items.LEATHER_HELMET)
                        .pattern("HHH")
                        .pattern("H H")
                        .define('H', Items.RABBIT_HIDE)
                        .unlockedBy(getHasName(Items.RABBIT_HIDE), has(Items.RABBIT_HIDE))
                        .save(output);
                shaped(RecipeCategory.COMBAT, Items.LEATHER_CHESTPLATE)
                        .pattern("H H")
                        .pattern("HHH")
                        .pattern("HHH")
                        .define('H', Items.RABBIT_HIDE)
                        .unlockedBy(getHasName(Items.RABBIT_HIDE), has(Items.RABBIT_HIDE))
                        .save(output);
                shaped(RecipeCategory.COMBAT, Items.LEATHER_LEGGINGS)
                        .pattern("HHH")
                        .pattern("H H")
                        .pattern("H H")
                        .define('H', Items.RABBIT_HIDE)
                        .unlockedBy(getHasName(Items.RABBIT_HIDE), has(Items.RABBIT_HIDE))
                        .save(output);
                shaped(RecipeCategory.COMBAT, Items.LEATHER_BOOTS)
                        .pattern("H H")
                        .pattern("H H")
                        .define('H', Items.RABBIT_HIDE)
                        .unlockedBy(getHasName(Items.RABBIT_HIDE), has(Items.RABBIT_HIDE))
                        .save(output);
            }
        };
    }

    @Override
    public @NonNull String getName() {
        return "BlueberryFlavoredVanillaRecipeProvider";
    }

    @Override
    protected @NonNull Identifier getRecipeIdentifier(Identifier identifier) {
        return Identifier.withDefaultNamespace(identifier.getPath());
    }
}
