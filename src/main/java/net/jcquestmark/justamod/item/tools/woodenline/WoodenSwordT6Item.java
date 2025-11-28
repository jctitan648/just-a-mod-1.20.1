package net.jcquestmark.justamod.item.tools.woodenline;

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

public class WoodenSwordT6Item extends SwordItem {
    public WoodenSwordT6Item() {
        super(new ForgeTier(
                2,          // Tool level
                180,         // Durability
                4.25f,       // Efficiency
                7f,       // Attack Damage (the real value is this value + 1)
                9,          // Enchantability
                        BlockTags.NEEDS_IRON_TOOL,
                () -> Ingredient.of()  // Repair ingredient
                ),
                0,
                -2.25f,  // Attack Speed (the real value is this value - 4)
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
