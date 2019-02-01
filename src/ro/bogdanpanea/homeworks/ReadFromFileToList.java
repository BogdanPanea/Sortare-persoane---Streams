package ro.bogdanpanea.homeworks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ReadFromFileToList {

    private String file;

    ReadFromFileToList(String file) {
        this.file = file;
    }

    List<String> readFromCSV() {

        List<String> list = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(file))) {

            list = stream
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
