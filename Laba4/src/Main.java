// Напишите функцию проверки вхождения списка L1 в список L2. Результат сохранить в файл.
// Создать итератор для коллекции.

import java.util.*;
import java.util.regex.Pattern;

public class Main{
    public static void main(String[] args) {

        System.out.println("Введите 1-й список через запятую и пробел: ");
        Scanner in1 = new Scanner(System.in);
        String l1 = in1.nextLine();
        boolean check = Pattern.matches("^[^, ]+(, [^, \\n]+)*$", l1);
        while (!check){
            System.out.println("Введите элементы списка через одну запятую и один пробел");
            l1 = in1.nextLine();
            check = Pattern.matches("^[^, ]+(, [^, \\n]+)*$", l1);
        }

        System.out.println("Введите 2-й список через запятую и пробел: ");
        Scanner in2 = new Scanner(System.in);
        String l2 = in2.nextLine();
        check = Pattern.matches("^[^, ]+(, [^, \\n]+)*$", l2);
        while (!check){
            System.out.println("Введите элементы списка через одну запятую и один пробел");
            l2 = in2.nextLine();
            check = Pattern.matches("^[^, ]+(, [^, \\n]+)*$", l2);
        }

        Pattern p = Pattern.compile(", ");
        String[] list1 = p.split(l1);
        String[] list2 = p.split(l2);

        Data d= new Data(list1,list2);
        if(d.is_in_list()){
            System.out.println("L1 входит в L2");
        }
        else {
            System.out.println("L1 не входит в L2");
        }
    }
}
