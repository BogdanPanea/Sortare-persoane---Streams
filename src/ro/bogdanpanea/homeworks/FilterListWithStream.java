package ro.bogdanpanea.homeworks;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterListWithStream {

    private List<String> sourceList = new ArrayList<>();
    private String month;

    public FilterListWithStream(List<String> sourceList, String month) {
        this.sourceList = sourceList;
        this.month = month;
    }

    public List<String> filterList() {

        List<String> filteredList = sourceList
                .stream()
                //.filter(s -> s.matches("\\d"))
                .filter(s -> s.indexOf("/" + month + "/") > 0)
                .sorted()
                .collect(Collectors.toList());

        for(String s : filteredList) {
            System.out.println(s);
        }
        return filteredList;

    }
}
