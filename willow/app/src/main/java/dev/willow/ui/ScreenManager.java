package dev.willow.ui;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

public class ScreenManager{
    private final Screen terminal;
    private dev.willow.ui.Screen current;

    public ScreenManager(Screen terminal){
        this.terminal=terminal;
    }

    public void show(dev.willow.ui.Screen next){
        this.current=next;
        loop();
    }

    private void loop(){
        try{
            while(true){
                terminal.clear();
                current.render();
                terminal.refresh();
                KeyStroke key=terminal.readInput();
                if(key!=null){current.handleInput(key);}
            }
        }
        catch (Exception e){throw new RuntimeException(e);}
    }

    public Screen terminal(){return terminal;}
}
