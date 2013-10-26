package zephraph.endertech.config;

import java.io.File;

import zephraph.endertech.data.Blocks;
import net.minecraftforge.common.Configuration;

public class ConfigHandler {
	public static void init(File file)
	{
		Configuration config = new Configuration(file);
		try {
			config.load();
			
			for( Blocks block : Blocks.values() )
				block.init( config.getBlock(block.name(), block.getDefaultID()).getInt(block.getDefaultID()) );
			
		} catch( Exception e ) {
			
		} finally {
			config.save();
		}
		
	}
}
