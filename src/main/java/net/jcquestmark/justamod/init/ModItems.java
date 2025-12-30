package net.jcquestmark.justamod.init;

import net.jcquestmark.justamod.JustAMod;
import net.jcquestmark.justamod.item.fuels.*;
import net.jcquestmark.justamod.item.tools.ironline.*;
import net.jcquestmark.justamod.item.tools.stoneline.*;
import net.jcquestmark.justamod.item.tools.woodenline.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


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

    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STEEL_NUGGET = ITEMS.register("steel_nugget",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CARBON_STEEL_INGOT = ITEMS.register("carbon_steel_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CARBON_STEEL_PIECE = ITEMS.register("carbon_steel_piece",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SMALL_STEEL_SPIKE = ITEMS.register("small_steel_spike",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STEEL_SPIKE_BUNCH = ITEMS.register("steel_spike_bunch",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> REINFORCED_STEEL_CORE = ITEMS.register("reinforced_steel_core",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ROUGH_POWER_COAL = ITEMS.register("rough_power_coal",
            () -> new RoughPowerCoalItem(new Item.Properties(), 4000));
    public static final RegistryObject<Item> POWER_COAL = ITEMS.register("power_coal",
            () -> new PowerCoalItem(new Item.Properties(), 20000));

    public static final RegistryObject<Item> WOODEN_SWORD_T2 = ITEMS.register("wooden_sword_t2", WoodenSwordT2Item::new);
    public static final RegistryObject<Item> WOODEN_AXE_T2 = ITEMS.register("wooden_axe_t2", WoodenAxeT2Item::new);
    public static final RegistryObject<Item> WOODEN_PICKAXE_T2 = ITEMS.register("wooden_pickaxe_t2", WoodenPickaxeT2Item::new);
    public static final RegistryObject<Item> WOODEN_SHOVEL_T2 = ITEMS.register("wooden_shovel_t2", WoodenShovelT2Item::new);
    public static final RegistryObject<Item> WOODEN_HOE_T2 = ITEMS.register("wooden_hoe_t2", WoodenHoeT2Item::new);

    public static final RegistryObject<Item> WOODEN_SWORD_T3 = ITEMS.register("wooden_sword_t3", WoodenSwordT3Item::new);
    public static final RegistryObject<Item> WOODEN_AXE_T3 = ITEMS.register("wooden_axe_t3", WoodenAxeT3Item::new);
    public static final RegistryObject<Item> WOODEN_PICKAXE_T3 = ITEMS.register("wooden_pickaxe_t3", WoodenPickaxeT3Item::new);
    public static final RegistryObject<Item> WOODEN_SHOVEL_T3 = ITEMS.register("wooden_shovel_t3", WoodenShovelT3Item::new);
    public static final RegistryObject<Item> WOODEN_HOE_T3 = ITEMS.register("wooden_hoe_t3", WoodenHoeT3Item::new);

    public static final RegistryObject<Item> WOODEN_SWORD_T4 = ITEMS.register("wooden_sword_t4", WoodenSwordT4Item::new);
    public static final RegistryObject<Item> WOODEN_AXE_T4 = ITEMS.register("wooden_axe_t4", WoodenAxeT4Item::new);
    public static final RegistryObject<Item> WOODEN_PICKAXE_T4 = ITEMS.register("wooden_pickaxe_t4", WoodenPickaxeT4Item::new);
    public static final RegistryObject<Item> WOODEN_SHOVEL_T4 = ITEMS.register("wooden_shovel_t4", WoodenShovelT4Item::new);
    public static final RegistryObject<Item> WOODEN_HOE_T4 = ITEMS.register("wooden_hoe_t4", WoodenHoeT4Item::new);

    public static final RegistryObject<Item> WOODEN_SWORD_T5 = ITEMS.register("wooden_sword_t5", WoodenSwordT5Item::new);
    public static final RegistryObject<Item> WOODEN_AXE_T5 = ITEMS.register("wooden_axe_t5", WoodenAxeT5Item::new);
    public static final RegistryObject<Item> WOODEN_PICKAXE_T5 = ITEMS.register("wooden_pickaxe_t5", WoodenPickaxeT5Item::new);
    public static final RegistryObject<Item> WOODEN_SHOVEL_T5 = ITEMS.register("wooden_shovel_t5", WoodenShovelT5Item::new);
    public static final RegistryObject<Item> WOODEN_HOE_T5 = ITEMS.register("wooden_hoe_t5", WoodenHoeT5Item::new);

    public static final RegistryObject<Item> WOODEN_SWORD_T6 = ITEMS.register("wooden_sword_t6", WoodenSwordT6Item::new);
    public static final RegistryObject<Item> WOODEN_AXE_T6 = ITEMS.register("wooden_axe_t6", WoodenAxeT6Item::new);
    public static final RegistryObject<Item> WOODEN_PICKAXE_T6 = ITEMS.register("wooden_pickaxe_t6", WoodenPickaxeT6Item::new);
    public static final RegistryObject<Item> WOODEN_SHOVEL_T6 = ITEMS.register("wooden_shovel_t6", WoodenShovelT6Item::new);
    public static final RegistryObject<Item> WOODEN_HOE_T6 = ITEMS.register("wooden_hoe_t6", WoodenHoeT6Item::new);

    public static final RegistryObject<Item> STONE_SWORD_T2 = ITEMS.register("stone_sword_t2", StoneSwordT2Item::new);
    public static final RegistryObject<Item> STONE_AXE_T2 = ITEMS.register("stone_axe_t2", StoneAxeT2Item::new);
    public static final RegistryObject<Item> STONE_PICKAXE_T2 = ITEMS.register("stone_pickaxe_t2", StonePickaxeT2Item::new);
    public static final RegistryObject<Item> STONE_SHOVEL_T2 = ITEMS.register("stone_shovel_t2", StoneShovelT2Item::new);
    public static final RegistryObject<Item> STONE_HOE_T2 = ITEMS.register("stone_hoe_t2", StoneHoeT2Item::new);

    public static final RegistryObject<Item> STONE_SWORD_T3 = ITEMS.register("stone_sword_t3", StoneSwordT3Item::new);
    public static final RegistryObject<Item> STONE_AXE_T3 = ITEMS.register("stone_axe_t3", StoneAxeT3Item::new);
    public static final RegistryObject<Item> STONE_PICKAXE_T3 = ITEMS.register("stone_pickaxe_t3", StonePickaxeT3Item::new);
    public static final RegistryObject<Item> STONE_SHOVEL_T3 = ITEMS.register("stone_shovel_t3", StoneShovelT3Item::new);
    public static final RegistryObject<Item> STONE_HOE_T3 = ITEMS.register("stone_hoe_t3", StoneHoeT3Item::new);

    public static final RegistryObject<Item> STONE_SWORD_T4 = ITEMS.register("stone_sword_t4", StoneSwordT4Item::new);
    public static final RegistryObject<Item> STONE_AXE_T4 = ITEMS.register("stone_axe_t4", StoneAxeT4Item::new);
    public static final RegistryObject<Item> STONE_PICKAXE_T4 = ITEMS.register("stone_pickaxe_t4", StonePickaxeT4Item::new);
    public static final RegistryObject<Item> STONE_SHOVEL_T4 = ITEMS.register("stone_shovel_t4", StoneShovelT4Item::new);
    public static final RegistryObject<Item> STONE_HOE_T4 = ITEMS.register("stone_hoe_t4", StoneHoeT4Item::new);

    public static final RegistryObject<Item> STONE_SWORD_T5 = ITEMS.register("stone_sword_t5", StoneSwordT5Item::new);
    public static final RegistryObject<Item> STONE_AXE_T5 = ITEMS.register("stone_axe_t5", StoneAxeT5Item::new);
    public static final RegistryObject<Item> STONE_PICKAXE_T5 = ITEMS.register("stone_pickaxe_t5", StonePickaxeT5Item::new);
    public static final RegistryObject<Item> STONE_SHOVEL_T5 = ITEMS.register("stone_shovel_t5", StoneShovelT5Item::new);
    public static final RegistryObject<Item> STONE_HOE_T5 = ITEMS.register("stone_hoe_t5", StoneHoeT5Item::new);
    
    public static final RegistryObject<Item> STONE_SWORD_T6 = ITEMS.register("stone_sword_t6", StoneSwordT6Item::new);
    public static final RegistryObject<Item> STONE_AXE_T6 = ITEMS.register("stone_axe_t6", StoneAxeT6Item::new);
    public static final RegistryObject<Item> STONE_PICKAXE_T6 = ITEMS.register("stone_pickaxe_t6", StonePickaxeT6Item::new);
    public static final RegistryObject<Item> STONE_SHOVEL_T6 = ITEMS.register("stone_shovel_t6", StoneShovelT6Item::new);
    public static final RegistryObject<Item> STONE_HOE_T6 = ITEMS.register("stone_hoe_t6", StoneHoeT6Item::new);

    public static final RegistryObject<Item> IRON_SWORD_T2 = ITEMS.register("iron_sword_t2", IronSwordT2Item::new);
    public static final RegistryObject<Item> IRON_AXE_T2 = ITEMS.register("iron_axe_t2", IronAxeT2Item::new);
    public static final RegistryObject<Item> IRON_PICKAXE_T2 = ITEMS.register("iron_pickaxe_t2", IronPickaxeT2Item::new);
    public static final RegistryObject<Item> IRON_SHOVEL_T2 = ITEMS.register("iron_shovel_t2", IronShovelT2Item::new);
    public static final RegistryObject<Item> IRON_HOE_T2 = ITEMS.register("iron_hoe_t2", IronHoeT2Item::new);

    public static final RegistryObject<Item> IRON_SWORD_T3 = ITEMS.register("iron_sword_t3", IronSwordT3Item::new);
    public static final RegistryObject<Item> IRON_AXE_T3 = ITEMS.register("iron_axe_t3", IronAxeT3Item::new);
    public static final RegistryObject<Item> IRON_PICKAXE_T3 = ITEMS.register("iron_pickaxe_t3", IronPickaxeT3Item::new);
    public static final RegistryObject<Item> IRON_SHOVEL_T3 = ITEMS.register("iron_shovel_t3", IronShovelT3Item::new);
    public static final RegistryObject<Item> IRON_HOE_T3 = ITEMS.register("iron_hoe_t3", IronHoeT3Item::new);

    public static final RegistryObject<Item> IRON_SWORD_T4 = ITEMS.register("iron_sword_t4", IronSwordT4Item::new);
    public static final RegistryObject<Item> IRON_AXE_T4 = ITEMS.register("iron_axe_t4", IronAxeT4Item::new);
    public static final RegistryObject<Item> IRON_PICKAXE_T4 = ITEMS.register("iron_pickaxe_t4", IronPickaxeT4Item::new);
    public static final RegistryObject<Item> IRON_SHOVEL_T4 = ITEMS.register("iron_shovel_t4", IronShovelT4Item::new);
    public static final RegistryObject<Item> IRON_HOE_T4 = ITEMS.register("iron_hoe_t4", IronHoeT4Item::new);

    public static final RegistryObject<Item> IRON_SWORD_T5 = ITEMS.register("iron_sword_t5", IronSwordT5Item::new);
    public static final RegistryObject<Item> IRON_AXE_T5 = ITEMS.register("iron_axe_t5", IronAxeT5Item::new);
    public static final RegistryObject<Item> IRON_PICKAXE_T5 = ITEMS.register("iron_pickaxe_t5", IronPickaxeT5Item::new);
    public static final RegistryObject<Item> IRON_SHOVEL_T5 = ITEMS.register("iron_shovel_t5", IronShovelT5Item::new);
    public static final RegistryObject<Item> IRON_HOE_T5 = ITEMS.register("iron_hoe_t5", IronHoeT5Item::new);

    public static final RegistryObject<Item> IRON_SWORD_T6 = ITEMS.register("iron_sword_t6", IronSwordT6Item::new);
    public static final RegistryObject<Item> IRON_AXE_T6 = ITEMS.register("iron_axe_t6", IronAxeT6Item::new);
    public static final RegistryObject<Item> IRON_PICKAXE_T6 = ITEMS.register("iron_pickaxe_t6", IronPickaxeT6Item::new);
    public static final RegistryObject<Item> IRON_SHOVEL_T6 = ITEMS.register("iron_shovel_t6", IronShovelT6Item::new);
    public static final RegistryObject<Item> IRON_HOE_T6 = ITEMS.register("iron_hoe_t6", IronHoeT6Item::new);

    public static final RegistryObject<Item> IRON_SWORD_T7 = ITEMS.register("iron_sword_t7", IronSwordT7Item::new);
    public static final RegistryObject<Item> IRON_AXE_T7 = ITEMS.register("iron_axe_t7", IronAxeT7Item::new);
    public static final RegistryObject<Item> IRON_PICKAXE_T7 = ITEMS.register("iron_pickaxe_t7", IronPickaxeT7Item::new);
    public static final RegistryObject<Item> IRON_SHOVEL_T7 = ITEMS.register("iron_shovel_t7", IronShovelT7Item::new);
    public static final RegistryObject<Item> IRON_HOE_T7 = ITEMS.register("iron_hoe_t7", IronHoeT7Item::new);

    public static final RegistryObject<Item> IRON_SWORD_T8 = ITEMS.register("iron_sword_t8", IronSwordT8Item::new);
    public static final RegistryObject<Item> IRON_AXE_T8 = ITEMS.register("iron_axe_t8", IronAxeT8Item::new);
    public static final RegistryObject<Item> IRON_PICKAXE_T8 = ITEMS.register("iron_pickaxe_t8", IronPickaxeT8Item::new);
    public static final RegistryObject<Item> IRON_SHOVEL_T8 = ITEMS.register("iron_shovel_t8", IronShovelT8Item::new);
    public static final RegistryObject<Item> IRON_HOE_T8 = ITEMS.register("iron_hoe_t8", IronHoeT8Item::new);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
