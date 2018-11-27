package com.timo.domain;

/**
 * @author Abraham Qin
 * @since 2018/11/17
 */
public class MiddleStudent extends Student{
    private String color;
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static void main(String[] args) {
        System.out.println(Student.class.isAssignableFrom(MiddleStudent.class));
    }
}
