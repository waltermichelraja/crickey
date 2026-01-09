package dev.willow.engine;

import java.util.OptionalInt;

public class GameConfig {
    private final OptionalInt oversPerInnings;
    private final OptionalInt wicketsPerInnings;

    public GameConfig(OptionalInt oversPerInnings, OptionalInt wicketsPerInnings){
        this.oversPerInnings=oversPerInnings;
        this.wicketsPerInnings=wicketsPerInnings;
    }

    public OptionalInt getOversPerInnings(){return oversPerInnings;}

    public OptionalInt getWicketsPerInnings(){return wicketsPerInnings;}
}
