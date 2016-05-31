package com.realism.mod.world;

import java.util.Random;

import com.realism.mod.init.RMBlocks;

import net.minecraft.client.renderer.block.statemap.BlockStateMapper;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class RMWorldGen implements IWorldGenerator {
	
	
	private WorldGenerator copper_ore;
	
	public RMWorldGen()
	{
		this.copper_ore = new WorldGenMinable(RMBlocks.copper_ore.getDefaultState(), 16);
	}
	
	
	
	private void runGenerator(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chancesToSpawn, int minHeight, int maxHeight)
	{
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");
		
		int heightDiff = maxHeight - minHeight + 1;
		for (int i = 0; i < chancesToSpawn; i++){
			int x = chunkX * 16 + random.nextInt(16);
			int y = minHeight + random.nextInt(heightDiff);
			int z = chunkZ * 16 + random.nextInt(16);
			generator.generate(world,  random,  new BlockPos(x, y, z));
		}
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		switch (world.provider.getDimension())
		{
		case 0:
			this.runGenerator(this.copper_ore, world, random, chunkX, chunkZ, 7, 20, 64);
			break;
		
		case -1:
			
			break;
		
		case 1:
			break;
		}
	}		
	{	}

	
	
	
	
	
}
