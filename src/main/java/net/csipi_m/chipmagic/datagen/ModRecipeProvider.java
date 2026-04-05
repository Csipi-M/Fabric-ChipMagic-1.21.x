package net.csipi_m.chipmagic.datagen;

import net.csipi_m.chipmagic.block.ModBlocks;
import net.csipi_m.chipmagic.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        List<ItemConvertible> MAGICTIUM_GEM_SMELTABLES = List.of(ModBlocks.MAGICTIUM_ORE);

        offerSmelting(recipeExporter, MAGICTIUM_GEM_SMELTABLES, RecipeCategory.MISC, ModItems.MAGICTIUM_GEM, 1.0f, 200, "magictium_gem");

        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.MAGICTIUM_GEM, RecipeCategory.MISC, ModBlocks.MAGICTIUM_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MAGICTIUM_GEM)
                .pattern("MM")
                .pattern("MM")
                .input('M', ModItems.MAGICTIUM_SHARD)
                .criterion(hasItem(ModItems.MAGICTIUM_SHARD), conditionsFromItem(ModItems.MAGICTIUM_SHARD))
                .offerTo(recipeExporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MAGICTIUM_SHARD, 4)
                .input(ModItems.MAGICTIUM_GEM)
                .criterion(hasItem(ModItems.MAGICTIUM_SHARD), conditionsFromItem(ModItems.MAGICTIUM_SHARD))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MAGICTIUM_ALLOY, 3)
                .pattern("MMM")
                .pattern("III")
                .input('M', ModItems.MAGICTIUM_GEM)
                .input('I', Items.IRON_INGOT)
                .criterion(hasItem(ModItems.MAGICTIUM_GEM), conditionsFromItem(ModItems.MAGICTIUM_GEM))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MAGIC_CHIP)
                .pattern("MM")
                .pattern("SS")
                .input('M', ModItems.MAGICTIUM_GEM)
                .input('S', ModItems.SILICON)
                .criterion(hasItem(ModItems.SILICON), conditionsFromItem(ModItems.SILICON))
                .offerTo(recipeExporter);

    }
}
