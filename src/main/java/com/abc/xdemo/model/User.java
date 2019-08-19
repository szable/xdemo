package com.abc.xdemo.model;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String accountId;
    private String name;
    private String token;
    private Long gmtCreate;
    private String gmtModified;
    private String avatarUrl;
}
