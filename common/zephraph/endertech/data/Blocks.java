package zephraph.endertech.data;

import java.util.logging.Level;

import zephraph.endertech.block.BlockWorkbench;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;


public enum Blocks {
	workbench(BlockWorkbench.class, "Workbench", 22000);
	
	@SuppressWarnings("rawtypes")
	private Class blockClass;
	private Block block;
	private final String displayName;
	private final int defaultID;
	
	@SuppressWarnings("rawtypes")
	private Blocks(Class blockClass, String displayName, int defaultID){
		this.blockClass = blockClass;
		this.displayName = displayName;
		this.defaultID = defaultID;
		
		block = null;
	}
	
	public void init(int id) {
		try {
			block = (Block) blockClass.getDeclaredConstructors()[0].newInstance(id);
		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e, ModInfo.name + " failed to initialize " + name());
		} 
		GameRegistry.registerBlock(block, name());
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
