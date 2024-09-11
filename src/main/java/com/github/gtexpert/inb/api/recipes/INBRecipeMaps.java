package com.github.gtexpert.inb.api.recipes;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.ore.OrePrefix.dust;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;

import gregtech.api.gui.GuiTextures;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.api.recipes.ingredients.GTRecipeInput;
import gregtech.api.unification.material.Materials;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenProperty;

@ZenExpansion("mods.gregtech.recipe.RecipeMaps")
@ZenRegister
public class INBRecipeMaps {

    /**
     * Fake recipe map to easily add to RecipeMaps.IMPLOSION_RECIPES.
     * Any recipe that is added by this fake recipe map will also be added to
     * the Implosion Compressor recipe map, with matching inputs and outputs.
     * A recipe for each explosive will be added to Implosion Compressor
     *
     * This action cannot be negated, unlike special build actions for other recipe maps.
     */

    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> FAKE_IMPLOSION_RECIPES = new RecipeMap<>(
            "fake_implosion_compressor", 3, 2, 0, 0,
            new SimpleRecipeBuilder().duration(20).EUt(VA[LV]), true)
                    .onRecipeBuild(recipeBuilder -> {
                        RecipeMaps.IMPLOSION_RECIPES.recipeBuilder()
                                .inputs(recipeBuilder.getInputs().toArray(new GTRecipeInput[0]))
                                .outputs(recipeBuilder.getOutputs())
                                .chancedOutputs(recipeBuilder.getChancedOutputs())
                                .explosivesType(new ItemStack(MetaBlocks.POWDERBARREL, 8))
                                .buildAndRegister();

                        RecipeMaps.IMPLOSION_RECIPES.recipeBuilder()
                                .inputs(recipeBuilder.getInputs().toArray(new GTRecipeInput[0]))
                                .outputs(recipeBuilder.getOutputs())
                                .chancedOutputs(recipeBuilder.getChancedOutputs())
                                .explosivesAmount(4)
                                .buildAndRegister();

                        RecipeMaps.IMPLOSION_RECIPES.recipeBuilder()
                                .inputs(recipeBuilder.getInputs().toArray(new GTRecipeInput[0]))
                                .outputs(recipeBuilder.getOutputs())
                                .chancedOutputs(recipeBuilder.getChancedOutputs())
                                .explosivesType(MetaItems.DYNAMITE.getStackForm(2))
                                .buildAndRegister();

                        RecipeMaps.IMPLOSION_RECIPES.recipeBuilder()
                                .inputs(recipeBuilder.getInputs().toArray(new GTRecipeInput[0]))
                                .outputs(recipeBuilder.getOutputs())
                                .chancedOutputs(recipeBuilder.getChancedOutputs())
                                .explosivesType(new ItemStack(MetaBlocks.ITNT))
                                .buildAndRegister();
                    });

    /**
     * Any Recipe added to the Compressor not specifying an <B>EUt</B> value will default to 491,520.
     * Any Recipe added to the Compressor not specifying a <B>duration</B> value will default to 1.
     */

    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> ELECTRIC_IMPLOSION_COMPRESSOR_RECIPES = new RecipeMap<>(
            "electric_implosion_compressor", 6, 2, 0, 0,
            new SimpleRecipeBuilder().duration(1).EUt(VA[UV]).chancedOutput(dust, Materials.DarkAsh, 2500, 0), false)
                    .setSlotOverlay(false, false, false, GuiTextures.IMPLOSION_OVERLAY_2)
                    .setSlotOverlay(false, false, false, GuiTextures.IMPLOSION_OVERLAY_2)
                    .setSlotOverlay(false, false, false, GuiTextures.IMPLOSION_OVERLAY_2)
                    .setSlotOverlay(false, false, false, GuiTextures.IMPLOSION_OVERLAY_2)
                    .setSlotOverlay(false, false, false, GuiTextures.IMPLOSION_OVERLAY_2)
                    .setSlotOverlay(false, false, true, GuiTextures.IMPLOSION_OVERLAY_2)
                    .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
                    .setSound(SoundEvents.ENTITY_GENERIC_EXPLODE)
                    .setSmallRecipeMap(RecipeMaps.IMPLOSION_RECIPES);
}
