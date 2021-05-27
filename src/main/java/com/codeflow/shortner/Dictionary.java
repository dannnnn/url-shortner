package com.codeflow.shortner;

public interface Dictionary {
    String createKey(Long id);

    Long getIdByKey(String uniqueKey);
}
