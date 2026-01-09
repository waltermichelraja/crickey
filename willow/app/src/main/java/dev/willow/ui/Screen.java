package dev.willow.ui;

import com.googlecode.lanterna.input.KeyStroke;

public interface Screen{
    void render();
    void handleInput(KeyStroke key);
}
