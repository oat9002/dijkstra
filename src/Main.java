import java.util.ArrayList;
import java.util.Scanner;


/**
 * Created by oat90 on 9/9/2558.
 */
public class Main {

    public static void main(String args[])
    {
        CSVFileReader csv = new CSVFileReader("test.csv");
        String[][] table = csv.getFileValue();
        Adjacency adjacency;
        Vertex[] vertexList;
        Scanner sc = new Scanner(System.in);
        char startVertex;
        char endVertex;


        //print array
        for(int i=0;i<table.length;i++)
        {
            for(int j=0;j<table[i].length;j++)
            {
                System.out.print(table[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        vertexList = new Vertex[table.length];
        adjacency = new Adjacency(table.length);

        //init vertex
        for(int i=0;i<table[0].length;i++)
        {
            vertexList[i] = new Vertex(table[0][i].charAt(0));
        }

        //init adjacency
        for(int i=1;i<table.length;i++)
        {
            for(int j=0;j<table[i].length;j++)
            {
                adjacency.setWeight(i,j,Integer.parseInt(table[i][j]));
            }
        }

        System.out.print("Enter Start node name : ");
        startVertex = sc.next().charAt(0);
        System.out.print("Enter End node name : ");
        endVertex = sc.next().charAt(0);
    }
}
