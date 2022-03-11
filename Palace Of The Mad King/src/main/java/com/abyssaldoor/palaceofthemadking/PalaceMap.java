package com.abyssaldoor.palaceofthemadking;

import java.util.HashMap;
import java.util.Map;

class PalaceMap {
    private Map<String, Location> locationHashMap = new HashMap<>();
    private Location currentLocation;

    PalaceMap() {
        Location house = new Location("This is a house. To the NORTH you see a yard.");
        Item chair = new Item("bolted chair", "a wooden chair that seems bolted to the floor.", false);
        Item knife = new Item("knife", "a simple iron knife with a wooden handle.");
        Item pocketWatch = new Item("pocket watch", "a fine pocket watch made of etched brass. It ticks resolutely.");
        addLocationToMap("house", house, Map.of(Command.NORTH, "yard"), chair, knife, pocketWatch);

        Location yard = new Location("This is a yard. To the SOUTH you see a house.");
        addLocationToMap("yard", yard, Map.of(Command.SOUTH, "house"));

        currentLocation = house;
    }

    private void addLocationToMap(String mapKey, Location locationToAdd, Map<Command, String> exits, Item... items) {
        locationHashMap.put(mapKey, locationToAdd);
        locationToAdd.addExits(exits);
        locationToAdd.getInventory().addItems(items);
    }

    Location getLocation(String mapKey) {return locationHashMap.get(mapKey);}

    Location exitTo(Command direction){
        if(currentLocation.canExitTo(direction)){
            currentLocation = locationHashMap.get(currentLocation.getExits().get(direction));
            System.out.println(currentLocation);
        }
        else System.out.println("You can't go that way from here.");

        return currentLocation;
    }
}
