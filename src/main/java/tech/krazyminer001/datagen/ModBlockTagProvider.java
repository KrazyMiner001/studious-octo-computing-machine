package tech.krazyminer001.datagen;

import tech.krazyminer001.block.ModBlockTags;
import tech.krazyminer001.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.LEAFSTONE_BLOCK)
                .add(ModBlocks.LEAF_ORE)
                .add(ModBlocks.DEEPSLATE_LEAF_ORE)
                .add(ModBlocks.EXTRATERRESTRIAL_LEAF_DEBRIS)
                .add(ModBlocks.CHLOROPHYTE_BLOCK);

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.MYSTERY_LEAVES);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.MYSTERY_LOG)
                .add(ModBlocks.MYSTERY_WOOD)
                .add(ModBlocks.STRIPPED_MYSTERY_LOG)
                .add(ModBlocks.STRIPPED_MYSTERY_WOOD)
                .add(ModBlocks.MYSTERY_PLANKS);

        getOrCreateTagBuilder(BlockTags.SAPLINGS)
                .add(ModBlocks.MYSTERY_SAPLING)
                .add(ModBlocks.TRANSIENTWOOD_SAPLING);

        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS)
                .add(ModBlocks.LEAFSTONE_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.MYSTERY_LEAVES)
                .add(ModBlocks.MYSTERY_LOG)
                .add(ModBlocks.MYSTERY_WOOD)
                .add(ModBlocks.STRIPPED_MYSTERY_LOG)
                .add(ModBlocks.STRIPPED_MYSTERY_WOOD)
                .add(ModBlocks.MYSTERY_PLANKS);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                ;

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.LEAF_ORE)
                .add(ModBlocks.LEAFSTONE_BLOCK);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_4")))
                .add(ModBlocks.DEEPSLATE_LEAF_ORE);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_5")))
                .add(ModBlocks.EXTRATERRESTRIAL_LEAF_DEBRIS)
                .add(ModBlocks.CHLOROPHYTE_BLOCK);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_6")));

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.MYSTERY_LOG)
                .add(ModBlocks.MYSTERY_WOOD)
                .add(ModBlocks.STRIPPED_MYSTERY_LOG)
                .add(ModBlocks.STRIPPED_MYSTERY_WOOD);

        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.MYSTERY_PLANKS);

        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_WOODEN_TOOL)
                .addTag(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_6")))
                .addTag(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_5")))
                .addTag(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_4")));

        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_GOLD_TOOL)
                .addTag(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_6")))
                .addTag(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_5")))
                .addTag(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_4")));

        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .addTag(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_6")))
                .addTag(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_5")))
                .addTag(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_4")));

        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .addTag(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_6")))
                .addTag(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_5")))
                .addTag(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_4")));

        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .addTag(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_6")))
                .addTag(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_5")))
                .addTag(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_4")));

        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_NETHERITE_TOOL)
                .addTag(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_6")))
                .addTag(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_5")));

        getOrCreateTagBuilder(ModBlockTags.INCORRECT_FOR_LEAFITE_TOOL)
                .addTag(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_6")));

        getOrCreateTagBuilder(ModBlockTags.INCORRECT_FOR_CHLOROPHYTE_TOOL);
    }
}
