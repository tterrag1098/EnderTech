package zephraph.endertech.data;

import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import zephraph.endertech.block.BaseBlock;
import zephraph.endertech.block.BlockWorkbench;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


public enum Blocks {
	workbench(BlockWorkbench.class, "Workbench", 3500);
	
	private Class<? extends BaseBlock> blockClass;
	private Class<? extends TileEntity> teClass;
	private BaseBlock block;
	private final String displayName;
	private final int defaultID;
	public int id;
	
	private Blocks(Class<? extends BaseBlock> blockClass, String displayName, int defaultID){
		this.blockClass = blockClass;
		this.displayName = displayName;
		this.defaultID = id = defaultID;
		
		block = null;
		teClass = null;
	}
	
	private Blocks(Class<? extends BaseBlock> blockClass, Class<? extends TileEntity> te, String displayName, int defaultID) {
		this(blockClass, displayName, defaultID);
		teClass = te;
	}
	
	public void init() {
		try {
			block = (BaseBlock) blockClass.newInstance();
		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e, ModInfo.name + " failed to initialize " + name());
		} 
		GameRegistry.registerBlock(block, name());
		LanguageRegistry.addName(block, displayName);
		if( teClass != null )
			GameRegistry.registerTileEntity(teClass, name() + "TileEntity");
		block.init();
	}
	
	public Block ref() {
		return block;
	}

	public String getDisplayName() {
		return displayName;
	}

	public int getDefaultID() {
		return defaultID;
	}
}
