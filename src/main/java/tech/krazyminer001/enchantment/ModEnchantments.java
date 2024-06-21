package tech.krazyminer001.enchantment;

import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.value.AddEnchantmentEffect;
import net.minecraft.item.Item;
import net.minecraft.loot.condition.DamageSourcePropertiesLootCondition;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.predicate.TagPredicate;
import net.minecraft.predicate.entity.DamageSourcePredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import org.jetbrains.annotations.Nullable;
import tech.krazyminer001.damagetype.ModDamageTypeTags;
import tech.krazyminer001.entity.ModEntityTypeTags;

import java.util.List;
import java.util.Optional;

import static tech.krazyminer001.utility.Util.of;

public class ModEnchantments {
    public static final RegistryKey<Enchantment> GARDEN_SHEARS = registerKey("garden_shears");
    public static final RegistryKey<Enchantment> LEAF_PROTECTION = registerKey("leaf_protection");

    public static void bootstrap(Registerable<Enchantment> context) {
        RegistryEntryLookup<Item> items = context.getRegistryLookup(RegistryKeys.ITEM);

        register(context, GARDEN_SHEARS, enchantmentBuilder(
                enchantmentDefinition(
                        context,
                        ItemTags.WEAPON_ENCHANTABLE,
                        ItemTags.SWORD_ENCHANTABLE,
                        5,
                        5,
                        Enchantment.leveledCost(5, 10),
                        Enchantment.leveledCost(25, 8), 2,
                        AttributeModifierSlot.MAINHAND
                )).addEffect(
                            EnchantmentEffectComponentTypes.DAMAGE,
                            new AddEnchantmentEffect(
                                    EnchantmentLevelBasedValue.linear(2.5f, 2.5f)
                            ),
                            EntityPropertiesLootCondition.builder(
                                    LootContext.EntityTarget.THIS,
                                    EntityPredicate.Builder.create().type(ModEntityTypeTags.LEAFY).build())
                )
        );

        register(context, LEAF_PROTECTION, enchantmentBuilder(
                enchantmentDefinition(
                        context,
                        ItemTags.ARMOR_ENCHANTABLE,
                        null,
                        5,
                        4,
                        Enchantment.leveledCost(5, 10),
                        Enchantment.leveledCost(25, 8),
                        2,
                        AttributeModifierSlot.ARMOR
                )).addEffect(
                        EnchantmentEffectComponentTypes.DAMAGE_PROTECTION,
                        new AddEnchantmentEffect(
                                EnchantmentLevelBasedValue.linear(2f, 2f)
                        ),
                        DamageSourcePropertiesLootCondition.builder(DamageSourcePredicate.Builder.create().tag(new TagPredicate<>(ModDamageTypeTags.LEAFY, true))
                )
        ));


    }

    private static void register(Registerable<Enchantment> context, RegistryKey<Enchantment> key, Enchantment.Builder enchantmentBuilder) {
        context.register(key, enchantmentBuilder.build(key.getRegistry()));
    }

    public static RegistryKey<Enchantment> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.ENCHANTMENT, of(name));
    }

    public static Enchantment.Builder enchantmentBuilder(Enchantment.Definition definition) {
        return Enchantment.builder(definition);
    }

    public static Enchantment.Definition enchantmentDefinition(Registerable<Enchantment> context, TagKey<Item> supportedItems,
                                                               @Nullable TagKey<Item> primaryItems, int weight, int maxLevel,
                                                               Enchantment.Cost minCost, Enchantment.Cost maxCost, int anvilCost,
                                                               AttributeModifierSlot slot) {
        RegistryEntryLookup<Item> items = context.getRegistryLookup(RegistryKeys.ITEM);

        return new Enchantment.Definition(
                items.getOrThrow(supportedItems),
                (primaryItems != null) ? Optional.of(items.getOrThrow(primaryItems)) : Optional.empty(),
                weight,
                maxLevel,
                minCost,
                maxCost,
                anvilCost,
                List.of(slot)
        );
    }
}
