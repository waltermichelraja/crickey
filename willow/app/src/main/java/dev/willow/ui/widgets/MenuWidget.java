package dev.willow.ui.widgets;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.util.List;

public class MenuWidget{
    private final List<String> options;
    private int selectedIndex=0;

    public MenuWidget(List<String> options){
        this.options=options;
    }

    public void render(TextGraphics tg, int x, int y){
        for(int i=0; i<options.size(); i++){
            String prefix=(i==selectedIndex)?"▶ ":"  ";
            tg.putString(x, y+i, prefix+options.get(i));
        }
    }

    public void handleInput(KeyStroke key){
        if(key.getKeyType()==KeyType.ArrowUp){selectedIndex=Math.max(0, selectedIndex-1);}
        if(key.getKeyType()==KeyType.ArrowDown){selectedIndex=Math.min(options.size()-1, selectedIndex+1);}
    }

    public boolean isSelected(KeyStroke key){return key.getKeyType()==KeyType.Enter;}

    public int selectedIndex(){return selectedIndex;}
}