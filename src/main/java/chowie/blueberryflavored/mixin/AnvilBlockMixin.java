package chowie.blueberryflavored.mixin;

import chowie.blueberryflavored.item.tags.ModItemTags;
import chowie.blueberryflavored.util.ItemDisplayUtil;
import com.mojang.math.Transformation;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Display;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AnvilBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(AnvilBlock.class)
public class AnvilBlockMixin {
    @Inject(method = "useWithoutItem", at = @At("HEAD"), cancellable = true)
    private void blueberryFlavored$useWithoutItem(BlockState state, Level level, BlockPos pos, Player player,
                                                  BlockHitResult hitResult, CallbackInfoReturnable<InteractionResult> cir) {
        if (!(player instanceof ServerPlayer serverPlayer)) {
            return;
        }
        ItemStack playerMainHandStack = player.getItemInHand(InteractionHand.MAIN_HAND);
        if (serverPlayer.getMainHandItem().is(ConventionalItemTags.INGOTS) && ItemDisplayUtil.getDisplayAt(
                serverPlayer.level(), pos).isEmpty()) {
            Display.ItemDisplay display = EntityTypes.ITEM_DISPLAY.create(serverPlayer.level(), EntitySpawnReason.TRIGGERED);
            if (display == null) {
                return;
            }

            // get required rotation
            double dx = serverPlayer.getX() - (pos.getX() + 0.5);
            double dz = serverPlayer.getZ() - (pos.getZ() + 0.5);
            float yaw = (float) Math.atan2(dx, dz);

            // get the display ready
            display.setItemStack(serverPlayer.getMainHandItem().copy());
            display.setPos(pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5);

            display.setTransformation(new Transformation(
                    new Vector3f(0f, 0f, 0f),
                    new Quaternionf().rotationY(yaw).rotateX((float) Math.toRadians(-90)),
                    new Vector3f(0.5f, 0.5f, 0.5f),
                    new Quaternionf()
            ));

            serverPlayer.level().addFreshEntity(display);
            serverPlayer.getMainHandItem().setCount(serverPlayer.getMainHandItem().count() - 1);

            cir.setReturnValue(InteractionResult.SUCCESS);
        } else if (hitResult.getDirection().equals(Direction.UP) && playerMainHandStack.is(ModItemTags.HAMMERS)) {
            Optional<Display.ItemDisplay> optionalDisplay = ItemDisplayUtil.getDisplayAt(serverPlayer.level(), pos);
            if (optionalDisplay.isPresent()) {
                Display.ItemDisplay display = optionalDisplay.get();
                if (!display.getItemStack().is(ItemDisplayUtil.HAMMER_TO_TAG.get(playerMainHandStack.getItem()))) {
                    serverPlayer.sendSystemMessage(Component.translatable("hammer.weak.message"), true);
                    cir.setReturnValue(InteractionResult.FAIL);
                    return;
                }
                ItemEntity item = new ItemEntity(serverPlayer.level(), pos.getX() + 0.5, pos.getY() + 1,
                        pos.getZ() + 0.5, ItemDisplayUtil.INGOT_TO_SHEET.get(display.getItemStack().getItem())
                        .getDefaultInstance());

                display.discard();
                serverPlayer.level().addFreshEntity(item);
                serverPlayer.level().playSound(null, pos, SoundEvents.ANVIL_USE, SoundSource.BLOCKS);

                player.getItemInHand(InteractionHand.MAIN_HAND).hurtAndBreak(1, player, InteractionHand.MAIN_HAND);
                cir.setReturnValue(InteractionResult.SUCCESS);
            }
        }
    }

    @Inject(method = "falling", at = @At("HEAD"))
    private void blueberryFlavored$falling(FallingBlockEntity entity, CallbackInfo ci) {
        Level l = entity.level();
        if (!(l instanceof ServerLevel level)) {
            return;
        }
        ItemDisplayUtil.onAnvilBreakOrMove(level, new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ()));
    }
}
