package com.dev.services;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
import java.util.UUID;


public class KeyGenerator {
    public static long generateKey() {
        return (long) UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;// Not to allow negative values
    }

    public static void main(String[] args) {
        System.out.println(generateKey());
    }
}
