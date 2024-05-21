package net.ale.tutorialmod.item;

import net.ale.tutorialmod.TutorialMod;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> GRAPHENE = ITEMS.register("graphene", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GRAPHENE_DUST = ITEMS.register("graphene_dust", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GRAPHENE_SWORD = ITEMS.register("graphene_sword",
            () -> new SwordItem(ModToolTiers.GRAPHENE, 4, -2, new Item.Properties()));
    public static final RegistryObject<Item> GRAPHENE_PICKAXE = ITEMS.register("graphene_pickaxe",
            () -> new PickaxeItem(ModToolTiers.GRAPHENE, 2, -2, new Item.Properties()));
    public static final RegistryObject<Item> GRAPHENE_AXE = ITEMS.register("graphene_axe",
            () -> new AxeItem(ModToolTiers.GRAPHENE, 6, -3, new Item.Properties()));
    public static final RegistryObject<Item> GRAPHENE_SHOVEL = ITEMS.register("graphene_shovel",
            () -> new ShovelItem(ModToolTiers.GRAPHENE, 1, -2, new Item.Properties()));
    public static final RegistryObject<Item> GRAPHENE_HOE = ITEMS.register("graphene_hoe",
            () -> new HoeItem(ModToolTiers.GRAPHENE, 1, -2, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
