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
            Pair<Command, String> inputPair = runInput(currentInput);
            Command currentCommand = inputPair.a;
            String remainingArgs = inputPair.b;

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
                case GET: {
                    // playerCharacter.getItemFrom(currentLocation,remainingArgs);
                    currentLocation.getInventory().transferItem(remainingArgs, playerCharacter.getInventory());
                }
                break;

                case DROP:
                    playerCharacter.getInventory().transferItem(remainingArgs, currentLocation.getInventory());
                    break;

                case INVENTORY:
                    System.out.println(playerCharacter.listInventory());
                    break;

                default:
                    System.out.printf("You consider trying to %s, but you just can't bring yourself to do it.%n", currentInput);
            }
        }
    }

    private static Pair<Command, String> runInput(String input) {
        String[] totalArgs = input.split(" ");
        StringBuilder remainingArgs = new StringBuilder();
        for(int i = 1; i<totalArgs.length; i++){
            remainingArgs.append(totalArgs[i]).append(" ");
        }
        String inputKeyword = totalArgs[0].toLowerCase();

        for(Command command: Command.values()){
            if(command.getInputValues().contains(inputKeyword)){
                return Pair.create(command, remainingArgs.toString());
            }
        }

        return Pair.create(Command.OTHER, remainingArgs.toString());
    }
}
