package net.csipi_m.chipmagic;

import net.csipi_m.chipmagic.block.ModBlocks;
import net.csipi_m.chipmagic.item.ModItemGroups;
import net.csipi_m.chipmagic.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChipMagic implements ModInitializer {
	public static final String MOD_ID = "chipmagic";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}