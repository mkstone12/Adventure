package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Adventure {

    public static void main() {

        Map map = new Map();
        map.createMap();

        //Scanner til input
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                Hey welcome to the Adventure game. You are trying to find the secret treasure hidden in the forest
                The forest is know to be dangerous so keep on your guard.

                """);


        System.out.println(map.Room1.getRoomDesc());

        //loop til at holde spillet kørende og boolean til at afbryde spillet
        boolean keepPlaying = true;
        while(keepPlaying){

            //loop for at checke om input er godt. Beder om nyt hvis det ikke er.
            boolean goodChoice = false;
            while(!goodChoice){

                String wrongWay = "You cannot go this way";


                String choice = scanner.nextLine().trim().toLowerCase();


                if (choice.equals("north") ||choice.equals("go north")){
                    //Checker om det er muligt at gå den vej
                    if(map.currentRoom.getNorth() == null)
                    {
                        System.out.println(wrongWay);
                    }

                    else{
                        //Skifter rum og printer navn og beskrivelse af nyt rum
                        System.out.println("Going north\n");
                        map.currentRoom = map.currentRoom.getNorth();
                        System.out.println(map.currentRoom.getName());
                        System.out.println(map.currentRoom.getRoomDesc());
                        goodChoice = true;
                }}


                else if(choice.equals("south") || choice.equals("go south")){
                    if(map.currentRoom.getSouth() == null)
                    {
                        System.out.println(wrongWay);
                    }
                    else{
                        System.out.println("Going south\n");
                        map.currentRoom =map.currentRoom.getSouth();
                        System.out.println(map.currentRoom.getName());
                        System.out.println(map.currentRoom.getRoomDesc());
                        goodChoice = true;
                }}

                else if(choice.equals("east") ||choice.equals("go east")){
                    if(map.currentRoom.getEast() == null)
                    {
                        System.out.println(wrongWay);
                    }
                    else{
                        System.out.println("Going east\n");
                        map.currentRoom =map.currentRoom.getEast();
                        System.out.println(map.currentRoom.getName());
                        System.out.println(map.currentRoom.getRoomDesc());
                        goodChoice = true;
                }}

                else if(choice.equals("west") || choice.equals("go west")){
                    if(map.currentRoom.getWest() == null)
                    {
                        System.out.println(wrongWay);
                    }
                    else{
                        System.out.println("Going west\n");
                        map.currentRoom = map.currentRoom.getWest();
                        System.out.println(map.currentRoom.getName());
                        System.out.println(map.currentRoom.getRoomDesc());
                        goodChoice = true;
                }}

                //andre kommandoer
                else if (choice.equals("look")){
                    System.out.println(map.currentRoom.getRoomDesc());
                    goodChoice= true;
                }

                else if(choice.equals("help")){
                    System.out.println("To go in any direction type that direction (north, south, east or west). " +
                            "To get a description of where you are type look.");
                }

                else if(choice.equals("exit") ||choice.equals("quit")){
                    keepPlaying = false;
                    goodChoice= true;
                    System.out.println("Thanks for playing the adventure game");

                }

            else{
                    System.out.println("This does not seem to be possible. Try something else like looking around by typing look or type help if you need it");
            }}
    }
}
}
