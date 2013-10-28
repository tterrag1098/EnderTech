package zephraph.endertech;

import java.util.logging.Logger;

import zephraph.endertech.config.ConfigHandler;
import zephraph.endertech.core.proxy.CommonProxy;
import zephraph.endertech.data.Blocks;
import zephraph.endertech.data.ModInfo;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = "EnderTech", name = ModInfo.name, version = ModInfo.version, 
acceptedMinecraftVersions = "[1.6.4]", dependencies = 
		"required-after:Forge@FORGE_VERSION@;")
@NetworkMod(clientSideRequired=true)
public class EnderTech {
	
	@Instance(ModInfo.id)
	public static EnderTech instance;
	
	@SidedProxy(clientSide = ModInfo.client_proxy, serverSide = ModInfo.common_proxy)
	public static CommonProxy proxy;
	
	public static Logger log;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		log = Logger.getLogger(ModInfo.id);
		log.setParent(FMLLog.getLogger());
		
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		
		for(Blocks block : Blocks.values())
			block.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.load();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}

}
