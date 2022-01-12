class HomeWork6 {
    public static void main(String[] args) {
        //IAnimal cat = new Cat(200);
        //IAnimal dog = new Dog(500,10);
        
        IAnimal[] animals = {new Cat(200), new Dog(500,10)};
            for (IAnimal animal : animals) {
                System.out.println(animal.run(100));
                System.out.println(animal.run(550));
                System.out.println(animal.swim(5));
                System.out.println(animal.swim(15));
        }
    }
}

class Cat extends Animal {
    Cat(int runLength, int swimLength) {
        super(runLength, swimLength);
    }
    
    Cat(int runLength) {
        super(runLength, -1);
    }
    
    @Override
    public String swim(int distance) {
        return getClassName() + " can't swim!";
    }
}

class Dog extends Animal {
    Dog(int runLength, int swimLength) {
        super(runLength, swimLength);
    }
}

interface IAnimal {
    String run(int distance);
    String swim(int distance);
    
}

abstract class Animal implements IAnimal{
    protected int runLength;
    protected int swimLength;
    protected String className;
    
    Animal (int runLength, int swimLength) {
        this.runLength = runLength;
        this.swimLength = swimLength;
        className = getClass().getSimpleName();
    }
    
    public String getClassName() {
        return className;
    }
    
    @Override
    public String run(int distance) {
        if(distance > runLength) {
            return className + " couldn't run " + distance;
        } else {
            return className + " successfully run " + distance;
        }
    }
    
    @Override
    public String swim(int distance) {
        if(distance > swimLength) {
            return className + " couldn't swim " + distance;
        } else {
            return className + " successfully swim " + distance;
        }
    }
}