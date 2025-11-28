package net.jcquestmark.justamod.datagen;

import net.jcquestmark.justamod.item.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class RecipeLines {
    public enum TierSet {
        WoodT2Set, WoodT3Set, WoodT4Set, WoodT5Set, WoodT6Set
    }

    public int getSetLength(TierSet tierSet) {
        switch(tierSet) {
            case WoodT2Set -> { return WoodT2Set.length; }
            case WoodT3Set -> { return WoodT3Set.length; }
            case WoodT4Set -> { return WoodT4Set.length; }
            case WoodT5Set -> { return WoodT5Set.length; }
        }
        return WoodT2Set.length;

    }

    Item[] WoodT1Set = {
            Items.WOODEN_SWORD,
            Items.WOODEN_AXE,
            Items.WOODEN_PICKAXE,
            Items.WOODEN_SHOVEL,
            Items.WOODEN_HOE
    };

    Item[] WoodT2Set = {
            ModItems.WOODEN_SWORD_T2.get(),
            ModItems.WOODEN_AXE_T2.get(),
            ModItems.WOODEN_PICKAXE_T2.get(),
            ModItems.WOODEN_SHOVEL_T2.get(),
            ModItems.WOODEN_HOE_T2.get()
    };

    Item[] WoodT3Set = {
            ModItems.WOODEN_SWORD_T3.get(),
            ModItems.WOODEN_AXE_T3.get(),
            ModItems.WOODEN_PICKAXE_T3.get(),
            ModItems.WOODEN_SHOVEL_T3.get(),
            ModItems.WOODEN_HOE_T3.get()
    };

    Item[] WoodT4Set = {
            ModItems.WOODEN_SWORD_T4.get(),
            ModItems.WOODEN_AXE_T4.get(),
            ModItems.WOODEN_PICKAXE_T4.get(),
            ModItems.WOODEN_SHOVEL_T4.get(),
            ModItems.WOODEN_HOE_T4.get()
    };
    Item[] WoodT5Set = {
            ModItems.WOODEN_SWORD_T5.get(),
            ModItems.WOODEN_AXE_T5.get(),
            ModItems.WOODEN_PICKAXE_T5.get(),
            ModItems.WOODEN_SHOVEL_T5.get(),
            ModItems.WOODEN_HOE_T5.get()
    };
}
