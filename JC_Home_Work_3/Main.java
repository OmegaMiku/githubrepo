import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Box box1 = new Box();
        box1.add(new Apple());
        box1.add(new Apple());
        box1.add(new Apple());
        System.out.println("Вес коробки №1: " + box1.getWeight());

        Box box2 = new Box();
        box2.add(new Orange());
        box2.add(new Orange());
        box2.add(new Orange());

        System.out.println("Вес коробки №2: " + box2.getWeight());
        System.out.println("Массы коробок " + (box1.compare(box2) ? "одинаковы" : "различны") + ".");
        System.out.println("В коробке №1 хранятся " + box1.getProduct().get(0).getClass().getSimpleName());

        Box box3 = new Box();
        box3.add(new Apple());
        box3.add(new Apple());
        box3.add(new Apple());
        box3.add(new Apple());
        box3.add(new Apple());

        System.out.println("Вес коробки №3: " + box3.getWeight());
        System.out.println("В коробке №3 хранятся " + box3.getProduct().get(0).getClass().getSimpleName());

        box1.shiftSingleItem(box3);

        System.out.println("Вес коробки №3: " + box3.getWeight());
        System.out.println("Вес коробки №1: " + box1.getWeight());

        try {
            box2.shiftSingleItem(box3);
        } catch (BoxCustomException e) {
            System.out.println(e);
        }
        System.out.println("Вес коробки №3: " + box3.getWeight());
        System.out.println("Вес коробки №2: " + box2.getWeight());

        try {
            box3.add(new Orange());
            box3.add(new Orange());
            box3.add(new Orange());
        } catch (BoxCustomException e) {
            System.out.println(e);
        }
        System.out.println("Вес коробки №3: " + box3.getWeight());

    }

    public static <T> void SwapTwoArrayElements(T[] modifiableArray, int elemNum1, int elemNum2) {
        T backupElement = modifiableArray[elemNum1];
        modifiableArray[elemNum1] = modifiableArray[elemNum2];
        modifiableArray[elemNum2] = backupElement;
    }

    public static <T> void convertArrayToArrayList(ArrayList<T> listArray, T[] convertedArray) {
        for (T element : convertedArray) {
            listArray.add(element);
        }
    }
}