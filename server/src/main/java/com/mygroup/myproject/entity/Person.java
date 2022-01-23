package com.mygroup.myproject.entity;

import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name="testtable")
public class  Person implements Serializable {
    private static final long serialVersionUID = -2740914841645370161L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer sex;
    private LocalDateTime birthday;

    @Min(value=100,message="钱太少")
    private BigDecimal money;
}
