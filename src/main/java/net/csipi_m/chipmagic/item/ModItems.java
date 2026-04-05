package net.csipi_m.chipmagic.item;

import net.csipi_m.chipmagic.ChipMagic;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    //Az alábbi sort duplikálva és behelyettesítve az új item nevét lehet hozzáadni új itemeket! NE FELEJTS EL nevetadni a lang mappában!!!
    public static final Item MAGICTIUM_GEM = registerItem("magictium_gem", new Item(new Item.Settings()));
    public static final Item MAGICTIUM_SHARD = registerItem("magictium_shard", new Item(new Item.Settings()));
    public static final Item MAGIC_CHIP = registerItem("magic_chip", new Item(new Item.Settings()));
    public static final Item SILICON = registerItem("silicon", new Item(new Item.Settings()));
    public static final Item MAGICTIUM_ALLOY = registerItem("magictium_alloy", new Item(new Item.Settings()));


    private static Item registerItem(String name, Item item) {

        return Registry.register(Registries.ITEM, Identifier.of(ChipMagic.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ChipMagic.LOGGER.info("Registering Mod Items for " + ChipMagic.MOD_ID);

        //Az alábbi sort duplikálva és az ItemGroup nevét átírva lehet másik group-hoz adni!
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            //Az alábbi sort dublikálva és behelyettesítve az új item nevét, lehet hozzáadni a creative inventory-hoz!
           fabricItemGroupEntries.add(MAGICTIUM_GEM);
           fabricItemGroupEntries.add(MAGICTIUM_SHARD);
           fabricItemGroupEntries.add(MAGIC_CHIP);
           fabricItemGroupEntries.add(SILICON);
           fabricItemGroupEntries.add(MAGICTIUM_ALLOY);
        });
    }
}
