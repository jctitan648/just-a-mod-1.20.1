package net.jcquestmark.justamod.item.tools.woodenline;

import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeTier;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WoodenHoeT3Item extends HoeItem {
    public WoodenHoeT3Item() {
        super(new ForgeTier(
                1,          // Tool level
                99,         // Durability
                2.5f,       // Efficiency
                0f,       // Attack Damage (the real value is this value + 1)
                9,          // Enchantability
                        BlockTags.NEEDS_STONE_TOOL,
                () -> Ingredient.of()  // Repair ingredient
                ),
                0,
                -2.6f,  // Attack Speed (the real value is this value - 4)
                new Properties()
        );
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(
                Component.translatable("tooltip.justamod.tier3"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
