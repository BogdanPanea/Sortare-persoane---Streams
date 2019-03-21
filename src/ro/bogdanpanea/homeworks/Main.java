package ro.bogdanpanea.homeworks;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String sourceCSVFile = "Fisiere cu date" + File.separator + "Persons.csv";
        String targetCSVFile = "Fisiere cu date" + File.separator + "Filtered persons.csv";
        String month = "06";
        String pattern = "D/MM/YYYY";

        ReadFromFileToList readFromFileToList = new ReadFromFileToList(sourceCSVFile);
        List<String> readedList = readFromFileToList.readFromCSV();

        FilterListWithStream filterListWithStream = new FilterListWithStream(readedList, month, pattern);
        List<String> fiteredList = filterListWithStream.filterList();

        WriteListToNewFile writeListToNewFile = new WriteListToNewFile(targetCSVFile, fiteredList);
        writeListToNewFile.writeToFile();

    }
}
