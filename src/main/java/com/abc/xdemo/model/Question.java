package com.abc.xdemo.model;

import lombok.Data;

/**
 * @Author: Ferredy
 * @Date: 2019/8/13
 */
@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;


}
