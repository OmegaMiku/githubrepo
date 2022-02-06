/* Сначала пытался сделать ДЗ сам, но после того, как вы воложили "Разбор ДЗ" и увидев ваш код, понял, что я делал все не правильно.
В итоге, сделал все так же, как вы показывали в "разборе ДЗ". Когда вы объясняете и наглядно показываете, становится +- понятно, что и как делать.
Но как только сталкиваюсь с заданием самостоятельно, то к сожалению, ничего не получается :(
*/

import java.io.File;
import java.util.Arrays;

class HomeWork5 {
    public static void main(String[] args) {

        File file = new File("src/result.csv");
        File file2 = new File("src/test.csv");
        AppData appData = new AppData();
        appData.read(file);
        System.out.println(Arrays.toString(appData.getHeader()));
        System.out.println(Arrays.toString(appData.getData()[0]));
        System.out.println(Arrays.toString(appData.getData()[5]));

        appData.write(file2);

    }
}










