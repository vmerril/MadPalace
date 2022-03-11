package com.abyssaldoor.palaceofthemadking;

class Character {
    private Inventory inventory = new Inventory(
            "You don't have one of those.",
            "You drop the %s.",
            "Which one do you mean?",
            "ERROR: The %s seems stuck to you!?");

    Inventory getInventory() { return inventory; }

    String listInventory(){
        if(inventory.size()>0)
            return "You are currently holding:" + inventory;
        else
            return "You aren't currently holding anything";
    }
}
