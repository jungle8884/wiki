package com.jungle.utils.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

@Data
public class ExcelEntity {
    @Excel(name = "name")
    private String name;
}
