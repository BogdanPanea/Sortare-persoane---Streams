package ro.bogdanpanea.homeworks;

import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReadFromFileToListTest {

    private String sourceCSVFile = "Fisiere cu date" + File.separator + "Persons.csv";

    @Test
    public void readFromCSVTest() {

        ReadFromFileToList readFromFileToList = new ReadFromFileToList(sourceCSVFile);
        List<String> readedList = readFromFileToList.readFromCSV();

        assertEquals(6, readedList.size());
    }
}
