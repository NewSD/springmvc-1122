package com.niu.controller.converter;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by ami on 2018/11/23.
 */
@Component
public class EmptyStringToNull implements Converter<String,String>{
    @Override
    public String convert(String source) {
        if(StringUtils.isBlank(source)){
            return null;
        }
        return source;
    }
}
