package com.realism.mod.GUI;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class CrateGUIHandler implements IGuiHandler{

	public static final int CRATE_GUI = 0;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {		
		if(ID == CRATE_GUI)
		return new ContainerCrate();
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == CRATE_GUI)
		return new GUICrate();
		
		return null;
	}

}
