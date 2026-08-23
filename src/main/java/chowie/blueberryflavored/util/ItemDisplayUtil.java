package chowie.blueberryflavored.util;

import chowie.blueberryflavored.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Display;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.AABB;

import java.util.Map;
import java.util.Optional;

public class ItemDisplayUtil {
    public static final Map<Item, Item> INGOT_TO_SHEET = Map.of(
            Items.COPPER_INGOT, ModItems.COPPER_SHEET,
            Items.GOLD_INGOT, ModItems.GOLD_SHEET,
            Items.IRON_INGOT, ModItems.IRON_SHEET,
            ModItems.IRON_GOLD_INGOT, ModItems.IRON_GOLD_SHEET,
            ModItems.ROSE_GOLD_INGOT, ModItems.ROSE_GOLD_SHEET,
            Items.DIAMOND, ModItems.DIAMOND_SHEET
    );

    public static Optional<Display.ItemDisplay> getDisplayAt(ServerLevel level, BlockPos pos) {
        AABB searchBox = new AABB(pos).inflate(0.5);
        return level.getEntitiesOfClass(Display.ItemDisplay.class, searchBox, _ -> true)
                .stream().findFirst();
    }

    public static void onAnvilBreakOrMove(ServerLevel level, BlockPos pos) {
        Optional<Display.ItemDisplay> display = ItemDisplayUtil.getDisplayAt(level, pos);
        display.ifPresent(itemDisplay -> {
            ItemEntity item = new ItemEntity(level, itemDisplay.getX(), itemDisplay.getY(), itemDisplay.getZ(),
                    itemDisplay.getItemStack().copy());

            level.addFreshEntity(item);
            itemDisplay.discard();
        });
    }

    public static void init() {

    }
}
