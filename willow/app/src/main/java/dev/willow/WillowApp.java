package dev.willow;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import dev.willow.ui.ScreenManager;
import dev.willow.ui.screens.MainMenuScreen;

public class WillowApp{
    public static void main(String[] args){
        try{
            Screen terminal=new DefaultTerminalFactory().createScreen();
            terminal.startScreen();
            ScreenManager manager=new ScreenManager(terminal);
            manager.show(new MainMenuScreen(manager));
            terminal.stopScreen();
        }
        catch(Exception e){e.printStackTrace();}
    }
}
