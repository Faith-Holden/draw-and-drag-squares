# draw-and-drag-squares

My solution for Chapter 7 Exercise 4 of “Introduction to Programming Using Java”.

NOTE: This is a javafx program. It requires the javafx library as a dependency. (See bottom of this README for javafx instructions).

Problem Description:
In Exercise 6.2, you wrote a program DragTwoSquares that allows the user to drag a red
square and a blue square around on a canvas. Write an much improved version where
the user can add squares to a canvas and drag them around. In particular: If the user
shift-clicks or right-clicks the canvas, then the user is trying to drag a square; find the
square that contains the mouse position, if any, and move it as the user drags the mouse.
Other clicks should add squares. You can place the center of the new square at the current
mouse position. To make the picture more visually appealing, give each square a random
color, and when you draw the squares, draw a black outline around each square. (My
program also gives the square a random alpha value between 0.5 and 1.0).
Write a class to represent the data needed for drawing one square, and use an ArrayList
to store the data for all the squares in the picture. If the user drags a square completely
off the canvas, delete it from the list.

Javafx setup instructions:
Download javafx from: https://gluonhq.com/products/javafx/ (I used javafx 12). Save it to a location of your choice.
Unpack the zip folder.
Open my project with your IDE of choice (I use intellij IDEA).
Add the javafx/lib folder as an external library for the project. For intellij, this means going to "project structure" -> "libraries" -> "add library" ->{javafx location}/lib
Add the following as a VM argument for the project: --module-path "{full path to your javafx/lib folder}" --add-modules javafx.controls,javafx.fxml,javafx.base,javafx.graphics,javafx.media,javafx.swing,javafx.web
Build and run the project as normal.
