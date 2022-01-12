package Obstacles;

import animals.*;

public class Water implements Obstacle {
    private int length;

    public Water(int length) {
        this.length = length;
    }
    @Override
    public boolean doIt(Animal animal) {
        if (animal instanceof Swimable)
            return ((Swimable) animal).swim(length);
        else
            return false;
    }
    public int getLength(){
        return length;
    }
}
