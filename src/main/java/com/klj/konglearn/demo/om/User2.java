package com.klj.konglearn.demo.om;

import com.klj.konglearn.tool.DateTimeFormatConstants;
import lombok.Data;
import oracle.sql.CLOB;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class User2 {

    private Long id;

    private String name;

    @DateTimeFormat(pattern = DateTimeFormatConstants.COMMON_DATETIME_FORMAT)
    private LocalDate birth;

    private String introduce;

    private String desc;




}
