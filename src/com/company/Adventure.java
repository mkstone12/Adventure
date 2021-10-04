package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Adventure {
    public static boolean keepPlaying = true;

    public static void main() {

        Map map = new Map();
        map.createMap();
        Player player = new Player();
        player.setCurrentRoom(map.currentRoom);
        System.out.println(player.getCurrentRoom().getName());

        String choice;


        //Scanner til input
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                Hey welcome to the Adventure game. You are trying to find the secret treasure hidden in the forest
                The forest is know to be dangerous so keep on your guard.

                """);
        System.out.println(map.Room1.getRoomDesc());
        System.out.println(map.currentRoom.getAllItems());

        //loop til at holde spillet kørende
        while(keepPlaying){

            //loop for at checke om input er godt. Beder om nyt hvis det ikke er.
            boolean goodChoice = false;
            while(!goodChoice){
                choice = scanner.nextLine().trim().toLowerCase();
                //Check for at se om vi skal samle eller smide noget væk
                    goodChoice = Command(map, choice, player);}

    }}






    public static boolean Command(Map map,  String choice, Player player){
        boolean goodChoice = false;
        boolean isTakeOrDrop = false;
        ArrayList<String> items = map.currentRoom.getAllItems();
        if (choice.length() > 3) {

            if (choice.substring(0,4).equals("take")){
                String item = choice.trim().substring(5);
                for (int i=0;i < map.currentRoom.getAllItems().size();i++)
                    if(item.equals(map.currentRoom.getAllItems().get(i))){
                        player.takeItem(map.currentRoom.getItem(item));
                        break;
                    }
                    else if (i == map.currentRoom.getAllItems().size()-1){
                        System.out.println("Items does not exist");
                    }

                    isTakeOrDrop = true;
                    goodChoice = true;


            }
            //Hvis vi skal smide noget væk
            else if (choice.substring(0,4).equals("drop")){
                String item = choice.trim().substring(5);
                for (int i=0;i < player.getPlayerItems().size();i++)
                    if(item.equals(player.getPlayerItems().get(i))){
                        player.dropItem(item);
                        System.out.println("You have dropped the " + item);
                        break;
                    }
                    else if (i == map.currentRoom.getAllItems().size()-1){
                        System.out.println("You do not have this item");
                    }
                    isTakeOrDrop = true;
                    goodChoice = true;

            }
        }


        String wrongWay = "You cannot go this way";
        if(isTakeOrDrop ==false){
        switch (choice) {
            case "north", "n", "go north" -> {
                //Checker om det er muligt at gå den vej
                if (map.currentRoom.getNorth() == null) {
                    System.out.println(wrongWay);
                } else {
                    //Skifter rum og printer navn og beskrivelse af nyt rum
                    System.out.println("Going north\n");
                    map.currentRoom = map.currentRoom.getNorth();
                    printCurRoomInfo(map);
                    goodChoice = true;
                }
            }
            case "south", "s", "go south" -> {
                if (map.currentRoom.getSouth() == null) {
                    System.out.println(wrongWay);
                } else {
                    System.out.println("Going south\n");
                    map.currentRoom = map.currentRoom.getSouth();
                    printCurRoomInfo(map);
                    goodChoice = true;
                }
            }
            case "east", "e", "go east" -> {
                if (map.currentRoom.getEast() == null) {
                    System.out.println(wrongWay);
                } else {
                    System.out.println("Going east\n");
                    map.currentRoom = map.currentRoom.getEast();
                    printCurRoomInfo(map);
                    goodChoice = true;
                }
            }
            case "west", "w", "go west" -> {
                if (map.currentRoom.getWest() == null) {
                    System.out.println(wrongWay);
                } else {
                    System.out.println("Going west\n");
                    map.currentRoom = map.currentRoom.getWest();
                    printCurRoomInfo(map);
                    goodChoice = true;
                }
            }


            //andre kommandoer
            case "look" -> {
                printCurRoomInfo(map);
                goodChoice = true;

            }
            case "help" ->
                System.out.println("To go in any direction type that direction (north, south, east or west). " +
                        "To get a description of where you are type look.");


            case "quit", "exit" -> {
                keepPlaying = false;
                goodChoice = true;
                System.out.println("Thanks for playing the adventure game");


            }
            case "inventory", "i" ->{
                System.out.println(player.getPlayerWeight());
                System.out.println(player.getPlayerItems());
              }

            default -> System.out.println("This does not seem to be possible. Try something else like looking around by typing look or type help if you need it");


        }}


        player.setCurrentRoom(map.currentRoom);
        return goodChoice;


    }
    public static void printCurRoomInfo(Map map){
        System.out.println(map.currentRoom.getName());
        System.out.println(map.currentRoom.getRoomDesc());
        System.out.println(map.currentRoom.getAllItems());
    }


    }


