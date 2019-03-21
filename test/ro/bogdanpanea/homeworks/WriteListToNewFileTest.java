package ro.bogdanpanea.homeworks;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WriteListToNewFileTest {

    private String sourceCSVFile = "Fisiere cu date" + File.separator + "Persons.csv";
    private String targetCSVFile = "Fisiere cu date" + File.separator + "Filtered persons.csv";
    private String month = "06";

    @Test
    public void fileExistTest() {

        File file = new File(targetCSVFile);

        ReadFromFileToList readFromFileToList = new ReadFromFileToList(sourceCSVFile);
        List<String> readedList = readFromFileToList.readFromCSV();

        FilterListWithStream filterListWithStream = new FilterListWithStream(readedList, month);
        List<String> fiteredList = filterListWithStream.filterList();

        WriteListToNewFile writeListToNewFile = new WriteListToNewFile(targetCSVFile, fiteredList);
        writeListToNewFile.writeToFile();

        assertTrue(file.exists());
    }

    @Test
    public void fileNumberOfLines() {

        Path path = Paths.get(targetCSVFile);

        ReadFromFileToList readFromFileToList = new ReadFromFileToList(sourceCSVFile);
        List<String> readedList = readFromFileToList.readFromCSV();

        FilterListWithStream filterListWithStream = new FilterListWithStream(readedList, month);
        List<String> fiteredList = filterListWithStream.filterList();

        WriteListToNewFile writeListToNewFile = new WriteListToNewFile(targetCSVFile, fiteredList);
        writeListToNewFile.writeToFile();

        assertEquals(2, getLineCount(path));
    }

    private long getLineCount(Path path) {
        long lineCount = 0;
        try {
            lineCount = Files.lines(path).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineCount;
    }
}
