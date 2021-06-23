package br.edu.infnet.easyplayapi.util;

import java.time.Instant;

public class IdGenerator {
    public static String genId() {
        Instant instant = Instant.now();
        return Long.toString(instant.toEpochMilli());
        // instant.getNano()
    }
}

