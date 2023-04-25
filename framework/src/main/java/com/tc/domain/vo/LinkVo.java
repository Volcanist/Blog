package com.tc.domain.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkVo {
    //网站地址
    private String address;

    private String description;

    private Long id;

    private String logo;

    private String name;

}
