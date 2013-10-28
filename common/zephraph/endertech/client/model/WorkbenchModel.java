package zephraph.endertech.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import zephraph.endertech.core.helper.RenderHelper;

public class WorkbenchModel extends ModelBase {
	private static final String TEXTURE = "endertech:textures/models/workbench.png";
	private static final String MODEL = "/assets/endertech/models/workbench.obj";
	
	private IModelCustom model;
	
	public WorkbenchModel() {
		model = AdvancedModelLoader.loadModel(MODEL);
	}
	
	public void render(double x, double y, double z) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x, (float) y, (float) z);
	    RenderHelper.bindTexture(TEXTURE);
	    model.renderAll();
		GL11.glPopMatrix();
	}
}
