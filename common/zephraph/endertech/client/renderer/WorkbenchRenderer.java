package zephraph.endertech.client.renderer;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHopper;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import zephraph.endertech.client.model.WorkbenchModel;

public class WorkbenchRenderer extends TileEntitySpecialRenderer implements IItemRenderer {

	private WorkbenchModel model;
	
	public WorkbenchRenderer() {
		model = new WorkbenchModel();		
	}
	
	//-- Item Rendering -----------------------------------------------------------
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch(type) {
		case INVENTORY:
			model.render(-1f, -0.9f, 0f);
			break;
		default:
			model.render(0f, 0f, 1f);
		}
		
	}
	
	// -- Entity Rendering -------------------------------------------------------------

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f) {
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		
		model.render(x, y, z + 1.0f);
		
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
	}
}
