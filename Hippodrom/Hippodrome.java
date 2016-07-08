package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by VetoSu4 on 06.02.2016.
 */
public class Hippodrome
{
    ArrayList<Horse> horses = new ArrayList<>();

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public static Hippodrome game;

    public static void main(String[] args)
    {

        game = new Hippodrome();
        Horse horseFirst = new Horse("Horse1", 3, 0);
        Horse horseSecond = new Horse("Horse2", 3, 0);
        Horse horseThird = new Horse("Horse3", 3, 0);

        game.getHorses().add(horseFirst);
        game.getHorses().add(horseSecond);
        game.getHorses().add(horseThird);

        game.run();
        game.printWinner();
    }

    public void run(){
        for (int i = 1; i <= 10; i++)
        {
            move();
            print();

            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }



        }
    }
    public void move(){
        for (int i = 0; i < horses.size(); i++)
        {
            horses.get(i).move();
        }
    }
    public void print(){

        for (int i = 0; i < horses.size(); i++)
        {
            horses.get(i).print();
        }

        System.out.println();
        System.out.println();
    }

    public Horse getWinner(){
        Horse winHorse  = new Horse("NoHorse", 0, 0);

        for (Horse horse : horses)
        {
            if(horse.distance > winHorse.distance){
                winHorse = horse;
            }
        }


        return winHorse;
    }

    public void printWinner(){

        System.out.println("Winner is " + getWinner().name + "!");

    }

}
