package com.realism.mod.Achievements;

import com.realism.mod.init.RMItems;

import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class AchievementList {
	
	//Acheivements
	public static Achievement AchievementGetEmeraldArmor;
	public static Achievement AchievementGetemeraldtools;


	public static void MainRegistry(){
		AchievementGetemeraldtools = new Achievement("achievement.GetEmeraldTools", "GetEmeraldTools", 0, 0, RMItems.EmeraldPickaxe, null);
		AchievementGetEmeraldArmor = new Achievement("achievement.GetEmeraldArmor", "GetEmeraldArmor", 0, 1, RMItems.EmeraldChestPlate, AchievementGetemeraldtools);

		
		AchievementPage.registerAchievementPage(new AchievementPage("Realism Mod", new Achievement[]{AchievementGetemeraldtools,AchievementGetEmeraldArmor}));
	
		FMLCommonHandler.instance().bus().register(new RMAchievementEvents());
	}
}
