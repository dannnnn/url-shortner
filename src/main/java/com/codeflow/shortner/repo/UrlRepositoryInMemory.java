package com.codeflow.shortner.repo;

import com.codeflow.shortner.UrlRepository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UrlRepositoryInMemory implements UrlRepository {

    private final Map<Long, String> inMemory = new ConcurrentHashMap<>();

    @Override
    public void saveUrl(Long id, String uniqueKey) {
        inMemory.put(id, uniqueKey);
    }

    @Override
    public String findById(Long idByKey) {
        return inMemory.get(idByKey);
    }
}
