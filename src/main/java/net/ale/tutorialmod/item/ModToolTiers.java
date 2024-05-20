package net.ale.tutorialmod.item;

import net.ale.tutorialmod.TutorialMod;
import net.ale.tutorialmod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier GRAPHENE = TierSortingRegistry.registerTier(
            new ForgeTier(5, 2500, 12f, 5f, 25, ModTags.Blocks.NEEDS_GRAPHENE_TOOL, () -> Ingredient.of(ModItems.GRAPHENE.get())),
            new ResourceLocation(TutorialMod.MOD_ID, "graphene"), List.of(Tiers.NETHERITE), List.of());
}
