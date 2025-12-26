package net.jcquestmark.justamod.init;

import net.jcquestmark.justamod.JustAMod;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModAttributes {
    public static final DeferredRegister<Attribute> ATTRIBUTES =
            DeferredRegister.create(ForgeRegistries.ATTRIBUTES, JustAMod.MOD_ID);

    public static final RegistryObject<Attribute> CRITICAL_CHANCE = ATTRIBUTES.register("critical_chance",
            () -> new RangedAttribute("attribute.justamod.critical_chance", 0.0, 0, 2147483647));
    public static final RegistryObject<Attribute> CRITICAL_DAMAGE = ATTRIBUTES.register("critical_damage",
            () -> new RangedAttribute("attribute.justamod.critical_damage", 50.0, 0, 2147483647));

    public static void register(IEventBus eventBus) {
        ATTRIBUTES.register(eventBus);
    }
}
