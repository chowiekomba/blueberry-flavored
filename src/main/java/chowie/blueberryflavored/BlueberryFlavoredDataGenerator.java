package chowie.blueberryflavored;

import chowie.blueberryflavored.datagen.ModItemTagProvider;
import chowie.blueberryflavored.datagen.ModModelProvider;
import chowie.blueberryflavored.datagen.ModRecipeProvider;
import chowie.blueberryflavored.datagen.VanillaRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator.Pack;
import org.jspecify.annotations.NonNull;

public class BlueberryFlavoredDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(@NonNull FabricDataGenerator fabricDataGenerator) {
		Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(VanillaRecipeProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModItemTagProvider::new);
	}
}
