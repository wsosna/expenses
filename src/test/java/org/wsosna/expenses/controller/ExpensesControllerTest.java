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
public class ExpensesControllerTest {

    private final static String BASE_URL = "/api/expenses";

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
        final String json = "{ \"name\": \"La Chula\", \"description\": \"Going out with friends\", " +
                "\"price\": 120.56, \"categoryIds\": [2, 3] }";

        mockMvc.perform(post(BASE_URL + "/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("La Chula"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Going out with friends"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(120.56));
    }
}
