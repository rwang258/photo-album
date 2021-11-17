
/**
 * Homework 3 
 * Ray Wang, rcw3tmf 
 * Sources : https://docs.oracle.com/javase/8/docs/api/?java/util/ArrayList.html
 * https://docs.oracle.com/javase/8/docs/api/?java/lang/Integer.html
 */

import java.util.ArrayList;
import java.util.HashSet;

public class PhotoLibrary extends PhotographContainer {
    /**
     * Holds a HashSet of albums, in the form of Album objects
     */
    private HashSet<Album> albums;
    /**
     * Holds the identification of the photo library
     */
    private final int id;

    /**
     * Constructor that requires name and id, and initializes all four fields
     */
    public PhotoLibrary(String name, int id) {
        super(name);
        // this.name = name;
        this.id = id;
        this.photos = new ArrayList<Photograph>();
        this.albums = new HashSet<Album>();
    }

    /**
     * Get HashSet of photo albums
     * 
     * @return HashSet of photo albums
     */
    public HashSet<Album> getAlbums() {
        return this.albums;
    }

    /**
     * Adds an album created from the name you gave it to the list of albums, only if an album with that name does not
     * already exist
     * 
     * @param a string of the album name
     * @return true if the add was successful, false if not
     */
    public boolean createAlbum(String albumName) {
        Album album = new Album(albumName);
        return albums.add(album);
    }

    /**
     * Removes the album with the given name from the list of albums, only if an album with that name exists in that set
     * 
     * @param a string of the album name
     * @return true if it was successfully removed, false if not
     */
    public boolean removeAlbum(String albumName) {
        Album album = new Album(albumName);
        return albums.remove(album);
    }

