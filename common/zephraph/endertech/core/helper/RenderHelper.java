package zephraph.endertech.core.helper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;

public class RenderHelper {
	
	public static TextureManager engine() {
		return Minecraft.getMinecraft().renderEngine;
	}

	public static void bindTexture(String string) {
		engine().bindTexture(new ResourceLocation(string));
	}
}
