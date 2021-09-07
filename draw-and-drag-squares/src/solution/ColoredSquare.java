package solution;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;



public class ColoredSquare {

    ColoredSquare(double xMidpoint, double yMidpoint){
        this.xMidpoint = xMidpoint;
        this.yMidpoint = yMidpoint;
    }

    private double xMidpoint;
    private double yMidpoint;

    private Color squareColor = Color.rgb((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255), Math.random());



    public void drawSquare(GraphicsContext graphicsContext){
        graphicsContext.setFill(squareColor);
        graphicsContext.fillRect(xMidpoint-15,yMidpoint-15, 30,30);
        graphicsContext.setStroke(Color.BLACK);
        graphicsContext.strokeRect(xMidpoint-15,yMidpoint-15, 30,30);
    }


    public void setxMidpoint(double newXMid){
        xMidpoint = newXMid;
    }
    public void setyMidpoint(double newYMid){
        yMidpoint = newYMid;
    }
    public void setMidPoint(double newXMid, double newYMid){
        yMidpoint = newYMid;
        xMidpoint = newXMid;
    }
    public double[] getMidPoint(){
        return new double[]{xMidpoint,yMidpoint};
    }
    public double getMidPointX(){
        return xMidpoint;
    }
    public double getMidPointY(){
        return yMidpoint;
    }

}
