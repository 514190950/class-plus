package com.gxz.generator.read;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author gxz gongxuanzhang@foxmail.com
 **/
public class MethodComposition {

    private Map<String, List<MethodMap>> methodMap;

    private final static int EMPTY_CODE = Integer.MAX_VALUE;


    public MethodComposition(Method[] methods,List<MethodComment> methodComments) {
        methodMap = packMap(methods,methodComments);
    }

    public MethodPlus[] getMethods() {
        return methodMap.values().stream()
                .flatMap(Collection::stream)
                .map(MethodMap::getMethodPlus)
                .collect(Collectors.toList()).toArray(new MethodPlus[]{});
    }


    public MethodPlus select(String name, Class<?>... parameterTypes) {
        List<MethodMap> methodMaps = methodMap.get(name);
        if (methodMaps == null) {
            return null;
        }
        int code = getCode(parameterTypes);
        for (MethodMap methodMap : methodMaps) {
            if (Objects.equals(code, methodMap.code)) {
                return methodMap.methodPlus;
            }
        }
        return null;
    }

    private int getCode(Class<?>... parameterTypes) {
        if (parameterTypes == null) {
            return EMPTY_CODE;
        }
        int code = 0;
        for (int i = 0; i < parameterTypes.length; i++) {
            int index = i + 1;
            code += (parameterTypes[i].hashCode() + index) * index;
        }
        return code;
    }

    private Map<String, List<MethodMap>> packMap(Method[] methods,List<MethodComment> methodComments) {
        Map<String, List<MethodMap>> candidate = new HashMap<>();
        for (Method method : methods) {
            List<MethodMap> methodMaps = candidate.computeIfAbsent(method.getName(), k -> new ArrayList<>());
            int code = getCode(method.getParameterTypes());
            MethodMap methodMap = new MethodMap(code, new MethodPlus(method));
            methodMaps.add(methodMap);
        }
        return candidate;
    }

    @Data
    @AllArgsConstructor
    static class MethodMap {

        private int code;

        private MethodPlus methodPlus;
    }

}
