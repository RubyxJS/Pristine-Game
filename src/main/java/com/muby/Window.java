package com.muby;
import static org.lwjgl.opengl.GL40.*;
import static org.lwjgl.glfw.GLFW.*;

public class Window {
    private static Window instance = null;
    private Window() {};
    public static Window get() {
        if (instance == null) {
            instance = new Window();
        }
        return instance;
    }
    private void init () {
        glfwInit();
        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 4);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 5);
    }
    private void loop() {

    }
    public void run() {
        init();
        loop();
    }

}
