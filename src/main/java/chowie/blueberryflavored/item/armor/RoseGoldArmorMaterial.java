package chowie.blueberryflavored.item.armor;

import chowie.blueberryflavored.BlueberryFlavored;
import chowie.blueberryflavored.item.tags.ModItemTags;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.Map;

public class RoseGoldArmorMaterial {
    public static final int BASE_DURABILITY = 30;
    public static final ResourceKey<EquipmentAsset>  ROSE_GOLD_ARMOR_MATERIAL_KEY = ResourceKey.create(
            EquipmentAssets.ROOT_ID, BlueberryFlavored.id("rose_gold")
    );
    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    ArmorType.HELMET, 2,
                    ArmorType.CHESTPLATE, 6,
                    ArmorType.LEGGINGS, 5,
                    ArmorType.BOOTS, 2
            ),
            9,
            SoundEvents.ARMOR_EQUIP_IRON,
            0.0F,
            0.0F,
            ModItemTags.REPAIRS_ROSE_GOLD_ARMOR,
            ROSE_GOLD_ARMOR_MATERIAL_KEY
    );

}
