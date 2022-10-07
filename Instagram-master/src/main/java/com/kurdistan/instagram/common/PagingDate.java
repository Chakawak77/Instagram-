package com.kurdistan.instagram.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class PagingDate<T> {

    private Integer totalPage;
    private Integer currentPage;
    private List<T> data;
}