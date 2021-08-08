package com.bjpowernode.service.impl;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import com.bjpowernode.util.SqlSessionUtil;

public class StudentServiceImpl implements StudentService {

    StudentDao studentDao = SqlSessionUtil.getSqlSession().getMapper(StudentDao.class);
    @Override
    public Student selectById(String id) {

        Student s = studentDao.selectById(id);

        return s;
    }

    @Override
    public int save(Student s) {
        int count = studentDao.save(s);
        return count;
    }
}
