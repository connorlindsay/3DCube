import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Point;
import java.awt.event.*;
import java.awt.Dimension;

// Main window for program
public class RenderFrame extends JFrame{
    
    // Instance constants
    private final int MIN_HEIGTH = 600;
    private final int MIN_WIDTH = 600;
    private final double WIDTH_SCALE = 0.5;
    private final double HEIGHT_SCALE = 0.75;
    private final double START_X_SCALE = 0.25;
    private final double START_Y_SCALE = 0.125;
    private final double THETA = 0.05;

    // Instance variables
    private RenderPanel renderPanel;
    private double width;
    private double height;

    public RenderFrame(){

        // Screen dimensions
        width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        
        // JPanel for rendering shapes
        renderPanel = new RenderPanel(width, height);

        // Default configuration
        setSize(Math.max((int)(width*WIDTH_SCALE), MIN_WIDTH), Math.max((int)(height*HEIGHT_SCALE), MIN_WIDTH));
        setLocation(new Point((int)(width*START_X_SCALE), (int)(height*START_Y_SCALE)));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        add(renderPanel);
        setMinimumSize(new Dimension(MIN_WIDTH, MIN_HEIGTH));

        // Very hacky fix... cube doesn't render properly until rotated
        renderPanel.rotateX(0);
        
        // Resize event
        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                width = getWidth();
                height = getHeight();
                renderPanel.updateDimensions(width, height);
                repaint();
            }
        });

        // Keypress event
        addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e){
                if (e.getKeyCode() == KeyEvent.VK_W){
                    renderPanel.rotateX(THETA);
                }else if (e.getKeyCode() == KeyEvent.VK_S){
                    renderPanel.rotateX(-THETA);
                }else if (e.getKeyCode() == KeyEvent.VK_A){
                    renderPanel.rotateY(-THETA);
                }else if (e.getKeyCode() == KeyEvent.VK_D){
                    renderPanel.rotateY(THETA);
                }
                repaint();
            }
            public void keyReleased(KeyEvent e){}
            public void keyTyped(KeyEvent e){}
        });

    }

}
