package com.backend.helper;



/**
 * The type String helper.
 */
public class StringHelper {

    /**
     * Capitalize first letter.
     *
     * @param original the original
     * @return the string
     */
    public static String capitalizeFirstLetter(String original) {
        if (original == null || original.length() == 0) {
            return original;
        }
        return original.substring(0, 1).toUpperCase() + original.substring(1);
    }

}
