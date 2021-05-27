package com.codeflow.shortner;

public interface UrlRepository {
    void saveUrl(Long id, String uniqueKey);

    String findById(Long idByKey);
}
