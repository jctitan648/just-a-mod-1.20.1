package net.jcquestmark.justamod.item;

import net.jcquestmark.justamod.JustAMod;
import net.jcquestmark.justamod.util.ModTags;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier WOOD_T2 = TierSortingRegistry.registerTier(
            new ForgeTier(0, 73, 2.2f, 0.2f, 9,
                    Tags.Blocks.NEEDS_WOOD_TOOL, () -> Ingredient.of(ItemTags.PLANKS)),
            new ResourceLocation(JustAMod.MOD_ID, "wooden_tier2"), List.of(), List.of(Tiers.STONE));

    public static final Tier WOOD_T3 = TierSortingRegistry.registerTier(
            new ForgeTier(1, 92, 2.55f, 0.6f, 9,
                    BlockTags.NEEDS_STONE_TOOL, () -> Ingredient.of(ItemTags.PLANKS)),
            new ResourceLocation(JustAMod.MOD_ID, "wooden_tier3"), List.of(), List.of(Tiers.IRON));
}
