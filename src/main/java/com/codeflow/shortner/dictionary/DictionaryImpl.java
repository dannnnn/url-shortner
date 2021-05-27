package com.codeflow.shortner.dictionary;

import com.codeflow.shortner.Conversion;
import com.codeflow.shortner.Dictionary;

public class DictionaryImpl implements Dictionary {

    private final Conversion conversion;

    public DictionaryImpl(Conversion conversion) {
        this.conversion = conversion;
    }

    @Override
    public String createKey(Long id) {
        return conversion.encode(id);
    }

    @Override
    public Long getIdByKey(String uniqueKey) {
        return conversion.decode(uniqueKey);
    }
}
