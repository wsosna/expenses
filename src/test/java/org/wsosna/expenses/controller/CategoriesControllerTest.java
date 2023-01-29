package org.wsosna.expenses.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CategoriesControllerTest {

    private final static String BASE_URL = "/api/categories";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnOk() throws Exception {
        this.mockMvc.perform(get(BASE_URL))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldAddCategoryAndReturnItWithoutExpenses() throws Exception {
        final String json = "{ \"name\": \"food\", \"color\": \"#0DC9D6\" }";

        mockMvc.perform(post(BASE_URL + "/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("food"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.color").value("#0DC9D6"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.expenses").doesNotExist());
    }

}
