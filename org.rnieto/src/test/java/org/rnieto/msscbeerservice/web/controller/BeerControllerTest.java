package org.rnieto.msscbeerservice.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.rnieto.msscbeerservice.web.model.BeerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeerDTO() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception {

        BeerDTO beer = BeerDTO.builder().build();
        String beerToJson = objectMapper.writeValueAsString(beer);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerToJson))
                .andExpect(status().isCreated());
    }

    @Test
    void saveUpdatedBeer() throws Exception {

        BeerDTO beer = BeerDTO.builder().build();
        String beerToJson = objectMapper.writeValueAsString(beer);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/beer/"+ UUID.randomUUID().toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerToJson))
                 .andExpect(status().isNoContent());
    }

    @Test
    void deleteBeerDTO() {
    }
}