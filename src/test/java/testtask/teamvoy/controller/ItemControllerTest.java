package testtask.teamvoy.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import testtask.teamvoy.dto.ItemRequestDto;

@SpringBootTest
@AutoConfigureMockMvc
class ItemControllerTest {
    private static final String ITEMS_URL = "/items";
    private static final String SEARCH_URL = "?name=banana&quantity=5";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void buyItem() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders
                .get(ITEMS_URL + SEARCH_URL)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void addItem() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post(ITEMS_URL)
                .content(asJsonString(
                        new ItemRequestDto("grape", 10L, 40L)))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
