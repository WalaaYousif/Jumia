package com.jumia.customer.api;

import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Optional;

import static com.jumia.utils.RequestUtils.pagination;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@Component
public class CustomerApi {

    private final MockMvc mockMvc;

    public CustomerApi(Optional<MockMvc> mockMvc) {
        this.mockMvc = mockMvc.orElse(null);
    }

    public ResultActions getCustomerList(String pageNo, String pageSize) throws Exception {
        return mockMvc.perform(
                get("/customer")
                        .with(pagination(pageNo, pageSize))
        );
    }
}