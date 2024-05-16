package net.ale.tutorialmod.datagen;

import net.ale.tutorialmod.TutorialMod;
import net.ale.tutorialmod.block.ModBlocks;
import net.ale.tutorialmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> GRAPHENE_SMELTABLES = List.of(ModItems.GRAPHENE_DUST.get(),
            ModBlocks.GRAPHENE_ORE.get(), ModBlocks.NETHER_GRAPHENE_ORE.get(), ModBlocks.DEEPSLATE_GRAPHENE_ORE.get(), ModBlocks.END_STONE_GRAPHENE_ORE.get()
    );

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    //tinha um consumer
    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter, GRAPHENE_SMELTABLES, RecipeCategory.MISC, ModItems.GRAPHENE.get(), 0.5f, 100, "graphene");
        oreSmelting(pWriter, GRAPHENE_SMELTABLES, RecipeCategory.MISC, ModItems.GRAPHENE.get(), 0.4f, 200, "graphene");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GRAPHENE_BLOCK.get()

                )
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.GRAPHENE.get())
                .unlockedBy(getHasName(ModItems.GRAPHENE.get()), has(ModItems.GRAPHENE.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GRAPHENE.get(), 9)
                .requires(ModBlocks.GRAPHENE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.GRAPHENE_BLOCK.get()), has(ModBlocks.GRAPHENE_BLOCK.get()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, TutorialMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }


}
