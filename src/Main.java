import java.util.Scanner;


/**
 * Created by oat90 on 9/9/2558.
 */
public class Main {

    static CSVFileReader csv = new CSVFileReader("test.csv");
    static String[][] table = csv.getFileValue();
    static Adjacency adjacency;
    static Vertex[] vertexList;
    static VertexPriorityQueue vertexPriorityQueue = new VertexPriorityQueue();
    static Scanner sc = new Scanner(System.in);
    static char startVertex;
    static char endVertex;
    static int currentVertexIndex;

    public static void main(String args[])
    {
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

        //prompt for start and end node
        System.out.print("Enter Start node name : ");
        startVertex = sc.next().charAt(0);
        System.out.print("Enter End node name : ");
        endVertex = sc.next().charAt(0);

        //add first node to queue
        vertexPriorityQueue.queue.add(vertexList[getIndexOfVertexWithName(startVertex)]);
        while(!vertexPriorityQueue.queue.isEmpty())
        {
            //dequeue node
            currentVertexIndex = getIndexOfVertexWithName(vertexPriorityQueue.queue.remove().name);

            for(int i=0;i<vertexList.length;i++)
            {
                if(adjacency.getWeight(currentVertexIndex,i)!=0)
                {
                    //somecode here
                }
            }

        }
    }


    public static int getIndexOfVertexWithName(char name)
    {
        // return -1 if the name do not exist
        for(int i=0;i<vertexList.length;i++)
        {
            if(vertexList[i].name == name)
            {
                return i;
            }
        }
        return -1;
    }
}
