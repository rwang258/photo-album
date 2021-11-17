
/**
 * Homework 3 


 * Ray Wang, rcw3tmf 
 * Sources : https://docs.oracle.com/javase/8/docs/api/?java/util/ArrayList.html
 */
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.text.ParseException;

import java.util.HashSet;

import javax.imageio.ImageIO;

public class Photograph implements Comparable<Photograph> {

    /**
     * A BufferedImage object that contains the image’s data
     */
    protected BufferedImage imageData;
    /**
     * A String that holds the date the photo was taken in the format “YYYY-MM-DD”
     */
    private String dateTaken;

    /**
     * An int that holds the value of the rating of the photograph from 0 to 5
     */
    private int rating;

    /**
     * Holds the caption of the photo
     */
    private String caption;

    /**
     * Holds the filename of the photo
     */
    private String filename;

    /**
     * Photograph Constructor, requires a caption and a filename
     */
    public Photograph(String caption, String filename) {
        this.caption = caption;
        this.filename = filename;
        this.dateTaken = "1901-01-01";
        this.rating = 0;
    }

    /**
     * Photograph Constructor, requires a caption, filename, date taken of the photo and rating of the photo, date taken of
     * the photo must be in the format "YYYY-MM-DD”, and rating must be between 0 and 5. If date taken not in that format
     * set to default value of "1901-01-01", and if rating not between 0 and 5, will be set to 0
     */
    public Photograph(String caption, String filename, String dateTaken, int rating) {
        this.caption = caption;
        this.filename = filename;
        if (dateTaken.length() == 10) {
            if (dateTaken.charAt(4) == '-' && dateTaken.charAt(7) == '-') {
                if (Integer.parseInt(dateTaken.substring(0, 4)) >= 1000 && Integer.parseInt(dateTaken.substring(0, 4)) <= 9999) {
                    if (Integer.parseInt(dateTaken.substring(5, 7)) >= 1 && Integer.parseInt(dateTaken.substring(5, 7)) <= 12) {
                        if (Integer.parseInt(dateTaken.substring(8)) >= 1 && Integer.parseInt(dateTaken.substring(8)) <= 31) {
                            this.dateTaken = dateTaken;
                        } else {
                            this.dateTaken = "1901-01-01";
                        }
                    } else {
                        this.dateTaken = "1901-01-01";
                    }
                } else {
                    this.dateTaken = "1901-01-01";
                }
            } else {
                this.dateTaken = "1901-01-01";
            }
        } else {
            this.dateTaken = "1901-01-01";
        }
        if (rating >= 0 && rating <= 5) {
            this.rating = rating;
        } else {
            this.rating = 0;
        }
    }
    /**
     * Loads image data from a given file using the given file name into imageData,
     * and sets the filename
     * returns true on success and false on failure
     * 
     * @param string of the file name to get the image data
     * @return a boolean value of true on success and false on failure
     */
    
    public boolean loadImageData(String filename) throws IOException {
        try {
        imageData = ImageIO.read(new File(filename));
        }
        catch (FileNotFoundException e){
            System.out.println("File not found!");
        }
        this.filename = filename;
        if(imageData != null) {
            return true;
        }
        return false;
    }
    
    /**
     * Get BufferedImage object that contains the image’s data
     *
     * @return BufferedImage object that contains the image’s data
     */
    public BufferedImage getImageData() {
        return this.imageData;
    }
    
