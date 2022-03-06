package com.abyssaldoor.palaceofthemadking;
import java.util.*;

public class Game {
    public static void main(String[] args){
        PalaceMap palaceMap = new PalaceMap();
        Location currentLocation = palaceMap.getLocation("house");
        Character playerCharacter = new Character();
        Scanner input = new Scanner(System.in);

        System.out.println(currentLocation.getDescription());


        while(input.hasNextLine()){
            String currentInput = input.nextLine();
            Map<Command, String> splitInput = runInput(currentInput);
            Command currentCommand = null;
            for(Command command : splitInput.keySet()){
                currentCommand = command;
                break;
            }
            String remainingArgs = splitInput.get(currentCommand);

            switch (currentCommand) {
                case NORTH:
                case SOUTH:
                case EAST:
                case WEST:
                    currentLocation = palaceMap.exitTo(currentCommand);
                    break;
                case STAY:
                    System.out.println("You stand quietly and take in the world around you.");
                    break;
                case LOOK:
                    System.out.println(currentLocation);
                    break;
                case GET:
                    // playerCharacter.getItemFrom(currentLocation,remainingArgs);
                    Item grabbedItem = currentLocation.grabItem(remainingArgs);
                    if (grabbedItem != null) {
                        playerCharacter.addToInventory(grabbedItem);
                    }
                    break;

                case DROP:
                    grabbedItem = playerCharacter.dropItem(remainingArgs);
                    if(grabbedItem != null){
                        currentLocation.addItems(grabbedItem);
                    }
                    break;

                case INVENTORY:
                    System.out.println(playerCharacter.listInventory());
                    break;


                default:
                    System.out.printf("You consider trying to %s, but you just can't bring yourself to do it.%n", currentInput);
            }


        }


    }

    public static HashMap<Command, String> runInput(String input){
        Map<Command, String> returnMap = new HashMap<>();
        String[] totalArgs = input.split(" ");
        StringBuilder remainingArgs = new StringBuilder();
        if(totalArgs.length != 1){
            for(int i = 1; i<totalArgs.length; i++){
                remainingArgs.append(totalArgs[i]).append(" ");
            }
        }
        String inputKeyword = totalArgs[0].toLowerCase();

        Command currentCommand;
        for(Command command: Command.values()){
            if(command.getInputValues().contains(inputKeyword)){
                currentCommand = command;
                return new HashMap<>(Map.of(currentCommand, remainingArgs.toString()));

            }

        }

        currentCommand = Command.OTHER;
        return new HashMap<>(Map.of(currentCommand, remainingArgs.toString()));
    }


}
