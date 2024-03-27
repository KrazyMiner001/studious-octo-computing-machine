package com.goggaguys.item.custom;

import com.goggaguys.entity.ModEntities;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TokenOfTheLeafGodItem extends Item {
    public TokenOfTheLeafGodItem() {
        super(new FabricItemSettings());
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world instanceof ServerWorld serverWorld) {
            user.getStackInHand(hand).setCount(user.getMainHandStack().getCount() - 1);
            Position pos = user.getPos();
            Entity entity = ModEntities.LEAF_GOD.spawnFromItemStack(serverWorld, user.getMainHandStack(), user, new BlockPos((int) pos.getX(), (int) (pos.getY() + 10), (int) pos.getZ()), SpawnReason.SPAWN_EGG, false, false);
            return TypedActionResult.consume(user.getStackInHand(hand));
        }
        return TypedActionResult.fail(user.getStackInHand(hand));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(1, Text.empty());
        tooltip.add(2, Text.translatable("item.octocomputing.leaf_god_spawn_item.tooltip").formatted(Formatting.GRAY));
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
