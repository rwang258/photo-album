
/**
 * Homework 3 
 * Ray Wang, rcw3tmf 
 * Sources : https://docs.oracle.com/javase/8/docs/api/?java/util/ArrayList.html
 */
import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;

public class Album extends PhotographContainer {

    /**
     * Constructor that requires name of the album
     */
    public Album(String name) {
        super(name);
        // this.name = name;
        this.photos = new ArrayList<Photograph>();
    }

}
