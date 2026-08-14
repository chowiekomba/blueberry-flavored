package chowie.blueberryflavored.mixin;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorMaterials;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Map;

@Mixin(ArmorMaterials.class)
public interface ArmorMaterialsMixin {
    @SuppressWarnings("rawtypes")
    @Definition(id = "ArmorMaterial", type = ArmorMaterial.class)
    @Expression("new ArmorMaterial(?, ?, ?, ?, ?, ?, ?, ?)")
    @WrapOperation(
            method = "<clinit>",
            at = @At("MIXINEXTRAS:EXPRESSION")
    )
    private static ArmorMaterial inArmorMaterialsConstructors(int durability, Map defense, int enchantmentValue,
                                                              Holder equipSound, float toughness, float knockbackResistance,
                                                              TagKey repairIngredient, ResourceKey assetId, Operation<ArmorMaterial> original) {
        return original.call(durability * 2, defense, enchantmentValue, equipSound, toughness, knockbackResistance,
                repairIngredient, assetId);
    }
}
