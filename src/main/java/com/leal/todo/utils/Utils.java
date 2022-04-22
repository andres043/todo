package com.leal.todo.utils;

import com.leal.todo.exception.errors.Errors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Utils {

    private Utils() {
        throw new IllegalStateException(Errors.UTILITY_CLASS.getValue());
    }

    public static void copyProperties(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        Set<String> emptyNames = new HashSet<>();
        Arrays.stream(src.getPropertyDescriptors()).forEach(propertyDescriptor -> {
            if (src.getPropertyValue(propertyDescriptor.getName()) == null)
                emptyNames.add(propertyDescriptor.getName());
        });

        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
