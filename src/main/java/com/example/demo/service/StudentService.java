package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentDao;
import com.example.demo.entity.Student;

@Service
public class StudentService {
	@Autowired
	private StudentDao stuDao;

	public List<Student> queryByName(String name) {
		List<Student> res = stuDao.queryStudentByName(name);
		if (res.isEmpty()) {
			throw new RuntimeException("查无此人");
		}
		return res;
	}
}
