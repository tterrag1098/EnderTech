package zephraph.endertech.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import zephraph.endertech.data.Blocks;
import zephraph.endertech.tileentity.TileWorkbench;

public class BlockWorkbench extends BaseBlock {

	public BlockWorkbench() {
		super(Blocks.workbench.id, Material.wood);
		setHardness(0.5F);
		setStepSound(Block.soundStoneFootstep);
		setUnlocalizedName(Blocks.workbench.name());
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public void init() {	
	}
	
	@Override
	public int getRenderType() {
		return -1;
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int x, int y, int z, int side) {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public TileEntity createTileEntity(World world, int metadata) {
		return new TileWorkbench();
	}
	

}
