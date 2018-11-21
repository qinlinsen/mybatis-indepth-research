package com.timo.reflect;

import com.timo.domain.Student;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.Reflector;
import org.apache.ibatis.reflection.invoker.Invoker;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author Abraham Qin
 * @since 2018/11/17
 */
public class ReflectTest {
    public static void main(String[] args) throws Exception{
        DefaultReflectorFactory defaultReflectorFactory = new DefaultReflectorFactory();
        Reflector studentReflector = defaultReflectorFactory.findForClass(Student.class);
        System.out.println(studentReflector.hasSetter("name"));
        Invoker nameGetInvoker = studentReflector.getGetInvoker("name");
        Student student = (Student) studentReflector.getDefaultConstructor().newInstance();
        student.setName("ouyangfeng");
        studentReflector.getSetInvoker("name").invoke(student,new String[]{"洪七公"});
        Object name = nameGetInvoker.invoke(student, null);
        System.out.println(name);

        System.out.println(student.getClass().getTypeName());
        System.out.println(student.getClass().getName());
        System.out.println(student.getClass().getSimpleName());
        ArrayList<Student> students = new ArrayList<>();
        Class<? extends ArrayList> aClass =  (students.getClass());

    }
}
