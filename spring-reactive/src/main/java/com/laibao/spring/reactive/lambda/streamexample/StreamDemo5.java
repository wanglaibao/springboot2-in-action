package com.laibao.spring.reactive.lambda.streamexample;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamDemo5 {

    private static List<Student> studentList;

    static {
        studentList = Arrays.asList(
                new Student("小明",10,Gender.MALE,Grade.ONE),
                new Student("大明",9,Gender.MALE,Grade.THREE),
                new Student("小白",8,Gender.FEMALE,Grade.TWO),
                new Student("小黑",13,Gender.FEMALE,Grade.FOUR),
                new Student("小红",7,Gender.FEMALE,Grade.FIVE),
                new Student("小黄",13,Gender.MALE,Grade.FOUR),
                new Student("小青",13,Gender.FEMALE,Grade.THREE),
                new Student("小紫",9,Gender.FEMALE,Grade.TWO),
                new Student("小王",6,Gender.MALE,Grade.SIX),
                new Student("小李",6,Gender.MALE,Grade.FOUR),
                new Student("小马",14,Gender.FEMALE,Grade.FIVE),
                new Student("小刘",13,Gender.MALE,Grade.FOUR));
    }
    public static void main(String[] args) {

        //获得所有学生的年龄列表
        studentList.stream().map(Student::getAge).collect(Collectors.toList());


        IntSummaryStatistics intSummaryStatistics = studentList.stream().collect(Collectors.summarizingInt(Student::getAge));
        System.out.println(intSummaryStatistics);
        System.out.println();

        //分区
        Map<Boolean,List<Student>> listMap = studentList.stream().collect(Collectors.partitioningBy(student -> student.getGender() == Gender.FEMALE));

        //分组
        Map<Grade,List<Student>> gradeListMap = studentList.stream().collect(Collectors.groupingBy(Student::getGrade));
    }
}
