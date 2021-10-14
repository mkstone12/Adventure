package com.company;

public class Map {


    Room Room1 = new Room("Town");
    Room Room2 = new Room( "Valley");
    Room Room3 = new Room("Clearing");
    Room Room4 = new Room("Abandoned house");
    Room Room4House = new Room("Inside House");
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
        Room4.setRoomDesc("A small wooden house appears on a hill. It seems to be abandoned. A large river flow to the east");
        Room4House.setRoomDesc("You enter the abandoned house, the room is covered in dust and webs.");
        Room5.setRoomDesc("You see a large stone statue in front of you. It has a diamond shaped hole in its base");
        Room6.setRoomDesc("You stumble upon several corpses. A bloody battle has taken place here. There is a lot of debris to the west");
        Room7.setRoomDesc("You see a bridge over the river. The forest seems to be thinning out to the south");
        Room8.setRoomDesc("There two monuments to the north forming a gate. Ancient runes decorate them");
        Room9.setRoomDesc("There are small tents arranged around a fire place. A corpse in blue uniform lays on the ground clutching a diamond.");
        Room5Underground.setRoomDesc("You are underneath the stone statue");


        Room1.addNewItem("lamp", "Shiny Lamp", 5);

        Room1.addWeaponMelee("sword", "Giant two handed sword", 40,20);

        Room1.addNewItem("carpet", "Purple Carpet", 30);

        Room2.addWeaponMelee("axe", "bloody axe", 13,10);
        Room2.addFood("bread", "moldy bread", 1,-20);

        Room3.addWeaponMelee("log","Giant Log", 99,100);
        Room3.addNewItem("key","Old Key", 1);

        Room4House.addRangedWeapon("handgun","Handgun", 5, 100,12);

        Room5.addNewItem("rock","Dwayne The Rock Johnson", 95);
        Room5.addFood("what the rock is cooking", "What The Rock Is Cooking", 5,50);

        Room6.addFood("corpse","Rotten Corpse", 75,-1000);
        Room6.addWeaponMelee("arm","severed arm", 15, 5);

        Room7.addRangedWeapon("eel","Slimey Eel", 14, 50, 1);
        Room7.addFood("oyster","Fresh Oyster", 1, 5);

        Room8.addNewItem("umbrella","Red Umbrella", 4);

        Room9.addNewItem("diamond","Diamond", 5);
        Room9.addWeaponMelee("spear","Very Long Spear", 30,15);
        Room9.addFood("pork","a roasted pig", 5, 35);


        Item_WeaponMelee DogTeeth = new Item_WeaponMelee("dog teeth", "Dog teeth", 5, 15);

        Room1.createEnemy("Dog",50,DogTeeth);

        Item_WeaponMelee skeletonWeapon = new Item_WeaponMelee("brittle sword", "Brittle sword", 5, 5);

        Room4.createEnemy("Skeleton",20,skeletonWeapon);

        Item_Weapon_Ranged Slingshot = new Item_Weapon_Ranged("slingshot", "Slingshot", 5, 1, 100);

        Room3.createEnemy("Goblin",50,Slingshot);

        Item_WeaponMelee SpiderFangs = new Item_WeaponMelee("spider fangs", "Spider fangs", 5, 100);

        Room4House.createEnemy("Giant Spider",1000,SpiderFangs);

        Item_WeaponMelee GiantClub = new Item_WeaponMelee("club", "Giant Club", 80, 50);

        Room6.createEnemy("Ogre",500,GiantClub);

        Item_WeaponMelee CarrotSword = new Item_WeaponMelee("carrotsword", "CarrotSword", 99, 25);

        Room8.createEnemy("Bunny",500,CarrotSword);

        Item_WeaponMelee Morningstar = new Item_WeaponMelee("morningstar", "Morningstar", 20, 20);

        Room9.createEnemy("John The Bandit",50,Morningstar);

        Room5Underground.addWeaponMelee("bunny slayer", "Bunny Slayer", 1, 500);
        Room5Underground.addFood("magic potion", "Magic Potion", 1, 500);
        Room5Underground.addNewItem("treasure", "TREASURE!", 101);


    }

    public void DiamondRoom(){
        System.out.println("The diamond fits perfectly in the hole in the statue. The statue moves and stairs appear below it\n" +
                "You dont think you would be able to remove the diamond again");
        Room5Underground.setUp(Room5);
        Room5.removeItem("diamond");
        Room5.setRoomDesc("There is stairs going underground and a large stone statue behind it");
    }
    public void HouseRoom(){
        System.out.println("The key fits in the lock of the house.\n" +
                "The door slides open.");
        Room4House.setDown(Room4);
        Room4.removeItem("key");




}}
