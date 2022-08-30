package com.muby.mvc;

import static org.lwjgl.glfw.GLFW.glfwTerminate;

import org.lwjgl.glfw.GLFWErrorCallback;

public class Main {
    public static void main(String[] args) {
        try (GLFWErrorCallback errorCallback = GLFWErrorCallback.createPrint(System.err)) {
            Game game = new Game();
            View view = new View(800, 600, "Pristine");
            CallbackHandler handler = new DefaultCallbackHandler();

            game.setView(view);
            view.setCallbackHandler(handler);
            handler.setGame(game);

            game.run();
            glfwTerminate();
        }
    }
}
