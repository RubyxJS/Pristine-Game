package com.muby;

import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;

public class Window {
    private int width;
    private int height;
    private String title;
    private Long glfwWindow;
    private static Window instance = null;
    private GLFWErrorCallback errorCallback;

    private Window() {
        this.width = 1920;
        this.height = 1080;
        this.title = "Pristine";
    }

    public static Window get() {
        if (instance == null) {
            instance = new Window();
        }
        return instance;
    }

    private void init() {
        // setup error callback
        GLFWErrorCallback.createPrint(System.err).set();

        // Inittialize GLFW
        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }
        glfwInit();

        // Configure Window
        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 4);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 5);

        // Create Window
        glfwWindow = glfwCreateWindow(this.width, this.height, this.title, 0, 0);
        if (glfwWindow == null) {
            throw new IllegalStateException("Failed to create the GLFW window");
        }

        // Mouse Listener Callbacks
        glfwSetCursorPosCallback(glfwWindow, MouseListener::mousePoseCallback);
        glfwSetMouseButtonCallback(glfwWindow, MouseListener::mouseButtonCallback);
        glfwSetScrollCallback(glfwWindow, MouseListener::mouseScrollCallback);

        // Make the OpenGL context current
        glfwMakeContextCurrent(glfwWindow);
        // Enable vsync
        glfwSwapInterval(1);
        // Make the Window Visible
        glfwShowWindow(glfwWindow);
        GL.createCapabilities();
    }

    private void loop() {
        while (!glfwWindowShouldClose(glfwWindow)) {
            // Poll events
            glfwPollEvents();

            glfwSwapBuffers(glfwWindow);
        }
    }

    public void run() {
        System.out.println("Hello !");
        init();
        loop();

        // Terminate GLFW and the free the error callback
        glfwTerminate();
        errorCallback.free();
    }

}
