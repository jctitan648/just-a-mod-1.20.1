package net.jcquestmark.justamod.init;

import net.jcquestmark.justamod.JustAMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> NEEDS_TOOL_LV5 = tag("needs_tool_lv5");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(JustAMod.MOD_ID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> FUEL_800 = tag("machine_fuel_800");
        public static final TagKey<Item> FUEL_4000 = tag("machine_fuel_4000");
        public static final TagKey<Item> FUEL_8000 = tag("machine_fuel_8000");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(JustAMod.MOD_ID, name));
        }
    }
}
