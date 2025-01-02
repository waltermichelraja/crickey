import java.util.*;
class HandCricket{
    Scanner in;
    int toss, choice, oppChoice;
    HandCricket(){
        in=new Scanner(System.in);
        toss=-1; choice=oppChoice=0;
    }
    boolean toss(){
        System.out.println("TOSS: ");
        toss=((int)(Math.random()*2+1));
        try{
            Thread.sleep(1000*2);
        }
        catch (InterruptedException ie){
            ie.printStackTrace();
        }
        if(toss==1){
            System.out.println("\tyou've won the toss!");
            return true;
        }
        else{
            System.out.println("\tyou've lost the toss...");
            return false;
        }
    }
    void decission(){
        System.out.println("DECISSION: ");
        if(toss()){
            do{
                System.out.println("\tenter 1 to opt batting \n\tenter 2 to opt bowling");
                choice=in.nextInt();
                if(choice==1){
                    System.out.println("you've decided to bat first! ");
                }
                if(choice==2){
                    System.out.println("you've decided to bowl first! ");
                }
                else{
                    System.out.println("\tINVALID INPUT!");
                }
            }
            while(choice!=1||choice!=2);
        }
        else{
            oppChoice=((int)Math.random()*2+1);
            if(oppChoice==1){
                System.out.println("your opponent decides to bat first | get ready to bowl!");
            }
            else{
                System.out.println("your opponent decides to bowl first | get ready to bat!");
            }
        }
    }
    void game(){

    }
}