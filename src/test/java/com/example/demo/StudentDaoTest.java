package com.example.demo;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.StudentDao;
import com.example.demo.entity.Student;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class StudentDaoTest extends SingleDataSourceApplicationTests{
	private static final Logger logger = LoggerFactory.getLogger(StudentDaoTest.class);
	
	@Autowired
	private StudentDao stuDao;
	
	@Test
	public void queryStudentTest(){
		String name = "小明";
	 	List<Student> stuList =stuDao.queryStudentByName(name);
	 	logger.info("===stuList:{}",stuList.size());
	 	assertEquals(1, stuList.size());
	}
}
