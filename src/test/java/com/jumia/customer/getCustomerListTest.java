package com.jumia.customer;

import com.jumia.customer.api.CustomerApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@WebAppConfiguration
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@RunWith(SpringRunner.class)
public class getCustomerListTest {

    @Autowired
    private CustomerApi customerApi;

    @Test
    public void testHappyScenario() throws Exception {
        customerApi.getCustomerList("0", "3")
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalElements", equalTo(41)))
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.content", hasSize(3)))
                .andExpect(jsonPath("$.content[0].name", equalTo("Walid Hammadi")))
                .andExpect(jsonPath("$.content[0].phone", equalTo("+212-600-798-9253")))
                .andExpect(jsonPath("$.content[0].status", equalTo("Not Valid")))
                .andExpect(jsonPath("$.content[0].countryName", equalTo("Morocco")))

                .andExpect(jsonPath("$.content[1].name", equalTo("Yosaf Karrouch")))
                .andExpect(jsonPath("$.content[1].phone", equalTo("+212-698-054-317")))
                .andExpect(jsonPath("$.content[1].status", equalTo("Valid")))
                .andExpect(jsonPath("$.content[1].countryName", equalTo("Morocco")))

                .andExpect(jsonPath("$.content[2].name", equalTo("Younes Boutikyad")))
                .andExpect(jsonPath("$.content[2].phone", equalTo("+212-654-654-5369")))
                .andExpect(jsonPath("$.content[2].status", equalTo("Not Valid")))
                .andExpect(jsonPath("$.content[2].countryName", equalTo("Morocco")));

    }
}