package com.denfop.render.sintezator;

import com.denfop.Constants;
import com.denfop.IUItem;
import com.denfop.tiles.base.TileSintezator;
import com.denfop.tiles.overtimepanel.EnumSolarPanels;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

import java.util.List;

public class TileEntitySintezatorRender extends TileEntitySpecialRenderer {

    public static final ResourceLocation texture = new ResourceLocation(Constants.TEXTURES,
            "textures/models/sintezator.png");
    static final IModelCustom model = AdvancedModelLoader
            .loadModel(new ResourceLocation(Constants.TEXTURES, "models/sintezator.obj"));
    static final IModelCustom model_panel1 = AdvancedModelLoader
            .loadModel(new ResourceLocation(Constants.TEXTURES, "models/panel_model_1.obj"));
    static final IModelCustom model_panel2 = AdvancedModelLoader
            .loadModel(new ResourceLocation(Constants.TEXTURES, "models/panel_model_2.obj"));
    static final IModelCustom model_panel3 = AdvancedModelLoader
            .loadModel(new ResourceLocation(Constants.TEXTURES, "models/panel_model_3.obj"));
    static final IModelCustom model_panel4 = AdvancedModelLoader
            .loadModel(new ResourceLocation(Constants.TEXTURES, "models/panel_model_4.obj"));
    static final IModelCustom model_panel5 = AdvancedModelLoader
            .loadModel(new ResourceLocation(Constants.TEXTURES, "models/panel_model_5.obj"));
    static final IModelCustom model_panel6 = AdvancedModelLoader
            .loadModel(new ResourceLocation(Constants.TEXTURES, "models/panel_model_6.obj"));
    static final IModelCustom model_panel7 = AdvancedModelLoader
            .loadModel(new ResourceLocation(Constants.TEXTURES, "models/panel_model_7.obj"));
    static final IModelCustom model_panel8 = AdvancedModelLoader
            .loadModel(new ResourceLocation(Constants.TEXTURES, "models/panel_model_8.obj"));
    static final IModelCustom model_panel9 = AdvancedModelLoader
            .loadModel(new ResourceLocation(Constants.TEXTURES, "models/panel_model_9.obj"));
    final IModelCustom[] panels = {model_panel1, model_panel2, model_panel3, model_panel4, model_panel5, model_panel6, model_panel7, model_panel8, model_panel9};

    @Override
    public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f) {
        render((TileSintezator) tile, x, y, z);
    }

    private void render(TileSintezator tile, double x, double y, double z) {
        GL11.glPushMatrix();
        GL11.glTranslated(x, y, z);
        GL11.glTranslatef(0.5F, 0F, 0.5F);
        GL11.glRotatef(0F, 0.0F, 0F, 0F);
        bindTexture(texture);
        model.renderAll();
        for (int i = 0; i < 9; i++) {
            if (tile.inputslot.get(i) != null) {
                if (IUItem.map2.get(tile.inputslot.get(i).getUnlocalizedName() + ".name") != null) {
                    EnumSolarPanels solar = IUItem.map2.get(tile.inputslot.get(i).getUnlocalizedName() + ".name");
                    ResourceLocation texture1;
                    if (solar.rendertype)
                        if (tile.solartype != 0)

                            texture1 = new ResourceLocation(Constants.TEXTURES, "textures/models/panels/" + solar.texturesmodels + "_" + tile.solartype + ".png");
                        else
                            texture1 = new ResourceLocation(Constants.TEXTURES,
                                    "textures/models/panels/" + solar.texturesmodels + ".png");
                    else
                        texture1 = new ResourceLocation(Constants.TEXTURES,
                                "textures/models/panels/" + solar.texturesmodels + ".png");
                    bindTexture(texture1);
                    panels[i].renderAll();


                } else if (IUItem.panel_list.get(tile.inputslot.get(i).getUnlocalizedName() + ".name") != null) {
                    List solar = IUItem.panel_list.get(tile.inputslot.get(i).getUnlocalizedName() + ".name");
                    ResourceLocation texture1;
                    if ((boolean) solar.get(6))
                        if (tile.solartype != 0)

                            texture1 = new ResourceLocation(((ResourceLocation) solar.get(5)).getResourceDomain(), ((ResourceLocation) solar.get(5)).getResourcePath().substring(0, ((ResourceLocation) solar.get(5)).getResourcePath().lastIndexOf(".")) + "_" + tile.solartype + ".png");
                        else
                            texture1 = new ResourceLocation(((ResourceLocation) solar.get(5)).getResourceDomain(),
                                    ((ResourceLocation) solar.get(5)).getResourcePath());
                    else
                        texture1 = new ResourceLocation(((ResourceLocation) solar.get(5)).getResourceDomain(),
                                ((ResourceLocation) solar).getResourcePath());
                    bindTexture(texture1);
                    panels[i].renderAll();
                }
            }
        }
        GL11.glPopMatrix();

    }

}