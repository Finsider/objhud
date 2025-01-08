package fin.objhud;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.Identifier;

public class Helper {

    public enum ScreenLocationX {
        LEFT,
        MIDDLE,
        RIGHT
    }

    public enum ScreenLocationY {
        UPPER,
        MIDDLE,
        UNDER,
    }

    public static int defaultHUDLocationX(ScreenLocationX locationX, DrawContext context) {
        return switch (locationX) {
            case LEFT -> 0;
            case MIDDLE -> context.getScaledWindowWidth() / 2;
            case RIGHT -> context.getScaledWindowWidth();
        };
    }

    public static int defaultHUDLocationY(ScreenLocationY locationY, DrawContext context) {
        return switch (locationY) {
            case UPPER -> 0;
            case MIDDLE -> context.getScaledWindowHeight() / 2;
            case UNDER -> context.getScaledWindowHeight();
        };
    }

    public static void drawTextureAlphaColor(DrawContext context, Identifier identifier, int x, int y, float u, float v, int width, int height, int textureWidth, int textureHeight, int color) {

        float alpha = (color >> 24 & 0xFF) / 255.0F;
        float red = (color >> 16 & 0xFF) / 255.0F;
        float green = (color >> 8 & 0xFF) / 255.0F;
        float blue = (color & 0xFF) / 255.0F;

        RenderSystem.enableBlend();
        RenderSystem.setShaderColor(red, green, blue, alpha);
        context.drawTexture(identifier, x, y, u, v, width, height, textureWidth, textureHeight);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.disableBlend();
    }

    public static void drawTextureAlpha(DrawContext context, Identifier identifier, int x, int y, float u, float v, int width, int height, int textureWidth, int textureHeight) {
        RenderSystem.enableBlend();
        context.drawTexture(identifier, x, y, u, v, width, height, textureWidth, textureHeight);
        RenderSystem.disableBlend();
    }

    public static void drawTextureColor(DrawContext context, Identifier identifier, int x, int y, float u, float v, int width, int height, int textureWidth, int textureHeight, int color) {
        float alpha = (color >> 24 & 0xFF) / 255.0F;
        float red = (color >> 16 & 0xFF) / 255.0F;
        float green = (color >> 8 & 0xFF) / 255.0F;
        float blue = (color & 0xFF) / 255.0F;

        RenderSystem.setShaderColor(red, green, blue, alpha);
        context.drawTexture(identifier, x, y, u, v, width, height, textureWidth, textureHeight);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
    }


}
