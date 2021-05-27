package com.codeflow.shortner;

import com.codeflow.shortner.conversion.Base62Conversion;
import com.codeflow.shortner.generator.IdGeneratorImpl;
import com.codeflow.shortner.repo.UrlRepositoryInMemory;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class UrlShorteningServiceBaseConversionTest {

    private UrlShorteningServiceBaseConversion service;

    @Before
    public void setUp() {
        service = new UrlShorteningServiceBaseConversion(new Base62Conversion(),
                                                         new IdGeneratorImpl(),
                                                         new UrlRepositoryInMemory());
    }

    @Test
    public void getShortUrl_longUrl_isShorten() {
        String longUrl = "longUrl";
        String shortUrl = service.getShortUrl(longUrl);
        assertThat(shortUrl).isLessThan(longUrl);
    }

    @Test
    public void getLongUrl_shortUrl_convertedToOriginalUrl() {
        String input = "longUrl";
        String shortUrl = service.getShortUrl(input);
        String longUrl = service.getLongUrl(shortUrl);
        assertThat(longUrl).isEqualTo(input);
    }
}
