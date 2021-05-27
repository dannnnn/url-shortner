package com.codeflow;

import com.codeflow.shortner.UrlShorteningService;
import com.codeflow.shortner.UrlShorteningServiceBaseConversion;
import com.codeflow.shortner.conversion.Base62Conversion;
import com.codeflow.shortner.generator.IdGeneratorImpl;
import com.codeflow.shortner.repo.UrlRepositoryInMemory;

public class Main {

    public static void main(String[] args) {
        UrlShorteningService service = new UrlShorteningServiceBaseConversion(new Base62Conversion(),
                                                                              new IdGeneratorImpl(),
                                                                              new UrlRepositoryInMemory());
        String shortUrl = service.getShortUrl("longUrl");
        String longUrl = service.getLongUrl(shortUrl);
        System.out.println(longUrl);
    }
}
