package com.klj.konglearn.tool;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EnumSqlCreate {
    public static void main(String[] args) {
        String templateSql = "INSERT INTO `user_center`.`sys_category`(`id`, `code`, `name`, `parent_id`, `enum_desc`, `extension`, `is_deleted`, `modify_by`, `modify_at`, `external_ext`) " +
                "VALUES (%d, '', '%s', %d, '%s', NULL, 0, 'klj', '%s', NULL);";

        String names = "每年年审、正常、间歇";

        printSql(10602221, names.split("、"),10602220, templateSql);

    }

    private static void printSql(int beginIndex,
                                  String[] name,
                                  int parentId,
                                  String template){
        String datetime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        for(int i = 0; i<name.length;i++){
            System.out.println(String.format(template,
                    beginIndex+i,
                    name[i],
                    parentId,
                    name[i],
                    datetime));
        }

    }

}
