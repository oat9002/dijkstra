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
        for(int i=0;i<table.length-1;i++)
        {
            for(int j=0;j<table[i].length;j++)
            {
                adjacency.setWeight(i,j,Integer.parseInt(table[i+1][j]));
            }
        }

        //prompt for start and end node
        System.out.print("Enter Start node name : ");
        startVertex = sc.next().charAt(0);
        System.out.print("Enter End node name : ");
        endVertex = sc.next().charAt(0);

        //init first vertex
        vertexList[getIndexOfVertexWithName(startVertex)].distance = 0;
        //add first node to queue
        vertexPriorityQueue.add(vertexList[getIndexOfVertexWithName(startVertex)]);

        while(!vertexPriorityQueue.isEmpty())
        {
            //dequeue node
            vertexPriorityQueue.updateQueue();
            currentVertexIndex = getIndexOfVertexWithName(vertexPriorityQueue.remove().name);

            for(int i=0;i<vertexList.length;i++)
            {
                if(adjacency.getWeight(currentVertexIndex,i)!=0&&vertexList[i].known==false)
                {
                    if(vertexList[i].distance==-1)
                    {
                        //distance is infinite >>> change distance to current path distance + path weight
                        vertexList[i].distance = vertexList[currentVertexIndex].distance+adjacency.getWeight(currentVertexIndex,i);
                        vertexList[i].path = vertexList[currentVertexIndex].name;
                    }
                    else if(vertexList[currentVertexIndex].distance+adjacency.getWeight(currentVertexIndex,i)<vertexList[currentVertexIndex].distance)
                    {
                        //new path distance < current path distance >>> change distance
                        vertexList[i].distance = vertexList[currentVertexIndex].distance+adjacency.getWeight(currentVertexIndex,i);
                        vertexList[i].path = vertexList[currentVertexIndex].name;
                    }
                    vertexPriorityQueue.add(vertexList[i]);
                }
            }
            vertexList[currentVertexIndex].known = true;
        }

        //reuse variable for printing shortest path
        currentVertexIndex = getIndexOfVertexWithName(endVertex);
        while(vertexList[currentVertexIndex].path!='-')
        {
            System.out.print(vertexList[currentVertexIndex].name + " < ");
            currentVertexIndex = vertexList[currentVertexIndex].path;
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

    public static int vertexDistanceCompare(Vertex o1,Vertex o2)
    {
        if(o1.distance == o2.distance)
        {
            return 0;
        }
        if(o1.distance == -1)
        {
            //infinite dist.
            return -1;
        }
        if(o2.distance == -1)
        {
            //infinite dist.
            return 1;
        }
        if(o1.distance<o2.distance)
        {
            return -1;
        }
        if(o1.distance>o2.distance)
        {
            return 1;
        }
        return 0;
    }

}
