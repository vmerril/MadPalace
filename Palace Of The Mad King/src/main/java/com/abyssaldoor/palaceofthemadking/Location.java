package com.abyssaldoor.palaceofthemadking;
import java.util.*;

public class Location {
    private String description;
    private HashSet<Item> itemsPresent = new HashSet<>();
    private Character charactersPresent;
    private HashMap<Commands, String> exits = new HashMap<>();
    public Location(String description){
        this.description = description;
        //this.itemsPresent = itemsPresent;
        //this.charactersPresent = charactersPresent;

    }

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public HashMap<Commands, String> getExits(){return exits; }
    public void addExits(HashMap<Commands, String> exits){
        for(Commands key : exits.keySet()){
            this.exits.put(key, exits.get(key));
        }
    }
    public void addItems(Item... items){

        for(Item item : items){

            itemsPresent.add(item);
        }
    }
    public void removeItems(Item... items){
        for(Item item : items){
            itemsPresent.remove(item);
        }
    }
    public Item grabItem(String input){
        String args = input.trim();
        int numOfMatchingItems=0;
        Item grabbedItem = null;
        for(Item item : itemsPresent){
            if(item.getName().contains(args)){
                grabbedItem = item;
                numOfMatchingItems++;
            }
        }
        if(numOfMatchingItems == 0) {
            System.out.println("You don't see that here.");
            return null;
        }
        else if(numOfMatchingItems == 1){
            System.out.printf("You grab the %s", grabbedItem.getName());
            this.removeItems(grabbedItem);
            return grabbedItem;


        } else
            System.out.println("Which one do you mean?");
        return null;


    }


    //public Set<String> getExits(){return this.exits;}

    public boolean canExitTo(Commands exit){return exits.containsKey(exit);}

    public String toString(){
        StringBuilder display = new StringBuilder();
        display.append(this.description);
        if(itemsPresent.size()>0) display.append(" You also see: ");
        boolean firstItem = true;
        for(Item item : itemsPresent){

            if(firstItem) firstItem = false;
            else display.append(",");
            display.append(" a " + item.getName());
        }
        return display.toString();
    }

}
