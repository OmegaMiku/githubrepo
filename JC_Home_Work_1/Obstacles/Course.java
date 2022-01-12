package Obstacles;

import java.util.*;
import animals.*;

public class Course {

    Obstacle[] obstacle = new Obstacle[3];
    Random random = new Random();

    public Course() {
        Track track = new Track(random.nextInt(50));
        Wall wall = new Wall(random.nextFloat() * 5);
        Water water = new Water(random.nextInt(50));
        obstacle[0] = (Obstacle) track;
        obstacle[1] = (Obstacle) wall;
        obstacle[2] = (Obstacle) water;
    }

    public void printInformationAboutTheObstacle() {
        System.out.println("Length track: " + ((Track) obstacle[0]).getLength());
        System.out.println("Height wall: " + ((Wall) obstacle[1]).getHeight());
        System.out.println("Length water: " + ((Water) obstacle[2]).getLength());
        System.out.println();
    }

    public void passObstacles(Team team){
        for(Animal animal : team.teamAnimal){
            for(Obstacle l : obstacle){
                if(!l.doIt(animal)){
                    animal.setPassing(l.doIt(animal));
                    break;
                }
                animal.setPassing(true);
            }
        }
    }
}