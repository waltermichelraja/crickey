package dev.willow.engine.rules;

import dev.willow.engine.GameConfig;
import dev.willow.engine.InningsState;

public class InningsRules{
    public static boolean isOver(InningsState state, GameConfig config){
        boolean ballsOver=config.getOversPerInnings().isPresent() && state.getBalls()>=config.getOversPerInnings().getAsInt()*6;
        boolean wicketsOver=config.getWicketsPerInnings().isPresent() && state.getWickets()>=config.getWicketsPerInnings().getAsInt();

        return ballsOver || wicketsOver;
    }
}
