package org.opola.apps.studenthome.dao;

public class TableInformation {
	public enum Table {
		STUDENT_INFO("SH_STUDENT_INFO");
		
		private String tableName;
		
		private Table(String pTableName) {
			tableName = pTableName;
		}
		
		public String getTableName() {
			return tableName;
		}
	}
	
	public enum StudentTableColumn {
		ID("ID"),
		NAME("NAME");
		private String columnName;
		private StudentTableColumn(String pColumnName) {
			columnName = pColumnName;
		}
		public String getColumnName() {
			return columnName;
		}
	}

}
