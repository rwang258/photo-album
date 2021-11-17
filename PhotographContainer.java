
/**
 * Homework 3 
 * Ray Wang, rcw3tmf
 */
import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;

public abstract class PhotographContainer {
    /**
     * A String that holds the album's name
     */
    protected String name;
    /**
     * An ArrayList that holds the photographs in the album
     */
    protected ArrayList<Photograph> photos;

    public PhotographContainer(String name) {
        this.name = name;
        this.photos = new ArrayList<Photograph>();
    }

    /**
     * Get name of the album
     * 
     * @return String name of the album
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get ArrayList of photo album
     * 
     * @return ArrayList of photo album
     */
    public ArrayList<Photograph> getPhotos() {
        return this.photos;
    }

    /**
     * Set name to desired string
     * 
     * @param String name the updated name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Add a photo into photo album
     * 
     * @param the photograph you want to add
     * @return true if it was added, false if not (already there), and false if it is null
     */
    public boolean addPhoto(Photograph p) {
        if (p != null) {
            return photos.add(p);
        } else {
            return false;
        }
    }

    /**
     * Check if photo is in the photo album
     * 
     * @param the photograph you want to check
     * @return true if it is there, false if not
     */
    public boolean hasPhoto(Photograph p) {
        return photos.contains(p);
    }

    /**
     * Removes a photo in photo album
     * 
     * @param the photograph you want to remove
     * @return true if it was removed, false if not
     */
    public boolean removePhoto(Photograph p) {
        return photos.remove(p);
    }

    /**
     * Find how many photos are in photo album
     * 
     * @return integer value of number of photographs in photo album
     */
    public int numPhotographs() {
        return photos.size();
    }

    /**
     * See if two photo albums are equal to each other by using the names
     * 
     * @param object(Album) you want to compare to
     * @return true if names are same, false if not
     */
    public boolean equals(Object o) {
        if (o != null && o instanceof Album) {
            Album otherAlbum = (Album) o;
            // if not null and instance of Album, cast it and continue
            if (this.name.equals(otherAlbum.getName())) {
                return true;
            } // if String values of name are same, return true
        }
        return false; // return false if not true
    }

    /**
     * Get a string representation of your photo album
     * 
     * @return album name, and filename of photos in a neat format
     */
    public String toString() {
        return "Name: " + name + " Photos: " + photos;
    }

    /**
     * Get hash code of photo album, based on hash code of the name.
     *
     * @return the hash code of the album
     */
    public int hashCode() {
        return this.name.hashCode();
    }

    /**
     * Get ArrayList of photos that have a rating greater than equal to the given parameter rating
     * 
     * @param an int of the rating, correctly formatted, between 0 and 5
     * @return ArrayList of Photographs
     */
    public ArrayList<Photograph> getPhotos(int rating) {
        ArrayList<Photograph> arr = new ArrayList<Photograph>(); // new array list
        if (rating >= 0 && rating <= 5) {
            for (int i = 0; i < photos.size(); i++) {
                if (photos.get(i).getRating() >= rating) { // if photo rating in photos
                    // feed is greater than or equal to given rating add into new array list
                    arr.add(photos.get(i));
                }
            }
            return arr;
        } else {
            return null;
        }
    }

    /**
     * Get ArrayList of photos from the photos feed that was taken in the given year
     * 
     * @param an int of year, correctly formatted, that has a length of 4
     * @return ArrayList of Photographs
     */
    public ArrayList<Photograph> getPhotosInYear(int year) {
        ArrayList<Photograph> arr = new ArrayList<Photograph>(); // new array list
        if (String.valueOf(year).length() == 4) {
            if (year >= 1000 && year <= 2019) {
                for (int i = 0; i < photos.size(); i++) {
                    if (Integer.parseInt(photos.get(i).getDateTaken().substring(0, 4)) == year) { // if date taken in photos
                        // feed is equal to given year add into new array list
                        arr.add(photos.get(i));
                    }
                }
            }
            return arr;
        } else {
            return null;
        }
    }

