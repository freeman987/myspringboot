package com.mygroup.myproject.common;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @ClassName: PersonDTO
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/10
 * @Version 1.0
 */
@Data
public class PersonOutput {
    private Integer id;
    private String name;
    private Integer sex;
    private LocalDateTime birthday;
    private BigDecimal money;
}
