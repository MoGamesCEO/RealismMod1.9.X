package com.realism.mod.render;

import org.lwjgl.opengl.GL11;

import com.realism.mod.RMGlobal;
import com.realism.mod.model.Crate;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityCrateRenderer extends TileEntitySpecialRenderer{

	ResourceLocation texture = new ResourceLocation(RMGlobal.Mod_ID + ":" + "textures/entity/Crate.png");
	private Crate model;
	
	public TileEntityCrateRenderer(){
		this.model = new Crate();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float partialTicks, int destroyStage) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5f, (float)y + 1.5f,(float) z + 0.5f);
		GL11.glRotatef(180, 0f, 0f, 1f);
		this.bindTexture(texture);
		GL11.glPushMatrix();
		this.model.renderModel(0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}
