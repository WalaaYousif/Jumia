package com.jumia.response;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PaginationUtils {

    private PaginationUtils() {
    }

    public static <T> PageModel<T> toPageModel(Page<T> page) {
        return new PageModel<>(page.getNumber(), page.getSize(), page.getTotalElements(), page.getTotalPages(), page.getContent());
    }

    public static Pageable toPageable(PageRequestModel page, Sort sort) {
        if (page == null) {
            page = new PageRequestModel(0, Integer.MAX_VALUE);
        }
        if (sort == null) {
            sort = Sort.unsorted();
        }
        return PageRequest.of(page.getPage(), page.getPageSize(), sort);
    }

    public static Pageable toPageable(PageRequestModel page) {
        return toPageable(page, Sort.unsorted());
    }
}
