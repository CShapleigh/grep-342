/**
 * Created by piper on 10/28/15.
 */
import java.util.ArrayList;

public class Found {
    private String fileName;
    private ArrayList<String> matchingLinesInFile;
    private boolean match;

    public Found(String fileName) {
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
        match = true;
    }

    public boolean hasMatch() {
      return match;
    }
}
