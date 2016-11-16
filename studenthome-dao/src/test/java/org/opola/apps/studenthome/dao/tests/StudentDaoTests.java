package org.opola.apps.studenthome.dao.tests;

import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.opola.apps.studenthome.dao.StudentDao;
import org.opola.apps.studenthome.domain.model.Student;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentDaoTests extends TestBase{
	private static final Log LOG = LogFactory.getLog(StudentDaoTests.class);
	@Autowired
	private StudentDao studentDao;
	@Test
	public void testInsert() {
		Student myStudent = new Student();
		studentDao.insert(myStudent);
	}
	@Test
	public void testFindBy() {
		studentDao.findBy(4);
	}
	
	@Test
	public void testDao() {
		Student myStudent = new Student();
		myStudent.setName("First-Student");
		long myStudentId = studentDao.insert(myStudent);
		myStudent = studentDao.findBy(myStudentId);
		Assert.assertNotNull(myStudent);
		LOG.debug("Fetched Student Information: Id = " + myStudent.getId() + ", Name = " + myStudent.getName());
	}
	
}
