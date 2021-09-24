package com.company;

import java.util.Scanner;

public class Adventure {

    public static void main() {
        //init room
        Room currentRoom = null;
        Room Room1 = new Room(null,null,null,null, "Room 1");
        Room Room2 = new Room(null,null,null, null, "Room 2");
        Room Room3 = new Room(null,null,null,null , "Room 3");
        Room Room4 = new Room(null,null,null,null, "Room 4");
        Room Room5 = new Room(null,null,null,null, "Room 5");
        Room Room6 = new Room(null,null,null,null, "Room 6");
        Room Room7 = new Room(null,null,null,null, "Room 7");
        Room Room8 = new Room(null,null,null,null, "Room 8");
        Room Room9 = new Room(null,null,null,null, "Room 9");

        //forbinder rum
        Room1.setEast(Room2);
        Room1.setSouth(Room4);
        Room2.setEast(Room3);
        Room2.setWest(Room1);
        Room3.setWest(Room2);
        Room3.setSouth(Room6);
        Room4.setNorth(Room1);
        Room4.setSouth(Room7);
        Room5.setSouth(Room8);
        Room6.setNorth(Room3);
        Room6.setSouth(Room9);
        Room7.setNorth(Room4);
        Room7.setEast(Room8);
        Room8.setNorth(Room5);
        Room8.setWest(Room7);
        Room8.setEast(Room9);
        Room9.setNorth(Room6);
        Room9.setWest(Room8);

        currentRoom = Room1;


        Scanner scanner = new Scanner(System.in);

        System.out.println("Hey welcome to the Adventure game");


        while(true){
            System.out.println("you are in room "+ currentRoom.getName());
            System.out.println("Which direction do you want to go?");
        String choice = scanner.nextLine();
        if (choice.equals("north")){
            System.out.println("Going north");
            currentRoom = currentRoom.getNorth();
        }
        else if(choice.equals("south")){
            System.out.println("Going south");
            currentRoom =currentRoom.getSouth();
        }
        else if(choice.equals("east")){
            currentRoom =currentRoom.getEast();
        }
        else if(choice.equals("west")){
            System.out.println("Going west");
            currentRoom = currentRoom.getWest();

        }
        else if (choice.equals("look")){
            System.out.println("looking around");
            System.out.println(currentRoom.getName());

        }

    }
}}
