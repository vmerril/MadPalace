package com.abyssaldoor.palaceofthemadking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum Commands {
    EAST(new HashSet<String>(Arrays.asList("e", "east"))),
    SOUTH(new HashSet<String>(Arrays.asList("s", "south"))),
    NORTH(new HashSet<String>(Arrays.asList("n", "north"))),
    WEST(new HashSet<String>(Arrays.asList("w", "west"))),
    STAY(new HashSet<String>(Arrays.asList("stay", "stand"))),
    LOOK(new HashSet<String>(Arrays.asList("look", "examine", "check", "l"))),
    GET(new HashSet<String>(Arrays.asList("get", "grab", "take"))),
    DROP(new HashSet<String>(Arrays.asList("drop", "set", "place", "put"))),
    INVENTORY(new HashSet<String>(Arrays.asList("inventory"))),
    OTHER(new HashSet<String>(Arrays.asList("")));


    private final HashSet<String> inputValues;

    Commands(HashSet<String> inputs){
        this.inputValues = inputs;
    }
    public HashSet<String> getInputValues(){return this.inputValues;}


}
