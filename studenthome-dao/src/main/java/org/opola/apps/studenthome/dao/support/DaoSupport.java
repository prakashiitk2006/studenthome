package org.opola.apps.studenthome.dao.support;

import java.util.List;

import org.opola.apps.studenthome.dao.jdbc.SpringJdbcTemplateSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public abstract class DaoSupport<T> extends SpringJdbcTemplateSupport {

	protected DaoSupport() {

	}
	
	public class SequenceProvider {
		private final String sql;

		public SequenceProvider(String sequence) {
			this.sql = ("select nextval('" + sequence + "')");
		}

		public Long get() {
			Long toReturn = Long.valueOf(getSimpleJdbcTemplate().queryForLong(this.sql));
			return toReturn;
		}
	}
	
	protected long getNextSeqNumber(String pSequenceName) {
		return this.new SequenceProvider(pSequenceName).get();
	}
	protected void performInsertion(String pSQL,
			SqlParameterSource pSqlParameterSource) {
		getSimpleJdbcTemplate().update(pSQL, pSqlParameterSource);

	}

	protected void performUpdation(String pSQL,
			SqlParameterSource pSqlParameterSource) {
		getSimpleJdbcTemplate().update(pSQL, pSqlParameterSource);
	}

	protected List<T> performQuery(String pSQL,
			SqlParameterSource pSqlParameterSource,
			ParameterizedRowMapper<T> pRowMapper) {
		List<T> myResults = getSimpleJdbcTemplate().query(pSQL, pRowMapper,
				pSqlParameterSource);
		return myResults;
	}
}
