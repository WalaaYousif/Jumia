package com.jumia.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class PageModel<T> {

    private int page;

    private int pageSize;

    private long totalElements;

    private int totalPages;

    private List<T> content;

    public PageModel(int page, int pageSize, long totalElements, int totalPages, List<T> content) {
        this.page = page;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.content = content;
    }

    public <U> PageModel<U> map(Function<T, U> mapFunction) {
        List<U> mappedContent = this.content.stream().map(mapFunction).collect(Collectors.toList());
        return new PageModel<>(page, pageSize, totalElements, totalPages, mappedContent);
    }

    public void copyTo(PageModel<T> pageModel) {
        pageModel.page = this.page;
        pageModel.pageSize = this.pageSize;
        pageModel.totalElements = this.totalElements;
        pageModel.totalPages = this.totalPages;
        pageModel.content = this.content;
    }
}
