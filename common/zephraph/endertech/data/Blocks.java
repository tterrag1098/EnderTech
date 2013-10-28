package zephraph.endertech.data;

import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import zephraph.endertech.block.BaseBlock;
import zephraph.endertech.block.BlockWorkbench;
import zephraph.endertech.tileentity.TileWorkbench;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


public enum Blocks {
	workbench(BlockWorkbench.class, TileWorkbench.class, "Workbench", 3500);
	
	@SuppressWarnings("rawtypes")
	private Class blockClass;
	private Class<? extends TileEntity> teClass;
	private Block block;
	private final String displayName;
	private final int defaultID;
	public int id;
	
	@SuppressWarnings("rawtypes")
	private Blocks(Class blockClass, String displayName, int defaultID){
		this.blockClass = blockClass;
		this.displayName = displayName;
		this.defaultID = id = defaultID;
		
		block = null;
		teClass = null;
	}
	
	@SuppressWarnings("rawtypes")
	private Blocks(Class blockClass, Class<? extends TileEntity> te, String displayName, int defaultID) {
		this(blockClass, displayName, defaultID);
		teClass = te;
	}
	
	public void init() {
		try {
			block = (Block) blockClass.newInstance();
		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e, ModInfo.name + " failed to initialize " + name());
		} 
		GameRegistry.registerBlock(block, name());
		LanguageRegistry.addName(block, displayName);
		if( teClass != null )
			GameRegistry.registerTileEntity(teClass, name() + "TileEntity");
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
