package com.denfop.integration.botania;

import com.denfop.IUItem;
import com.denfop.item.base.IUItemBase;
import com.denfop.item.energy.EnergyDrill;
import cpw.mods.fml.common.registry.GameRegistry;
import ic2.api.item.IC2Items;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import ic2.core.Ic2Items;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.common.item.ModItems;
import vazkii.botania.common.lib.LibOreDict;

public class BotaniaIntegration {

    public static Block blockBotSolarPanel;
    public static Item manasteel_plate;
    public static Item manasteel_core;
    public static Item elementium_plate;
    public static Item elementium_core;
    public static Item terrasteel_plate;
    public static Item terrasteel_core;
    public static ItemStack reactorterastrellSimple;
    public static ItemStack reactorDepletedterastrellSimple;
    public static ItemStack reactorterastrellQuad;
    public static ItemStack reactorterastrellDual;
    public static ItemStack reactorDepletedterastrellQuad;
    public static ItemStack reactorDepletedterastrellDual;
    public static Item rune_sun;
    public static Item rune_night;
    public static Item rune_energy;

    public static Item teraDDrill;

    public static void init() {
        blockBotSolarPanel = new blockBotSolarPanel();
        manasteel_plate = new IUItemBase("manasteel_plate");
        manasteel_core = new IUItemBase("manasteel_core");
        elementium_plate = new IUItemBase("elementium_plate");
        elementium_core = new IUItemBase("elementium_core");
        terrasteel_plate = new IUItemBase("terrasteel_plate");
        terrasteel_core = new IUItemBase("terrasteel_core");
        rune_sun = new IUItemBase("rune_sun");
        rune_night = new IUItemBase("rune_night");
        rune_energy = new IUItemBase("rune_energy");
        teraDDrill = new EnergyDrill(Item.ToolMaterial.EMERALD, "teraDDrill", 0, 0, 500, 45000, 4, 35, 16, 160, 80);

    }

