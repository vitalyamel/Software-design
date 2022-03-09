package passverification;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите целые числа через пробел." +
                "Если число будет не целое или не числом, тогда оно не будет подсчитано" +
                "в общей сумме и произведении.");

        String numbers = in.nextLine();
        //Делим строку на подстроки через пробелы
        String[] sl = numbers.split(" ");

        int mass[];
        int kol = 0;

        for (int i = 0; i < sl.length; i++) {
            //Исключение на то, число введено или нет
            try {
                Integer.parseInt(sl[i]);
                kol++;
            } catch (Exception e) {
                //Если введено не число, то переходим к следующей иттерации
                continue;
            }
        }

        mass = new int[kol];
        kol = 0;
        for (int i = 0; i < sl.length; i++) {
            //Исключение на то, число введено или нет
            try {
                mass[kol] = Integer.parseInt(sl[i]);
                kol++;
            } catch (Exception e) {
                //Если введено не число, то переходим к следующей иттерации
                continue;
            }
        }
        //Вывод получившихся значений
        System.out.println("Сумма введеных чисел: " + getSumm(mass));
        System.out.println("Произведение введеных чисел: " + getMulti(mass));
    }

    public static int getSumm(int mass[]){

        int summ = 0;
        for (int i = 0; i < mass.length; i++)
            summ += mass[i];
        return summ;
    }

    public static long getMulti(int mass[]){

        long multi = 1;
        for (int i = 0; i < mass.length; i++)
            multi *= mass[i];
        return multi;
    }
    }

