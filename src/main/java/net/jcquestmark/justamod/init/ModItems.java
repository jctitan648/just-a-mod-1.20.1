package net.jcquestmark.justamod.init;

import net.jcquestmark.justamod.JustAMod;
import net.jcquestmark.justamod.item.fuels.RoughPowerCoalItem;
import net.jcquestmark.justamod.item.tools.stoneline.*;
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
    public static final RegistryObject<Item> CHIPPED_STONE_CORE = ITEMS.register("chipped_stone_core",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GILDED_STONE_CORE = ITEMS.register("gilded_stone_core",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ROUGH_POWER_COAL = ITEMS.register("rough_power_coal",
            () -> new RoughPowerCoalItem(new Item.Properties(), 4000));

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

    public static final RegistryObject<Item> WOODEN_SWORD_T5 = ITEMS.register("wooden_sword_t5", () -> new WoodenSwordT5Item());
    public static final RegistryObject<Item> WOODEN_AXE_T5 = ITEMS.register("wooden_axe_t5", () -> new WoodenAxeT5Item());
    public static final RegistryObject<Item> WOODEN_PICKAXE_T5 = ITEMS.register("wooden_pickaxe_t5", () -> new WoodenPickaxeT5Item());
    public static final RegistryObject<Item> WOODEN_SHOVEL_T5 = ITEMS.register("wooden_shovel_t5", () -> new WoodenShovelT5Item());
    public static final RegistryObject<Item> WOODEN_HOE_T5 = ITEMS.register("wooden_hoe_t5", () -> new WoodenHoeT5Item());

    public static final RegistryObject<Item> WOODEN_SWORD_T6 = ITEMS.register("wooden_sword_t6", () -> new WoodenSwordT6Item());
    public static final RegistryObject<Item> WOODEN_AXE_T6 = ITEMS.register("wooden_axe_t6", () -> new WoodenAxeT6Item());
    public static final RegistryObject<Item> WOODEN_PICKAXE_T6 = ITEMS.register("wooden_pickaxe_t6", () -> new WoodenPickaxeT6Item());
    public static final RegistryObject<Item> WOODEN_SHOVEL_T6 = ITEMS.register("wooden_shovel_t6", () -> new WoodenShovelT6Item());
    public static final RegistryObject<Item> WOODEN_HOE_T6 = ITEMS.register("wooden_hoe_t6", () -> new WoodenHoeT6Item());

    public static final RegistryObject<Item> STONE_SWORD_T2 = ITEMS.register("stone_sword_t2", () -> new StoneSwordT2Item());
    public static final RegistryObject<Item> STONE_AXE_T2 = ITEMS.register("stone_axe_t2", () -> new StoneAxeT2Item());
    public static final RegistryObject<Item> STONE_PICKAXE_T2 = ITEMS.register("stone_pickaxe_t2", () -> new StonePickaxeT2Item());
    public static final RegistryObject<Item> STONE_SHOVEL_T2 = ITEMS.register("stone_shovel_t2", () -> new StoneShovelT2Item());
    public static final RegistryObject<Item> STONE_HOE_T2 = ITEMS.register("stone_hoe_t2", () -> new StoneHoeT2Item());

    public static final RegistryObject<Item> STONE_SWORD_T3 = ITEMS.register("stone_sword_t3", () -> new StoneSwordT3Item());
    public static final RegistryObject<Item> STONE_AXE_T3 = ITEMS.register("stone_axe_t3", () -> new StoneAxeT3Item());
    public static final RegistryObject<Item> STONE_PICKAXE_T3 = ITEMS.register("stone_pickaxe_t3", () -> new StonePickaxeT3Item());
    public static final RegistryObject<Item> STONE_SHOVEL_T3 = ITEMS.register("stone_shovel_t3", () -> new StoneShovelT3Item());
    public static final RegistryObject<Item> STONE_HOE_T3 = ITEMS.register("stone_hoe_t3", () -> new StoneHoeT3Item());

    public static final RegistryObject<Item> STONE_SWORD_T4 = ITEMS.register("stone_sword_t4", () -> new StoneSwordT4Item());
    public static final RegistryObject<Item> STONE_AXE_T4 = ITEMS.register("stone_axe_t4", () -> new StoneAxeT4Item());
    public static final RegistryObject<Item> STONE_PICKAXE_T4 = ITEMS.register("stone_pickaxe_t4", () -> new StonePickaxeT4Item());
    public static final RegistryObject<Item> STONE_SHOVEL_T4 = ITEMS.register("stone_shovel_t4", () -> new StoneShovelT4Item());
    public static final RegistryObject<Item> STONE_HOE_T4 = ITEMS.register("stone_hoe_t4", () -> new StoneHoeT4Item());

    public static final RegistryObject<Item> STONE_SWORD_T5 = ITEMS.register("stone_sword_t5", () -> new StoneSwordT5Item());
    public static final RegistryObject<Item> STONE_AXE_T5 = ITEMS.register("stone_axe_t5", () -> new StoneAxeT5Item());
    public static final RegistryObject<Item> STONE_PICKAXE_T5 = ITEMS.register("stone_pickaxe_t5", () -> new StonePickaxeT5Item());
    public static final RegistryObject<Item> STONE_SHOVEL_T5 = ITEMS.register("stone_shovel_t5", () -> new StoneShovelT5Item());
    public static final RegistryObject<Item> STONE_HOE_T5 = ITEMS.register("stone_hoe_t5", () -> new StoneHoeT5Item());
    
    public static final RegistryObject<Item> STONE_SWORD_T6 = ITEMS.register("stone_sword_t6", () -> new StoneSwordT6Item());
    public static final RegistryObject<Item> STONE_AXE_T6 = ITEMS.register("stone_axe_t6", () -> new StoneAxeT6Item());
    public static final RegistryObject<Item> STONE_PICKAXE_T6 = ITEMS.register("stone_pickaxe_t6", () -> new StonePickaxeT6Item());
    public static final RegistryObject<Item> STONE_SHOVEL_T6 = ITEMS.register("stone_shovel_t6", () -> new StoneShovelT6Item());
    public static final RegistryObject<Item> STONE_HOE_T6 = ITEMS.register("stone_hoe_t6", () -> new StoneHoeT6Item());

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
