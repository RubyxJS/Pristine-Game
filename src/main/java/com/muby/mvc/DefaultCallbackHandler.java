package com.muby.mvc;

public class DefaultCallbackHandler implements CallbackHandler {
    private Game game;

    @Override
    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public void cursorPos(double xpos, double ypos) {
        // TODO
    }

    @Override
    public void mouseButton(int button, int action, int mods) {
        // TODO
    }

    @Override
    public void scroll(double xoffset, double yoffset) {
        // TODO
    }

    @Override
    public void key(int key, int scancode, int action, int mods) {
        // TODO
    }
}
