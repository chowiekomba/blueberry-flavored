package chowie.blueberryflavored.mixin;

import chowie.blueberryflavored.util.ItemDisplayUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Level.class)
public abstract class LevelMixin {
    @Inject(method = "removeBlock", at = @At("HEAD"))
    private void blueberryFlavored$destroyBlock(BlockPos pos, boolean movedByPiston, CallbackInfoReturnable<Boolean> cir) {
        Level l = (Level) (Object) this;
        if (!(l instanceof ServerLevel level)) {
            return;
        }

        BlockState state = level.getBlockState(pos);
        if (!state.is(BlockTags.ANVIL)) {
            return;
        }

        ItemDisplayUtil.onAnvilBreakOrMove(level, pos);
    }
}
