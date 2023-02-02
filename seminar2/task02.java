package seminar2;

// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class task02 {
    private static Random random = new Random();
    public  static void main(String[] args){

        int[] array = getArray(10, 10);
        System.out.printf("Неотсортированный массив: %s\n",  Arrays.toString(array));
        
        addLogSort(array);

        for (int element : array)
        System.out.printf("%d", element);
    }

    static int[] getArray(int size, int n){
        int[] array = new int[size];
        int index = 0;
        while (index < size) {
            array[index] = random.nextInt(n);
            index = index + 1;
        }
        return array;
    }


    static void addLogSort(int[] array){
        try {
            Logger logger = Logger.getLogger(task02.class.getName());
            FileHandler fh = new FileHandler("log.txt");
            logger.addHandler(fh);
            logger.setLevel(Level.INFO);

            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);

            int size =  array.length;
            int d = 0;
            String str = "";
            for (int i = 0; i < size-1; i++) {
                for (int j = i + 1; j < size; j++) {
                    if (array[i] > array[j]) {
                        d = array[i];
                        array[i] = array[j];
                        array[j] = d;
                        str = "Элемент " + d + " перемещен на позицию " + j;
                        logger.info(str);
                    }
                }
                str = "";
            }
            } catch (IOException ex){
                System.out.println(ex.getMessage());
            }
        }


}