
/**
 * Homework 3 
 * Ray Wang, rcw3tmf
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class HW3Tests {

    /**
     * Test the true case of the removePhoto method Because a photograph was successfully removed from the photo library
     * should return true
     */
    @Test
    public void testTrueRemovePhoto() {
        PhotoLibrary p = new PhotoLibrary("Library", 1);
        p.addPhoto(new Photograph("Hi!", "Day 1", "1995-10-29", 4));
        assertEquals("removePhoto with argument (new Photograph(Hi!, Day 1, 1995-10-29, 4)) failed", true,
                p.removePhoto(new Photograph("Hi!", "Day 1", "1995-10-29", 4)));

    }

    /**
     * Test the false case of the removePhoto method Because a photograph was not successfully removed from the photo
     * library should return false
     */
    @Test
    public void testFalseRemovePhoto() {
        PhotoLibrary p = new PhotoLibrary("Library", 1);
        p.addPhoto(new Photograph("Hi!", "Day 1", "1995-10-29", 4));
        assertEquals("removePhoto with argument (new Photograph(Bye!, Day 2, 1995-10-30, 4)) failed", false,
                p.removePhoto(new Photograph("Bye!", "Day 2", "1995-10-30", 4)));

    }

    /**
     * Test the negative number case of the compareTo(Photograph p) method Because the current object's dateTaken is before
     * p's, it should return a negative number
     */
    @Test
    public void testNegCompareTo() {
        PhotoLibrary p = new PhotoLibrary("Library", 1);
        Photograph p1 = new Photograph("Hi!", "Day 1", "1995-10-29", 4);
        Photograph p2 = new Photograph("Bye!", "Day 2", "1995-10-30", 4);
        p.addPhoto(p1);

        assertEquals("compareTo with argument (p2) failed", -1, p1.compareTo(p2));

    }

    /**
     * Test the positive number case of the compareTo(Photograph p) method Because the current object's dateTaken is after
     * p's, it should return a positive number
     */
    @Test
    public void testPosCompareTo() {
        PhotoLibrary p = new PhotoLibrary("Library", 1);
        Photograph p1 = new Photograph("Hi!", "Day 1", "1995-10-29", 4);
        Photograph p2 = new Photograph("Bye!", "Day 2", "1995-10-30", 4);
        p.addPhoto(p1);

        assertEquals("compareTo with argument (p1) failed", 1, p2.compareTo(p1));

    }

    /**
     * Test the negative number case of the compare(Photograph a, Photograph b) method in CompareByCaption Because the
     * current object's caption is alphabetically before p's, it should return a negative number
     */
    @Test
    public void testNegCompareByCaption() {
        CompareByCaption c = new CompareByCaption();
        PhotoLibrary p = new PhotoLibrary("Library", 1);
        Photograph p1 = new Photograph("Hi!", "Day 1", "1995-10-29", 4);
        Photograph p2 = new Photograph("Bye!", "Day 2", "1995-10-30", 4);
        p.addPhoto(p1);

        assertEquals("compare with argument (p2, p1) failed", -6, c.compare(p2, p1));

    }

    /**
     * Test the positive number case of the compare(Photograph a, Photograph b) method in CompareByCaption Because the
     * current object's caption is alphabetically after p's, it should return a positive number
     */
    @Test
    public void testPosCompareByCaption() {
        CompareByCaption c = new CompareByCaption();
        PhotoLibrary p = new PhotoLibrary("Library", 1);
        Photograph p1 = new Photograph("Hi!", "Day 1", "1995-10-29", 4);
        Photograph p2 = new Photograph("Bye!", "Day 2", "1995-10-30", 4);
        p.addPhoto(p1);

        assertEquals("compare with argument (p1, p2) failed", 6, c.compare(p1, p2));

    }

    /**
     * Test the negative number case of the compare(Photograph a, Photograph b) method in CompareByRating Because the
     * current rating is higher than p's, it should return a negative number, because the natural order is descending
     */
    @Test
    public void testNegCompareByRating() {
        CompareByRating c = new CompareByRating();
        PhotoLibrary p = new PhotoLibrary("Library", 1);
        Photograph p1 = new Photograph("Hi!", "Day 1", "1995-10-29", 4);
        Photograph p2 = new Photograph("Bye!", "Day 2", "1995-10-30", 5);
        p.addPhoto(p1);

        assertEquals("compare with argument (p2, p1) failed", -1, c.compare(p2, p1));

    }

    /**
     * Test the positive number case of the compare(Photograph a, Photograph b) method in CompareByRating Because the
     * current rating is lower than p's, it should return a positive number, because the natural order is descending
     */
    @Test
    public void testPosCompareByRating() {
        CompareByRating c = new CompareByRating();
        PhotoLibrary p = new PhotoLibrary("Library", 1);
        Photograph p1 = new Photograph("Hi!", "Day 1", "1995-10-29", 4);
        Photograph p2 = new Photograph("Bye!", "Day 2", "1995-10-30", 5);
        p.addPhoto(p1);

        assertEquals("compare with argument (p1, p2) failed", 1, c.compare(p1, p2));

    }

}
