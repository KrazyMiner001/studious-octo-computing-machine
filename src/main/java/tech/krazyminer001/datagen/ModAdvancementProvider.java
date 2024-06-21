package tech.krazyminer001.datagen;

import net.minecraft.advancement.criterion.RecipeCraftedCriterion;
import tech.krazyminer001.OctoComputing;
import tech.krazyminer001.entity.ModEntities;
import tech.krazyminer001.item.ModItemTags;
import tech.krazyminer001.item.ModItems;
import static tech.krazyminer001.utility.Util.of;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.*;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.OnKilledCriterion;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup registryLookup, Consumer<AdvancementEntry> consumer) {
        // region Investigation Advancements
        consumer.accept(new AdvancementEntry(
                of("investigation/root"),
                new Advancement(
                        Optional.empty(),
                        Optional.of(new AdvancementDisplay(
                                ModItems.LEAF_PICKER.getDefaultStack(),
                                Text.translatable("advancements.octocomputing.investigation.root.title"),
                                Text.translatable("advancements.octocomputing.investigation.root.description"),
                                Optional.of(of("textures/gui/advancements/background/investigation.png")),
                                AdvancementFrame.TASK,
                                false,
                                false,
                                false
                                )),
                        AdvancementRewards.NONE,
                        Map.of(
                                "crafted_leaf_picker", RecipeCraftedCriterion.Conditions.create(of("leaf_picker"))
                        ),
                        new AdvancementRequirements(
                                List.of(
                                        List.of("crafted_leaf_picker")
                                )
                        ),
                        false
                )
        ));

        consumer.accept(new AdvancementEntry(
                of("investigation/get_leaf"),
                new Advancement(
                        Optional.empty(),
                        Optional.of(new AdvancementDisplay(
                                ModItems.MIXED_LEAF.getDefaultStack(),
                                Text.translatable("advancements.octocomputing.investigation.get_leaf.title"),
                                Text.translatable("advancements.octocomputing.investigation.get_leaf.description"),
                                Optional.empty(),
                                AdvancementFrame.TASK,
                                false,
                                false,
                                false
                        )),
                        AdvancementRewards.NONE,
                        Map.of(
                                "collected_leaf", InventoryChangedCriterion.Conditions.items(
                                        ItemPredicate.Builder.create()
                                                .tag(ModItemTags.LEAF)
                                                .tag(ModItemTags.LEAF_COMPRESSED)
                                                .tag(ModItemTags.LEAF_DOUBLE_COMPRESSED)
                                                .build()
                                )
                        ),
                        new AdvancementRequirements(
                                List.of(
                                        List.of("collected_leaf")
                                )
                        ),
                        false
                )
        ));

        consumer.accept(new AdvancementEntry(
                of("investigation/get_mixed_leaf"),
                new Advancement(
                        Optional.of(of("investigation/get_leaf")),
                        Optional.of(new AdvancementDisplay(
                                ModItems.MIXED_LEAF.getDefaultStack(),
                                Text.translatable("advancements.octocomputing.investigation.get_mixed_leaf.title"),
                                Text.translatable("advancements.octocomputing.investigation.get_mixed_leaf.description"),
                                Optional.empty(),
                                AdvancementFrame.GOAL,
                                false,
                                false,
                                false
                        )),
                        AdvancementRewards.NONE,
                        Map.of(
                                "collected_mixed_leaf", InventoryChangedCriterion.Conditions.items(
                                        ItemPredicate.Builder.create()
                                                .items(ModItems.MIXED_LEAF)
                                                .build()
                                )
                        ),
                        new AdvancementRequirements(
                                List.of(
                                        List.of("collected_mixed_leaf")
                                )
                        ),
                        false
                )
        ));

        consumer.accept(new AdvancementEntry(
                of("investigation/leaf_armor"),
                new Advancement(
                        Optional.of(of("investigation/get_leaf")),
                        Optional.of(new AdvancementDisplay(
                                ModItems.LEAF_CHESTPLATE.getDefaultStack(),
                                Text.translatable("advancements.octocomputing.leaf_armor.title"),
                                Text.translatable("advancements.octocomputing.leaf_armor.description"),
                                Optional.empty(),
                                AdvancementFrame.TASK,
                                false,
                                false,
                                false
                        )),
                        AdvancementRewards.NONE,
                        Map.of(
                                "leaf_armor", InventoryChangedCriterion.Conditions.items(
                                        ItemPredicate.Builder.create()
                                                .items(ModItems.LEAF_HELMET, ModItems.LEAF_CHESTPLATE, ModItems.LEAF_LEGGINGS, ModItems.LEAF_BOOTS)
                                                .build()
                                ),
                                "compressed_leaf_armor", InventoryChangedCriterion.Conditions.items(
                                        ItemPredicate.Builder.create()
                                                .items(ModItems.COMPRESSED_LEAF_HELMET, ModItems.COMPRESSED_LEAF_CHESTPLATE, ModItems.COMPRESSED_LEAF_LEGGINGS, ModItems.COMPRESSED_LEAF_BOOTS)
                                                .build()
                                ),
                                "double_compressed_leaf_armor", InventoryChangedCriterion.Conditions.items(
                                        ItemPredicate.Builder.create()
                                                .items(ModItems.DOUBLE_COMPRESSED_LEAF_HELMET, ModItems.DOUBLE_COMPRESSED_LEAF_CHESTPLATE, ModItems.DOUBLE_COMPRESSED_LEAF_LEGGINGS, ModItems.DOUBLE_COMPRESSED_LEAF_BOOTS)
                                                .build()
                                )
                        ),
                        new AdvancementRequirements(
                                List.of(
                                        List.of(
                                                "leaf_armor",
                                                "compressed_leaf_armor",
                                                "double_compressed_leaf_armor"
                                        )
                                )
                        ),
                        false
                )
        ));

        consumer.accept(new AdvancementEntry(
                of("investigation/mine_leafstone"),
                new Advancement(
                        Optional.of(of("investigation/get_leaf")),
                        Optional.of(new AdvancementDisplay(
                                ModItems.LEAFSTONE.getDefaultStack(),
                                Text.translatable("advancements.octocomputing.mine_leafstone.title"),
                                Text.translatable("advancements.octocomputing.mine_leafstone.description"),
                                Optional.empty(),
                                AdvancementFrame.TASK,
                                true,
                                true,
                                false
                        )),
                        AdvancementRewards.NONE,
                        Map.of(
                                "leafstone", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.
                                        create()
                                        .items(ModItems.LEAFSTONE)
                                        .build())
                        ),
                        new AdvancementRequirements(
                                List.of(
                                        List.of(
                                                "leafstone"
                                        )
                                )
                        ),
                        false
                )
        ));

        consumer.accept(new AdvancementEntry(
                of("investigation/kill_leaf_god"),
                new Advancement(
                        Optional.of(of("investigation/get_leaf")),
                        Optional.of(new AdvancementDisplay(
                                ModItems.LEAF_CORE.getDefaultStack(),
                                Text.translatable("advancements.octocomputing.kill_leaf_god.title"),
                                Text.translatable("advancements.octocomputing.kill_leaf_god.description"),
                                Optional.empty(),
                                AdvancementFrame.CHALLENGE,
                                false,
                                false,
                                true
                        )),
                        new AdvancementRewards(
                                10,
                                List.of(),
                                List.of(),
                                Optional.empty()
                        ),
                        Map.of("killed_leaf_god", OnKilledCriterion.Conditions.createEntityKilledPlayer(
                                Optional.of(EntityPredicate.Builder.create()
                                        .type(ModEntities.LEAF_GOD)
                                        .build())
                        )),
                        new AdvancementRequirements(
                            List.of(
                                    List.of("killed_leaf_god")
                            )
                        ),
                        true
                )
        ));
        // endregion
    }
}
