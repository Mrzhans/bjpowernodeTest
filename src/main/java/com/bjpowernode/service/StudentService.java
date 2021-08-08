package com.bjpowernode.service;

import com.bjpowernode.domain.Student;

public interface StudentService {
    Student selectById(String id);

    int save(Student s);
}
