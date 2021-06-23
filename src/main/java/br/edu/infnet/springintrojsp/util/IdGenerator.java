package br.edu.infnet.springintrojsp.util;

import java.time.Instant;

public class IdGenerator {
    public static String genId() {
        Instant instant = Instant.now();
        return Long.toString(instant.toEpochMilli());
        // instant.getNano()
    }
}