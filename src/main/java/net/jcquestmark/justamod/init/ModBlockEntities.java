package net.jcquestmark.justamod.init;

import net.jcquestmark.justamod.JustAMod;
import net.jcquestmark.justamod.block.entity.CompressorMachineBlockEntity;
import net.jcquestmark.justamod.block.entity.InfuserMachineBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, JustAMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<CompressorMachineBlockEntity>> COMPRESSOR_MACHINE_BE =
            BLOCK_ENTITIES.register("compressor_machine_be", () ->
                    BlockEntityType.Builder.of(CompressorMachineBlockEntity::new,
                            ModBlocks.COMPRESSOR_T1_MACHINE.get()).build(null));

    public static final RegistryObject<BlockEntityType<InfuserMachineBlockEntity>> INFUSER_MACHINE_BE =
            BLOCK_ENTITIES.register("infuser_machine_be", () ->
                    BlockEntityType.Builder.of(InfuserMachineBlockEntity::new,
                            ModBlocks.INFUSER_T1_MACHINE.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
