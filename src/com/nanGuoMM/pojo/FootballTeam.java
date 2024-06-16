package com.nanGuoMM.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FootballTeam {
    // id 主键
    private Integer id;
    // 球队名称
    private String teamName;
    // 球队位置
    private String location;
    // 排序字段
    private Integer ordered;
    // 描述信息
    private String description;
    // 状态：0：禁用  1：启用
    private Integer status;
}
