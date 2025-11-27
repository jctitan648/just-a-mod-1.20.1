package net.jcquestmark.justamod.item;

import net.jcquestmark.justamod.JustAMod;
import net.jcquestmark.justamod.item.tools.woodenline.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("Convert2MethodRef")
public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, JustAMod.MOD_ID);

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WOODEN_CORE = ITEMS.register("wooden_core",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> WOODEN_SWORD_T2 = ITEMS.register("wooden_sword_t2", () -> new WoodenSwordT2Item());
    public static final RegistryObject<Item> WOODEN_AXE_T2 = ITEMS.register("wooden_axe_t2", () -> new WoodenAxeT2Item());
    public static final RegistryObject<Item> WOODEN_PICKAXE_T2 = ITEMS.register("wooden_pickaxe_t2", () -> new WoodenPickaxeT2Item());
    public static final RegistryObject<Item> WOODEN_SHOVEL_T2 = ITEMS.register("wooden_shovel_t2", () -> new WoodenShovelT2Item());
    public static final RegistryObject<Item> WOODEN_HOE_T2 = ITEMS.register("wooden_hoe_t2", () -> new WoodenHoeT2Item());

    public static final RegistryObject<Item> WOODEN_SWORD_T3 = ITEMS.register("wooden_sword_t3", () -> new WoodenSwordT3Item());
    public static final RegistryObject<Item> WOODEN_AXE_T3 = ITEMS.register("wooden_axe_t3", () -> new WoodenAxeT3Item());
    public static final RegistryObject<Item> WOODEN_PICKAXE_T3 = ITEMS.register("wooden_pickaxe_t3", () -> new WoodenPickaxeT3Item());
    public static final RegistryObject<Item> WOODEN_SHOVEL_T3 = ITEMS.register("wooden_shovel_t3", () -> new WoodenShovelT3Item());
    public static final RegistryObject<Item> WOODEN_HOE_T3 = ITEMS.register("wooden_hoe_t3", () -> new WoodenHoeT3Item());

    public static final RegistryObject<Item> WOODEN_SWORD_T4 = ITEMS.register("wooden_sword_t4", () -> new WoodenSwordT4Item());
    public static final RegistryObject<Item> WOODEN_AXE_T4 = ITEMS.register("wooden_axe_t4", () -> new WoodenAxeT4Item());
    public static final RegistryObject<Item> WOODEN_PICKAXE_T4 = ITEMS.register("wooden_pickaxe_t4", () -> new WoodenPickaxeT4Item());
    public static final RegistryObject<Item> WOODEN_SHOVEL_T4 = ITEMS.register("wooden_shovel_t4", () -> new WoodenShovelT4Item());
    public static final RegistryObject<Item> WOODEN_HOE_T4 = ITEMS.register("wooden_hoe_t4", () -> new WoodenHoeT4Item());

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