    /**
     * Set BufferedImage object that contains the image’s data
     *
     * @param new BufferedImage object that contains the image’s data
     */
    public void setDateTaken(BufferedImage imageData) {
        this.imageData = imageData;
    }
    
    
    /**
     * Compares the date taken of current Photograph object and Photograph p, if current object's date taken is before p's,
     * returns a negative number, if p's is earlier, returns a positive number, if equal, returns the comparison of this
     * object's caption with p's caption
     * 
     * @param object to compare to
     * @return a integer value denoting the current object's comparison to object p
     */
    public int compareTo(Photograph p) {
        String[] begin = this.getDateTaken().split("-", -1); // split it into year, month, and day
        String[] end = p.getDateTaken().split("-", -1);// split it into year, month, and day
        if (Integer.parseInt(begin[0]) < Integer.parseInt(end[0])) {
            return -1; // if current date's year is before p's year, return negative number
        } else if (Integer.parseInt(begin[0]) == Integer.parseInt(end[0])) {// else if it's equal check month
            if (Integer.parseInt(begin[1]) < Integer.parseInt(end[1])) {// if current month less than p's month, return -1
                return -1;
            }
            if (Integer.parseInt(begin[1]) == Integer.parseInt(end[1])) { // if equal, check day
                if (Integer.parseInt(begin[2]) < Integer.parseInt(end[2])) { // if current day less than p's day return -1
                    return -1;
                }
                if (Integer.parseInt(begin[2]) > Integer.parseInt(end[2])) {// if current day is after p's day, return 1
                    return 1;
                }
            }
            if (Integer.parseInt(begin[1]) > Integer.parseInt(end[1])) { // if current month after p's month return 1
                return 1;
            }
        } else if (Integer.parseInt(begin[0]) > Integer.parseInt(end[0])) {// if current year after p's year return 1
            return 1;
        } // if dates are equal, then return the comparison of the photos captions
        return this.getCaption().compareTo(p.getCaption());
    }

    /**
     * Set date taken of the photograph
     *
     * @param the correct date String format
     */
    public void setDateTaken(String dateTaken) {
        this.dateTaken = dateTaken;
    }

    /**
     * Set rating of the photograph
     *
     * @param the rating between 0 and 5
     */
    public void setRating(int rating) {
        if (rating >= 0 && rating <= 5) {
            this.rating = rating;
        } else {
            this.rating = 0;
        }
    }

    /**
     * Set caption of the photograph
     *
     * @param the String of the caption
     */
    public void setCaption(String caption) {
        this.caption = caption;
    }

    /**
     * Get hash code of photograph, based on hash code of the file name.
     *
     * @return the hash code of the photograph object
     */
    public int hashCode() {
        return this.filename.hashCode();
    }

    /**
     * Get date taken of the photograph
     *
     * @return returns the string format of the date taken
     */
    public String getDateTaken() {
        return this.dateTaken;
    }

    /**
     * Get rating of the photograph
     *
     * @return returns the rating of the photograph
     */
    public int getRating() {
        return this.rating;
    }

    /**
     * Get caption of the photograph
     *
     * @return returns the caption
     */
    public String getCaption() {
        return this.caption;
    }

    /**
     * Get filename of the photograph
     *
     * @return returns the filename
     */
    public String getFilename() {
        return this.filename;
    }

    /**
     * Can determine if two objects are equal or not, if their caption and filename are equal or not
     * 
     * @param an Object to compare to
     * @return returns true, if they are equal or false, if they aren't
     */
    public boolean equals(Object o) {
        if (o != null && o instanceof Photograph) {
            Photograph otherPhotograph = (Photograph) o;
            // if o is not null and is an instance of Photograph, continue
            if (this.caption.equals(otherPhotograph.getCaption()) && this.filename.equals(otherPhotograph.getFilename())) {
                return true;        // if both caption AND filename are the same, return true, yes they are equal
            }
        }

        return false; // return false if not true
    }

    /**
     * Get a string representation of a Photograph object
     *
     * @return returns the caption and filename formatted together
     */
    public String toString() {
        return "Caption: " + caption + " Filename: " + filename;
    }

    public static void main(String[] args) {
        Photograph p = new Photograph("Fun!", "Carter's Mountain");// create a photograph object
        Photograph q = new Photograph("Fun!", "Carter's Mountain");// create a photograph object
        Photograph w = new Photograph("Cool!", "Arcade");// new photograph object
        System.out.println(p.equals(q) + " - should be true."); // p has same caption and filename as q
        System.out.println(p.equals(w) + " - should be false."); // not same caption or filename
        System.out.println(p.toString() + " - should print Caption: Fun! Filename: Carter's Mountain"); // format should be same
        System.out.println(w.toString() + " - should print Caption: Cool! Filename: Arcade"); // format should be same
    }
}
