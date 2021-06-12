package br.edu.infnet.springintrojsp.util;

import java.time.Instant;

public class IdGenerator {
    public static String genId() {
        return Long.toString(Instant.now().toEpochMilli());
    }
}
