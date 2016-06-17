package com.realism.mod.Achievements;

import com.realism.mod.init.RMItems;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class RMAchievementEvents {

	@SubscribeEvent
	public void onGetemeraldtools(PlayerEvent.ItemCraftedEvent e){
		if(e.crafting.getItem().equals(RMItems.EmeraldPickaxe)){
			e.player.addStat(AchievementList.AchievementGetemeraldtools, 1);
		}
	}
	@SubscribeEvent
	public void onGetemeraldArmor(PlayerEvent.ItemCraftedEvent e){
		if(e.crafting.getItem().equals(RMItems.EmeraldChestPlate)){
			e.player.addStat(AchievementList.AchievementGetEmeraldArmor, 1);
		}
	}
}
