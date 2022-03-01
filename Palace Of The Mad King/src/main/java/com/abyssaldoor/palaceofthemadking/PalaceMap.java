package com.abyssaldoor.palaceofthemadking;

import java.util.Collections;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;

public class PalaceMap {
    private HashMap<String, Location> locationHashMap = new HashMap<>();
    private Location currentLocation;
    private Location house;
    private Location yard;
    PalaceMap(){
        Location addLocation;
        house = new Location("This is a house. To the NORTH you see a yard.");
        Item knife = new Item("knife", "a simple iron knife with a wooden handle.");
        Item pocketWatch = new Item("pocket watch", "a fine pocket watch made of etched brass. It ticks resolutely.");
        addLocationToMap("house", house, new HashMap<>(Map.of(Commands.NORTH, "yard")), knife, pocketWatch);

        yard = new Location("This is a yard. To the SOUTH you see a house.");
        addLocationToMap("yard", yard, new HashMap<>(Map.of(Commands.SOUTH, "house")));


        currentLocation = house;
    }
    private void addLocationToMap(String mapKey, Location locationToAdd, HashMap<Commands, String> exits, Item... items){

        locationHashMap.put(mapKey, locationToAdd);
        locationToAdd.addExits(exits);
        locationToAdd.addItems(items);

    }
    public Location getLocation(String mapKey){return locationHashMap.get(mapKey);}

    public Location exitTo(Commands direction){
        if(currentLocation.canExitTo(direction)){
            currentLocation = locationHashMap.get(currentLocation.getExits().get(direction));
            System.out.println(currentLocation);

        }
        else System.out.println("You can't go that way from here.");
        return currentLocation;
    }
}
