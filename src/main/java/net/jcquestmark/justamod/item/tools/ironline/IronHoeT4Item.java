package net.jcquestmark.justamod.item.tools.ironline;

import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeTier;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class IronHoeT4Item extends HoeItem {
    public IronHoeT4Item() {
        super(new ForgeTier(
                3,          // Tool level
                551,         // Durability
                7.56f,       // Efficiency
                1.6f,       // Attack Damage (the real value is this value + 1)
                16,          // Enchantability
                        BlockTags.NEEDS_DIAMOND_TOOL,
                () -> Ingredient.of()  // Repair ingredient
                ),
                0,
                0f,  // Attack Speed (the real value is this value - 4)
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
