
/**
 * Homework 3 
 * Ray Wang, rcw3tmf
 */

import java.util.Comparator;

public class CompareByCaption implements Comparator<Photograph> {

    /*
     * Compare method that will compare the two photographs on captions in alphabetical order, if same then will return
     * comparison by rating in descending order
     * @param two photograph objects to compare
     * @return int value of comparison, based on caption or rating
     */
    public int compare(Photograph p1, Photograph p2) {
        int caption = p1.getCaption().compareTo(p2.getCaption());
        if (caption != 0)
            return caption;
        return p2.getRating() - p1.getRating();
    }

}
