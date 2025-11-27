package net.jcquestmark.justamod.item.tools.woodenline;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WoodenHoeT2Item extends HoeItem {
    public WoodenHoeT2Item() {
        super(new ForgeTier(
                0,          // Tool level
                76,         // Durability
                2.2f,       // Efficiency
                0f,       // Attack Damage (the real value is this value + 1)
                9,          // Enchantability
                Tags.Blocks.NEEDS_WOOD_TOOL,
                () -> Ingredient.of()  // Repair ingredient
                ),
                0,
                -2.85f,  // Attack Speed (the real value is this value - 4)
                new Properties()
        );
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(
                Component.translatable("tooltip.justamod.tier2"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
