package net.jcquestmark.justamod.item.tools.ironline;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class IronShovelT7Item extends ShovelItem {
    public IronShovelT7Item() {
        super(new ForgeTier(
                4,          // Tool level
                957,         // Durability
                10.92f,       // Efficiency
                8f,       // Attack Damage (the real value is this value + 1)
                16,          // Enchantability
                        Tags.Blocks.NEEDS_NETHERITE_TOOL,
                () -> Ingredient.of()  // Repair ingredient
                ),
                0,
                -2.7f,  // Attack Speed (the real value is this value - 4)
                new Properties()
        );
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(
                Component.translatable("tooltip.justamod.tier7"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
