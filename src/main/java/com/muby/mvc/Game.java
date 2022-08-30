package com.muby.mvc;

import static org.lwjgl.glfw.GLFW.glfwPollEvents;

public class Game {
    private View view;

    public void setView(View view) {
        this.view = view;
    }

    public synchronized void run() {
        Clock clock = new Clock();

        while (!view.shouldClose()) {
            glfwPollEvents();
            view.render();
            clock.tick();
        }
    }
}
