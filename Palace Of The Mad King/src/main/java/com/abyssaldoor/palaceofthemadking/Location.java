package com.abyssaldoor.palaceofthemadking;
import java.util.*;

public class Location {
    private String description;
    private Map<Command, String> exits = new HashMap<>();
    private Inventory inventory = new Inventory(
            "You don't see that here.",
            "You grab the %s",
            "Which one do you mean?",
            "The %s seems stuck to the ground.");

    Inventory getInventory() { return inventory; }

    Location(String description){
        this.description = description;
    }

    String getDescription() {return description;}

    Map<Command, String> getExits(){return exits;}

    void addExits(Map<Command, String> exits){
        this.exits.putAll(exits);
    }

    //public Set<String> getExits(){return this.exits;}

    boolean canExitTo(Command exit){return exits.containsKey(exit);}

    public String toString(){
        StringBuilder display = new StringBuilder();
        display.append(getDescription());
        if(inventory.size()>0) {
            display.append(" You also see: ");
            display.append(inventory);
        }
        return display.toString();
    }
}
