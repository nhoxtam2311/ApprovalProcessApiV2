package com.iu.approval.api.configurations

import org.hibernate.dialect.Dialect
import org.hibernate.dialect.identity.IdentityColumnSupport
import org.hibernate.dialect.identity.IdentityColumnSupportImpl
import org.hibernate.MappingException

import java.sql.Types

class SQLiteDialect extends Dialect {

	public SQLiteDialect() {
		registerColumnType(Types.BIT, "integer")
		registerColumnType(Types.TINYINT, "tinyint")
		registerColumnType(Types.SMALLINT, "smallint")
		registerColumnType(Types.INTEGER, "integer")
		registerColumnType(Types.BIGINT, "bigint")
		registerColumnType(Types.FLOAT, "float")
		registerColumnType(Types.REAL, "real")
		registerColumnType(Types.DOUBLE, "double")
		registerColumnType(Types.NUMERIC, "numeric")
		registerColumnType(Types.DECIMAL, "decimal")
		registerColumnType(Types.CHAR, "char")
		registerColumnType(Types.VARCHAR, "varchar")
		registerColumnType(Types.LONGVARCHAR, "longvarchar")
		registerColumnType(Types.DATE, "date")
		registerColumnType(Types.TIME, "time")
		registerColumnType(Types.TIMESTAMP, "timestamp")
		registerColumnType(Types.BINARY, "blob")
		registerColumnType(Types.VARBINARY, "blob")
		registerColumnType(Types.LONGVARBINARY, "blob")
		registerColumnType(Types.BLOB, "blob")
		registerColumnType(Types.CLOB, "clob")
		registerColumnType(Types.BOOLEAN, "integer")
	}

	IdentityColumnSupport getIdentityColumnSupport() {
		new SQLiteIdentityColumnSupport()
	}

	boolean hasAlterTable() {
		false
	}

	boolean dropConstraints() {
		false
	}

	String getDropForeignKeyString() {
		""
	}

	String getAddForeignKeyConstraintString(String constraintName, String[] foreignKey, String referencedTable, String[] primaryKey, boolean referencesPrimaryKey) {
		""
	}

	String getAddPrimaryKeyConstraintString(String constraintName) {
		""
	}

	String getForUpdateString() {
		""
	}

	String getAddColumnString() {
		"add column"
	}

	boolean supportsOuterJoinForUpdate() {
		false
	}

	boolean supportsIfExistsBeforeTableName() {
		true
	}

	boolean supportsCascadeDelete() {
		false
	}
}

class SQLiteIdentityColumnSupport extends IdentityColumnSupportImpl {

	@Override
	boolean supportsIdentityColumns() {
		true
	}

	@Override
	String getIdentitySelectString(String table, String column, int type) throws MappingException {
		"select last_insert_rowid()"
	}

	@Override
	String getIdentityColumnString(int type) throws MappingException {
		"integer"
	}
}