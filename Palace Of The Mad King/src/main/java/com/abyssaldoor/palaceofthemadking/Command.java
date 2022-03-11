package com.abyssaldoor.palaceofthemadking;

import java.util.Collections;
import java.util.Set;

public enum Command {
    EAST(Set.of("e", "east")),
    SOUTH(Set.of("s", "south")),
    NORTH(Set.of("n", "north")),
    WEST(Set.of("w", "west")),
    STAY(Set.of("stay", "stand")),
    LOOK(Set.of("look", "examine", "check", "l")),
    GET(Set.of("get", "grab", "take")),
    DROP(Set.of("drop", "set", "place", "put")),
    INVENTORY(Collections.singleton("inventory")),
    GO(Set.of("go", "goto")),
    OTHER(Collections.emptySet());

    private final Set<String> inputValues;

    Command(Set<String> inputs){this.inputValues = inputs;}
    public Set<String> getInputValues(){return this.inputValues;}
}