    /**
     * Get ArrayList of photos from the photos feed that was taken in the given year and the given month
     * 
     * @param an int of year, correctly formatted, that has a length of 4, an int of month, correctly formatted, between 1
     *           and 12
     * @return ArrayList of Photographs
     */
    public ArrayList<Photograph> getPhotosInMonth(int month, int year) {
        ArrayList<Photograph> arr = new ArrayList<Photograph>(); // new array list
        if (String.valueOf(year).length() == 4 && month >= 1 && month <= 12 && year >= 1000 && year <= 2019) {
            for (int i = 0; i < photos.size(); i++) {
                if (Integer.parseInt(photos.get(i).getDateTaken().substring(0, 4)) == year
                        && Integer.parseInt(photos.get(i).getDateTaken().substring(5, 7)) == month) { // if date taken in photos
                    // feed is equal to given year and given month add into new array list
                    arr.add(photos.get(i));
                }
            }
            return arr;
        } else {
            return null;
        }
    }

    /**
     * Check if begin date is after end date
     * 
     * @param a string for begin date and end date
     * @return true if begin date is after end date, false if not
     */
    public boolean isAfter(String beginDate, String endDate) {
        ArrayList<Photograph> arr = new ArrayList<Photograph>(); // new array list
        String[] begin = beginDate.split("-", -1);
        String[] end = endDate.split("-", -1);
        if (Integer.parseInt(begin[0]) < Integer.parseInt(end[0])) {
            return true;
        } else if (Integer.parseInt(begin[0]) == Integer.parseInt(end[0])) {
            if (Integer.parseInt(begin[1]) < Integer.parseInt(end[1])) {
                return true;
            }
            if (Integer.parseInt(begin[1]) == Integer.parseInt(end[1])) {
                if (Integer.parseInt(begin[2]) <= Integer.parseInt(end[2])) {
                    return true;
                }
            }
        } else {
            return false;
        }
        return false;
    }

    /**
     * Check if current photo's date is between given begin date and given end date
     * 
     * @param a string for photo's date, begin date, and end date
     * @return true if date is between begin date and end date, false if not
     */
    public boolean isBetween(String currentDate, String beginDate, String endDate) {
        String[] current = currentDate.split("-", -1);
        String[] begin = beginDate.split("-", -1);
        String[] end = endDate.split("-", -1); // split it at "-"

        if (Integer.parseInt(current[0]) > Integer.parseInt(begin[0])
                && Integer.parseInt(current[0]) < Integer.parseInt(end[0])) {
            return true;
        } else if (Integer.parseInt(current[0]) == Integer.parseInt(begin[0])
                && Integer.parseInt(current[0]) < Integer.parseInt(end[0])) {
            if (Integer.parseInt(current[1]) > Integer.parseInt(begin[1])) {
                return true;
            } else if (Integer.parseInt(current[1]) == Integer.parseInt(begin[1])) {
                if (Integer.parseInt(current[2]) >= Integer.parseInt(begin[2])) {
                    return true;
                } else {
                    return false;
                }

            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Get ArrayList of photos from the photos feed that was taken between a begin date and an end date, inclusive
     * 
     * @param two strings of a date with a year, month, and day, in the correct format
     * @return ArrayList of Photographs
     */
    public ArrayList<Photograph> getPhotosBetween(String beginDate, String endDate) {
        ArrayList<Photograph> arr = new ArrayList<Photograph>(); // new array list
        String[] begin = beginDate.split("-");
        String[] end = endDate.split("-");
        if (begin.length != 3 || end.length != 3) {
            return null;
        }
        if (begin[0].length() == 4 && Integer.parseInt(begin[1]) >= 1 && Integer.parseInt(begin[1]) <= 12
                && Integer.parseInt(begin[2]) >= 1 && Integer.parseInt(begin[2]) <= 31 && end[0].length() == 4
                && Integer.parseInt(end[1]) >= 1 && Integer.parseInt(end[1]) <= 12 && Integer.parseInt(end[2]) >= 1
                && Integer.parseInt(end[2]) <= 31 && isAfter(beginDate, endDate)) {
            for (int i = 0; i < photos.size(); i++) {
                if (isBetween(photos.get(i).getDateTaken(), beginDate, endDate)) {
                    arr.add(photos.get(i));
                }

            }
            return arr;
        } else {
            return null;
        }
    }

}
