package net.jcquestmark.justamod.datagen;

import net.jcquestmark.justamod.init.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class RecipeLines {
    public enum TierSet {
        WoodT2Set, WoodT3Set, WoodT4Set, WoodT5Set, WoodT6Set,
        StoneT2Set, StoneT3Set, StoneT4Set, StoneT5Set, StoneT6Set,
        IronT2Set, IronT3Set, IronT4Set, IronT5Set, IronT6Set, IronT7Set, IronT8Set,
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
            case IronT2Set -> {
                return IronT2Set.length;
            }
            case IronT3Set -> {
                return IronT3Set.length;
            }
            case IronT4Set -> {
                return IronT4Set.length;
            }
            case IronT5Set -> {
                return IronT5Set.length;
            }
            case IronT6Set -> {
                return IronT6Set.length;
            }
            case IronT7Set -> {
                return IronT7Set.length;
            }
            case IronT8Set -> {
                return IronT8Set.length;
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

    Item[] IronT1Set = {Items.IRON_SWORD, Items.IRON_AXE, Items.IRON_PICKAXE, Items.IRON_SHOVEL, Items.IRON_HOE};
    Item[] IronT2Set = {
            ModItems.IRON_SWORD_T2.get(),
            ModItems.IRON_AXE_T2.get(),
            ModItems.IRON_PICKAXE_T2.get(),
            ModItems.IRON_SHOVEL_T2.get(),
            ModItems.IRON_HOE_T2.get()
    };
    Item[] IronT3Set = {
            ModItems.IRON_SWORD_T3.get(),
            ModItems.IRON_AXE_T3.get(),
            ModItems.IRON_PICKAXE_T3.get(),
            ModItems.IRON_SHOVEL_T3.get(),
            ModItems.IRON_HOE_T3.get()
    };
    Item[] IronT4Set = {
            ModItems.IRON_SWORD_T4.get(),
            ModItems.IRON_AXE_T4.get(),
            ModItems.IRON_PICKAXE_T4.get(),
            ModItems.IRON_SHOVEL_T4.get(),
            ModItems.IRON_HOE_T4.get()
    };
    Item[] IronT5Set = {
            ModItems.IRON_SWORD_T5.get(),
            ModItems.IRON_AXE_T5.get(),
            ModItems.IRON_PICKAXE_T5.get(),
            ModItems.IRON_SHOVEL_T5.get(),
            ModItems.IRON_HOE_T5.get()
    };
    Item[] IronT6Set = {
            ModItems.IRON_SWORD_T6.get(),
            ModItems.IRON_AXE_T6.get(),
            ModItems.IRON_PICKAXE_T6.get(),
            ModItems.IRON_SHOVEL_T6.get(),
            ModItems.IRON_HOE_T6.get()
    };
    Item[] IronT7Set = {
            ModItems.IRON_SWORD_T7.get(),
            ModItems.IRON_AXE_T7.get(),
            ModItems.IRON_PICKAXE_T7.get(),
            ModItems.IRON_SHOVEL_T7.get(),
            ModItems.IRON_HOE_T7.get()
    };
    Item[] IronT8Set = {
            ModItems.IRON_SWORD_T8.get(),
            ModItems.IRON_AXE_T8.get(),
            ModItems.IRON_PICKAXE_T8.get(),
            ModItems.IRON_SHOVEL_T8.get(),
            ModItems.IRON_HOE_T8.get()
    };
}
