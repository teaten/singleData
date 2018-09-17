package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studService;
	
	@GetMapping("/queryByname")
	public Student getStudentByName(@RequestParam("name") String name) {
	 List<Student> stuList=	studService.queryByName(name);
	 return stuList.get(0);
	}
	
	@GetMapping("/queryByname2")
	public Map<String,Object> getStudentByName2(@RequestParam("name") String name) {
		Map<String,Object> resMap =new HashMap<>();
	 List<Student> stuList=	studService.queryByName(name);
	 resMap.put(name, stuList.get(0));
	 return resMap;
	}
	
	@GetMapping("/queryByname3")
	public Object getStudentByName3(@RequestParam("name") String name) {
	 List<Student> stuList=	studService.queryByName(name);
	 return stuList;
	}
}
