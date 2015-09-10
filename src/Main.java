/**
 * Created by oat90 on 9/9/2558.
 */
public class Main {

    public static void main(String args[])
    {

        CSVFileReader csv = new CSVFileReader("D:\\work\\TOC\\dijkstra\\test.csv");
        String[][] table = csv.getFileValue();

        for(int i=0;i<table.length;i++)
        {
            for(int j=0;j<table[i].length;j++)
            {
                System.out.print(table[i][j]);
            }
            System.out.println();
        }
    }
}
