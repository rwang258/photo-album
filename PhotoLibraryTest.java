/**
 * Homework 2 Ray Wang, rcw3tmf 
 * Sources : https://docs.oracle.com/javase/8/docs/api/?java/util/ArrayList.html
 */
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PhotoLibraryTest {
    /**
     * Test the null case of the getPhotos method
     * The rating 6 is not valid so should return null
     */
    @Test
    public void testNullGetPhotos() {
        PhotoLibrary p = new PhotoLibrary("Library", 1);
        p.addPhoto(new Photograph("Hi!", "Day 1", "1995-10-29", 4));
        assertEquals("getPhotos with argument (6) failed", null, p.getPhotos(6));

    }
    /**
     * Test the empty case of getPhotos
     * There is not photograph with rating of 5, so should return an empty array list
     */
    @Test
    public void testEmptyGetPhotos() {
        PhotoLibrary p = new PhotoLibrary("Library", 1);
        p.addPhoto(new Photograph("Hi!", "Day 1", "1995-10-29", 4));
        assertEquals("getPhotos with argument (5) failed", new ArrayList<Photograph>(), p.getPhotos(5));

    }
    /**
     * Test the empty case of the getPhotosInMonth method
     * There are no photos with the given year and month so should return an empty array list
     */
    @Test
    public void testEmptyGetPhotosInMonth() {
        PhotoLibrary p = new PhotoLibrary("Library", 1);
        p.addPhoto(new Photograph("Hi!", "Day 1", "1995-10-29", 4));
        assertEquals("getPhotosInMonth with argument (7,2018) failed", new ArrayList<Photograph>(), p.getPhotosInMonth(7, 2018));

    }
    /**
     * Test the null case of the getPhotosInMonth method
     * The month and year are invalid so should return null
     */
    @Test
    public void testNullGetPhotosInMonth() {
        PhotoLibrary p = new PhotoLibrary("Library", 1);
        p.addPhoto(new Photograph("Hi!", "Day 1", "1995-10-29", 4));
        assertEquals("getPhotosInMonth with argument (13,201) failed", null, p.getPhotosInMonth(13, 201));

    }
    /**
     * Test the empty case of the getPhotosBetween method
     * There are no photos between given dates so should return an empty array list
     */
    @Test
    public void testEmptyGetPhotosBetween() {
        PhotoLibrary p = new PhotoLibrary("Library", 1);
        p.addPhoto(new Photograph("Hi!", "Day 1", "1995-10-29", 4));
        assertEquals("getPhotosBetween with argument (2019-10-22, 2019-10-23) failed", new ArrayList<Photograph>(),
                p.getPhotosBetween("2019-10-22", "2019-10-23"));

    }
    /**
     * Test the null case of the getPhotosBetween method
     * The given dates are not valid, so should return null
     */
    @Test
    public void testNullGetPhotosBetween() {
        PhotoLibrary p = new PhotoLibrary("Library", 1);
        p.addPhoto(new Photograph("Hi!", "Day 1", "1995-10-29", 4));
        assertEquals("getPhotosInMonth with argument (2-1-1, 2-1-2) failed", null, p.getPhotosBetween("2-1-1", "2-1-2"));

    }
    /**
     * Test that remove the only Photograph in the PhotoLibrary.
     * The side effects are tested, the number of photographs is 0
     */
    @Test
    public void testPassErasePhoto() {
        PhotoLibrary p = new PhotoLibrary("Library", 1);
        Photograph h = new Photograph("Hi!", "Day 1", "1995-10-29", 4);
        p.addPhoto(h);
        p.removePhoto(h);
        assertEquals("erasePhoto with argument (p) failed", 0, p.numPhotographs());

    }
    @Test
    /**
     * Test that remove a nonexistent Photograph in the PhotoLibrary.
     * Erase photo will return false because the removal was unsuccessful since the 
     * photo was not in the photo library in the first place
     */
    public void testFailErasePhoto() {
        PhotoLibrary p = new PhotoLibrary("Library", 1);
        Photograph h = new Photograph("Hi!", "Day 1", "1995-10-29", 4);
        assertFalse(p.removePhoto(h));
    }
    /**
     * Test one case of the similarity method, should return 0.0
     * They have no common photos so the similarity rating should be 0.0
     */
    @Test
    public void testOneSimilarity() {
        PhotoLibrary p = new PhotoLibrary("Library", 1);
        Photograph h = new Photograph("Hi!", "Day 1", "1995-10-29", 4);
        Photograph r = new Photograph("hi", "Day 0", "2005-10-29", 4);
        p.addPhoto(h);
        PhotoLibrary p2 = new PhotoLibrary("Library", 2);
        p2.addPhoto(r);
        assertEquals("similarity with arguments (p, p2) failed", 0.0, PhotoLibrary.similarity(p, p2), 0);
    }
    /**
     * Test one case of the similarity method, should return 1.0
     * They have one photo in each photo library and they are the same, so 
     * the similarity rating is 1.0
     */
    @Test
    public void testTwoSimilarity() {
        PhotoLibrary p = new PhotoLibrary("Library", 1);
        Photograph h = new Photograph("Hi!", "Day 1", "1995-10-29", 4);
        p.addPhoto(h);
        PhotoLibrary p2 = new PhotoLibrary("Library", 2);
        p2.addPhoto(h);
        assertEquals("similarity with arguments (p, p2) failed", 1.0, PhotoLibrary.similarity(p, p2), 0);
    }

}
