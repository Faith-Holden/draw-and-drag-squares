package solution;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;


public class DrawSquares extends Application {
    Canvas canvas = new Canvas(400,400);
    int selectedBox = -1;
    boolean dragging = false;

    public void start(Stage primaryStage){

        Pane pane = new Pane(canvas);
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);

        ArrayList<ColoredSquare> squareArrayList = new ArrayList<>();


        drawCanvas(squareArrayList);



        canvas.setOnMousePressed(evt -> {
            if(dragging){
                return;
            }
            double evtX = evt.getX();
            double evtY = evt.getY();
            for(int i = 0; i<squareArrayList.size(); i++){
                double sqXMid = squareArrayList.get(i).getMidPointX();
                double sqYMid = squareArrayList.get(i).getMidPointY();
                if(sqXMid-evtX>-15 && sqXMid-evtX<15 && sqYMid-evtY>-15 && sqYMid-evtY<15){
                    selectedBox = i;
                    break;
                }
            }
            if(selectedBox<0){
                squareArrayList.add(new ColoredSquare(evt.getX(), evt.getY()));
                selectedBox = squareArrayList.size()-1;
            }
            drawCanvas(squareArrayList);
        });
        canvas.setOnMouseDragged(evt->{
            if(evt.isShiftDown()||evt.isSecondaryButtonDown()){
                dragging = true;
                squareArrayList.get(selectedBox).setMidPoint(evt.getX(),evt.getY());
                drawCanvas(squareArrayList);
            }
        });
        canvas.setOnMouseReleased(evt->{
            if(squareArrayList.get(selectedBox).getMidPointX()>canvas.getWidth()
                    || squareArrayList.get(selectedBox).getMidPointX()<0
                    || squareArrayList.get(selectedBox).getMidPointY()>canvas.getHeight()
                    || squareArrayList.get(selectedBox).getMidPointY()<0){
                squareArrayList.remove(selectedBox);
            }
            selectedBox = -1;
            dragging = false;
            drawCanvas(squareArrayList);
        });



        primaryStage.show();
    }

    public void drawCanvas(ArrayList<ColoredSquare> squareArrayList){
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillRect(0,0, canvas.getWidth(), canvas.getHeight());
        for(ColoredSquare square : squareArrayList){
            square.drawSquare(canvas.getGraphicsContext2D());
        }
    }


    public static void main (String[] Args){
        launch(Args);
    }
}
