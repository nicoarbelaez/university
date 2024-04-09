package util;

import java.io.*;
import java.util.*;

public class FileHandler {
    private final String directoryPath;

    public FileHandler(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public boolean fileExists(String fileName) {
        File file = new File(directoryPath + fileName);
        return file.exists();
    }

    public List<Integer[]> readFromFile(String fileName) throws IOException {
        File file = new File(directoryPath + fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<Integer[]> numbers = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            Integer[] number = Arrays.stream(line.split(","))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
            numbers.add(number);
        }
        br.close();
        return numbers;
    }

    public void writeToFile(String fileName, List<Integer[]> numbers) throws IOException {
        File file = new File(directoryPath + fileName);
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for (Integer[] number : numbers) {
            bw.write(Arrays.toString(number)
                    .replace("[", "")
                    .replace("]", "")
                    .replace(" ", ""));
            bw.newLine();
        }
        bw.close();
    }
}
