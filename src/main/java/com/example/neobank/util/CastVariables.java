package com.example.neobank.util;

import java.nio.ByteBuffer;
import java.util.UUID;

public class CastVariables {
    public static byte[] uuidToBytes(UUID uuid){
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        return bb.array();
    }
}
