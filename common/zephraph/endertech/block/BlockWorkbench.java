package zephraph.endertech.block;

import zephraph.endertech.data.Blocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockWorkbench extends Block {

	public BlockWorkbench(int id) {
		super(id, Material.rock);
		setHardness(0.5F);
		setStepSound(Block.soundStoneFootstep);
		setUnlocalizedName(Blocks.workbench.name());
	}

}
