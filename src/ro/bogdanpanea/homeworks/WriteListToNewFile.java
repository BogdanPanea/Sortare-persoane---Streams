package ro.bogdanpanea.homeworks;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WriteListToNewFile {

    private String destinationFile;
    private List<String> list;

    public WriteListToNewFile(String destinationFile, List<String> list) {
        this.destinationFile = destinationFile;
        this.list = list;
    }

    public void writeToFile() {

        Path file = Paths.get(destinationFile);

        if (!Files.exists(file, LinkOption.NOFOLLOW_LINKS)) {
            try {
                Files.createFile(Paths.get(destinationFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            Files.write(file, list, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
