package ro.bogdanpanea.homeworks;

import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FilterListWithStreamTest {

    private String sourceCSVFile = "Fisiere cu date" + File.separator + "Persons.csv";
    private String month = "06";

    @Test
    public void filterList() {

        ReadFromFileToList readFromFileToList = new ReadFromFileToList(sourceCSVFile);
        List<String> readedList = readFromFileToList.readFromCSV();

        FilterListWithStream filterListWithStream = new FilterListWithStream(readedList, month);
        List<String> fiteredList = filterListWithStream.filterList();

        assertEquals(2, fiteredList.size());
    }
}
