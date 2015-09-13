import java.util.PriorityQueue;
import java.util.Comparator;
/**
 * Created by lenovo on 14/9/2558.
 */
public class VertexPriorityQueue extends PriorityQueue<Vertex>{
    static Comparator<Vertex> comparator = new VertexWeightComparator();
    public VertexPriorityQueue()
    {
        super(20,comparator);
    }

    @Override
    public boolean add(Vertex vertex) {
        if(!this.contains(vertex)) {
            return super.add(vertex);
        }
        return false;
    }

    public void updateQueue()
    {
        /*when object change value queue do not auto update so just
        dequeue all then enqueue all*/
        int queueSize = this.size();
        Vertex[] queueTemp = new Vertex[queueSize];
        for(int i=0;i<queueSize;i++)
        {
            queueTemp[i] = this.remove();
        }
        for(int i=0;i<queueSize;i++)
        {
            this.add(queueTemp[i]);
        }
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
