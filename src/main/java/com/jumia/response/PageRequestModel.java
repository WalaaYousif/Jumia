package com.jumia.response;

import lombok.Data;

@Data
public class PageRequestModel {

    private final int page;

    private final int pageSize;
}
