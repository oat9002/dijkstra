import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by oat90 on 9/9/2558.
 */


public class CSVFileReader {
    Scanner sc;
        public CSVFileReader(String filePath)
        {
            try {
                sc = new Scanner(new File(filePath));
            } catch (FileNotFoundException e) {
                System.out.println("sc not Found");
            }
        }

    public String[][] getFileValue() {
        String line;
        String[][] table = new String[0][0];
        boolean first = true;
        int index = 0;
        while(sc.hasNext()) {
            line = sc.nextLine();
            if(first) {
                table = new String[line.split(",").length + 1][line.split(",").length];
                first = false;
            }
            table[index] = line.split(",");
            index++;
        }
        return table;
    }
}
