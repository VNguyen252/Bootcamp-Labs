package org.example;

public class Cats {

    //properties

    private String furColor;

    private String breed;

    private double size;



    //constructor

    public Cats(String furColor, String breed, double size){
        this.furColor = furColor;
        this.breed = breed;
        this.size = size;
    }



    public String getFurColor(){
        return this.furColor;
    }
    public void setFurColor(String furColor){
        this.furColor = furColor;
    }


    public String getBreed(){
        return this.breed;
    }
    public void setBreed(String breed){
        this.breed = breed;
    }


    public double getSize(){
        return this.size;
    }
    public void setSize(double size){
        this.size = size;
    }

}
