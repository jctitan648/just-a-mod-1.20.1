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

public class IronHoeT5Item extends HoeItem {
    public IronHoeT5Item() {
        super(new ForgeTier(
                3,          // Tool level
                716,         // Durability
                8.16f,       // Efficiency
                2.2f,       // Attack Damage (the real value is this value + 1)
                16,          // Enchantability
                        BlockTags.NEEDS_DIAMOND_TOOL,
                () -> Ingredient.of()  // Repair ingredient
                ),
                0,
                0.4f,  // Attack Speed (the real value is this value - 4)
                new Properties()
        );
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(
                Component.translatable("tooltip.justamod.tier5"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
