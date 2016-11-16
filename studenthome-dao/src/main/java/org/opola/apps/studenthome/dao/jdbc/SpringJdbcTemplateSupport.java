package org.opola.apps.studenthome.dao.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class SpringJdbcTemplateSupport {
	private DataSource mDataSource;
	private SimpleJdbcTemplate mJdbcTemplate;

	@Autowired
	public void setDataSource(@Qualifier("applicationDB") DataSource pDataSource) {
		this.mJdbcTemplate = new SimpleJdbcTemplate(
				this.mDataSource = pDataSource);
	}

	protected final DataSource getDataSource() {
		return this.mDataSource;
	}

	protected final SimpleJdbcTemplate getSimpleJdbcTemplate() {
		return this.mJdbcTemplate;
	}
}