import java.util.regex.*;
import java.io.*;
public class FileReader extends Thread {
  //Found found;
  String fileName;
  String regexPattern;

  public FileReader(String fileName, String regexPattern) {
    this.fileName = fileName;
    this.regexPattern = regexPattern;
    //found = new Found(fileName);
  }

  public void run() {
    readFile();
  }

  public void readFile() {
    try (BufferedReader br = new BufferedReader(new java.io.FileReader(fileName))) {
      String line;
      while ((line = br.readLine()) != null) {
        matchLine(line);
      }
    } catch (Exception e)  {

    }
  }

  public void matchLine(String line) {
    Pattern pattern = Pattern.compile(regexPattern);
    Matcher matcher = pattern.matcher(line);
    if (matcher.find()) {
      //found.addLine(line);
    }
  }

}
