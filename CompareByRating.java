
/**
 * Homework 3 
 * Ray Wang, rcw3tmf
 */

import java.util.Comparator;

public class CompareByRating implements Comparator<Photograph> {

    /*
     * Compare method that will compare the two photographs by rating in descending order, if same then will return
     * comparison by caption comparison in alphabetical order
     * @param two photograph objects to compare
     * @return int value of comparison, based on rating or caption
     */
    public int compare(Photograph p1, Photograph p2) {
        int retVal = p2.getRating() - p1.getRating();
        if (retVal != 0)
            return retVal;
        return p1.getCaption().compareTo(p2.getCaption());
    }
}
