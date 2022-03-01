package com.abyssaldoor.palaceofthemadking;

import java.util.HashSet;

public class Character {
    private HashSet<Item> inventory = new HashSet<>();

    public HashSet<Item> getInventory() {
        return inventory;
    }

    public void addToInventory(Item itemToAdd){
        inventory.add(itemToAdd);

    }
    public Item dropItem(String input){
        String args = input.trim();
        int numOfMatchingItems=0;
        Item grabbedItem = null;
        for(Item item : inventory){
            if(item.getName().contains(args)){
                grabbedItem = item;
                numOfMatchingItems++;
            }
        }
        if(numOfMatchingItems == 0) {
            System.out.println("You don't have one of those.");
            return null;
        }
        else if(numOfMatchingItems == 1){
            System.out.printf("You drop the %s.", grabbedItem.getName());
            this.removeItems(grabbedItem);
            return grabbedItem;


        } else
            System.out.println("Which one do you mean?");
        return null;

    }
    public String listInventory(){
        StringBuilder totalInventory = new StringBuilder();
        if(inventory.size()>0) totalInventory.append("You are currently holding:");
        else return "You aren't currently holding anything";
        boolean firstItem = true;
        for(Item item : inventory){

            if(firstItem) firstItem = false;
            else totalInventory.append(",");
            totalInventory.append(" a " + item.getName());
        }
        return totalInventory.toString();
    }
    public void removeItems(Item... items){
        for(Item item : items){
            inventory.remove(item);
        }
    }
}
