package com.pofil.util;

import org.apache.commons.lang.RandomStringUtils;

public class RandomKeyGenerator {
    public static final int ID_LENGTH = 5;
    public static  String generateUniqueId() {
        return RandomStringUtils.randomAlphanumeric(ID_LENGTH);
    }

}
