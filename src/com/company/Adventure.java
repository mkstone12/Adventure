package com.company;

import java.util.Scanner;

public class Adventure {

    public static void main() {
        //init room
        Room currentRoom;
        Room Room1 = new Room(null,null,null,null, "The Town");
        Room Room2 = new Room(null,null,null, null, "The valley");
        Room Room3 = new Room(null,null,null,null , "The clearing");
        Room Room4 = new Room(null,null,null,null, "Abandoned house");
        Room Room5 = new Room(null,null,null,null, "The statue");
        Room Room6 = new Room(null,null,null,null, "The old battlefield");
        Room Room7 = new Room(null,null,null,null, "Bridge");
        Room Room8 = new Room(null,null,null,null, "Monuments");
        Room Room9 = new Room(null,null,null,null, "Tent Camp");

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

        //Beskriver rum
        Room1.setRoomDesc("You are in a quiet town on the edge of the forest. The town is surrounded by mountains to the north and west");
        Room2.setRoomDesc("You are standing a lush valley full of flowers. A large river runs to the south");
        Room3.setRoomDesc("You enter a clearing in the woods. Seems like somebody made camp here. A red banner hangs from a tree. The forest to the east seems very thick");
        Room4.setRoomDesc("A small wooden house appears. It seems to be abandoned. A large river flow to the east");
        Room5.setRoomDesc("You see a large stone statue in front of you. It has a diamond shaped hole in its base");
        Room6.setRoomDesc("You stumble upon several corpses. A bloody battle has taken place here. There is a lot of debris to the west");
        Room7.setRoomDesc("You see a bridge over the river. The forest seems to be thinning out to the south");
        Room8.setRoomDesc("There two monuments to the north forming a gate. Ancient runes decorate them");
        Room9.setRoomDesc("There are small tents arranged around a fire place. A corpse in blue uniform lays on the ground clutching something.");


        //Scanner til input
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                Hey welcome to the Adventure game. You are trying to find the secret treasure hidden in the forest
                The forest is know to be dangerous so keep on your guard.

                """);
        System.out.println(Room1.getRoomDesc());

        //loop til at holde spillet kørende og boolean til at afbryde spillet
        boolean keepPlaying = true;
        while(keepPlaying){

            //loop for at checke om input er godt. Beder om nyt hvis det ikke er.
            boolean goodChoice = false;
            while(!goodChoice){

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
                        //Skifter rum og printer navn og beskrivelse
                        System.out.println("Going north\n");
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
                        System.out.println("Going south\n");
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
                        System.out.println("Going east\n");
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
                        System.out.println("Going west\n");
                        currentRoom = currentRoom.getWest();
                        System.out.println(currentRoom.getName());
                        System.out.println(currentRoom.getRoomDesc());
                        goodChoice = true;
                }

                }


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
