import java.util.ArrayList;
import java.util.Collections;

// 3-dimensional cube
public class Cube{

    ArrayList<Face3D> faces;

    public Cube(double sideLength){
        // Construct the lines of this cube
        faces = new ArrayList<>();
        double d = sideLength/2;
        // Front face
        Face3D ff = new Face3D(new Point3D(d, d, d));
        ff.addPoint(new Point3D(d, -d, d));
        ff.addPoint(new Point3D(-d, -d, d));
        ff.addPoint(new Point3D(-d, d, d));
        faces.add(ff);
        // Left face
        Face3D lf = new Face3D(new Point3D(-d, d, d));
        lf.addPoint(new Point3D(-d, d, -d));
        lf.addPoint(new Point3D(-d, -d, -d));
        lf.addPoint(new Point3D(-d, -d, d));
        faces.add(lf);
        // Bottom face
        Face3D bf = new Face3D(new Point3D(-d, -d, d));
        bf.addPoint(new Point3D(-d, -d, -d));
        bf.addPoint(new Point3D(d, -d, -d));
        bf.addPoint(new Point3D(d, -d, d));
        faces.add(bf);
        // Right face
        Face3D rf = new Face3D(new Point3D(d, d, d));
        rf.addPoint(new Point3D(d, -d, d));
        rf.addPoint(new Point3D(d, -d, -d));
        rf.addPoint(new Point3D(d, d, -d));
        faces.add(rf);
        // Top face
        Face3D tf = new Face3D(new Point3D(d, d, d));
        tf.addPoint(new Point3D(d, d, -d));
        tf.addPoint(new Point3D(-d, d, -d));
        tf.addPoint(new Point3D(-d, d, d));
        faces.add(tf);
        // Back face
        Face3D baf = new Face3D(new Point3D(-d, -d, -d));
        baf.addPoint(new Point3D(d, -d, -d));
        baf.addPoint(new Point3D(d, d, -d));
        baf.addPoint(new Point3D(-d, d, -d));
        faces.add(baf);

    }

    // Rotate about X-axis
    public void rotateX(double theta){
        for(Face3D face : faces){
            face.rotateX(theta);
        }
        Collections.sort(faces);
    }

    // Rotate about Y-axis
    public void rotateY(double theta){
        for(Face3D face : faces){
            face.rotateY(theta);
        }
        Collections.sort(faces);
    }

    public ArrayList<Face3D> getFaces(){return faces;}
}