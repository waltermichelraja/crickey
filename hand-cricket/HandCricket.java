import java.util.*;
import java.math.*;
/**
 * @author Walter Michel Raja
 * @version 1.0.2.23
 */
public class HandCricket{
    int toss=0,score1=0,score2=0;
    int choice,oppChoice,ball=0,oppBall=0;
    int runs[]=new int[6];
    int oppRuns[]=new int[6];
    Scanner in=new Scanner(System.in);
    void toss(){
        System.out.println("TOSS: ");
        try{
            Thread.sleep(1000*2);
        }
        catch (InterruptedException ie){
            ie.printStackTrace();
        }
        toss=((int)(Math.random()*2+1));
        if(toss==1){
            System.out.println("\tyou've won the toss!");
        }
        else{
            System.out.println("\tyou've lost the toss...");
        }
    }
    void choose(){
        System.out.println("DECISION: ");
        if(toss==1){
            System.out.print("\t- enter 1 to opt batting... \n\t- enter 2 to opt bowling... \n\t");
            choice=in.nextInt();
            if((choice>2)||(choice<1)){
                System.exit(0);
            }
            if(choice==2){
                System.out.println("\tyou've decided to bowl first!");
            }
            else{
                System.out.println("\tyou've decided to bat first!");
            }
        }
        else{
            oppChoice=(int)(Math.random()*2+1);
            if(oppChoice==1){
                System.out.println("\tyour opponent decides to bat first | get ready to bowl!");
            }
            else{
                System.out.println("\tyour opponent decides to bowl first | get ready to bat!");
            }
        }
    }
    void game(){
        System.out.println("LET'S PLAY: ");
        if((choice==1)||(oppChoice==2)){
            System.out.println("\t1st Innings: ");
            System.out.println("\t\there comes the first ball!!");
            for(int i=0;i<6;i++){
                oppBall=((int)(Math.random()*7+0));
                System.out.print("\t\tplay!: ");
                runs[i]=in.nextInt();
                System.out.println("\t\topponent plays: "+oppBall);
                score1+=runs[i];
                if((runs[i]>6)||(runs[i]<0)){
                    System.exit(0);
                }
                if(runs[i]==oppBall){
                    score1=score1-runs[i];
                    System.out.println("\t\toops! you're out!");
                    System.out.println("\t\truns scored: "+score1+" | "+"opponent need "+(score1+1)+" to win!");
                    System.out.println("\t2nd Innings: ");
                    for(int j=0;j<6;j++){
                        oppRuns[j]=((int)(Math.random()*7+0));
                        System.out.print("\t\tplay!: ");
                        ball=in.nextInt();
                        System.out.println("\t\topponent plays: "+oppRuns[j]);
                        score2+=oppRuns[j];
                        if((ball>6)||(ball<0)){
                            System.exit(0);
                        }
                        if(oppRuns[j]==ball){
                            score2=score2-oppRuns[j];
                            System.out.print("\t\tYour opponent's out! ");
                            if(score1==score2){
                                System.out.println("and its a TIE!");
                                System.exit(0);
                            }
                            if((score1+1)>score2){
                                System.out.println("and you've WON the match!");
                                System.exit(0);
                            }
                        }
                        else{
                            if(score2>score1){
                                System.out.println("\t\tYou've LOST the match, better luck next time!");
                                System.exit(0);
                            }
                            if(oppRuns[j]==0){
                                score2+=ball;
                                if((oppRuns[j]==0)&&(score2>score1)){
                                    System.out.println("\t\tYou've LOST the match, better luck next time!");
                                    System.exit(0);
                                }
                                System.out.println("\t\tcurrent score: "+score2+" | "+"opponent need "+((score1+1)-score2)+" to win from "+(5-j)+" balls!");
                            }
                            else{
                                System.out.println("\t\tcurrent score: "+score2+" | "+"opponent need "+((score1+1)-score2)+" to win from "+(5-j)+" balls!");
                                if((5-j)==0){
                                    break;
                                }
                            }
                        }
                    }
                    if(score1==score2){
                        System.out.println("\t\tThat was close, its a TIE!");
                        System.exit(0);
                    }
                    if((score1+1)>score2){
                        System.out.println("\t\tWell done! You've WON the match!");
                        System.exit(0);
                    }
                    else{
                        System.exit(0);
                    }
                    break;
                }
                else{
                    if(runs[i]==0){
                        score1+=oppBall;
                        System.out.println("\t\tcurrent score: "+score1+" | "+"balls left: "+(5-i));
                    }
                    else{
                        System.out.println("\t\tcurrent score: "+score1+" | "+"balls left: "+(5-i));//(6-(i+1))
                    }
                }
            }
            System.out.println("\t\truns scored: "+score1+" | "+"opponent need "+(score1+1)+" to win!");
            System.out.println("\t2nd Innings: ");
            for(int k=0;k<6;k++){
                oppRuns[k]=((int)(Math.random()*7+0));
                System.out.print("\t\tplay!: ");
                ball=in.nextInt();
                System.out.println("\t\topponent plays: "+oppRuns[k]);
                score2+=oppRuns[k];
                if((ball>6)||(ball<0)){
                    System.exit(0);
                }
                if(oppRuns[k]==ball){
                    score2=score2-oppRuns[k];
                    System.out.print("\t\tYour opponent's out! ");
                    if(score1==score2){
                        System.out.println("and its a TIE!");
                        System.exit(0);
                    }
                    if((score1+1)>score2){
                        System.out.println("and you've WON the match!");
                        System.exit(0);
                    }
                }
                else{
                    if(score2>score1){
                        System.out.println("\t\tYou've LOST the match, better luck next time!");
                        System.exit(0);
                    }
                    if(oppRuns[k]==0){
                        score2+=ball;
                        if((oppRuns[k]==0)&&(score2>score1)){
                            System.out.println("\t\tYou've LOST the match, better luck next time!");
                            System.exit(0);
                        }
                        System.out.println("\t\tcurrent score: "+score2+" | "+"opponent need "+((score1+1)-score2)+" to win from "+(5-k)+" balls!");
                    }
                    else{
                        System.out.println("\t\tcurrent score: "+score2+" | "+"opponent need "+((score1+1)-score2)+" to win from "+(5-k)+" balls!");
                    }
                }
            }
            if(score1==score2){
                System.out.println("\t\tThat was close, its a TIE!");
                System.exit(0);
            }
            if((score1+1)>score2){
                System.out.println("\t\tWell done! You've WON the match!");
                System.exit(0);
            }
            else{
                System.exit(0);
            }
        }
        if((choice==2)||(oppChoice==1)){
            System.out.println("\t1st Innings: ");
            System.out.println("\t\there comes the first ball!!");
            for(int i=0;i<6;i++){
                oppRuns[i]=((int)(Math.random()*7+0));
                System.out.print("\t\tplay!: ");
                ball=in.nextInt();
                System.out.println("\t\topponent plays: "+oppRuns[i]);
                score1+=oppRuns[i];
                if((ball>6)||(ball<0)){
                    System.exit(0);
                }
                if(oppRuns[i]==ball){
                    score1=score1-oppRuns[i];
                    System.out.println("\t\tgotcha! opponent's out!");
                    System.out.println("\t\truns scored: "+score1+" | "+"you need "+(score1+1)+" to win!");
                    System.out.println("\t2nd Innings: ");
                    for(int j=0;j<6;j++){
                        oppBall=((int)(Math.random()*7+0));
                        System.out.print("\t\tplay!: ");
                        runs[j]=in.nextInt();
                        System.out.println("\t\topponent plays: "+oppBall);
                        score2+=runs[j];
                        if((runs[j]>6)||(runs[j]<0)){
                            System.exit(0);
                        }
                        if(runs[j]==oppBall){
                            score2=score2-runs[j];
                            System.out.print("\t\tYou're out! ");
                            if(score1==score2){
                                System.out.println("and its a TIE!");
                                System.exit(0);
                            }
                            if((score1+1)>score2){
                                System.out.println("and LOST the match!");
                                System.exit(0);
                            }
                        }
                        else{
                            if(score2>score1){
                                System.out.println("\t\tWell done! You've WON the match!");
                                System.exit(0);
                            }
                            if(runs[j]==0){
                                score2+=oppBall;
                                if((runs[j]==0)&&(score2>score1)){
                                    System.out.println("\t\tWell done! You've WON the match!");
                                    System.exit(0);
                                }
                                System.out.println("\t\tcurrent score: "+score2+" | "+"you need "+((score1+1)-score2)+" to win from "+(5-j)+" balls!");
                            }
                            else{
                                System.out.println("\t\tcurrent score: "+score2+" | "+"you need "+((score1+1)-score2)+" to win from "+(5-j)+" balls!");
                                if((5-j)==0){
                                    break;
                                }
                            }
                        }
                    }
                    if(score1==score2){
                        System.out.println("\t\tThat was close, its a TIE!");
                        System.exit(0);
                    }
                    if((score1+1)>score2){
                        System.out.println("\t\tYou've LOST, better luck next time!");
                        System.exit(0);
                    }
                    else{
                        System.exit(0);
                    }
                    break;
                }
                else{
                    if(oppRuns[i]==0){
                        score1+=ball;
                        System.out.println("\t\tcurrent score: "+score1+" | "+"balls left: "+(5-i));
                    }
                    else{
                        System.out.println("\t\tcurrent score: "+score1+" | "+"balls left: "+(5-i));
                    }
                }
            }
            System.out.println("\t\truns scored: "+score1+" | "+"you need "+(score1+1)+" to win!");
            System.out.println("\t2nd Innings: ");
            for(int k=0;k<6;k++){
                oppBall=((int)(Math.random()*7+0));
                System.out.print("\t\tplay!: ");
                runs[k]=in.nextInt();
                System.out.println("\t\topponent plays: "+oppBall);
                score2+=runs[k];
                if((runs[k]>6)||(runs[k]<0)){
                    System.exit(0);
                }
                if(runs[k]==oppBall){
                    score2=score2-runs[k];
                    System.out.print("\t\tYou're out! ");
                    if(score1==score2){
                        System.out.println("and its a TIE!");
                        System.exit(0);
                    }
                    if((score1+1)>score2){
                        System.out.println("and LOST the match!");
                        System.exit(0);
                    }
                }
                else{
                    if(score2>score1){
                        System.out.println("\t\tWell done! You've WON the match!");
                        System.exit(0);
                    }
                    if(runs[k]==0){
                        score2+=oppBall;
                        if((runs[k]==0)&&(score2>score1)){
                            System.out.println("\t\tWell done! You've WON the match!");
                            System.exit(0);
                        }
                        System.out.println("\t\tcurrent score: "+score2+" | "+"you need "+((score1+1)-score2)+" to win from "+(5-k)+" balls!");
                    }
                    else{
                        System.out.println("\t\tcurrent score: "+score2+" | "+"you need "+((score1+1)-score2)+" to win from "+(5-k)+" balls!");
                    }
                }
            }
            if(score1==score2){
                System.out.println("\t\tThat was close, its a TIE!");
                System.exit(0);
            }
            if((score1+1)>score2){
                System.out.println("\t\tYou've LOST, better luck next time!");
                System.exit(0);
            }
            else{
                System.exit(0);
            }
        }
    }
    public static void main(String args[]){
        System.out.println("Welcome to the ground of Hand Cricket!!!");
        System.out.println("CAUTION: entering invalid input will abandon the play!");
        HandCricket ob=new HandCricket();
        ob.toss();
        ob.choose();
        ob.game();
    }
}