package com.abyssaldoor.palaceofthemadking;

public class Item {
    private String description;
    private String name;

    public Item(){}
    public Item(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String toString(){
        return description;
    }


    public String getName(){return this.name;}
}
