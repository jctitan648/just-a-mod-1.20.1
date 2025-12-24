package net.jcquestmark.justamod.item.tools.stoneline;

import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeTier;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class StoneSwordT6Item extends SwordItem {
    public StoneSwordT6Item() {
        super(new ForgeTier(
                3,          // Tool level
                399,         // Durability
                6.3f,       // Efficiency
                8.2f,       // Attack Damage (the real value is this value + 1)
                15,          // Enchantability
                        BlockTags.NEEDS_DIAMOND_TOOL,
                () -> Ingredient.of()  // Repair ingredient
                ),
                0,
                -1.68f,  // Attack Speed (the real value is this value - 4)
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
