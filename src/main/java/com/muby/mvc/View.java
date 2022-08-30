package com.muby.mvc;

import static org.lwjgl.glfw.GLFW.glfwCreateWindow;
import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwSetCursorPosCallback;
import static org.lwjgl.glfw.GLFW.glfwSetKeyCallback;
import static org.lwjgl.glfw.GLFW.glfwSetMouseButtonCallback;
import static org.lwjgl.glfw.GLFW.glfwSetScrollCallback;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwSwapInterval;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;
import static org.lwjgl.opengl.GL.createCapabilities;

public class View {
    private Long window;

    public View(int width, int height, String title) {
        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        window = glfwCreateWindow(width, height, title, 0, 0);
        if (window == null) {
            throw new IllegalStateException("Failed to create the GLFW window");
        }

        glfwMakeContextCurrent(window);
        glfwSwapInterval(1);
        glfwShowWindow(window);
        glfwShowWindow(window);
        createCapabilities();
    }

    public boolean shouldClose() {
        return glfwWindowShouldClose(window);
    }

    public void setCallbackHandler(CallbackHandler handler) {
        glfwSetCursorPosCallback(window, (_window, xpos, ypos) -> handler.cursorPos(xpos, ypos));
        glfwSetMouseButtonCallback(window, (_window, button, action, mods) -> handler.mouseButton(button, action, mods));
        glfwSetScrollCallback(window, (_window, xoffset, yoffset) -> handler.scroll(xoffset, yoffset));
        glfwSetKeyCallback(window, (_window, key, scancode, action, mods) -> handler.key(key, scancode, action, mods));
    }

    public void render() {
        glfwSwapBuffers(window);
    }
}
