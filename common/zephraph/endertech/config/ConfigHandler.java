package zephraph.endertech.config;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import zephraph.endertech.EnderTech;
import zephraph.endertech.data.Blocks;
import zephraph.endertech.data.ModInfo;
import cpw.mods.fml.common.FMLLog;

public class ConfigHandler {
	public static void init(File file)
	{
		Configuration config = new Configuration(file);
		try {
			config.load();
			
			for( Blocks block : Blocks.values() )
			{
				block.id = config.getBlock(block.name(), block.getDefaultID()).getInt(block.getDefaultID());
				EnderTech.log.info(block.name() + ": " + String.valueOf(block.id));
			}
			
		} catch( Exception e ) {
			FMLLog.log(Level.SEVERE, e, ModInfo.name + " failed loading configuration");
		} finally {
			config.save();
		}
		
	}
}
