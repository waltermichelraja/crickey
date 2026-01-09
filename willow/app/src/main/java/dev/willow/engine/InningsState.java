package dev.willow.engine;

public class InningsState{
    private int runs=0;
    private int balls=0;
    private int wickets=0;

    public void addRuns(int r){
        runs+=r;
        balls++;
    }
    public void wicket(){
        wickets++;
        balls++;
    }
    public int getRuns(){
        return runs;
    }
    public int getBalls(){
        return balls;
    }
    public int getWickets(){
        return wickets;
    }
    public void reset(){
        runs=0;
        balls=0;
        wickets=0;
    }
}
