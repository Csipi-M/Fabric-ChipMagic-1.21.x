package net.csipi_m.chipmagic.item;

import net.csipi_m.chipmagic.ChipMagic;
import net.csipi_m.chipmagic.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup CHIPMAGIC_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ChipMagic.MOD_ID, "chipmagic"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.MAGICTIUM_GEM))
                    .displayName(Text.translatable("itemgroup.chipmagic.chipmagic"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.MAGICTIUM_GEM);
                        entries.add(ModItems.MAGICTIUM_SHARD);
                        entries.add(ModItems.SILICON);
                        entries.add(ModItems.MAGIC_CHIP);

                        entries.add(ModBlocks.MAGICTIUM_ORE);
                        entries.add(ModBlocks.MAGICTIUM_BLOCK);


                    }).build());


    public static void registerItemGroups() {
        ChipMagic.LOGGER.info("Registering Item Groups for " + ChipMagic.MOD_ID);
    }
}
