package net.jcquestmark.justamod.item.tools.ironline;

import net.jcquestmark.justamod.init.ModTags;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeTier;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class IronPickaxeT8Item extends PickaxeItem {
    public IronPickaxeT8Item() {
        super(new ForgeTier(
                5,          // Tool level
                1196,         // Durability
                14.6f,       // Efficiency
                7.95f,       // Attack Damage (the real value is this value + 1)
                19,          // Enchantability
                        ModTags.Blocks.NEEDS_TOOL_LV5,
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
                Component.translatable("tooltip.justamod.tier8"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
