package net.ale.grapheneextension.worldgen;

import net.ale.grapheneextension.GrapheneExtension;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> GRAPHENE_ORE_PLACED_KEY = registerKey("graphene_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_GRAPHENE_ORE_PLACED_KEY = registerKey("nether_graphene_ore_placed");
    public static final ResourceKey<PlacedFeature> END_STONE_GRAPHENE_ORE_PLACED_KEY = registerKey("end_stone_graphene_ore_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        register(context, GRAPHENE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_GRAPHENE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));

        register(context, NETHER_GRAPHENE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_GRAPHENE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(5), VerticalAnchor.absolute(120))));

        register(context, END_STONE_GRAPHENE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_STONE_GRAPHENE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(100))));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(GrapheneExtension.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
