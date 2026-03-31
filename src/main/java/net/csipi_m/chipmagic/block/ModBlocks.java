package net.csipi_m.chipmagic.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.csipi_m.chipmagic.ChipMagic;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    //Az alábbi sort duplikálva és behelyettesítve az új block nevét lehet hozzáadni új blockokat! NE FELEJTS EL nevetadni a lang mappában!!!
    public static final Block MAGICTIUM_ORE = registerBlock("magictium_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(4, 10),
                    AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.NETHER_GOLD_ORE)));

    public static final Block MAGICTIUM_BLOCK = registerBlock("magictium_block",
            new Block(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_CLUSTER)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ChipMagic.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(ChipMagic.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        ChipMagic.LOGGER.info("Registering Mod Blocks for " + ChipMagic.MOD_ID);

        //Az alábbi sort duplikálva és az ItemGroup nevét átírva lehet másik group-hoz adni!
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            //Az alábbi sort dublikálva és behelyettesítve az új block nevét, lehet hozzáadni a creative inventory-hoz!
            entries.add(ModBlocks.MAGICTIUM_ORE);


        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.MAGICTIUM_BLOCK);

        });
    }
}