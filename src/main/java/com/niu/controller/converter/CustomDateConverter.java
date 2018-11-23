package com.niu.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ami on 2018/11/22.
 * 自定义参数绑定
 * 自定义转换器:日期字符串"2018-02-03+14:56:02"转换为date
 */
@Component
public class CustomDateConverter implements Converter<String,Date> {
    private String pattern = "yyyy-MM-dd HH:mm:ss";

    @Override
    public Date convert(String source) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            return simpleDateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
     }
}
