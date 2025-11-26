package net.jcquestmark.justamod.datagen;

import net.jcquestmark.justamod.item.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class RecipeLines {
    public int getSetLength() {
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
            ModItems.WOODEN_AXE_T2.get()
    };
}
