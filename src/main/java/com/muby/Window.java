package com.muby;

import static org.lwjgl.opengl.GL40.*;

import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWScrollCallback;
import org.lwjgl.opengl.GL;

import com.muby.util.Time;

import sun.java2d.marlin.Version;

import static org.lwjgl.glfw.GLFW.*;

public class Window {
    private int width, height;
    private String title;
    private Long glfwWindow;

    public float r, g, b, a;

    private static Window instance = null;
    private GLFWErrorCallback errorCallback;

    private static Scene currentScene;

    private Window() {
        this.width = 1920;
        this.height = 1080;
        this.title = "Pristine";
    }

    public static void changeScene(int newScene) {
        switch (newScene) {
            case 0:
                currentScene = new LevelEditorScene();
                // currentScene.init();
                break;
            case 1:
                currentScene = new LevelScene();
                break;
            default:
                assert false : "Unknown scene '" + newScene + "'";
        }
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
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
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
        glfwSetKeyCallback(glfwWindow, KeyListener::keyCallback);

        // Make the OpenGL context current
        glfwMakeContextCurrent(glfwWindow);
        // Enable vsync
        glfwSwapInterval(1);
        // Make the Window Visible
        glfwShowWindow(glfwWindow);
        GL.createCapabilities();
        Window.changeScene(0);
    }

    private void loop() {

        float beginTime = Time.getTime();
        float endTime;
        float dt = -1.0f;

        while (!glfwWindowShouldClose(glfwWindow)) {
            // Poll events
            glfwPollEvents();

            glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            glClear(GL_COLOR_BUFFER_BIT);

            if (dt >= 0) {
                currentScene.update(dt);
            }

            if (KeyListener.isKeyPressed(GLFW_KEY_APOSTROPHE)) {
                System.out.println("Lol");
            }

            glfwSwapBuffers(glfwWindow);

            endTime = Time.getTime();
            dt = endTime - beginTime;
            beginTime = endTime;
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
