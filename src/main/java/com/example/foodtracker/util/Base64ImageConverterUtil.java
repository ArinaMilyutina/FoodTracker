package com.example.foodtracker.util;

import java.util.Base64;

public class Base64ImageConverterUtil {
    public String convertImageToBase64(byte[] image) {
        return Base64.getEncoder().encodeToString(image);
    }
}
