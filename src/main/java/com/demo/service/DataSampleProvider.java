package com.demo.service;

import com.demo.domain.DataSample;
import org.springframework.stereotype.Service;

@Service
public class DataSampleProvider {

    public static final int SAMPLE_ID = 9999;

    public DataSample getData(String value) {
        return new DataSample(SAMPLE_ID, value);
    }
}
