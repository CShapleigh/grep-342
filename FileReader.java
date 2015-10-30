import java.util.regex.*;
import java.io.*;
public class FileReader {
  Found found;
  String fileName;
  String regexPattern;

  public FileReader(String fileName, String regexPattern) {
    this.fileName = fileName;
    this.regexPattern = regexPattern;
    found = new Found(fileName);
  }

  public void readFile() {
	  BufferedReader br;
		try {
			br = new BufferedReader(new java.io.FileReader(fileName));
			String line;
			while ((line = br.readLine()) != null) {
				matchLine(line);
			}
			br.close();
	    } catch (Exception e)  {
	      System.err.println("Error in readfile");
	    }
  }

  public void matchLine(String line) {
    Pattern pattern = Pattern.compile(regexPattern);
    Matcher matcher = pattern.matcher(line);
    if (matcher.find()) {
      found.addLine(line);
    }
  }

}
