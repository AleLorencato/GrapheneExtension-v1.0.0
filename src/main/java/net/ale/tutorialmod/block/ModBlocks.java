package net.ale.tutorialmod.block;

import net.ale.tutorialmod.TutorialMod;
import net.ale.tutorialmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final RegistryObject<Block> GRAPHENE_BLOCK = registerBlock("graphene_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)));
    public static final RegistryObject<Block> GRAPHENE_ORE = registerBlock("graphene_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f)
                    .requiresCorrectToolForDrops(), UniformInt.of(3, 6)
            ));
    public static final RegistryObject<Block> DEEPSLATE_GRAPHENE_ORE = registerBlock("deepslate_graphene_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(3f)
                    .requiresCorrectToolForDrops(), UniformInt.of(4, 8)
            ));
    public static final RegistryObject<Block> NETHER_GRAPHENE_ORE = registerBlock("nether_graphene_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK).strength(1f)
                    .requiresCorrectToolForDrops(), UniformInt.of(3, 7)
            ));
    public static final RegistryObject<Block> END_STONE_GRAPHENE_ORE = registerBlock("end_stone_graphene_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE).strength(5f)
                    .requiresCorrectToolForDrops(), UniformInt.of(5, 10)
            ));
//se quiser criar outro block só fazer outro RegistryObject...


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }


}
