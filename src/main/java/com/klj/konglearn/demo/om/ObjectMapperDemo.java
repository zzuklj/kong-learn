package com.klj.konglearn.demo.om;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.klj.konglearn.tool.DateTimeFormatConstants;
import oracle.jdbc.internal.OracleResultSet;
import oracle.sql.CLOB;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static com.klj.konglearn.tool.DateTimeFormatConstants.NORM_DATE_PATTERN;

/**
 * @author 0
 */
public class ObjectMapperDemo {

    static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.setDateFormat(new SimpleDateFormat(DateTimeFormatConstants.COMMON_DATETIME_FORMAT));
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDate.class,
                new LocalDateSerializer(DateTimeFormatter.ofPattern(NORM_DATE_PATTERN)));
        javaTimeModule.addSerializer(CLOB.class, getSerializer());
        objectMapper.registerModule(javaTimeModule);
    }

    private static JsonSerializer<CLOB> getSerializer() {
        return new JsonSerializer<CLOB>() {
            @Override
            public void serialize(CLOB value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
                StringBuilder builder = new StringBuilder();
                if (Objects.nonNull(value)) {
                    Reader rd = null;
                    try {
                        rd = value.getCharacterStream();
                        char[] str = new char[12];
                        while (rd.read(str) != -1) {
                            builder.append(new String(str));
                        }
                    } catch (Exception throwables) {

                    }
                }
                gen.writeString(builder.toString());
            }
        };

    }



    public static void main(String[] args) throws JsonProcessingException, SQLException {
        User user = new User();
        user.setId(1L);
        user.setName("klj");
        user.setBirth(LocalDate.now());
        user.setIntroduce("kljkls");

        OperateOracle operateOracle = new OperateOracle();
        Connection connection = operateOracle.getConnection();
        String sql = "select SFDI_JJ from b_dj_sfdi where ROWNUM < 2";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rss = stmt.executeQuery();
        if (rss.next()) {
            CLOB clob = ((OracleResultSet) rss).getCLOB(1);
            user.setDesc(clob);
            //desc.putString(1,"fdjaslfkjsakjf");
        }

        String s = objectMapper.writeValueAsString(user);
        System.out.println(s);

    }


}
