/**
 * Created by oat90 on 13/9/2558.
 */
public class Graph {
    Vertex vertex[];
    Adjacency adj[];

    public Graph(int size)
    {
        vertex = new Vertex[size];
        adj = new Adjacency[size];
    }

    public int returnSize()
    {
        return vertex.length;
    }
}
