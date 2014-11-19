package com.demo.controllers;

import com.demo.domain.DataSample;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/json")
public class JsonController {

    @RequestMapping(value = "/test/{value}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public DataSample createJson(@PathVariable("value") String value) {
        DataSample data = new DataSample(9999, value);
        return data;
    }
}
