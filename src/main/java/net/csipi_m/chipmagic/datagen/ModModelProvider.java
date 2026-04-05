package net.csipi_m.chipmagic.datagen;

import net.csipi_m.chipmagic.block.ModBlocks;
import net.csipi_m.chipmagic.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGICTIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGICTIUM_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.MAGICTIUM_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAGICTIUM_ALLOY, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAGIC_CHIP, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAGICTIUM_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILICON, Models.GENERATED);
    }
}
