package homeWork.HomeWork12;

/* 3. Прочитать строки из файла и поменять местами
      первое и последнее слова в каждой строк. */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class StreamTask3 {
    private static String srcText = null;
    private static String str = null;
    private static String symbols = ":;";
    private static StringTokenizer strToken = null;
    private static ArrayList<String> textArrList = new ArrayList(10);
    private static ArrayList<String> sentence = new ArrayList(15);

    public void task3() {

        File file = new File("D:\\katsko.dev\\src\\homework\\HomeWork12\\TextTask3.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            while (bufferedReader.ready()) {
                srcText = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        strToken = new StringTokenizer(srcText, symbols);

        while (strToken.hasMoreTokens()) {
            str = strToken.nextToken();
            textArrList.add(str);
        }

        for (String s : textArrList) {
            System.out.println(s);
        }
        System.out.print('\n');

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            while (bufferedReader.ready()) {
                srcText = bufferedReader.readLine();
            }
            replaceWords();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static void replaceWords() {
        for (String s : textArrList) {
            strToken = new StringTokenizer(s, ",:;");
            while (strToken.hasMoreTokens()) {
                str = strToken.nextToken();
                sentence.add(str);
            }
            String tempStr = sentence.get(0);
            int LastElementIndex = sentence.size() - 1;
            String lastWord = sentence.get(LastElementIndex);
            sentence.set(0, lastWord);
            sentence.set(LastElementIndex, tempStr);
            for (String str : sentence) {
                System.out.print(str.concat(" "));
            }
            System.out.print('\n');
        }
    }
}
