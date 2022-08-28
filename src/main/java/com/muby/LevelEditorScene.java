package com.muby;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;

public class LevelEditorScene extends Scene{
    private boolean changingScene = false;
    public LevelEditorScene(){

    }
    @Override
    public void update(float dt) {
        if (!changingScene && KeyListener.isKeyPressed(GLFW_KEY_SPACE)) {
            changingScene = true;
        }
    }
}