    public static void recipe() {
        BotaniaAPI.registerRuneAltarRecipe(new ItemStack(rune_energy, 1, 0), 12000,
                LibOreDict.RUNE[0], LibOreDict.RUNE[1], new ItemStack(IUItem.photoniy),
                new ItemStack(IUItem.itemIU, 1, 0), new ItemStack(IUItem.iuingot, 1, 17),
                new ItemStack(elementium_plate), new ItemStack(IUItem.compresscarbonultra));
        BotaniaAPI.registerRuneAltarRecipe(new ItemStack(rune_sun, 1, 0), 12000,
                LibOreDict.RUNE[4], LibOreDict.RUNE[3], new ItemStack(IUItem.photoniy_ingot),
                new ItemStack(IUItem.itemIU, 1, 0), new ItemStack(IUItem.iuingot, 1, 17),
                new ItemStack(elementium_plate), new ItemStack(IUItem.compresscarbon));
        BotaniaAPI.registerRuneAltarRecipe(new ItemStack(rune_night, 1, 0), 12000,
                LibOreDict.RUNE[7], LibOreDict.RUNE[5], new ItemStack(Ic2Items.energyCrystal.getItem(), 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(IUItem.itemIU, 1, 0), new ItemStack(IUItem.iuingot, 1, 17),
                new ItemStack(manasteel_plate), new ItemStack(IUItem.coal_chunk1));
        Recipes.compressor.addRecipe(
                new RecipeInputItemStack(new ItemStack(ModItems.manaResource, 1, 0), 1),
                null, new ItemStack(manasteel_plate));
        Recipes.compressor.addRecipe(
                new RecipeInputItemStack(new ItemStack(ModItems.manaResource, 1, 7), 1),
                null, new ItemStack(elementium_plate));
        Recipes.compressor.addRecipe(
                new RecipeInputItemStack(new ItemStack(ModItems.manaResource, 1, 4), 1),
                null, new ItemStack(terrasteel_plate));
        GameRegistry.addRecipe(new ItemStack(teraDDrill, 1, OreDictionary.WILDCARD_VALUE),
                " L ", "ODO", "COC", 'O', IUItem.overclockerUpgrade, 'D',
                new ItemStack(Ic2Items.diamondDrill.getItem(), 1, OreDictionary.WILDCARD_VALUE), 'C',
                terrasteel_plate, 'L', ModItems.terraPick);
        GameRegistry.addRecipe(new ItemStack(terrasteel_core),
                "KLM", "DOD", "CHC", 'C', terrasteel_plate, 'D', new ItemStack(IUItem.itemIU, 1, 1), 'O',
                terrasteel_plate, 'L', IC2Items.getItem("advancedAlloy"), 'K', rune_night, 'M', rune_sun, 'H',
                rune_energy);
        GameRegistry.addRecipe(new ItemStack(elementium_core),
                "KLM", "DOD", "CHC", 'C', elementium_plate, 'D', IUItem.photoniy_ingot, 'O',
                manasteel_core, 'L', IC2Items.getItem("advancedCircuit"), 'K', rune_night, 'M', rune_sun, 'H',
                rune_energy);
        GameRegistry.addRecipe(new ItemStack(manasteel_core),
                "KLM", "DOD", "CHC", 'C', manasteel_plate, 'D', IUItem.photoniy_ingot, 'O',
                IUItem.core, 'L', IC2Items.getItem("advancedCircuit"), 'K', rune_night, 'M', rune_sun,
                'H', rune_energy);
        GameRegistry.addRecipe(new ItemStack(blockBotSolarPanel, 1, 0), " B ", "BAB", " B ", 'A',
                manasteel_core, 'B', new ItemStack(IUItem.blockpanel, 1, 0));
        GameRegistry.addRecipe(new ItemStack(blockBotSolarPanel, 1, 1), " B ", "BAB", " B ", 'A',
                elementium_core, 'B', new ItemStack(blockBotSolarPanel, 1, 0));
        GameRegistry.addRecipe(new ItemStack(blockBotSolarPanel, 1, 2), " B ", "BAB", " B ", 'A',
                terrasteel_core, 'B', new ItemStack(blockBotSolarPanel, 1, 1));

        Recipes.advRecipes.addRecipe(reactorterastrellDual, "SQS", 'S',
                reactorterastrellSimple, 'Q', "plateIron");
        Recipes.advRecipes.addRecipe(reactorterastrellQuad, "SQS", "CQC", "SQS", 'S',
                reactorterastrellSimple, 'Q', "plateIron", 'C', "plateCopper");

        Recipes.advRecipes.addRecipe(reactorterastrellQuad, "SQS", 'S',
                reactorterastrellDual, 'Q', "plateIron", 'C', "plateCopper");

        Recipes.cannerBottle.addRecipe(new RecipeInputItemStack(IC2Items.getItem("fuelRod"), 1),
                new RecipeInputItemStack(new ItemStack(ModItems.manaResource, 1, 4), 1),
                reactorterastrellSimple);
        Recipes.compressor.addRecipe(new RecipeInputItemStack(reactorDepletedterastrellSimple, 1),
                null, new ItemStack(ModItems.manaResource, 1, 4));
        Recipes.compressor.addRecipe(new RecipeInputItemStack(reactorDepletedterastrellDual, 1),
                null, new ItemStack(ModItems.manaResource, 2, 4));
        Recipes.compressor.addRecipe(new RecipeInputItemStack(reactorDepletedterastrellQuad, 1),
                null, new ItemStack(ModItems.manaResource, 4, 4));
        //
        GameRegistry.addRecipe(new ItemStack(IUItem.UpgradePanelKit, 1, 17), "   ", "BAB", " B ", 'A',
                manasteel_core, 'B', new ItemStack(IUItem.blockpanel, 1, 0));
        GameRegistry.addRecipe(new ItemStack(IUItem.UpgradePanelKit, 1, 18), "   ", "BAB", " B ", 'A',
                elementium_core, 'B', new ItemStack(blockBotSolarPanel, 1, 0));
        GameRegistry.addRecipe(new ItemStack(IUItem.UpgradePanelKit, 1, 19), "   ", "BAB", " B ", 'A',
                terrasteel_core, 'B', new ItemStack(blockBotSolarPanel, 1, 1));

    }


}
