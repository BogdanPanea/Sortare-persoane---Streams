package ro.bogdanpanea.homeworks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.lang.*;

class FilterListWithStream {

    private List<String> sourceList;
    private String month;
    private String pattern;
    private SimpleDateFormat simpleDateFormat;


    public FilterListWithStream(List<String> sourceList, String month, String pattern) {
        this.sourceList = sourceList;
        this.month = month;
        this.pattern = pattern;
        this.simpleDateFormat = new SimpleDateFormat(pattern);
    }

    public List<String> filterList() {

        return sourceList
                .stream()
                .filter(s -> chechLine(s, ",")) //linie incorecta
                .filter(s -> checkDate( s , month))
                .sorted()
                .collect(Collectors.toList());

    }

    public boolean chechLine(String s, String c) {

        return s.split(c).length == 3;
    }

    public boolean checkDate(String lineToCheck, String month)  {

        Date date = null;
        Calendar cal = null;

        try {
            date = simpleDateFormat.parse(retunrnMontFromLine(lineToCheck).trim());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal = Calendar.getInstance();
        cal.setTime(date);

        System.out.println(cal.get(Calendar.MONTH));

        return Integer.parseInt(month) == cal.get(Calendar.MONTH);
    }

    public String retunrnMontFromLine(String line) {

        String[] month = line.split(",");
        return month[2];
    }
}
