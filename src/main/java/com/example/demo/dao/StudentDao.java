package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Student;
@Mapper
public interface StudentDao {
	List<Student> queryStudentByName(String name);
}
