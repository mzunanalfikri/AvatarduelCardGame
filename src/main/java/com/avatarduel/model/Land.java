package com.avatarduel.model;

public class Land extends Card{
    public Land(String id, String name, String element, String description, String imagePath){
      super(id,name,element,description,imagePath,"Land");
    }

    public Land(Land land){
        super(land.id,land.name,land.element,land.description,land.imagePath,"Land");
    }
}
