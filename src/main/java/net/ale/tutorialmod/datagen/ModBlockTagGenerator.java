package net.ale.tutorialmod.datagen;

import net.ale.tutorialmod.TutorialMod;
import net.ale.tutorialmod.block.ModBlocks;
import net.ale.tutorialmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.GRAPHENE_BLOCK.get(),
                        ModBlocks.GRAPHENE_ORE.get(),
                        ModBlocks.DEEPSLATE_GRAPHENE_ORE.get(),
                        ModBlocks.NETHER_GRAPHENE_ORE.get(),
                        ModBlocks.END_STONE_GRAPHENE_ORE.get()
                );


        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.GRAPHENE_ORE.get())
                .add(ModBlocks.DEEPSLATE_GRAPHENE_ORE.get())
                .add(ModBlocks.NETHER_GRAPHENE_ORE.get())
        ;
        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.END_STONE_GRAPHENE_ORE.get());

/*
        this.tag(ModTags.Blocks.NEEDS_GRAPHENE_TOOL)
                .add(ModBlocks.END_STONE_GRAPHENE_ORE.get());
*/

    }


}
