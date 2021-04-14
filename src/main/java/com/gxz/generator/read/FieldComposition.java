package com.gxz.generator.read;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gxz gongxuanzhang@foxmail.com
 **/
public class FieldComposition {

    private Map<String, FieldPlus> fieldMap;

    public FieldComposition(Field[] fields) {
            fieldMap = new HashMap<>();
        for (Field field : fields) {
            fieldMap.put(field.getName(),new FieldPlus(field));
        }
    }

    public FieldPlus[] getFiles() {
        return fieldMap.values().toArray(new FieldPlus[]{});
    }


    public FieldPlus select(String name) {
        return fieldMap.get(name);
    }


}
