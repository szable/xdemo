package com.abc.xdemo.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Ferredy
 * @Date: 2019/9/1
 */
@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showLastPage;
    private Integer page;
    private Integer totalPage;
    private List<Integer> pages = new ArrayList<>();

    public void setPagination(Integer totalCount, Integer page, Integer size) {
        this.page = page;
        this.totalPage = 0;
        if (this.totalPage % size == 0) {
            this.totalPage = totalCount / size;
        } else {
            this.totalPage = totalCount / size + 1;
        }

        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }

            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }

        //前一页
        if (page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }

        //下一页
        if (page == totalPage) {
            showNext = false;
        } else {
            showNext = true;
        }

        //第一页
        if (pages.contains(1)) {
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }

        //最后一页
        if (pages.contains(totalPage)) {
            showLastPage = false;
        } else {
            showLastPage = true;
        }
    }
}
