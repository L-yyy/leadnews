package com.heima.model.admin.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class AdChannelDto {

    /**
     * 频道名称
     */
    private String name;

    /**
     * 描述信息
     */
    private String description;

    /**
     * 是否默认频道
     */
    private Boolean isDefault;

    /**
     * 启用状态
     */
    private Boolean status;

    /**
     * 排序等级
     */
    private Integer ord;

    /**
     * 创建时间
     */
    private Date createdTime;

}
