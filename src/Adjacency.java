/**
 * Created by oat90 on 9/9/2558.
 */
public class Adjacency {
    private static final int MAXSIZE = 20;
    private int size = 0;
    private int[][] weightTable;
    public Adjacency(int size)
    {
        weightTable = new int[MAXSIZE][MAXSIZE];
        for(int i=0;i< MAXSIZE;i++) {
            for(int j=0;j< MAXSIZE;j++) {
                weightTable[i][j] = 0;
            }
        }
        this.size = size;
    }

    public void setWeight(int x,int y,int weight)
    {
        weightTable[x][y] = weight;
    }
    public int getSize()
    {
        return size;
    }
    public int getWeight(int x,int y)
    {
        return weightTable[x][y];
    }
}
