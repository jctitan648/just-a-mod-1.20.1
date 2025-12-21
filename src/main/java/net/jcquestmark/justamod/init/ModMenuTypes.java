package net.jcquestmark.justamod.init;

import net.jcquestmark.justamod.JustAMod;
import net.jcquestmark.justamod.screen.CompressorMachineMenu;
import net.jcquestmark.justamod.screen.InfuserMachineMenu;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, JustAMod.MOD_ID);

    public static final RegistryObject<MenuType<CompressorMachineMenu>> COMPRESSOR_MACHINE_MENU =
            registerMenuType("compressor_machine_menu", CompressorMachineMenu::new);

    public static final RegistryObject<MenuType<InfuserMachineMenu>> INFUSER_MACHINE_MENU =
            registerMenuType("infuser_machine_menu", InfuserMachineMenu::new);

    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
