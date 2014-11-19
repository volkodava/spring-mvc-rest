package com.demo.controllers;

import com.demo.domain.DataSample;
import com.demo.service.DataSampleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/json")
public class JsonController {

    @Autowired
    private DataSampleProvider provider;

    @RequestMapping(value = "/test/{value}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public DataSample createJson(@PathVariable("value") String value) {
        DataSample result = provider.getData(value);
        return result;
    }
}
