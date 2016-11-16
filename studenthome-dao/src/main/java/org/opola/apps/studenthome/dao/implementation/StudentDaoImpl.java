package org.opola.apps.studenthome.dao.implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.opola.apps.studenthome.dao.StudentDao;
import org.opola.apps.studenthome.dao.TableInformation.StudentTableColumn;
import org.opola.apps.studenthome.dao.TableInformation.Table;
import org.opola.apps.studenthome.dao.support.DaoSupport;
import org.opola.apps.studenthome.domain.model.Student;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class StudentDaoImpl extends DaoSupport<Student> implements StudentDao {
	private static final Log LOG = LogFactory.getLog(StudentDaoImpl.class);
	@Override
	public long insert(Student pStudent) {
		long myNextStudentId = getNextSeqNumber("SH_STUDENT_ID_SEQ");
		String myInsertSQL = "INSERT INTO SH_STUDENT_INFO (ID, NAME) VALUES (:id, :name)";
		MapSqlParameterSource mySqlParameterSource = new MapSqlParameterSource();
		mySqlParameterSource.addValue("id", myNextStudentId);
		mySqlParameterSource.addValue("name", pStudent.getName());
		performInsertion(myInsertSQL, mySqlParameterSource);
		return myNextStudentId;
	}

	@Override
	public void update(Student pObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student findBy(long pStudentId) {
		String myFindByIdQuery = "SELECT " + StudentTableColumn.ID.getColumnName() + "," + StudentTableColumn.NAME.getColumnName() + " FROM " + Table.STUDENT_INFO.getTableName() + " WHERE " + StudentTableColumn.ID.getColumnName() +  "= :" + StudentTableColumn.ID.getColumnName();
		MapSqlParameterSource mySqlParameterSource = new MapSqlParameterSource();
		mySqlParameterSource.addValue(StudentTableColumn.ID.getColumnName(), pStudentId);
		List<Student> myStudents = performQuery(myFindByIdQuery, mySqlParameterSource, getStudentRowMapper());
		return (myStudents != null && myStudents.size() == 1) ? myStudents.get(0) : null;
	}
	
	private ParameterizedRowMapper<Student> getStudentRowMapper() {
		return new ParameterizedRowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet pResultSet, int pRowNum) throws SQLException {
				Student myStudent = new Student();
				myStudent.setId(pResultSet.getLong(StudentTableColumn.ID.getColumnName()));
				myStudent.setName(pResultSet.getString(StudentTableColumn.NAME.getColumnName()));
				return myStudent;
			}
		};
	}

	@Override
	public void delete(Student pObject) {
		// TODO Auto-generated method stub
		
	}
}
