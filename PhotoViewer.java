
/**
 * Homework 4 Ray Wang, rcw3tmf 
 * Sources : https://docs.oracle.com/javase/tutorial/uiswing/components/button.html
 * https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html
 * https://docs.oracle.com/javase/7/docs/api/javax/swing/ImageIcon.html
 * https://docs.oracle.com/javase/tutorial/uiswing/events/index.html
 */

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class PhotoViewer extends JFrame {
    /**
     * A PhotographContainer object that contains the image’s and their data
     */
    private PhotographContainer imageLibrary;
    /**
     * A JPanel for the thumb nails
     */     
    public JPanel panel2;
    /**
     * A JPanel for the current image, main image
     */
    public JPanel panel1;
    /**
     * A JPanel for the rating bar
     */
    public JPanel panel3;
    /**
     * A JPanel for the sort by date, caption, and rating radio buttons
     */
    public JPanel panel4;
    /**
     * A JPanel for the next and previous buttons
     */
    public JPanel panel5;
    /**
     * A JPanel for the sort by date, caption, and rating radio buttons and the next and previous buttons, combined into a
     * single panel for the Border Layout
     */
    public JPanel top;
    /**
     * An int to keep track of what image in the array list of photos in imageLibrary we are currently on
     */
    public int current;
    /**
     * An overall JPanel that will hold all of our smaller panels
     */
    public JPanel a = new JPanel(new BorderLayout());

    /**
     * Set imageLibrary to a Photolibrary object
     *
     * @param new PhotoLibrary object that contains the photographs
     */
    public void setImageLibrary(PhotoLibrary p) {
        this.imageLibrary = p;
    }

    /**
     * Get PhotographContainer object that contains the imageLibrary
     *
     * @return PhotographContainer object that contains the photographs
     */
    public PhotographContainer getImageLibrary() {
        return this.imageLibrary;
    }

    /**
     * A generic flow layout for future use
     */
    private FlowLayout layout = new FlowLayout();

    /**
     * Add components to pane
     *
     * @param Container pane to add to
     */
    public void addComponentsToPane(Container pane) {

        // *** PANEL 1 *** current image, main image -------------------------------- \\
        panel1 = new JPanel();
        // add a layout
        panel1.setLayout(layout); // flow layout
        ImageIcon i = new ImageIcon(
                imageLibrary.getPhotos().get(current).getImageData().getScaledInstance(700, 500, Image.SCALE_DEFAULT));
        JLabel picture = new JLabel();
        picture.setIcon(i);
        panel1.add(picture);
        a.add(panel1, BorderLayout.CENTER);

        // *** PANEL 2 *** Thumb nails \\
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(5, 1, 0, 0));

        ImageIcon i0 = new ImageIcon(
                imageLibrary.getPhotos().get(0).getImageData().getScaledInstance(100, 65, Image.SCALE_DEFAULT));
        JLabel picture0 = new JLabel();
        picture0.setIcon(i0);
        picture0.setText("<html>" + picture0.getText() + "Caption: " + imageLibrary.getPhotos().get(0).getCaption()
                + "<br> Rating: " + imageLibrary.getPhotos().get(0).getRating() + "<br> Date Taken: "
                + imageLibrary.getPhotos().get(0).getDateTaken() + "</html>");
        picture0.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
                current = 0; // mouse listeners
                updatec();
                updateR();
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }

        });
        panel2.add(picture0);

        ImageIcon i1 = new ImageIcon(
                imageLibrary.getPhotos().get(1).getImageData().getScaledInstance(100, 65, Image.SCALE_DEFAULT));
        JLabel picture1 = new JLabel();
        picture1.setIcon(i1);
        picture1.setText("<html>" + picture1.getText() + "Caption: " + imageLibrary.getPhotos().get(1).getCaption()
                + "<br> Rating: " + imageLibrary.getPhotos().get(1).getRating() + "<br> Date Taken: "
                + imageLibrary.getPhotos().get(1).getDateTaken() + "</html>");
        picture1.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
                current = 1;
                updatec();
                updateR();
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }

        });
        panel2.add(picture1);

        ImageIcon i2 = new ImageIcon(
                imageLibrary.getPhotos().get(2).getImageData().getScaledInstance(100, 65, Image.SCALE_DEFAULT));
        JLabel picture2 = new JLabel();
        picture2.setIcon(i2);
        picture2.setText("<html>" + picture2.getText() + "Caption: " + imageLibrary.getPhotos().get(2).getCaption()
                + "<br> Rating: " + imageLibrary.getPhotos().get(2).getRating() + "<br> Date Taken: "
                + imageLibrary.getPhotos().get(2).getDateTaken() + "</html>");
        picture2.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
                current = 2;
                updatec();
                updateR();
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }

        });
        panel2.add(picture2);

        ImageIcon i3 = new ImageIcon(
                imageLibrary.getPhotos().get(3).getImageData().getScaledInstance(100, 65, Image.SCALE_DEFAULT));
        JLabel picture3 = new JLabel();
        picture3.setIcon(i3);
        picture3.setText("<html>" + picture3.getText() + "Caption: " + imageLibrary.getPhotos().get(3).getCaption()
                + "<br> Rating: " + imageLibrary.getPhotos().get(3).getRating() + "<br> Date Taken: "
                + imageLibrary.getPhotos().get(3).getDateTaken() + "</html>");
        picture3.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
                current = 3;
                updatec();
                updateR();
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }

        });
        panel2.add(picture3);

        ImageIcon i4 = new ImageIcon(
                imageLibrary.getPhotos().get(4).getImageData().getScaledInstance(100, 65, Image.SCALE_DEFAULT));
        JLabel picture4 = new JLabel();
        picture4.setIcon(i4);
        picture4.setText("<html>" + picture4.getText() + "Caption: " + imageLibrary.getPhotos().get(4).getCaption()
                + "<br> Rating: " + imageLibrary.getPhotos().get(4).getRating() + "<br> Date Taken: "
                + imageLibrary.getPhotos().get(4).getDateTaken() + "</html>");
        picture4.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
                current = 4;
                updatec();
                updateR();
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }

        });
        panel2.add(picture4);

        a.add(panel2, BorderLayout.LINE_START);

        // Panel 3, the rating bar
        panel3 = new JPanel();
        panel3.setLayout(layout); // using a FlowLayout here
        JLabel rating = new JLabel("Rating: ");
        JRadioButton button1 = new JRadioButton("1");
        JRadioButton button2 = new JRadioButton("2");
        JRadioButton button3 = new JRadioButton("3");
        JRadioButton button4 = new JRadioButton("4");
        JRadioButton button5 = new JRadioButton("5");

        // initializing button to be picked based on current rating
        if (imageLibrary.getPhotos().get(current).getRating() == 1) {
            button1 = new JRadioButton("1", true);
        }
        if (imageLibrary.getPhotos().get(current).getRating() == 2) {
            button2 = new JRadioButton("2", true);
        }
        if (imageLibrary.getPhotos().get(current).getRating() == 3) {
            button3 = new JRadioButton("3", true);
        }
        if (imageLibrary.getPhotos().get(current).getRating() == 4) {
            button4 = new JRadioButton("4", true);
        }
        if (imageLibrary.getPhotos().get(current).getRating() == 5) {
            button5 = new JRadioButton("5", true);
        }

        panel3.add(rating);
        panel3.add(button1);
        panel3.add(button2);
        panel3.add(button3);
        panel3.add(button4);
        panel3.add(button5);

        ButtonGroup group = new ButtonGroup();
        group.add(button1);
        group.add(button2);
        group.add(button3);
        group.add(button4);
        group.add(button5);

        a.add(panel3, BorderLayout.PAGE_END);

        button1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                imageLibrary.getPhotos().get(current).setRating(1);
                updatet();
            }
        });
        button2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                imageLibrary.getPhotos().get(current).setRating(2);
                updatet();

            }
        });
        button3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                imageLibrary.getPhotos().get(current).setRating(3);
                updatet();

            }
        });
        button4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                imageLibrary.getPhotos().get(current).setRating(4);
                updatet();
            }
        });
        button5.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                imageLibrary.getPhotos().get(current).setRating(5);
                updatet();
            }

        });

        // panel 4, sort order controls, sort by date, sort by caption, sort by rating
        panel4 = new JPanel();
        JRadioButton date = new JRadioButton("Sort By Date", true);
        JRadioButton caption = new JRadioButton("Sort By Caption");
        JRadioButton srating = new JRadioButton("Sort By Rating");
        panel4.add(date);
        panel4.add(caption);
        panel4.add(srating);

        ButtonGroup group1 = new ButtonGroup();
        group1.add(date);
        group1.add(caption);
        group1.add(srating);

        date.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Collections.sort(getImageLibrary().getPhotos());
                updateCSort();
                updatet();
                updateR();
                current = 0;
            }
        });
        caption.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Collections.sort(getImageLibrary().getPhotos(), new CompareByCaption());
                updateCSort();
                updatet();
                updateR();
                current = 0;
            }
        });
        srating.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Collections.sort(getImageLibrary().getPhotos(), new CompareByRating());
                updateCSort();
                updatet();
                updateR();
                current = 0;
            }
        });

        // panel for previous and next buttons
        panel5 = new JPanel();
        JButton previous = new JButton("Previous");
        JButton next = new JButton("Next");
        panel5.add(previous);
        panel5.add(next);

        // panel for previous and next buttons panel and sort order panel, for ease of use in border layout
        top = new JPanel();
        top.add(panel5);
        top.add(panel4);

        a.add(top, BorderLayout.PAGE_START);

        previous.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                current--; // button action listeners
                if (current < 0) {
                    current = 4;
                }

                updatec();
                updatet();
                updateR();
            }
        });
        next.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                current++;
                if (current > 4) {
                    current = 0;
                }

                updatec();
                updatet();
                updateR();
            }
        });

        pane.add(a); // add overall panel a to pane
    }

    /**
     * Update the rating bar, when initializing selected one
     */
    // update rating bar, when initializing selected one
    public void updateR() {

        panel3.removeAll();

        panel3.setLayout(layout); // using a FlowLayout here
        JLabel rating = new JLabel("Rating: ");
        JRadioButton button1 = new JRadioButton("1");
        JRadioButton button2 = new JRadioButton("2");
        JRadioButton button3 = new JRadioButton("3");
        JRadioButton button4 = new JRadioButton("4");
        JRadioButton button5 = new JRadioButton("5");

        // initializing button to be picked based on current rating
        if (imageLibrary.getPhotos().get(current).getRating() == 1) {
            button1 = new JRadioButton("1", true);
        }
        if (imageLibrary.getPhotos().get(current).getRating() == 2) {
            button2 = new JRadioButton("2", true);
        }
        if (imageLibrary.getPhotos().get(current).getRating() == 3) {
            button3 = new JRadioButton("3", true);
        }
        if (imageLibrary.getPhotos().get(current).getRating() == 4) {
            button4 = new JRadioButton("4", true);
        }
        if (imageLibrary.getPhotos().get(current).getRating() == 5) {
            button5 = new JRadioButton("5", true);
        }

        panel3.add(rating);
        panel3.add(button1);
        panel3.add(button2);
        panel3.add(button3); // adding buttons to the panel
        panel3.add(button4);
        panel3.add(button5);

        ButtonGroup group = new ButtonGroup();
        group.add(button1);
        group.add(button2);
        group.add(button3); // grouping them together
        group.add(button4);
        group.add(button5);

        button1.addActionListener(new ActionListener() { // button action listeners

            public void actionPerformed(ActionEvent e) {
                imageLibrary.getPhotos().get(current).setRating(1);
                updatet();
            }
        });
        button2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                imageLibrary.getPhotos().get(current).setRating(2);
                updatet();

            }
        });
        button3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                imageLibrary.getPhotos().get(current).setRating(3);
                updatet();

            }
        });
        button4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                imageLibrary.getPhotos().get(current).setRating(4);
                updatet();
            }
        });
        button5.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                imageLibrary.getPhotos().get(current).setRating(5);
                updatet();
            }

        });
        revalidate(); // update when not doing it by default
    }

    /**
     * Update current image after choosing a way to sort it Assuming sorting by caption is ascending, sorting by date is
     * ascending, and sorting by rating is descending order, from top to bottom
     */
    // update current image after choosing a way to sort it
    // assuming sorting by caption is ascending, sorting by date is ascending, and sorting by rating is descending order,
    // from top to bottom
    public void updateCSort() {
        // update current image/main image
        panel1.removeAll();
        // add a layout
        panel1.setLayout(layout); // flow layout
        ImageIcon i = new ImageIcon(
                imageLibrary.getPhotos().get(0).getImageData().getScaledInstance(700, 500, Image.SCALE_DEFAULT));
        JLabel picture = new JLabel();
        picture.setIcon(i);
        panel1.add(picture);
        revalidate();

    }

    /**
     * Update current image/main image
     */
    // update current image/main image
    public void updatec() {
        panel1.removeAll();
        // add a layout
        panel1.setLayout(layout); // flow layout
        ImageIcon i = new ImageIcon(
                imageLibrary.getPhotos().get(current).getImageData().getScaledInstance(700, 500, Image.SCALE_DEFAULT));
        JLabel picture = new JLabel();
        picture.setIcon(i);
        panel1.add(picture);
        revalidate();

    }

    /**
     * Update thumb nails method
     */
    // update thumb nails method
    public void updatet() {
        panel2.removeAll();

        ImageIcon i0 = new ImageIcon(
                imageLibrary.getPhotos().get(0).getImageData().getScaledInstance(100, 65, Image.SCALE_DEFAULT));
        JLabel picture0 = new JLabel();
        picture0.setIcon(i0);
        picture0.setText("<html>" + picture0.getText() + "Caption: " + imageLibrary.getPhotos().get(0).getCaption()
                + "<br> Rating: " + imageLibrary.getPhotos().get(0).getRating() + "<br> Date Taken: "
                + imageLibrary.getPhotos().get(0).getDateTaken() + "</html>");
        picture0.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) { // must implement all mouse listener methods
                current = 0;
                updatec();
                updateR();
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }

        });
        panel2.add(picture0);

        ImageIcon i1 = new ImageIcon(
                imageLibrary.getPhotos().get(1).getImageData().getScaledInstance(100, 65, Image.SCALE_DEFAULT));
        JLabel picture1 = new JLabel();
        picture1.setIcon(i1);
        picture1.setText("<html>" + picture1.getText() + "Caption: " + imageLibrary.getPhotos().get(1).getCaption()
                + "<br> Rating: " + imageLibrary.getPhotos().get(1).getRating() + "<br> Date Taken: "
                + imageLibrary.getPhotos().get(1).getDateTaken() + "</html>");
        picture1.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
                current = 1;
                updatec();
                updateR();
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }

        });
        panel2.add(picture1);

        ImageIcon i2 = new ImageIcon(
                imageLibrary.getPhotos().get(2).getImageData().getScaledInstance(100, 65, Image.SCALE_DEFAULT));
        JLabel picture2 = new JLabel();
        picture2.setIcon(i2);
        picture2.setText("<html>" + picture2.getText() + "Caption: " + imageLibrary.getPhotos().get(2).getCaption()
                + "<br> Rating: " + imageLibrary.getPhotos().get(2).getRating() + "<br> Date Taken: "
                + imageLibrary.getPhotos().get(2).getDateTaken() + "</html>");
        picture2.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
                current = 2;
                updatec();
                updateR();
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }

        });
        panel2.add(picture2);

        ImageIcon i3 = new ImageIcon(
                imageLibrary.getPhotos().get(3).getImageData().getScaledInstance(100, 65, Image.SCALE_DEFAULT));
        JLabel picture3 = new JLabel();
        picture3.setIcon(i3);
        picture3.setText("<html>" + picture3.getText() + "Caption: " + imageLibrary.getPhotos().get(3).getCaption()
                + "<br> Rating: " + imageLibrary.getPhotos().get(3).getRating() + "<br> Date Taken: "
                + imageLibrary.getPhotos().get(3).getDateTaken() + "</html>");
        picture3.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
                current = 3;
                updatec();
                updateR();
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }

        });
        panel2.add(picture3);

        ImageIcon i4 = new ImageIcon(
                imageLibrary.getPhotos().get(4).getImageData().getScaledInstance(100, 65, Image.SCALE_DEFAULT));
        JLabel picture4 = new JLabel();
        picture4.setIcon(i4);
        picture4.setText("<html>" + picture4.getText() + "Caption: " + imageLibrary.getPhotos().get(4).getCaption()
                + "<br> Rating: " + imageLibrary.getPhotos().get(4).getRating() + "<br> Date Taken: "
                + imageLibrary.getPhotos().get(4).getDateTaken() + "</html>");
        picture4.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
                current = 4;
                updatec();
                updateR();
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }

        });
        panel2.add(picture4);

        revalidate();

    }

    /**
     * Create and show GUI
     */
    private void createAndShowGUI() {
        // Create and set up the window.

        setTitle("Photograph Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set up the content pane.
        addComponentsToPane(getContentPane());
        // Display the window.
        pack();
        setVisible(true); // Important!!
    }

    /**
     * Main method
     */
    public static void main(String[] args) throws IOException {
        PhotoViewer myViewer = new PhotoViewer();
        // the relative image directory
        String imageDirectory = "images/"; // for Macs / Linux
        Photograph p1 = new Photograph("Chickens on the farm!", imageDirectory + "ChickenGUI.jpg", "2015-06-10", 5);
        p1.loadImageData(imageDirectory + "ChickenGUI.jpg");
        Photograph p2 = new Photograph("Photogenic deer!", imageDirectory + "DeerGUI.jpg", "2015-07-10", 4);
        p2.loadImageData(imageDirectory + "DeerGUI.jpg");
        Photograph p3 = new Photograph("Cute white puppy!", imageDirectory + "DogGUI.jpg", "2015-02-10", 2);
        p3.loadImageData(imageDirectory + "DogGUI.jpg");
        Photograph p4 = new Photograph("Interesting red panda!", imageDirectory + "RedPandaGUI.jpg", "2015-09-10", 1);
        p4.loadImageData(imageDirectory + "RedPandaGUI.jpg");
        Photograph p5 = new Photograph("A stoic zebra!", imageDirectory + "ZebraGUI.jpg", "2015-01-10", 3);
        p5.loadImageData(imageDirectory + "ZebraGUI.jpg");

        myViewer.setImageLibrary(new PhotoLibrary("Photograph Library", 5));
        myViewer.getImageLibrary().addPhoto(p1);
        myViewer.getImageLibrary().addPhoto(p2);
        myViewer.getImageLibrary().addPhoto(p3);
        myViewer.getImageLibrary().addPhoto(p4);
        myViewer.getImageLibrary().addPhoto(p5);

        // use Collections . sort () to sort the photos based on the
        // written compareTo() method
        Collections.sort(myViewer.getImageLibrary().getPhotos());
        // Invoke and start the GUI
        javax.swing.SwingUtilities.invokeLater(() -> myViewer.createAndShowGUI());

    }
}
