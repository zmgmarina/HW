import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


// 1.В файле содержится строка с исходными данными в такой форме:
// {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
// SELECT * FROM students WHERE 
//   name = "Ivanov" AND country = "Russia" AND city = "Moscow";
// Для разбора строки используйте String.split. Сформируйте новую строку, используя StringBuilder. Значения null не включаются в запрос.


public class seminar2 {
    public static void main(String[] args) {
        String str = reader("file.txt");
        String[] indexValue = parsString(str);
        String name = indexValue[0];
        String country = indexValue[1];
        String city = indexValue[2];

        System.out.println(getSQLString(name,country,city));

    }

    static String reader(String file) {
        StringBuilder sb = new StringBuilder();
    try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
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

    static String[] parsString(String str){
        int index = 0;
        str = str.substring(1, str.length()-1);
        String[] arrayString = str.split(",");
        int length = arrayString.length;
        String[] sqlValue = new String[length];
        for (String el : arrayString){
            int indexx = el.indexOf(':');
            sqlValue[index] = el.substring(indexx+2, el.length()-1);
            index++;
        }
        return sqlValue;
    }

     static String getSQLString(String name, String country, String city){
        StringBuilder result = new StringBuilder();

        result.append("SELECT * FROM students WHERE name = \"" + name + "\" AND country = \"" + country + "\" AND city = \"" + city + "\";");
      
        return result.toString();
    }
}