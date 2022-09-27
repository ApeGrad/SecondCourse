package SecondLessonMassives;

import java.util.Scanner;
import java.util.SplittableRandom;

public class Ant {
    static Scanner scan = new Scanner(System.in);

    static String[][] world = new String[5][5];

    static int verticalX;
    static int horizontalY;
    static String currentDirection;
    static String currentColor;
    static String previousColor;
    static String colorWhite = "W";
    static String colorBlack = "B";
    static String ant = "@";
    static String defaultDirection = "NORTH";
    static String southDirection = "SOUTH";
    static String eastDirection = "EAST";
    static String westDirection = "WEST";

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

    public static String getColorBlack() {
        return colorBlack;
    }

    public static void main(String[] args) {
        System.out.println("Введите индекс с которого хотите начать движение: ");
        printNewField(world);
        boolean userType = true;
        while(userType) {
            verticalX = scan.nextInt();
            horizontalY = scan.nextInt();
            if (verticalX < world.length && verticalX >= 0 && horizontalY < world.length && horizontalY >= 0) {
                currentColor = world[verticalX][horizontalY];
                world[verticalX][horizontalY] = getAnt();
                setAnt(ant);
                setVerticalX(verticalX);
                setHorizontalY(horizontalY);
                printAntWorld(world);
                userType = false;
            } else {
                System.out.println("Неправильный индекс");
            }
        }
        System.out.println("Введите количество шагов: ");
        int steps = scan.nextInt();
        for (int i = 0; i < steps; i++) {
            steps(world);
        }
    }

    public static void printNewField(String[][] array) {
        SplittableRandom random = new SplittableRandom();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (random.nextBoolean() == true) {
                    array[i][j] = getColorWhite();
                } else {
                    array[i][j] = getColorBlack();
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
                }
                System.out.print(array[i][j] + "|");
            }
            System.out.println();
        }
    }

    static void steps(String[][] array) {
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
        try {
            if (currentColor.equals(colorWhite) && currentDirection.equals(defaultDirection)) {
                setCurrentDirection(eastDirection);
                previousColor = currentColor;
                currentColor = array[getVerticalX()][getHorizontalY() + 1];
                array[getVerticalX()][getHorizontalY() + 1] = ant;
                array[getVerticalX()][getHorizontalY()] = reverseColor();
                previousColor = array[getVerticalX()][getHorizontalY()];
                setVerticalX(getVerticalX());
                setHorizontalY(getHorizontalY() + 1);
                return;
            }
            if (currentColor.equals(colorWhite) && currentDirection.equals(westDirection)) {
                setCurrentDirection(defaultDirection);
                previousColor = currentColor;
                currentColor = array[getVerticalX() - 1][getHorizontalY()];
                array[getVerticalX() - 1][getHorizontalY()] = ant;
                array[getVerticalX()][getHorizontalY()] = reverseColor();
                previousColor = array[getVerticalX()][getHorizontalY()];
                setVerticalX(getVerticalX() - 1);
                setHorizontalY(getHorizontalY());
                return;
            }
            if (currentColor.equals(colorWhite) && currentDirection.equals(eastDirection)) {
                setCurrentDirection(southDirection);
                previousColor = currentColor;
                currentColor = array[getVerticalX() + 1][getHorizontalY()];
                array[getVerticalX() + 1][getHorizontalY()] = ant;
                array[getVerticalX()][getHorizontalY()] = reverseColor();
                previousColor = array[getVerticalX()][getHorizontalY()];
                setVerticalX(getVerticalX() + 1);
                setHorizontalY(getHorizontalY());
                return;
            }
            if (currentColor.equals(colorWhite) && currentDirection.equals(southDirection)) {
                setCurrentDirection(westDirection);
                previousColor = currentColor;
                currentColor = array[getVerticalX()][getHorizontalY() - 1];
                array[getVerticalX()][getHorizontalY() - 1] = ant;
                array[getVerticalX()][getHorizontalY()] = reverseColor();
                previousColor = array[getVerticalX()][getHorizontalY()];
                setVerticalX(getVerticalX());
                setHorizontalY(getHorizontalY() - 1);
                return;
            }
            if (currentColor.equals(colorBlack) && currentDirection.equals(defaultDirection)) {
                setCurrentDirection(westDirection);
                previousColor = currentColor;
                currentColor = array[getVerticalX()][getHorizontalY() - 1];
                array[getVerticalX()][getHorizontalY() - 1] = ant;
                array[getVerticalX()][getHorizontalY()] = reverseColor();
                previousColor = array[getVerticalX()][getHorizontalY()];
                setVerticalX(getVerticalX());
                setHorizontalY(getHorizontalY() - 1);
                return;
            }
            if (currentColor.equals(colorBlack) && currentDirection.equals(westDirection)) {
                setCurrentDirection(southDirection);
                previousColor = currentColor;
                currentColor = array[getVerticalX() + 1][getHorizontalY()];
                array[getVerticalX() + 1][getHorizontalY()] = ant;
                array[getVerticalX()][getHorizontalY()] = reverseColor();
                previousColor = array[getVerticalX()][getHorizontalY()];
                setVerticalX(getVerticalX() + 1);
                setHorizontalY(getHorizontalY());
                return;
            }
            if (currentColor.equals(colorBlack) && currentDirection.equals(eastDirection)) {
                setCurrentDirection(defaultDirection);
                previousColor = currentColor;
                currentColor = array[getVerticalX() - 1][getHorizontalY()];
                array[getVerticalX() - 1][getHorizontalY()] = ant;
                array[getVerticalX()][getHorizontalY()] = reverseColor();
                previousColor = array[getVerticalX()][getHorizontalY()];
                setVerticalX(getVerticalX() - 1);
                setHorizontalY(getHorizontalY());
                return;
            }
            if (currentColor.equals(colorBlack) && currentDirection.equals(southDirection)) {
                previousColor = currentColor;
                setCurrentDirection(eastDirection);
                currentColor = array[getVerticalX()][getHorizontalY() + 1];
                array[getVerticalX()][getHorizontalY() + 1] = ant;
                array[getVerticalX()][getHorizontalY()] = reverseColor();
                previousColor = array[getVerticalX()][getHorizontalY()];
                setVerticalX(getVerticalX());
                setHorizontalY(getHorizontalY() + 1);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\nМуравей покинул поле");
            System.exit(0);
        }
    }
    static String reverseColor() {
        if (previousColor.equals(getColorWhite())) {
            return world[verticalX][horizontalY] = getColorBlack();
        } else {
            return world[verticalX][horizontalY] = getColorWhite();
        }
    }
}
