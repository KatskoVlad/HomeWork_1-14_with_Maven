package homeWork.HomeWork12;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TasksStreamMain {
    public static void main(String[] args) {
        // Task1
        StreamTask1 streamTask1 = new StreamTask1();
        try {
            streamTask1.task1();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Task2
        Path randomNumPath = Paths.get("src", "homework", "src/main/homeWork/HomeWork12", "random.txt");
        Path outputPathForSortNum = Paths.get("src", "homework", "src/main/homeWork/HomeWork12", "sorted.txt");
        int amountOfNumbers = 10;
        int boundOfRandomizing = 100;

        StreamTask2.fileWithRandomValues(amountOfNumbers, boundOfRandomizing, randomNumPath);
        StreamTask2.getSortedNum(randomNumPath, outputPathForSortNum);

        // Task3
        StreamTask3 streamTask3 = new StreamTask3();
        streamTask3.task3();


    }
}
