package net.jcquestmark.justamod.item.tools.ironline;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.jcquestmark.justamod.init.ModAttributes;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.util.Lazy;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class IronSwordT7Item extends SwordItem {

    // Stats
    public double attackDamage = 14.8f;
    public double attackSpeed = 1.8f;

    public double critDamage = 8f;

    public IronSwordT7Item() {
        super(new ForgeTier(
                3,          // Tool level
                957,         // Durability
                6.55f,       // Efficiency
                13.8f,       // Attack Damage (the real value is this value + 1)
                16,          // Enchantability
                        BlockTags.NEEDS_DIAMOND_TOOL,
                () -> Ingredient.of()  // Repair ingredient
                ),
                0,
                -2.2f,  // Attack Speed (the real value is this value - 4)
                new Properties()
        );
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(
                Component.translatable("tooltip.justamod.tier7"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    public Lazy<? extends Multimap<Attribute, AttributeModifier>> ATTRIBUTE_LAZY_MAP = Lazy.of(() -> {
        Multimap<Attribute, AttributeModifier> map;
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", attackDamage - 1.0f, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", attackSpeed - 4.0f, AttributeModifier.Operation.ADDITION));
        builder.put(ModAttributes.CRITICAL_DAMAGE.get(), new AttributeModifier("attributes.justamod.critical_damage",critDamage, AttributeModifier.Operation.ADDITION));

        map = builder.build();
        return map;
    });

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        return slot == EquipmentSlot.MAINHAND ? ATTRIBUTE_LAZY_MAP.get() : super.getAttributeModifiers(slot, stack);
    }
}
