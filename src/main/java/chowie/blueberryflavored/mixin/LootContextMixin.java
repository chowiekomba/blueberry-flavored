package chowie.blueberryflavored.mixin;

import chowie.blueberryflavored.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.context.ContextKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LootContext.class)
public abstract class LootContextMixin {

    @Inject(method = "getParameter", at = @At("RETURN"), cancellable = true)
    private <T> void blueberryFlavored$getParameter(ContextKey<T> key, CallbackInfoReturnable<T> cir) {
        blueberryFlavored$commonMethod(key, cir);
    }

    @Inject(method = "getOptionalParameter", at = @At("RETURN"), cancellable = true)
    private <T> void blueberryFlavored$getOptionalParameter(ContextKey<T> key, CallbackInfoReturnable<T> cir) {
        blueberryFlavored$commonMethod(key, cir);
    }

    @SuppressWarnings("unchecked")
    @Unique
    private <T> void blueberryFlavored$commonMethod(ContextKey<T> key, CallbackInfoReturnable<T> cir) {
        if (key != LootContextParams.TOOL) {
            return;
        }

        Object value = cir.getReturnValue();
        if (!(value instanceof ItemStack stack)) {
            return;
        }
        if (!(stack.getItem().equals(ModItems.ROSE_GOLD_SHOVEL) || stack.getItem().equals(ModItems.ROSE_GOLD_PICKAXE)
        || stack.getItem().equals(ModItems.ROSE_GOLD_AXE))) {
            return;
        }

        LootContext self = (LootContext) (Object) this;
        Holder<Enchantment> silkTouch = self.getResolver().lookupOrThrow(Registries.ENCHANTMENT)
                .getOrThrow(Enchantments.SILK_TOUCH);

        ItemStack ghostTool = stack.copy();
        ghostTool.enchant(silkTouch, 1);

        cir.setReturnValue((T) ghostTool);
    }
}