package painter;

// imports for BufferedImage, Graphics, Color, Random, etc.
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.util.Random;
import java.util.ArrayList;

/**
 * Painter application for drawing things in a dialog
 * Practice: declaring a class with constructor and instance fields and methods
 * declaring and invoking methods with parameters
 * random number generation
 * looping and branching
 * user interaction with JOptionPane
 * @author pffung
 *
 * CSCI1130 Java Assignment 3 Painter
 *
 * Remark: Name your class, variables, methods, etc. properly. 
 * You should write comment for your work and follow good styles.
 *
 * I declare that the assignment here submitted is original except for source
 * material explicitly acknowledged, and that the same or closely related
 * material has not been previously submitted for another course. I also
 * acknowledge that I am aware of University policy and regulations on honesty
 * in academic work, and of the disciplinary guidelines and procedures
 * applicable to breaches of such policy and regulations, as contained in the
 * website.
 *
 * University Guideline on Academic Honesty:
 *     http://www.cuhk.edu.hk/policy/academichonesty
 * Faculty of Engineering Guidelines to Academic Honesty:
 *     https://www.erg.cuhk.edu.hk/erg/AcademicHonesty
 *
 * Student Name: Mitul Mohammad Abdullah Al Mukit
 * Student ID  : 115565211
 * Date        : 20/10/2022
 */
public class Painter {
    
    // ALL static and instance fields are given, DO NOT MODIFY
    
    /* fixed image width for this assignment */
    public static final int IMAGE_WIDTH  = 480;
    /* fixed image height for this assignment */
    public static final int IMAGE_HEIGHT = 320;

    /** we need to draw an image using its Graphics context object, a drawing pen */
    private Graphics pen;
    
    /** an ImageIcon object to display in JOptionPane dialog */
    private ImageIcon icon;
   
    /**
     * Constructor is given, DO NOT MODIFY
     */
    public Painter() {
        /* create a new image of designed dimensions; with AlphaRedGreenBlue colors */
        BufferedImage img = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_ARGB);

        /* create an ImageIcon for display in dialog */
        icon = new ImageIcon(img);

        /* create a pen for drawing, the pen is to be used by paint methods */
        pen = img.createGraphics();
    }

    /**
     * Paint method controlled by user through JOptionPane dialog
     * Students shall finish the rest of this given method
     */
    public void paintByUser()
    {
        Random rand = new Random(); 
        clearCanvas();

        /* given paint example */
//        paintExample();
        /* test patterns at the four corners, DO NOT MODIFY */
//        paintStar(0, 0);
//        paintStar(IMAGE_WIDTH-1, IMAGE_HEIGHT-1);
//        paintRing(0, IMAGE_HEIGHT-1, 3);
//        paintRing(IMAGE_WIDTH-1,  0, 3);
//        
        /* forever loop is given */
        for ( ; ; )
        {
            // given JOptionPane code
            String title   = "Painter";
            String message = "Pick";
            Object[] options = {"Star", "Ring", "Clear"};
            int response;
            response = JOptionPane.showOptionDialog(null, message, title, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, null);
            System.out.println("Response = " + response);

            
            
            // STUDENT WORK HERE
            switch (response) {
                case 0:
                    for (int i = 0; i < 5; i++) {
                        int starCenterX = rand.nextInt(IMAGE_WIDTH-1);
                        int starCenterY = rand.nextInt(IMAGE_HEIGHT-1);
                        paintStar(starCenterX, starCenterY);
                    }
                    break;
                case 1:
                    for (int size = 1; size < 6; size++) {
                        int ringCenterX = rand.nextInt(IMAGE_WIDTH-1);
                        int ringCenterY = rand.nextInt(IMAGE_HEIGHT-1);
                        paintRing(ringCenterX, ringCenterY, size);
                    }
                    break;
                case 2:
                    clearCanvas();
                    break;
                default:
                    System.exit(0);

            }
            
            
        }
    }

    /**
     * Paint example method is given, DO NOT MODIFY
     */
    public void paintExample()
    {
        /* a Graphics pen object can be used to draw a lot of color things */
        pen.setColor(Color.RED);
        pen.fillOval(130, 120, 20, 7); // draw an oval with top-left corner at (130, 120)
        
        pen.setColor(Color.GREEN);
        pen.fillOval(100-1, 50-1, 3, 3); // draw an oval "dot" centered at (100, 50) of size 3 x 3

        // draw an oval (circle) center at (30, 170) of size 20 x 20
        // top-left corner shall be at (30-20/2, 170-20/2), i.e., (20, 160)
        int centerX = 150;
        int centerY = 170;
        pen.setColor(Color.WHITE);
        pen.fillOval(centerX-10, centerY-10, 20, 10);
        pen.setColor(Color.YELLOW);
        pen.fillOval(centerX-5, centerY-15, 10, 20);

    }
    
    
    /**
     * Paint a Star (crossing of two ovals) of dimensions 20 x 20
     * Paint a WHITE oval of size 20 x 7
     * Paint a YELLOW oval of size 7 x 20
     * Adjust location of the ovals properly
     * @param centerX indicates center X-coordinate
     * @param centerY indicates center Y-coordinate
     */
    public void paintStar(int centerX, int centerY)
    {
        // STUDENT WORK HERE
        pen.setColor(Color.WHITE);
        pen.fillOval(centerX-10, centerY-10, 20, 7);
        pen.setColor(Color.YELLOW);
        pen.fillOval(centerX-3, centerY-17, 7, 20);

    }
    
    /**
     * Paint a Ring color pattern of outer dimensions (size * 20, size * 20)
     * Max dimensions: 100 x 100 if size is 5
     * Min dimensions:  20 x  20 if size is 1
     * Fill 10 concentric equidistance ovals (circles) with changing solid colors
     * from outside to inside in sequence R-G-B-R-G-B-R-G-B-R
     * @param centerX indicates center X-coordinate
     * @param centerY indicates center Y-coordinate
     * @param size is an int of value 1, 2, 3, 4 or 5
     */
    
    public void paintRing(int centerX, int centerY, int size)
    {
        // STUDENT WORK HERE
        int j=20;
        for (int i = 0; i <= 9; i++){
        if(i%3==0){
         pen.setColor(Color.RED);
        }
        else if(i%3==1){
        pen.setColor(Color.GREEN);
        }
        else if(i%3==2){
        pen.setColor(Color.BLUE);
        }
        pen.fillOval(centerX+i*size, centerY+i*size, j*size, j*size);
        j-=2;
        }

    }

    /**
     * Clear canvas to BLACK
     * DO NOT MODIFY
     */
    public void clearCanvas()
    {
        pen.setColor(Color.BLACK);
        pen.clearRect(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
    }    
    
    /**
     * main method is given, DO NOT MODIFY
     * @param args is a String array keeping command line arguments 
     */
    public static void main(String[] args) {
        Painter obj;
        
        // construct a new Painter object
        obj = new Painter();
        
        // send message to the new Painter object to kick start actions
        obj.paintByUser();
    }

}