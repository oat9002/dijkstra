/**
 * Created by oat90 on 9/9/2558.
 */

public class Vertex {
    char name;
    int distance;
    boolean known;
    char path;

    public Vertex(char name)
    {
        this.name = name;
        distance = -1;
        known = false;
        path = '-';
    }

    public void setDistance(int dist)
    {
        distance = dist;
    }

    public void setKnown(boolean known)
    {
        this.known = known;
    }

    public void setPath(char path)
    {
        this.path = path;
    }
}
