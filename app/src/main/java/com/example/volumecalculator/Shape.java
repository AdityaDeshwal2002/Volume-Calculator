package com.example.volumecalculator;

public class Shape {
    private int shapeImg;
    private String shapeHeading;

    public Shape(int shapeImg,String shapeHeading){
        this.shapeImg = shapeImg;
        this.shapeHeading = shapeHeading;
    }

    public int getShapeImg(){
        return shapeImg;
    }

    public String getShapeHeading(){
        return shapeHeading;
    }

    public void setShapeImg(int shapeImg){
        this.shapeImg = shapeImg;
    }

    public void setShapeHeading(String shapeHeading){
        this.shapeHeading = shapeHeading;
    }
}
