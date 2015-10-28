/**
 * Created by piper on 10/28/15.
 */
import java.util.ArrayList;

public class Found {
    private String fileName;
    private ArrayList<String> matchingLinesInFile;

    public Found(String fileName) {
        // TODO: implement
        this.fileName = fileName;
        this.matchingLinesInFile = new ArrayList<>();
    }

    public String getFileName() {
        return fileName;
    }

    public ArrayList<String> getMatchingLinesInFile() {
        return matchingLinesInFile;
    }


    public void addLine(String line) {
        matchingLinesInFile.add(line);
    }
}
