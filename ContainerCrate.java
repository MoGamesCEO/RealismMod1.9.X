package com.realism.mod.GUI;

import com.realism.mod.init.TileEntity.TileEntityCrate;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerCrate extends Container{

	private TileEntityCrate te;
	
	public ContainerCrate(IInventory playerinv, TileEntityCrate te){
		this.te = te;
		
		//Tile Entity, Slot 0-17 0-8
		for(int y = 0; y < 3; ++y){
			for(int x = 0; x < 9;++x){
				this.addSlotToContainer(new Slot(te, x + y * 9, 62 + x * 18, 17 + y * 18));
			}
		}
		//Player inventory slot 9-35 9-35
		
		for(int y = 0; y < 3; ++y){
			for( int x = 0;x < 9;++x){
				this.addSlotToContainer(new Slot(playerinv, x + y * 9, 8 + x * 18 , 84 + y * 18));
			}
		}
		
		//Player inventory slot 0-8 ids 36-44
		for(int x = 0;x < 9;++x)
			this.addSlotToContainer(new Slot(playerinv, x, 8 + x * 18 ,  142));
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return this.te.isUseableByPlayer(playerIn);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player,int fromSlot){
		ItemStack previous = null;
		Slot slot = (Slot)this.inventorySlots.get(fromSlot);
		
		if(slot != null && slot.getHasStack()){
			ItemStack current = slot.getStack();
			previous = current.copy();	
			
			if(fromSlot < 18){
				if(!this.mergeItemStack(current, 18, 45, true))
					return null;
			}else{
				if(!this.mergeItemStack(current, 0, 18, false))
					return null;
			}
			
		if(current.stackSize == 0)
			slot.putStack((ItemStack)null);
		else
		slot.onSlotChanged();
		
		if(current.stackSize == previous.stackSize)
			return null;
		slot.onPickupFromSlot(player, current);
		}
		return previous;
	}
}