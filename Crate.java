package com.realism.mod.init.block;

import javax.annotation.Nullable;

import com.realism.mod.RMGlobal;
import com.realism.mod.GUI.CrateGUIHandler;
import com.realism.mod.init.TileEntity.TileEntityCrate;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Crate extends Block implements ITileEntityProvider{

	public Crate(Material materialIn) {
		super(materialIn);
		
		this.setUnlocalizedName("Crate");
		this.setHardness(2.0F);
		this.setResistance(6.0F);
		this.setCreativeTab(RMGlobal.RMCreativeTabBlocks);
		this.setHarvestLevel("axe", 0);
	}
	@Override
	 public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,ItemStack stack, EnumFacing side, float hitX, float hitY, float hitZ){
	 if(!world.isRemote){
		player.openGui(RMGlobal.Mod_ID, CrateGUIHandler.CRATE_GUI, world, pos.getX(),pos.getY() ,pos.getZ() );
	}
	return true;
}
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
	
	public int getRenderType(){
		return -1;
	}
	@Override
        public void breakBlock(World world, BlockPos pos, IBlockState state)  {
     		TileEntityCrate te = (TileEntityCrate)world.getTileEntity(pos);
     		InventoryHelper.dropInventoryItems(world, pos, te);
            super.breakBlock(world, pos, state);
            world.removeTileEntity(pos);
        }

	@Override
	public void onBlockPlacedBy(World world,BlockPos pos, IBlockState state, EntityLivingBase player, ItemStack stack){
		if(stack.hasDisplayName()){
			((TileEntityCrate)world.getTileEntity(pos)).setCustomName(stack.getDisplayName());
		}
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityCrate();
	}
}
