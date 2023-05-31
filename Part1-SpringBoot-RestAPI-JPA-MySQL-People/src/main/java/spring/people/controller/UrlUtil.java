/*******************************************************************************
 * Copyright (c) 2023 Viking Cloud, LLC - All Rights Reserved.
 *
 * Proprietary and confidential information of Viking Cloud, LLC.
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 *******************************************************************************/
package spring.people.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * TODO: Class description here
 *
 * <pre>
 * Copyright (c) 2023 Viking Cloud, LLC. - All rights reserved.
 * </pre>
 *
 * @author ymartinez
 */
public class UrlUtil {

    public static String shortenURL(String longURL) {
      /*  String uniqueID = generateUniqueID(longURL);
        String shortenedURL = encodeBase64(uniqueID);*/

        String shorturl =  longURL.substring(longURL.length()/2,longURL.length());
        return shorturl;
    }

    private static String generateUniqueID(String longURL) {
        String input = "my_url" + longURL;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(input.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String encodeBase64(String input) {
        byte[] bytes = input.getBytes();
        String encodedString = Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
        return encodedString;
    }

}

