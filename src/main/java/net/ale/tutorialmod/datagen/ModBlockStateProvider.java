package net.ale.tutorialmod.datagen;

import net.ale.tutorialmod.TutorialMod;
import net.ale.tutorialmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TutorialMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.GRAPHENE_BLOCK);
        blockWithItem(ModBlocks.GRAPHENE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_GRAPHENE_ORE);
        blockWithItem(ModBlocks.NETHER_GRAPHENE_ORE);
        blockWithItem(ModBlocks.END_STONE_GRAPHENE_ORE);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

}
