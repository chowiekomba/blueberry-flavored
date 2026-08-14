package chowie.blueberryflavored.mixin;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ToolMaterial;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ToolMaterial.class)
public class ToolMaterialMixin {
    @SuppressWarnings("rawtypes")
    @Definition(id = "ToolMaterial", type = ToolMaterial.class)
    @Expression("new ToolMaterial(?, ?, ?, ?, ?, ?)")
    @WrapOperation(
            method = "<clinit>",
            at = @At(value = "MIXINEXTRAS:EXPRESSION")
    )
    private static ToolMaterial inToolConstructors(
            TagKey incorrectBlocksForDrops, int durability, float speed, float attackDamageBonus, int enchantmentValue,
            TagKey repairItems, Operation<ToolMaterial> original) {
        return original.call(incorrectBlocksForDrops, durability * 2, speed + 1, attackDamageBonus,
                enchantmentValue, repairItems);
    }
}