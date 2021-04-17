package com.gxz.generator.read;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author gxz gongxuanzhang@foxmail.com
 **/
public class FieldComposition {

    private Map<String, FieldPlus> fieldMap;

    public FieldComposition(Field[] fields, List<FieldComment> comments) {
        fieldMap = new HashMap<>();
        for (Field field : fields) {
            FieldComment hitComment = null;
            for (FieldComment comment : comments) {
                if (Objects.equals(field.getName(), comment.getName())) {
                    hitComment = comment;
                    break;
                }
            }
            fieldMap.put(field.getName(), new FieldPlus(field, hitComment));

        }
    }

    public FieldPlus[] getFiles() {
        return fieldMap.values().toArray(new FieldPlus[]{});
    }


    public FieldPlus select(String name) {
        return fieldMap.get(name);
    }


}
