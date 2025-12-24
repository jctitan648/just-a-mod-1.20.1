package net.jcquestmark.justamod.item.tools.stoneline;

import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeTier;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class StoneShovelT6Item extends ShovelItem {
    public StoneShovelT6Item() {
        super(new ForgeTier(
                3,          // Tool level
                399,         // Durability
                10.68f,       // Efficiency
                4.9f,       // Attack Damage (the real value is this value + 1)
                11,          // Enchantability
                        BlockTags.NEEDS_IRON_TOOL,
                () -> Ingredient.of()  // Repair ingredient
                ),
                0,
                -2.15f,  // Attack Speed (the real value is this value - 4)
                new Properties()
        );
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(
                Component.translatable("tooltip.justamod.tier6"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
