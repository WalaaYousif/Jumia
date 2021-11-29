package com.jumia.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class PageResponse<T> {

    private int page;

    private int pageSize;

    private int totalPages;

    private long totalElements;

    private List<T> content;

    public PageResponse(int page, int pageSize, long totalElements, List<T> content) {
        this.page = page;
        this.pageSize = pageSize;
        this.totalPages = (int) Math.ceil((double) totalElements / pageSize);
        this.totalElements = totalElements;
        this.content = content;
    }

    public static <T> PageResponse<T> of(PageModel<T> pageModel) {
        return copyAndOverrideContent(pageModel, pageModel.getContent());
    }

    public static <T> PageResponse<T> copyAndOverrideContent(PageModel<?> pageModel, List<T> content) {
        return new PageResponse<>(
                pageModel.getPage(),
                pageModel.getPageSize(),
                pageModel.getTotalElements(),
                content
        );
    }
}
