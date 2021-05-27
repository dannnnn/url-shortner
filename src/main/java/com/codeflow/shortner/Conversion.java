package com.codeflow.shortner;

public interface Conversion {

    String encode(Long id);

    Long decode(String key);
}
