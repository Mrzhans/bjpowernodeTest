package com.bjpowernode.test;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import com.bjpowernode.service.impl.StudentServiceImpl;
import com.bjpowernode.util.ServiceFactory;
import com.bjpowernode.util.SqlSessionUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        StudentDao studentDao = SqlSessionUtil.getSqlSession().getMapper(StudentDao.class);

        /*Student s = new Student();
        s.setName("张三");
        s.setClassroomid(1001);
        List<Map<String,String>> stulist = studentDao.selectNameAndClass(s);
        for (Map<String, String> map : stulist) {
            Set<String> set = map.keySet();
            for (String s1 : set) {
                System.out.println("key:" + s1);
                System.out.println("value:" + map.get(s1));
            }
        }*/

        String[] strArr = {"A1002","A1003","A1004"};
        List<Student> studentList = studentDao.selectByForEach(strArr);
        for (Student s : studentList) {
            System.out.println(s.toString());
        }
    }
}

