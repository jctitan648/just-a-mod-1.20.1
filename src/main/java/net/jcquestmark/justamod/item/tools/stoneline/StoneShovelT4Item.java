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

public class StoneShovelT4Item extends ShovelItem {
    public StoneShovelT4Item() {
        super(new ForgeTier(
                2,          // Tool level
                255,         // Durability
                5.98f,       // Efficiency
                3.85f,       // Attack Damage (the real value is this value + 1)
                7,          // Enchantability
                        BlockTags.NEEDS_IRON_TOOL,
                () -> Ingredient.of()  // Repair ingredient
                ),
                0,
                -2.88f,  // Attack Speed (the real value is this value - 4)
                new Properties()
        );
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(
                Component.translatable("tooltip.justamod.tier4"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
