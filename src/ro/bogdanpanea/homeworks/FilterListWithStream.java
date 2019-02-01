package ro.bogdanpanea.homeworks;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.lang.*;

class FilterListWithStream {

    private List<String> sourceList;
    private String month;

    public FilterListWithStream(List<String> sourceList, String month) {
        this.sourceList = sourceList;
        this.month = month;
    }

    public List<String> filterList() {

        return sourceList
                .stream()
                .filter(s -> s.indexOf("/" + month + "/") > 0)
                .filter(s -> chechLine(s, ",")) //linie incorecta
                .sorted()
                .collect(Collectors.toList());

    }

    public boolean chechLine(String s, String c) {

        return s.split(c).length == 3;
    }
}
