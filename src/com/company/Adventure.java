package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Adventure {
    public static boolean keepPlaying = true;

    public static void main() {

        Map map = new Map();
        map.createMap();
        Player player = new Player();
        player.setCurrentRoom(map.currentRoom);

        String choice;


        //Scanner til input
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                Hey welcome to the Adventure game. You are trying to find the secret treasure hidden in the forest
                The forest is know to be dangerous so keep on your guard.

                """);

        printCurRoomInfo(map);

        //loop til at holde spillet kørende
        while(keepPlaying){

            //loop for at checke om input er godt. Beder om nyt hvis det ikke er.
            boolean goodChoice = false;
            while(!goodChoice){
                choice = scanner.nextLine().trim().toLowerCase();
                    goodChoice = Command(map, choice, player);

            for (int i = 0; i < map.Room5.getAllItems().size();i++){
                if (map.Room5.getAllItems().get(i).equals("diamond")){
                    map.dungMap();
                }}}

    }}






    public static boolean Command(Map map,  String choice, Player player){
        boolean goodChoice = false;
        boolean isTakeOrDrop = false;
       // if (choice.length() > 8) {


            if (choice.startsWith("take ")) {
                String item = choice.trim().substring(5);
                System.out.println(choice);
                for (int i = 0; i < map.currentRoom.getAllItems().size(); i++) {
                    if (item.equals(map.currentRoom.getAllItems().get(i))) {
                        player.takeItem(map.currentRoom.getItem(item));
                        break;
                    } else if (i == map.currentRoom.getAllItems().size() - 1) {
                        System.out.println("Items does not exist");
                    }
                }

                isTakeOrDrop = true;
                goodChoice = true;


            }
            //Hvis vi skal smide noget væk
            else if (choice.startsWith("drop ")) {
                String item = choice.trim().substring(5);
                for (int i = 0; i < player.getPlayerItems().size(); i++) {

                    if (item.equals(player.getPlayerItems().get(i).getName())) {
                        player.dropItem((item));
                        break;
                    } else if (i == player.getPlayerItems().size() -1 ) {
                        System.out.println("You do not have this item in your inventory");
                    }
                }

                isTakeOrDrop = true;
                goodChoice = true;


            } else if (choice.startsWith("eat ")) {
                String food = choice.trim().substring(4);
                for (int i = 0; i < player.getPlayerItems().size(); i++) {
                    if (food.equals(player.getPlayerItems().get(i).getName())) {
                        System.out.println(food);

                        if (player.getItem(food).getHpReg() != 0) {
                            player.regHp(player.getItem(food).getHpReg());
                            System.out.println("your health is now " + player.getHP());
                            isTakeOrDrop = true;
                            goodChoice = true;

                        } else {
                            System.out.println("You cannot eat this");
                            isTakeOrDrop = true;
                            goodChoice = true;


                        }
                    } else if (i == player.getPlayerItems().size() - 1) {
                        System.out.println("Item Does not exist");
                        isTakeOrDrop = true;
                        goodChoice = true;


                    }

                }
                if (player.getPlayerItems().size() == 0) {
                    System.out.println("Item does not exist");
                }
                isTakeOrDrop = true;
                goodChoice = true;

            }


            else if (choice.startsWith("equip ")) {
                String weapon = choice.trim().substring(6);
                for (int i = 0; i < player.getPlayerItems().size(); i++) {
                    if (weapon.equals(player.getPlayerItems().get(i).getName()) && player.isItemEquiped() == false) {
                        player.equipWeapon(player.getItem(weapon));
                        isTakeOrDrop = true;
                        goodChoice = true;

                        break;
                    } else if (i == player.getPlayerItems().size() - 1) {
                        isTakeOrDrop = true;
                        goodChoice = true;

                        System.out.println("Items does not exist");
                    }
                }

                isTakeOrDrop = true;
                goodChoice = true;
                if (player.getPlayerItems().size() == 0) {
                    System.out.println("Item does not exist");
                    isTakeOrDrop = true;
                    goodChoice = true;

                }


            }

            else if(choice.startsWith("unequip")){
                if(player.isItemEquiped() == true){
                    player.unequipWeapon(player.getWeaponEquiped().getName());
                    isTakeOrDrop = true;
                    goodChoice = true;

                }
                else{
                    System.out.println("no weapon equipped");
                    isTakeOrDrop = true;
                    goodChoice = true;

                }

            }


            else if(choice.startsWith("attack")){
                if(player.isItemEquiped() == true){
                    if(player.getWeaponEquiped() instanceof Item_Weapon_Ranged){
                        if(((Item_Weapon_Ranged) player.getWeaponEquiped()).usesLeft() != 0){
                            attack(player, map);
                            isTakeOrDrop = true;
                            goodChoice = true;
                        }
                        else{
                            System.out.println("You have no ammo");
                        }

                    }
                    if(player.getWeaponEquiped() instanceof Item_WeaponMelee){
                    attack(player, map);
                    isTakeOrDrop = true;
                    goodChoice = true;

                }}
            else{
                System.out.println("you have no weapon equipped or no more ammo");}
                isTakeOrDrop = true;
                goodChoice = true;

            }


        String wrongWay = "You cannot go this way";

        if(!isTakeOrDrop){
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
            case "down", "d", "go down" -> {
                if (map.currentRoom.getDown() == null) {
                    System.out.println(wrongWay);
                } else {
                    System.out.println("Going down\n");
                    map.currentRoom = map.currentRoom.getDown();
                    printCurRoomInfo(map);
                    goodChoice = true;
                }
            }
            case "up", "u", "go up" -> {
                if (map.currentRoom.getUp() == null) {
                    System.out.println(wrongWay);
                } else {
                    System.out.println("Going up\n");
                    map.currentRoom = map.currentRoom.getUp();
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
                System.out.println("To go in any direction type that direction (north, south, east, west, up or down). " +
                        "To get a description of where you are, type look.");


            case "quit", "exit" -> {
                keepPlaying = false;
                goodChoice = true;
                System.out.println("Thanks for playing the adventure game");


            }
            case "inventory", "i" ->{
                System.out.println("You are carrying " +player.getPlayerWeight() + " out of 100");
                ArrayList<Item> playerItem =player.getPlayerItems();
                String item;
                for (int i = 0; i< playerItem.size(); i++){
                    item = playerItem.get(i).getName();
                    item = item.substring(0,1).toUpperCase() + item.substring(1);
                    if (playerItem.get(i) instanceof Item_Weapon){
                        System.out.print(item + " " +player.getItemWeight(playerItem.get(i).getName()));
                        System.out.println("- Deals " + playerItem.get(i).getWeaponDamage() + " damage");
                    }
                    else{
                        System.out.println(item + " " +player.getItemWeight(playerItem.get(i).getName()));
                    }
                }
                if(player.isItemEquiped()== true){
                System.out.println("You have "+ player.getWeaponEquiped().getName()+ " equipped");
                    System.out.println("It deals " + player.getWeaponEquiped().getWeaponDamage() + " damage");
              }}

              case "health", "h" ->{
                  System.out.println(player.getHP());
              }




            default -> System.out.println("This does not seem to be possible. Try something else like looking around by typing look or type help if you need it");


        }}


        player.setCurrentRoom(map.currentRoom);
        return goodChoice;
    }

    public static void printCurRoomInfo(Map map){
        System.out.println(map.currentRoom.getName());
        System.out.println(map.currentRoom.getRoomDesc());
        if(map.currentRoom.getAllItems().size() != 0){
        System.out.println("Items in this room:");
        for (int i = 0; i< map.currentRoom.getAllItems().size(); i++){

            System.out.println(map.currentRoom.getAllItemLong().get(i) + " " +map.currentRoom.getItemArrayList().get(i).getWeight());


        }
     }
        if (map.currentRoom.getEnemy() !=null){
            System.out.println("There is an enemy in the room");
            System.out.println(map.currentRoom.getEnemy().getEnemyName());
        }
        else{
            System.out.println("There is no enemy in the room");
        }
    }


    public static void attack(Player player, Map map) {

        if(map.currentRoom.getEnemy()!=null) {
            map.currentRoom.getEnemy().takeDmg(player.getWeaponEquiped().getWeaponDamage());
            System.out.println("You deal " + player.getWeaponEquiped().getWeaponDamage() + " damage to " + map.currentRoom.getEnemy().getEnemyName());
            if(map.currentRoom.getEnemy().getEnemyHealth() > 0){
                System.out.println("The enemy now has " + map.currentRoom.getEnemy().getEnemyHealth() +" HP left");
                player.takeDmg(map.currentRoom.getEnemy().getWeapon().getWeaponDamage());
                System.out.println(map.currentRoom.getEnemy().getEnemyName() + " deals " + map.currentRoom.getEnemy().getWeapon().getWeaponDamage() + " to you");
            }
            else{
                System.out.println("The enemy is dead!");
                if(map.currentRoom.getEnemy().getWeapon() instanceof Item_Weapon_Ranged){
                    map.currentRoom.addWeapon(map.currentRoom.getEnemy().getWeapon());
                }

                map.currentRoom.setEnemy(null);


           if(player.getHP() > 0){
                System.out.println("You now have " + player.getHP() + " HP left");
            }else{
                System.out.println("YOU DIED AHAHAHAHAHAHAHAHAHAHAHAHAHA AND LOST");
                keepPlaying = false;
            }
    } }
        else{
            System.out.println("you hit the air");
            if(player.getWeaponEquiped() instanceof Item_Weapon_Ranged){
                ((Item_Weapon_Ranged) player.getWeaponEquiped()).useAmmo();
                System.out.println( "You have " +  ((Item_Weapon_Ranged) player.getWeaponEquiped()).usesLeft() + " ammo left");
            }
        }

}}




