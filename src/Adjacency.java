/**
 * Created by oat90 on 9/9/2558.
 */
public class Adjacency {
    private static final int SIZE = 20;
    int[][] table;
    public Adjacency()
    {
        table = new int[SIZE][SIZE];
        for(int i=0;i<SIZE;i++) {
            for(int j=0;j<SIZE;j++) {
                table[i][j] = -1;
            }
        }
    }

    public void setTableValue(int x,int y,int value)
    {
        table[x][y] = value;
    }


}
