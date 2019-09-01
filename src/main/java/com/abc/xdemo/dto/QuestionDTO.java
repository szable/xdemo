package com.abc.xdemo.dto;

import com.abc.xdemo.model.User;
import lombok.Data;

/**
 * @Author: Ferredy
 * @Date: 2019/8/19
 */

@Data
public class QuestionDTO {
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
    private User user;

}
