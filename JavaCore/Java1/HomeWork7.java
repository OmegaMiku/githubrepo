/**
 * Java 1. Homework 7
 *
 * @author Pavel Ermilov
 * @version 28.12.2021 - 29.12.2021
 */

class HomeWork7 {
    public static void main(String[]args) {
        Plate plate = new Plate(25);
        System.out.println("Food in " + plate);

        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Pushok", 5);
        cats[1] = new Cat("Prohor", 30);
        cats[2] = new Cat("Barsik", 7);

        for (Cat cat: cats) {
            cat.eat(plate);
            System.out.println(cat);
        }

        System.out.println("Left in " + plate);
        plate.increaseFood(29);
        System.out.println("Adding food in " + plate);

        for (Cat cat: cats) {
            cat.setSatiety(false);
            cat.eat(plate);
            System.out.println(cat);
        }
        System.out.println("Left in " + plate);
    }
}

class Plate {
    private int food;

    Plate(int food) {
        this.food = food;
    }

    boolean decreaseFood(int portion) {
        if (food < portion) {
            return false;
        }
        food -= portion;
        return true;
    }

    void increaseFood(int food) {
        this.food += food;
    }

    @Override
    public String toString() {
        return  "plate: " + food;
    }
}

class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        satiety = false;
    }

    void setSatiety(boolean condition) {
        satiety = condition;
    }

    void eat(Plate plate) {
        if (!satiety) {
            satiety = plate.decreaseFood(appetite);
        }
    }
    @Override
    public String toString() {
        return ("name = " + name + ", appetite = " +
            appetite + ", satiety = " + satiety);
    }
}


