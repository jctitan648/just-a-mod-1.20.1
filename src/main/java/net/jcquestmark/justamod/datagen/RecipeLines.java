package net.jcquestmark.justamod.datagen;

import net.jcquestmark.justamod.init.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class RecipeLines {
    public enum TierSet {
        WoodT2Set, WoodT3Set, WoodT4Set, WoodT5Set, WoodT6Set,
        StoneT2Set, StoneT3Set, StoneT4Set, StoneT5Set, StoneT6Set
    }



    public int getTierSetLength(TierSet tierSet) {
        switch (tierSet) {
            case WoodT2Set -> {
                return WoodT2Set.length;
            }
            case WoodT3Set -> {
                return WoodT3Set.length;
            }
            case WoodT4Set -> {
                return WoodT4Set.length;
            }
            case WoodT5Set -> {
                return WoodT5Set.length;
            }
            case StoneT2Set -> {
                return StoneT2Set.length;
            }
            case StoneT3Set -> {
                return StoneT3Set.length;
            }
            case StoneT4Set -> {
                return StoneT4Set.length;
            }
            case StoneT5Set -> {
                return StoneT5Set.length;
            }
            default -> { return 0; }
        }
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
    Item[] WoodT6Set = {
            ModItems.WOODEN_SWORD_T6.get(),
            ModItems.WOODEN_AXE_T6.get(),
            ModItems.WOODEN_PICKAXE_T6.get(),
            ModItems.WOODEN_SHOVEL_T6.get(),
            ModItems.WOODEN_HOE_T6.get()
    };

    Item[] StoneT1Set = {
            Items.STONE_SWORD,
            Items.STONE_AXE,
            Items.STONE_PICKAXE,
            Items.STONE_SHOVEL,
            Items.STONE_HOE
    };
    Item[] StoneT2Set = {
            ModItems.STONE_SWORD_T2.get(),
            ModItems.STONE_AXE_T2.get(),
            ModItems.STONE_PICKAXE_T2.get(),
            ModItems.STONE_SHOVEL_T2.get(),
            ModItems.STONE_HOE_T2.get()
    };
    Item[] StoneT3Set = {
            ModItems.STONE_SWORD_T3.get(),
            ModItems.STONE_AXE_T3.get(),
            ModItems.STONE_PICKAXE_T3.get(),
            ModItems.STONE_SHOVEL_T3.get(),
            ModItems.STONE_HOE_T3.get()
    };
    Item[] StoneT4Set = {
            ModItems.STONE_SWORD_T4.get(),
            ModItems.STONE_AXE_T4.get(),
            ModItems.STONE_PICKAXE_T4.get(),
            ModItems.STONE_SHOVEL_T4.get(),
            ModItems.STONE_HOE_T4.get()
    };
    Item[] StoneT5Set = {
            ModItems.STONE_SWORD_T5.get(),
            ModItems.STONE_AXE_T5.get(),
            ModItems.STONE_PICKAXE_T5.get(),
            ModItems.STONE_SHOVEL_T5.get(),
            ModItems.STONE_HOE_T5.get()
    };
    Item[] StoneT6Set = {
            ModItems.STONE_SWORD_T6.get(),
            ModItems.STONE_AXE_T6.get(),
            ModItems.STONE_PICKAXE_T6.get(),
            ModItems.STONE_SHOVEL_T6.get(),
            ModItems.STONE_HOE_T6.get()
    };
}
