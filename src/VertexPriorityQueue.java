import java.util.PriorityQueue;
import java.util.Comparator;
/**
 * Created by lenovo on 14/9/2558.
 */
public class VertexPriorityQueue extends PriorityQueue<Vertex>{
    public PriorityQueue<Vertex> queue;
    public VertexPriorityQueue()
    {
        Comparator<Vertex> comparator = new VertexWeightComparator();
        queue = new PriorityQueue<Vertex>(20,comparator);
    }

    @Override
    public boolean add(Vertex vertex) {
        if(!queue.contains(vertex)) {
            return super.add(vertex);
        }
        return false;
    }
}

class VertexWeightComparator implements Comparator<Vertex>{

    @Override
    public int compare(Vertex o1, Vertex o2) {
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
