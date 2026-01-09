package dev.willow.ui.screens;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import dev.willow.engine.GameConfig;
import dev.willow.ui.Screen;
import dev.willow.ui.ScreenManager;
import dev.willow.ui.widgets.MenuWidget;

import java.util.List;
import java.util.OptionalInt;

public class WicketsConfigScreen implements Screen{
    private final ScreenManager manager;
    private final OptionalInt overs;
    private final MenuWidget menu;

    public WicketsConfigScreen(ScreenManager manager, OptionalInt overs){
        this.manager=manager;
        this.overs=overs;
        this.menu=new MenuWidget(List.of("1 wicket", "2 wickets", "unlimited"));
    }

    @Override
    public void render(){
        TextGraphics tg=manager.terminal().newTextGraphics();
        tg.putString(5, 2, "MATCH CONFIGIURATION");
        tg.putString(5, 4, "wickets per innings");
        menu.render(tg, 5, 6);
    }

    @Override
    public void handleInput(KeyStroke key){
        if (key.getKeyType()==KeyType.ArrowUp || key.getKeyType()==KeyType.ArrowDown){
            menu.handleInput(key);
            return;
        }
        if(menu.isSelected(key)){
            OptionalInt wickets=switch(menu.selectedIndex()){
                case 0->OptionalInt.of(1);
                case 1->OptionalInt.of(2);
                case 2->OptionalInt.empty();
                default->OptionalInt.of(1);
            };
            GameConfig config=new GameConfig(overs, wickets);
            manager.show(new TossScreen(manager, config));
        }
    }
}
