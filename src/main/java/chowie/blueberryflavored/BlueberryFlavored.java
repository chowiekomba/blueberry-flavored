package chowie.blueberryflavored;

import chowie.blueberryflavored.item.ModItems;
import chowie.blueberryflavored.util.ItemDisplayUtil;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlueberryFlavored implements ModInitializer {
	public static final String MOD_ID = "blueberry-flavored";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Registering {}", MOD_ID);
		ModItems.init();
		ItemDisplayUtil.init();
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
