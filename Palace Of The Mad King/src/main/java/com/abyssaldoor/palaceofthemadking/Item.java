package com.abyssaldoor.palaceofthemadking;

public class Item {
    private String description;
    private String name;
    private boolean mobile;



    public Item(){}
    public Item(String name, String description){
        this.name = name;
        this.description = description;
    }

    //need a string to item method.

    public String toString(){
        return description;
    }


    public String getName(){return this.name;}
    public boolean isMobile(){return this.mobile;
    }
}
