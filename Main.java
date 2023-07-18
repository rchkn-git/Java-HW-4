package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type show whitespaces,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        ArrayList<String> secondName = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> surname = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Boolean> gender = new ArrayList<>();
        ArrayList<Integer> id = new ArrayList<>();
        String tmp;
        String spacebar = " ";
        String point = ".";
        while (true) {
            while (true) {
                System.out.println("Введите фамилию -> ");
                secondName.add(scanner.nextLine());
                System.out.println("Введите имя -> ");
                name.add(scanner.nextLine());
                System.out.println("Введите отчество -> ");
                surname.add(scanner.nextLine());
                System.out.println("Введите возраст -> ");
                age.add(Integer.valueOf(scanner.nextLine()));
                System.out.println("Введите пол -> ");
                gender.add(scanner.nextLine().toLowerCase().contains("ж"));
                id.add(secondName.size() - 1);
                System.out.println("Вы хотите продолжить?");
                tmp = scanner.nextLine();
                if (tmp.toLowerCase().contains("не")) {
                    break;
                }
            }

            for (int i = 0; i < secondName.size(); i++) {
                System.out.println(secondName.get(i) + spacebar
                        + name.get(i).toUpperCase().charAt(0)
                        + point + surname.get(i).toUpperCase().charAt(0) + point + spacebar
                        + age.get(i) + spacebar + (gender.get(i) ? "Ж" : "М"));
            }

            System.out.println("Сортировать по возрасту? Да/Нет -> ");
            tmp = scanner.nextLine();
            if (tmp.toLowerCase().contains("да")) {
                id.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return age.get(o1) - age.get(o2);
                    }
                });
                for (int i = 0; i < secondName.size(); i++) {
                    System.out.println(secondName.get(id.get(i)) + spacebar
                            + name.get(id.get(i)).toUpperCase().charAt(0)
                            + point + surname.get(id.get(i)).toUpperCase().charAt(0) + point + spacebar
                            + age.get(id.get(i)) + spacebar + (gender.get(id.get(i)) ? "Ж" : "М"));
                }
//                break;

            }
            break;
        }
    }
}