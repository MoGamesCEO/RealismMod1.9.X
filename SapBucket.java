package com.realism.mod.init.block;

import com.realism.mod.RMGlobal;
import com.realism.mod.init.RMBlocks;
import com.realism.mod.init.RMItems;
import com.sun.corba.se.spi.ior.iiop.GIOPVersion;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SapBucket extends Block{

	public SapBucket() {
		super(Material.CARPET);
		setRegistryName("sap_bucket");
		setCreativeTab(RMGlobal.RMCreativeTabBlocks);
		setHardness(4.0F);
		setHarvestLevel(3, 3);
		GameRegistry.register(this);		
		GameRegistry.register(new ItemBlock(this), getRegistryName());
	}
	private void setHarvestLevel(int i, int level) {
		// TODO Auto-generated method stub
		
	}
	 public boolean isFullCube(IBlockState state)
	    {
	        return false;
	    }

	    public boolean isOpaqueCube(IBlockState state)
	    {
	        return false;
	    }
}