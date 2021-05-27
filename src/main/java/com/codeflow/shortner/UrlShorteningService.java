package com.codeflow.shortner;

public interface UrlShorteningService {

    String getShortUrl(String longUrl);

    String getLongUrl(String uniqueKey);
}
