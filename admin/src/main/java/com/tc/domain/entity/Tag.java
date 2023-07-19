package com.tc.domain.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 标签(Tag)表实体类
 *
 * @author makejava
 * @since 2023-05-16 23:33:55
 */
@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value="sg_tag")
public class Tag {
    
    private Long id;
    //标签名
    private String name;
    
    private Long createBy;
    
    private Date createTime;
    
    private Long updateBy;
    
    private Date updateTime;
    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;
    //备注
    private String remark;


}

