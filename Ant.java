package SecondLessonMassives;

import java.util.Scanner;

public class Ant {
    static Scanner scan = new Scanner(System.in);

    static String[][] world = new String[5][5];

    static int verticalX;
    static int horizontalY;
    static String currentDirection;
    static String currentColor;

    static String colorWhite = "W";
    static String colorBlack = "B";
    static String ant = "@";
    static String defaultDirection = "NORTH";
    static String southDirection = "SOUTH";
    static String eastDirection = "EAST";
    static String westDirection = "WEST";

    public static String getCurrentDirection() {
        return currentDirection;
    }

    public static void setCurrentDirection(String currentDirection) {
        Ant.currentDirection = currentDirection;
    }

    public static String getAnt() {
        return ant;
    }

    public static void setAnt(String ant) {
        Ant.ant = ant;
    }


    public static int getVerticalX() {
        return verticalX;
    }

    public static void setVerticalX(int verticalX) {
        Ant.verticalX = verticalX;
    }

    public static int getHorizontalY() {
        return horizontalY;
    }

    public static void setHorizontalY(int horizontalY) {
        Ant.horizontalY = horizontalY;
    }

    public static String getColorWhite() {
        return colorWhite;
    }

    public static void setColorWhite() {
        Ant.colorWhite = colorWhite;
    }

    public static String getColorBlack() {
        return colorBlack;
    }

    public static void setColorBlack() {
        Ant.colorBlack = colorBlack;

    }


    public static void main(String[] args) {
        System.out.println("¬ведите индекс с которого хотите начать движение: ");
        printNewField(world);
        verticalX = scan.nextInt();
        horizontalY = scan.nextInt();
        if (verticalX < 8 && verticalX > 0 && horizontalY < 8 && horizontalY > 0) {
            currentColor = world[verticalX][horizontalY];
            world[verticalX][horizontalY] = getAnt();
            setAnt(ant);
            setVerticalX(verticalX);
            setHorizontalY(horizontalY);
            printAntWorld(world);
        } else {
            System.out.println("Wrong");
        }
        System.out.println("¬ведите количество шагов: ");
        int steps = scan.nextInt();
        for (int i = 0; i < steps; i++) {
            steps(steps, getVerticalX(), getHorizontalY(), world);


        }
    }


    public static void printNewField(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if ((i + j) % 2 == 0) {
                    array[i][j] = getColorWhite();
                    setColorWhite();
                } else {
                    array[i][j] = getColorBlack();
                    setColorBlack();

                }
                System.out.print(array[i][j] + "|");

            }
            System.out.println();

        }
    }

    static void printAntWorld(String[][] array) {
        System.out.println(currentColor + " is current color");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == getVerticalX() && j == getHorizontalY()) {
                    setCurrentDirection(defaultDirection);
                    array[i][j] = getAnt();
                    setAnt(ant);

                } else if ((i + j) % 2 == 0) {
                    array[i][j] = getColorWhite();
                    setColorWhite();

                } else if ((i + j) % 2 != 0) {
                    array[i][j] = getColorBlack();
                    setColorBlack();

                }

                System.out.print(array[i][j] + "|");
            }
            System.out.println();
        }
    }

    static void steps(int steps, int verticalX, int horizontalY, String[][] array) {
        System.out.println(currentColor + " is current color");
        System.out.println(currentDirection + " is current direction");
        checkDirection(array);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "|");
            }
            System.out.println();
        }

    }


    static void checkDirection(String[][] array) {

        if (currentColor.equals(colorWhite) && currentDirection.equals(defaultDirection)) {
            setCurrentDirection(eastDirection);
            array[getVerticalX()][getHorizontalY() + 1] = ant;
            array[getVerticalX()][getHorizontalY()] = reverseColor();
            currentColor = array[getVerticalX()][getHorizontalY()];
            setVerticalX(getVerticalX());
            setHorizontalY(getHorizontalY() + 1);
            return;
        }
        if (currentColor.equals(colorWhite) && currentDirection.equals(westDirection)) {
            setCurrentDirection(defaultDirection);
            array[getVerticalX() + 1][getHorizontalY()] = ant;
            array[getVerticalX()][getHorizontalY()] = reverseColor();
            currentColor = array[getVerticalX()][getHorizontalY()];
            setVerticalX(getVerticalX() + 1);
            setHorizontalY(getHorizontalY());
            return;
        }
        if (currentColor.equals(colorWhite) && currentDirection.equals(eastDirection)) {
            setCurrentDirection(southDirection);
            array[getVerticalX() + 1][getHorizontalY()] = ant;
            array[getVerticalX()][getHorizontalY()] = reverseColor();
            currentColor = array[getVerticalX()][getHorizontalY()];
            setVerticalX(getVerticalX() + 1);
            setHorizontalY(getHorizontalY());
            return;
        }
        if (currentColor.equals(colorWhite) && currentDirection.equals(southDirection)) {
            setCurrentDirection(westDirection);
            array[getVerticalX()][getHorizontalY() - 1] = ant;
            array[getVerticalX()][getHorizontalY()] = reverseColor();
            currentColor = array[getVerticalX()][getHorizontalY()];
            setVerticalX(getVerticalX());
            setHorizontalY(getHorizontalY() - 1);
            return;
        }
        if (currentColor.equals(colorBlack) && currentDirection.equals(defaultDirection)) {
            setCurrentDirection(eastDirection);
            array[getVerticalX()][getHorizontalY() + 1] = ant;
            array[getVerticalX()][getHorizontalY()] = reverseColor();
            currentColor = array[getVerticalX()][getHorizontalY()];
            setVerticalX(getVerticalX());
            setHorizontalY(getHorizontalY() + 1);
            return;
        }
        if (currentColor.equals(colorBlack) && currentDirection.equals(westDirection)) {
            setCurrentDirection(defaultDirection);
            array[getVerticalX() + 1][getHorizontalY()] = ant;
            array[getVerticalX()][getHorizontalY()] = reverseColor();
            currentColor = array[getVerticalX()][getHorizontalY()];
            setVerticalX(getVerticalX() + 1);
            setHorizontalY(getHorizontalY());

            return;
        }
        if (currentColor.equals(colorBlack) && currentDirection.equals(eastDirection)) {
            setCurrentDirection(southDirection);
            array[getVerticalX() - 1][getHorizontalY()] = ant;
            array[getVerticalX()][getHorizontalY()] = reverseColor();
            currentColor = array[getVerticalX()][getHorizontalY()];
            setVerticalX(getVerticalX() - 1);
            setHorizontalY(getHorizontalY());
            return;
        }
        if (currentColor.equals(colorBlack) && currentDirection.equals(southDirection)) {
            setCurrentDirection(westDirection);
            array[getVerticalX()][getHorizontalY() - 1] = ant;
            array[getVerticalX()][getHorizontalY()] = reverseColor();
            currentColor = array[getVerticalX()][getHorizontalY()];
            setVerticalX(getVerticalX());
            setHorizontalY(getHorizontalY() - 1);
            return;
        }
    }


    static String reverseColor() {
        if (currentColor.equals(getColorWhite())) {
            return world[verticalX][horizontalY] = getColorBlack();
        } else {
            return world[verticalX][horizontalY] = getColorWhite();
        }
    }


}