    /**
     * Adds a photograph to the album in the set of albums with the name albumName if it is in the list of photos and it is
     * not already in that album
     * 
     * @param a photograph object to add, string of the album name you want to add to
     * @return true if the photograph was successfully added, false if not
     */
    public boolean addPhotoToAlbum(Photograph p, String albumName) {
        if (photos.contains(p)) {
            for (Album a : albums) {
                if (a.getName().equals(albumName)) {
                    if (!a.hasPhoto(p)) {
                        return a.addPhoto(p);
                    } else {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        return false;
    }

    /**
     * Removes a specified photograph from an album with the given album name in the set of albums
     * 
     * @param a photograph object to remove, string of the album name you want to remove from
     * @return true if the photograph was successfully removed, false if not
     */
    public boolean removePhotoFromAlbum(Photograph p, String albumName) {
        if (getAlbumByName(albumName) == null) {
            return false;
        }
        if (photos.contains(p)) {
            return getAlbumByName(albumName).removePhoto(p);
        } else {
            return false;
        }
    }

    /**
     * Private helper method that returns an album with the specified name from the set of albums
     * 
     * @param string of the album name
     * @return album object with specified name, null if not found
     */
    private Album getAlbumByName(String albumName) {
        for (Album a : albums) {
            if (a.getName().equals(albumName)) {
                return a;
            }
            return null;
        }
        return null;
    }

    /**
     * Get Id number
     * 
     * @return id number
     */
    public int getId() {
        return this.id;
    }

    /**
     * Removes a photo in photo library, and any album in the set of albums that has the photo
     * 
     * @param the photograph you want to remove
     * @return true if it was removed from the photo library and and albums that have the photo, false if not
     */
    public boolean removePhoto(Photograph p) {
        boolean b = false;
        if (photos.remove(p)) {
            b = true;
        }
        for (Album a : albums) {
            if (a.removePhoto(p)) {
                b = true;
            }
        }
        return b;
    }

    /**
     * See if two photo libraries are equal to each other by using the id's
     * 
     * @param object(PhotoLibrary) you want to compare to
     * @return true if id's are same, false if not
     */
    public boolean equals(Object o) {
        if (o != null && o instanceof PhotoLibrary) {
            PhotoLibrary otherPhotoLibrary = (PhotoLibrary) o;
            // if not null and instance of PhotoLibrary, cast it and continue
            if (this.id == otherPhotoLibrary.getId()) {
                return true;
            } // if int values of id are same, return true
        }
        return false; // return false if not true
    }

    /**
     * Get a string representation of your photo library and album list
     * 
     * @return name, id, photos, album names in a neat format
     */
    public String toString() {
        return "Name: " + name + " Id: " + id + " Photos: " + photos + "Albums: " + albums;
    }

    /**
     * Get a list of the common photos between two photo libraries
     * 
     * @param the two photo libraries you want to compare
     * @return an ArrayList of the common photos between two photo libraries
     */
    public static ArrayList<Photograph> commonPhotos(PhotoLibrary a, PhotoLibrary b) {
        ArrayList<Photograph> n = new ArrayList<Photograph>();
        for (Photograph temp : a.getPhotos()) {
            if (b.hasPhoto(temp)) {
                n.add(temp);
            }// use for each loop to look at each Photograph object in a, if it does have it, add it into the common array list
        }// return common array list at the end of the for each loop
        return n;
    }

    /**
     * Get a numerical value showing how similar two photo libraries are
     * 
     * @param the two photo libraries you want to compare
     * @return a double showing you how similar the two libraries are, 0 if one has no photos, or the number of common
     *         photos divided by the number of photographs in the group with the least number of photographs
     */
    public static double similarity(PhotoLibrary a, PhotoLibrary b) {
        if (a.numPhotographs() == 0 || b.numPhotographs() == 0) {
            return 0.0;// if either of them have size of 0, return 0, because can't divide by 0 in below calculation
        } else if (a.numPhotographs() <= b.numPhotographs()) {// return size of common photo size divide by least number photo
                                                              // library size
            return (commonPhotos(a, b).size() * 1.0) / (a.numPhotographs());
        }
        return (commonPhotos(a, b).size() * 1.0) / (b.numPhotographs());
    }

    public static void main(String[] args) {
        Photograph pe = new Photograph("Fun!", "Carter's Mountain");// new photograph object
        Photograph we = new Photograph("Cool!", "Arcade");// new photograph object
        PhotoLibrary p = new PhotoLibrary("Summer", 111);// new photolibrary object
        PhotoLibrary q = new PhotoLibrary("Winter", 222);// new photolibrary object
        System.out.println(p.addPhoto(pe) + " - should be true.");// can add
        System.out.println(p.addPhoto(pe) + " - should be false.");// can't because already there
        System.out.println(p.hasPhoto(pe) + " - should be true.");// it does have the photo, just added in
        System.out.println(q.hasPhoto(pe) + " - should be false.");// q does not have photograph pe
        System.out.println(p.removePhoto(pe) + " - should be true.");// it erased successfully so true
        System.out.println(p.removePhoto(pe) + " - should be false.");// it has already been erased, so did not erase
                                                                      // successfully,
                                                                      // returns false
        System.out.println(p.numPhotographs() + " - should be 0.");// p has no photographs in it, they have been removed
        System.out.println(q.numPhotographs() + " - should be 0.");// q has no photographs in it
        System.out.println(p.equals(p) + " - should be true.");// p should be equal to itself, has the same id number as itself
        System.out.println(p.equals(q) + " - should be false.");// not equal because of different id numbers
        p.addPhoto(pe);// add a photo
        q.addPhoto(we);// add a different photo
        System.out
                .println(p.toString() + " - should be Name: Summer Id: 111 Photos: [Caption: Fun! Filename: Carter's Mountain]");// should
                                                                                                                                 // print
                                                                                                                                 // out
                                                                                                                                 // in
                                                                                                                                 // the
                                                                                                                                 // format
                                                                                                                                 // specified
                                                                                                                                 // in
                                                                                                                                 // toString()
                                                                                                                                 // method
        System.out.println(q.toString() + " - should be Name: Winter Id: 222 Photos: [Caption: Cool! Filename: Arcade]");// should
                                                                                                                         // print
                                                                                                                         // out in
                                                                                                                         // the
                                                                                                                         // format
                                                                                                                         // specified
                                                                                                                         // in
                                                                                                                         // toString()
                                                                                                                         // method
        System.out.println(commonPhotos(p, q) + " should be []");// should be empty
        q.addPhoto(pe);
        System.out.println(commonPhotos(p, q) + " should have only [Caption: Fun! Filename: Carter's Mountain.]");// only has one
                                                                                                                  // common photo,
                                                                                                                  // pe
        System.out.println(similarity(p, q) + " should be 1.0.");// 1 common, divided by 1 photo from smallest library, equals 1.0
        q.removePhoto(pe); // erase one photo from q
        System.out.println(similarity(p, q) + " should be 0.0.");// q has size 0, so equal to 0.0

    }
}
