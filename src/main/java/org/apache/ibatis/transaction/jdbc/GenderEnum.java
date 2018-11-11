package org.apache.ibatis.transaction.jdbc;

public enum GenderEnum {
    MALE("male",0),
    FEMALE("female",1),;

    GenderEnum(String gender,int value) {
    }

    public static void main(String[] args) {
        System.out.println(GenderEnum.MALE);
    }
}
