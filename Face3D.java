import java.util.ArrayList;

// A 3-dimensional face... like the side of a cube
public class Face3D implements Comparable<Face3D>{
    
    ArrayList<Point3D> points;

    public Face3D(Point3D point){
        points = new ArrayList<>();
        points.add(point);
    }

    public void addPoint(Point3D point){
        points.add(point);
    }

    public ArrayList<Point3D> getPoints(){return points;}

    // Compare by which face has the furthest center
    public int compareTo(Face3D other){
        double thisNum = (points.get(0).getZ() + points.get(1).getZ() + points.get(2).getZ() + points.get(3).getZ())/4;
        double otherNum = (other.points.get(0).getZ() + other.points.get(1).getZ() + other.points.get(2).getZ() + other.points.get(3).getZ())/4;
        if (thisNum > otherNum) return 1;
        else if (otherNum > thisNum) return -1;
        else return 0;
    }

    // Rotate about X-axis
    public void rotateX(double theta){
        for(Point3D point : points){
            point.rotateX(theta);
        }
    }

    // Rotate about Y-axis
    public void rotateY(double theta){
        for(Point3D point : points){
            point.rotateY(theta);
        }
    }

}