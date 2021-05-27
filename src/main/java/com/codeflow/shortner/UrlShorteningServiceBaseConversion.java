package com.codeflow.shortner;

public class UrlShorteningServiceBaseConversion implements UrlShorteningService {

    private final Conversion conversion;
    private final IdGenerator generator;
    private final UrlRepository urlRepository;

    public UrlShorteningServiceBaseConversion(Conversion conversion,
                                              IdGenerator generator,
                                              UrlRepository urlRepository) {

        this.conversion = conversion;
        this.generator = generator;
        this.urlRepository = urlRepository;
    }

    @Override
    public String getShortUrl(String longUrl) {
        Long id = generator.getId();
        String uniqueKey = conversion.encode(id);
        urlRepository.saveUrl(id, longUrl);
        return uniqueKey;
    }

    @Override
    public String getLongUrl(String uniqueKey) {
        Long idByKey = conversion.decode(uniqueKey);
        return urlRepository.findById(idByKey);
    }
}
