package seminar2;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;


// В файле содержится строка с данными:
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"}, {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"}, {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Напишите метод, который разберёт её на составные части и, используя StringBuilder создаст массив строк такого вида:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

public class task03 {
    public static void main(String[] args) throws Exception {
        String str =  reader("student.txt");
        String[] arrayData = str.split(" ");

        for(int i = 0; i < arrayData.length; i++) {
            System.out.println(PrintLine(arrayData[i]));
        }
    }


    static String reader(String file) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("student.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str = sb.toString();
        return str;
    }         
        
    
    static StringBuilder PrintLine(String str) {
        String stroka1 = str.replace("{", "");
        String stroka2 = stroka1.replace("}", "");
        String stroka3 = stroka2.replaceAll("\"", "");
        String stroka4 = stroka3.replace("[", "");
        String stroka5 = stroka4.replace("]", "");
        StringBuilder result = new StringBuilder("");
        String [] arrayStrok = stroka5.split(",");
        String [] strName = {"Студент ", " получил ", " по предмету "};
        for (int i =0; i < arrayStrok.length; i++) {
            String[] arrayData = arrayStrok[i].split(":");
            result.append(strName[i]);
            result.append(arrayData[1]);
            }
            return result;
    }
}
    