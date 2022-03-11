package com.abyssaldoor.palaceofthemadking;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Inventory {
    private Set<Item> inventory = new HashSet<>();
    private String missing, single, several, immobile;

    Inventory(String missing, String single, String several, String immobile) {
        this.missing = missing;
        this.single = single;
        this.several = several;
        this.immobile = immobile;
    }

    int size() { return inventory.size(); }

    void removeItems(Item...items) {
        inventory.removeAll(Arrays.asList(items));
    }

    void addItems(Item...items) {
        inventory.addAll(Arrays.asList(items));
    }

    void transferItem(String input, Inventory destInv) {
        Pair<Integer, Item> match = findMatches(input.trim());
        int numMatches = match.a;
        Item grabbedItem = match.b;

        if(numMatches <= 0) {
            System.out.println(missing);
        }
        else if(numMatches > 1){
            System.out.println(several);
        }
        else if(!grabbedItem.isMobile()){
            System.out.println(String.format(immobile, grabbedItem.getName()));
        }
        else {
            System.out.println(String.format(single, grabbedItem.getName()));
            destInv.addItems(grabbedItem);
            removeItems(grabbedItem);
        }
    }

    private Pair<Integer, Item> findMatches(String itemName) {
        Item grabbedItem = null;
        int numMatches = 0;
        for (Item item : inventory) {
            if (item.getName().contains(itemName)) {
                grabbedItem = item;
                numMatches++;
            }
        }
        return Pair.create(numMatches, grabbedItem);
    }

    public String toString(){
        StringBuilder totalInventory = new StringBuilder();
        boolean firstItem = true;
        for(Item item : inventory){
            if(firstItem) firstItem = false;
            else totalInventory.append(",");
            totalInventory.append(" a ");
            totalInventory.append(item.getName());
        }
        return totalInventory.toString();
    }
}
