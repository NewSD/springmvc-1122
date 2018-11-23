package com.niu.controller.converter;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder;

import javax.servlet.ServletRequest;

/**
 * Created by ami on 2018/11/22.
 */
public class EmptyStringToNullRequestDataBinder extends ExtendedServletRequestDataBinder {
    public EmptyStringToNullRequestDataBinder(Object target, String objectName) {
        super(target, objectName);
    }

    protected void addBindValues(MutablePropertyValues mpvs, ServletRequest request) {
        super.addBindValues(mpvs, request);
        for (PropertyValue propertyValue : mpvs.getPropertyValueList()) {
            if (propertyValue.getValue().equals(""))
                propertyValue.setConvertedValue(null);
        }
    }
}
