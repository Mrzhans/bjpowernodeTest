package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    Student selectById(String id);

    int save(Student s);

    List<Map<String,String>> selectNameAndClass(Student s);

    List<Student> selectByForEach(String[] strArr);
}
