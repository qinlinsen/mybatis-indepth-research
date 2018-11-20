/**
 * Copyright 2009-2015 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.ibatis.reflection.property;

import com.timo.domain.Student;

import java.lang.reflect.Field;

/**
 * @author Clinton Begin
 */
public final class PropertyCopier {

    private PropertyCopier() {
        // Prevent Instantiation of Static Class
    }

    /**
     * 主要是实现两个相同类型的属性之间的复制，也就是说sourceBean 和 destinationBean是同一个类型
     * @param type
     * @param sourceBean
     * @param destinationBean
     */
    public static void copyBeanProperties(Class<?> type, Object sourceBean, Object destinationBean) {
        Class<?> parent = type;
        while (parent != null) {
            final Field[] fields = parent.getDeclaredFields();
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    field.set(destinationBean, field.get(sourceBean));
                } catch (Exception e) {
                    // Nothing useful to do, will only fail on final fields, which will be ignored.
                    e.printStackTrace();
                }
            }
            parent = parent.getSuperclass();
        }
    }

    public static void main(String[] args) throws Exception {
        Student sourceBean = new Student();
        Student destBean = new Student();
        sourceBean.setName("人民");
        sourceBean.setAge(19);
       copyBeanProperties(sourceBean.getClass(),sourceBean,destBean);
    }
}
