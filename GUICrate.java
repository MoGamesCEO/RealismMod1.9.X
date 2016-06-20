package com.realism.mod.GUI;

import com.realism.mod.RMGlobal;
import com.realism.mod.init.TileEntity.TileEntityCrate;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GUICrate extends GuiContainer{

	private IInventory playInv;
	private TileEntityCrate te;
	
	public GUICrate(IInventory playerInv,TileEntityCrate te) {
		super(new ContainerCrate(playerInv, te));
		
		this.playInv = playerInv;
		this.te = te;
		
		this.xSize = 176;
		this.ySize = 166;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0f,1.0F);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(RMGlobal.Mod_ID + ":" + "textures/gui/conatiner/crate_gui.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0,0, this.xSize, this.ySize);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX,int mouseY){
		String s = this.te.getDisplayName().getUnformattedText();
		this.fontRendererObj.drawString(s, 88- this.fontRendererObj.getStringWidth(s) / 2, 6, 421752);
		this.fontRendererObj.drawString(this.playInv.getDisplayName().getUnformattedText(), 8, 72, 4210752);
	}
}