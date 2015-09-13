/**
 * Created by oat90 on 9/9/2558.
 */
public class Adjacency {
    int[] weight;
    char[] adjVer;
    public Adjacency(int size)
    {
        weight = new int[size];
        adjVer = new char[size];
        for(int i=0;i < size;i++) {
            weight[i] = -1;
            adjVer[i] = ' ';
        }
    }

    public Adjacency(int size,int[] w) {
        weight = new int[size];
        adjVer = new char[size];
        for(int i=0;i < size;i++) {
            weight[i] = w[i];
            adjVer[i] = ' ';
        }
    }

    public void setTableValue(int x,int value,char name)
    {
        weight[x] = value;
        adjVer[x] = name;
    }


}
