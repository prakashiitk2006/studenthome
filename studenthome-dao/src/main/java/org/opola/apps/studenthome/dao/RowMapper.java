package org.opola.apps.studenthome.dao;

public interface RowMapper<T> {
	T mapRow(Row pRow);
}
