package net.jcquestmark.justamod.item;

import net.jcquestmark.justamod.JustAMod;
import net.jcquestmark.justamod.item.tools.woodenline.WoodenAxeT2Item;
import net.jcquestmark.justamod.item.tools.woodenline.WoodenSwordT2Item;
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

    public static final RegistryObject<Item> WOODEN_SWORD_T2 = ITEMS.register("wooden_sword_t2", () -> new WoodenSwordT2Item());
    public static final RegistryObject<Item> WOODEN_AXE_T2 = ITEMS.register("wooden_axe_t2", () -> new WoodenAxeT2Item());

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
