package dev.willow;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

import dev.willow.ui.ScreenManager;
import dev.willow.ui.screens.MainMenuScreen;

public class WillowApp{
    public static void main(String[] args){
        try{
            Screen terminal=new DefaultTerminalFactory().createScreen();
            ScreenManager manager=new ScreenManager(terminal);
            manager.start(new MainMenuScreen(manager));
        }
        catch(Exception e){e.printStackTrace();}
    }
}
