package net.jcquestmark.justamod.item.tools.woodenline;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WoodenSwordT2Item extends SwordItem {
    public WoodenSwordT2Item() {
        super(new ForgeTier(
                0,          // Tool level
                73,         // Durability
                2.2f,       // Efficiency
                3.2f,       // Attack Damage
                9,          // Enchantability
                Tags.Blocks.NEEDS_WOOD_TOOL,
                () -> Ingredient.of()  // Repair ingredient
                ),
                0,
                -2.4f,  // Attack Speed (the real value is 4 less than shown here)
                new Item.Properties()
        );
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(
                Component.translatable("tooltip.justamod.tier2"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
