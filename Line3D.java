/* ------------------------------------------- */
/* --------------- DEPRECATED ---------------- */
/* ------------------------------------------- */
// 3-dimensional line
public class Line3D implements Comparable<Line3D>{

    // Start and end points
    private Point3D start;
    private Point3D end;

    public Line3D(Point3D s, Point3D e){
        start = s;
        end = e;
    }

    public Point3D getStart(){return start;}

    public Point3D getEnd(){return end;}

    // Rotate about X-axis
    public void rotateX(double theta){
        start.rotateX(theta);
        end.rotateX(theta);
    }

    // Rotate about Y-axis
    public void rotateY(double theta){
        start.rotateY(theta);
        end.rotateY(theta);
    }

    // Compare function
    public int compareTo(Line3D other){
        Point3D biggest1;
        Point3D biggest2;
        if (start.compareTo(end) > 0) biggest1 = start;
        else biggest1 = end;
        if (other.getStart().compareTo(other.getEnd()) > 0) biggest2 = other.getStart();
        else biggest2 = other.getEnd();
        if (biggest1.compareTo(biggest2) > 0) return 1;
        else if (biggest1.compareTo(biggest2) < 0) return -1;
        else return 0;
    }
    
}