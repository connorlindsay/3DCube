import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.util.ListIterator;
import java.awt.Polygon;

// Panel for actual rendering
public class RenderPanel extends JPanel{
    
    // Instance constants
    private final double WIDTH_SCALE = 0.5;
    private final double HEIGHT_SCALE = 0.5;
    private final double CONVERGENCE_DISTANCE = 1000;

    // Instance varialbes
    private Cube cube;
    private double width;
    private double height;

    public RenderPanel(double w, double h){
        updateDimensions(w, h);
        cube = new Cube(200);
    }

    // Update panel dimensions
    public void updateDimensions(double w, double h){
        width = w;
        height = h;
    }

    // Draw the faces of the cube
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.BLUE);
        ListIterator<Face3D> faces = cube.getFaces().listIterator(cube.getFaces().size() - 1);
        while (faces.hasPrevious()){
            Face3D face = faces.previous();
            Polygon poly = new Polygon();
            for (Point3D point : face.getPoints()){
                poly.addPoint(toX(point), toY(point));
            }
            g2.setColor(Color.CYAN);
            g2.fill(poly);
            g2.setColor(Color.BLUE);
            g2.draw(poly);
        }
    }

    // Convert point to on-screen X-coordinate
    private int toX(Point3D p){
        return (int)((p.getX()*((CONVERGENCE_DISTANCE - p.getZ())/CONVERGENCE_DISTANCE)) + width*WIDTH_SCALE);
    }

    // Convert point to on-screen Y-coordinate
    private int toY(Point3D p){
        return (int)(-(p.getY()*((CONVERGENCE_DISTANCE - p.getZ())/CONVERGENCE_DISTANCE)) + height*HEIGHT_SCALE);
    }

    // Rotate shape about Y-axis
    public void rotateY(double theta){
        cube.rotateY(theta);
    }

    // Rotate shape about X-axis
    public void rotateX(double theta){
        cube.rotateX(theta);
    }

}
