package gar.osh.slmtest;


import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({SpringExtension.class})
@AutoConfigureMockMvc
@SpringBootTest
public class CustomExceptionHandlerTest {

    @Autowired
    public MockMvc mockMvc;

    @Test
    public void testAllErrors() throws Exception {
        Response response = new Response("Oops, error occured...");
        String json = JsonMapper.builder().addModule(new JavaTimeModule()).build().writeValueAsString(response);
        mockMvc.perform(get("/errorrrr").contentType(MediaType.APPLICATION_JSON).content(String.valueOf(json))).andExpect(status().is2xxSuccessful());
        mockMvc.perform(post("/").contentType(MediaType.APPLICATION_JSON).content(String.valueOf(json))).andExpect(status().is2xxSuccessful());
    }
}
