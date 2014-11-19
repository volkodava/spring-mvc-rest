package com.demo.controllers;

import com.demo.domain.DataSample;
import com.demo.service.DataSampleProvider;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:test-spring-config.xml"})
public class JsonControllerTest {

    private static final int DATA_ID = 999;
    private static final String DATA_VALUE = "some_value";
    private static final String BASE_URI = "/json/test/" + DATA_VALUE;

    private MockMvc mockMvc;

    @Autowired
    private DataSampleProvider provider;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        reset(provider);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        when(provider.getData(DATA_VALUE)).thenReturn(new DataSample(DATA_ID, DATA_VALUE));
    }

    @Test
    public void testHelloWorld() throws Exception {
        mockMvc.perform(get(BASE_URI)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("$.id", is(DATA_ID)))
            .andExpect(jsonPath("$.value", is(DATA_VALUE)));
    }
}
