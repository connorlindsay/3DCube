
// 3-dimensional point
public class Point3D implements Comparable<Point3D>{
    
    // Directional components
    private double x, y, z;

    public Point3D(double x2, double y2, double z2){
        x = x2;
        y = y2;
        z = z2;
    }

    public double getX(){return x;}

    public double getY(){return y;}

    public double getZ(){return z;}

    // Rotate about Y-axis
    public void rotateY(double theta){
        // Rotation matrix
        double x2 = x*Math.cos(theta) - z*Math.sin(theta);
        double z2 = x*Math.sin(theta) + z*Math.cos(theta);   
        x = x2;
        z = z2;
    }

    // Rotate about X-axis
    public void rotateX(double theta){
        // Rotation matrix
        double y2 = y*Math.cos(theta) - z*Math.sin(theta);
        double z2 = y*Math.sin(theta) + z*Math.cos(theta);   
        y = y2;
        z = z2;
    }

    // NOT IN USE
    // Compare by farthest Z-coord
    public int compareTo(Point3D p){
        if (z > p.getZ()) return 1;
        else if (z < p.getZ()) return -1;
        else return 0;
    }

}
