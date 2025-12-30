package net.jcquestmark.justamod.item.tools.ironline;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class IronHoeT7Item extends HoeItem {
    public IronHoeT7Item() {
        super(new ForgeTier(
                4,          // Tool level
                1211,         // Durability
                10.08f,       // Efficiency
                3.8f,       // Attack Damage (the real value is this value + 1)
                16,          // Enchantability
                        Tags.Blocks.NEEDS_NETHERITE_TOOL,
                () -> Ingredient.of()  // Repair ingredient
                ),
                0,
                1.6f,  // Attack Speed (the real value is this value - 4)
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
