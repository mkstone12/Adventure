package com.company;

import java.util.Locale;
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

        //Beskriv rum
        Room1.setRoomDesc("A dark empty room in a cave. You can barely see the walls around you");
        Room2.setRoomDesc("A small room lit by torches.");
        Room3.setRoomDesc("A big painting covers the north wall. It looks like a demon of some sort.");
        Room4.setRoomDesc("A room so small you can barely crawl through.");
        Room5.setRoomDesc("A giant cavetroll with a club sits on a treasure chest. Your presence does not disturb him");
        Room6.setRoomDesc("Shattered gargoyles decorate the west and east wall.");
        Room7.setRoomDesc("An empty dark room.");
        Room8.setRoomDesc("An empty dark room. A foul smell is coming from the north");
        Room9.setRoomDesc("An empty dark room");


        //Scanner til input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hey welcome to the Adventure game");
        System.out.println("You find yourself in a dark room");

        //loop til at holde spillet kørende og boolean til at afbryde spillet
        boolean keepPlaying = true;
        while(keepPlaying == true){

            //loop for at checke om input er godt. Beder om nyt hvis det ikke er.
            boolean goodChoice = false;
            while(goodChoice == false){

                String wrongWay = "You cannot go this way";


                String choice = scanner.nextLine();
                choice = choice.toLowerCase();


                if (choice.equals("north") ||choice.equals("go north")){
                    //Checker om det er muligt at gå den vej
                    if(currentRoom.getNorth() == null)
                    {
                        System.out.println(wrongWay);
                    }

                    else{
                        System.out.println("Going north");
                        currentRoom = currentRoom.getNorth();
                        System.out.println(currentRoom.getName());
                        System.out.println(currentRoom.getRoomDesc());
                        goodChoice = true;
                }}

                else if(choice.equals("south") || choice.equals("go south")){
                    if(currentRoom.getSouth() == null)
                    {
                        System.out.println(wrongWay);
                    }
                    else{
                        System.out.println("Going south");
                        currentRoom =currentRoom.getSouth();
                        System.out.println(currentRoom.getName());
                        System.out.println(currentRoom.getRoomDesc());
                        goodChoice = true;
                }}

                else if(choice.equals("east") ||choice.equals("go east")){
                    if(currentRoom.getEast() == null)
                    {
                        System.out.println(wrongWay);
                    }
                    else{
                        System.out.println("Going east");
                        currentRoom =currentRoom.getEast();
                        System.out.println(currentRoom.getName());
                        System.out.println(currentRoom.getRoomDesc());
                        goodChoice = true;
                }}

                else if(choice.equals("west") || choice.equals("go west")){
                    if(currentRoom.getWest() == null)
                    {
                        System.out.println(wrongWay);
                    }
                    else{
                        System.out.println("Going west");
                        currentRoom = currentRoom.getWest();
                        System.out.println(currentRoom.getName());
                        System.out.println(currentRoom.getRoomDesc());
                        goodChoice = true;
                }}

                else if (choice.equals("look")){
                    System.out.println(currentRoom.getRoomDesc());
                    goodChoice= true;
                }

                else if(choice.equals("help")){
                    System.out.println("To go in any direction type that direction (north, south, east or west). " +
                            "To get a description of where you are type look.");
                }

                else if(choice.equals("exit")){
                    keepPlaying = false;
                    System.out.println("Thanks for playing the adventure game");
                    break;
                }

            else{
                    System.out.println("This does not seem to be possible. Try something else like looking around by typing look or type help if you need it");
            }
            }


    }
}
}
