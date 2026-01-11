package dev.willow.ui;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import dev.willow.ui.screens.MainMenuScreen;

public class ScreenManager {
    private final Screen screen;
    private dev.willow.ui.Screen current;

    public ScreenManager(Screen screen){
        this.screen=screen;
    }

    public void start(dev.willow.ui.Screen initial){
        try{
            screen.startScreen();
            this.current=initial;
            loop();
        }
        catch(Exception e){throw new RuntimeException(e);}
    }

    public void show(dev.willow.ui.Screen next){this.current=next;}

    private void loop(){
        try{
            while(true){
                screen.clear();
                current.render();
                screen.refresh();
                KeyStroke key=screen.readInput();
                if(key==null){continue;}
                if(key.getKeyType()==KeyType.Escape){
                    if(current instanceof MainMenuScreen){
                        screen.stopScreen(); screen.close(); System.exit(0);
                    }
                    show(new MainMenuScreen(this));
                    continue;
                }
                current.handleInput(key);
            }
        }
        catch(Exception e){throw new RuntimeException(e);}
    }

    public Screen terminal(){return screen;}
}
