package com.abyssaldoor.palaceofthemadking;
import java.util.HashSet;

public interface Inventory {
    HashSet<Item> inventory = new HashSet<>();
    //Getters and Setters
    default HashSet<Item> getInventory(){return this.inventory;}


    default void removeItem(Item item){
        this.inventory.remove(item);
    }
    default void addItem(Item item){
        this.inventory.add(item);
    }


    //the big method. Needs to reach into other inventory, remove item from the other inventory and add it to this one.
    //Needs to confirm that it's grabbing the right item
    default void getItemFrom(Inventory startingInventory, Item item){
        startingInventory.removeItem(item);
        this.inventory.add(item);

    }
    default void getItemFrom(Inventory startingInventory, String input){
        // once I figure out instanceof, probably make a stringBuilder that generates the output. i.e.:
        // sb = "You %s the %s", verb, name
        input = input.trim();
        int possibleItemCount = 0;
        Item itemToMove = new Item();
        for(Item item : inventory){
            if(item.getName().contains(input)){
                possibleItemCount++;
                itemToMove = item;
            }
        }
        if(possibleItemCount <= 0){
            System.out.printf("You don't see a %s.%n", input);
        } else if(possibleItemCount > 1){
            System.out.printf("Which %s do you mean?%n", input);
        } else if(!itemToMove.isMobile()){
            System.out.printf("You try, but the %s just won't budge.%n");
        } else {
            getItemFrom(startingInventory, itemToMove);
        }


    }

    default void printInventory(){
        boolean isFirst = true;
        for(Item item: inventory){
            if(isFirst) {
                System.out.print(item.getName());
                isFirst = false;
                continue;
            }
            System.out.printf(", %s", item.getName());

        }
    }



}
