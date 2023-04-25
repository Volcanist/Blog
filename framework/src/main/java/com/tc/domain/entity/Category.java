package com.tc.domain.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 分类表(Category)表实体类
 *
 * @author Volcano
 * @since 2023-04-17 10:58:27
 */
@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value="sg_category")
public class Category {
    
    private Long id;
    //分类名
    private String name;
    //父分类id，如果没有父分类为-1
    private Long pid;
    //描述
    private String description;
    //状态0:正常,1禁用
    private String status;
    
    private Long createBy;
    
    private Date createTime;
    
    private Long updateBy;
    
    private Date updateTime;
    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;


}

