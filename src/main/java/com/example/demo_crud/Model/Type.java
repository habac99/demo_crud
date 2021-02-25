package com.example.demo_crud.Model;

public class Type {
    private Integer idType;
    private String name;
    private String description;
    private String image;

    public Type(){

    }
    public Type(Integer idType, String name, String description, String image){
        this.idType = idType;
        this.name = name;
        this.description = description;
        this.image = image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIdType() {
        return this.idType;
    }

    public String getDescription() {
        return this.description;
    }

    public String getImage() {
        return this.image;
    }

    public String getName() {
        return this.name;
    }
}
