package com.codeflow.shortner.generator;

import com.codeflow.shortner.IdGenerator;

import java.util.concurrent.atomic.AtomicLong;

public class IdGeneratorImpl implements IdGenerator {

    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Long getId() {
        return idGenerator.getAndIncrement();
    }
}
