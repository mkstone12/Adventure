package com.company;

public class Map {


    Room Room1 = new Room("Town");
    Room Room2 = new Room( "Valley");
    Room Room3 = new Room("Clearing");
    Room Room4 = new Room("Abandoned house");
    Room Room5 = new Room("The statue");
    Room Room6 = new Room("The old battlefield");
    Room Room7 = new Room("Bridge");
    Room Room8 = new Room("Monuments");
    Room Room9 = new Room("Tent Camp");
    Room currentRoom = Room1;

    public void createMap(){
        //forbinder rum
        Room1.setEast(Room2);
        Room1.setSouth(Room4);
        Room2.setEast(Room3);
        Room3.setSouth(Room6);
        Room4.setSouth(Room7);
        Room5.setSouth(Room8);
        Room6.setSouth(Room9);
        Room7.setEast(Room8);
        Room8.setEast(Room9);
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
        Room9.setRoomDesc("There are small tents arranged around a fire place. A corpse in blue uniform lays on the ground clutching a diamond.");



        Room1.addNewItem("lamp", "Shiny Lamp");
        Room1.addNewItem("sword", "Giant two handed sword");
        Room1.addNewItem("carpet");

        Room2.addNewItem("axe", " asd");
        Room2.addNewItem("food", "asd");


    }



}
