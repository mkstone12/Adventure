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
    Room Room5Underground = new Room("Under statue");
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
        //Underjords rum




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
        Room5Underground.setRoomDesc("You are underneath the stone statue");


        Room1.addNewItem("lamp", "Shiny Lamp", 5);

        Room1.addWeaponMelee("sword", "Giant two handed sword", 40,10);

        Room1.addNewItem("carpet", "Purple Carpet", 30);

        Room2.addNewItem("axe", "bloody axe", 13);
        Room2.addNewItem("bread", "moldy bread", 1);

        Room3.addNewItem("log","Giant Log", 99);

        Room4.addNewItem("key","Old Key", 1);

        Room5.addNewItem("Rock","Dwayne The Rock Johnson", 99);

        Room6.addNewItem("corpse","Rotten Corpse", 75);

        Room7.addNewItem("eel","Slimey Eel", 14);

        Room8.addNewItem("umbrella","Red Umbrella", 4);

        Room9.addNewItem("diamond","Diamond", 5);
        Room9.addNewItem("spear","Very Long Spear", 25);

        Room5Underground.addNewItem("test","Test",5);

        Room1.addWeaponMelee("spear","Very Long Spear", 25,15);
        Room1.addFood("cake","Very nice cake", 5, 10);

        Item_WeaponMelee skeletonWeapon = new Item_WeaponMelee("Brittle sword", " Brittle sword", 5, 5);

        Room1.createEnemy("Skeleton",20,skeletonWeapon);


    }

    public void dungMap(){
        System.out.println("The diamond fits perfectly in the hole in the status. The statue moves and stairs appear below it\n" +
                "You dont think you would be able to remove the diamond again");
        Room5Underground.setUp(Room5);
        Room5.removeItem("diamond");
        Room5.setRoomDesc("There is stairs going underground and a large stone statue behind it");
    }



}
