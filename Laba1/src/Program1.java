import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) {
        System.out.println("Ввести с консоли t целых чисел и поместить их в массив. На консоль\n" +
                "вывести дробную часть десятичной дроби р = m/n для первых двух\n" +
                "целых положительных чисел n и m, расположенных подряд.\n");

        System.out.println("Введите количество целых чисел t");
        Scanner in = new Scanner(System.in);
        while (!in.hasNextInt()) {
            System.out.println("Введите целое число");
            in.next();
        }

        int t = in.nextInt();
        int array[] = new int[t];
        System.out.printf("Введите %d целых чисел:\n", t);
        Scanner in1 = new Scanner(System.in);
        for (int i = 0; i < t; i++) {
            while (!in1.hasNextInt()) {
                System.out.println("Разрешён ввод только целых чисел");
                in1.next();
            }
            array[i] = in1.nextInt();
        }

        double p = -1;
        for (int i = 0; i < t - 1; i++) {
            if (array[i] > 0)
                if (array[i + 1] > 0) {
                    p = array[i + 1] / (double) array[i];
                    double frac = p - (int) p;
                    System.out.printf("Дробная часть десятичной дроби %d/%d равна %f", array[i + 1], array[i], frac);
                    break;
                }
        }
        if (p == -1)
            System.out.println("Двух целых положительных чисел, расположенных подряд, не найдено");
    }
}