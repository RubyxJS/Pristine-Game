package com.muby.mvc;

public interface CallbackHandler {
    public void setGame(Game game);
    public void cursorPos(double xpos, double ypos);
    public void mouseButton(int button, int action, int mods);
    public void scroll(double xoffset, double yoffset);
    public void key(int key, int scancode, int action, int mods);
}
