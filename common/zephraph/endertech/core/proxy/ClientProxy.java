package zephraph.endertech.core.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import zephraph.endertech.client.renderer.WorkbenchRenderer;
import zephraph.endertech.data.Blocks;
import zephraph.endertech.tileentity.TileWorkbench;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {
	
	@Override
	  public World getClientWorld() {
	    return FMLClientHandler.instance().getClient().theWorld;
	  }

	  @Override
	  public EntityPlayer getClientPlayer() {
	    return Minecraft.getMinecraft().thePlayer;
	  }
	
	@Override
	public void load() {
		WorkbenchRenderer wbr = new WorkbenchRenderer();
		ClientRegistry.bindTileEntitySpecialRenderer(TileWorkbench.class, wbr);
		MinecraftForgeClient.registerItemRenderer(Blocks.workbench.id, wbr);
	}
}
