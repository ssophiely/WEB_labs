// Составить регулярное выражение, определяющее является ли заданная строка IP адресом, записанным в десятичном виде.

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите IP-адреса через запятую и один пробел");
        Scanner in = new Scanner(System.in);
        String IP = in.nextLine();
        boolean check = Pattern.matches("(^[^, ]+(, [^, \\n]+)*$)|(^[^, ]+$)", IP);
        while (!check) {
            System.out.println("Введите IP-адреса через запятую и один пробел");
            IP = in.nextLine();
            check = Pattern.matches("(^[^, ]+(, [^, \\n]+)*$)|(^[^, ]+$)", IP);
        }
        String[] words = IP.split(", ");
        for (int i = 0; i < words.length; i++) {
            Pattern p = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
            Matcher m = p.matcher(words[i]);
            if (!m.matches()) {
                System.out.printf("%s не является IP-адресом. Примеры корректного IP-адреса: " +
                        "127.0.0.1, 255.255.255.0\n", words[i]);
            } else
                System.out.printf("%s - IP-адрес\n", words[i]);
        }
    }
}

