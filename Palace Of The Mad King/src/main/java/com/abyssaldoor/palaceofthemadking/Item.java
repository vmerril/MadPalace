package com.abyssaldoor.palaceofthemadking;

public class Item {
    private String description;
    private String name;
    private boolean mobile;

    Item(String name, String description, boolean mobile){
        this.name = name;
        this.description = description;
        this.mobile = mobile;
    }
    Item(String name, String description) {
        this(name, description, true);
    }

    //need a string to item method.

    public String toString(){
        return description;
    }
    String getName(){return this.name;}
    boolean isMobile(){return this.mobile;}
}
