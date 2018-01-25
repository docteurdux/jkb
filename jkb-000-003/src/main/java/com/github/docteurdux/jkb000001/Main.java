package com.github.docteurdux.jkb000001;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class Main {

	public static void main(String[] args) throws SQLException {

		Driver driver = new Driver();

		out("Version: " + driver.getMajorVersion() + "." + driver.getMinorVersion());
		out("Driver OS Name: " + Driver.getOSName());
		out("Driver Platform: " + Driver.getPlatform());

		Properties props = new Properties();
		props.setProperty("useSSL", "false");
		props.setProperty("user", "user");
		props.setProperty("password", "user");
		props.setProperty("serverTimezone", "UTC");

		Connection connection = driver.connect("jdbc:mysql:///test", props);

		DatabaseMetaData metadata = connection.getMetaData();

		/*-
		for (Method method : DatabaseMetaData.class.getMethods()) {
			out(method.toGenericString());
		}*/

		out("Things which are true about MySQL Community Server 2.5.21 x64 for Windows ");

		out("");

		out("dataDefinitionCausesTransactionCommit ? " + metadata.dataDefinitionCausesTransactionCommit());
		out("doesMaxRowSizeIncludeBlobs ? " + metadata.doesMaxRowSizeIncludeBlobs());
		out("generatedKeyAlwaysReturned ? " + metadata.generatedKeyAlwaysReturned());
		out("isCatalogAtStart ? " + metadata.isCatalogAtStart());
		out("locatorsUpdateCopy ? " + metadata.locatorsUpdateCopy());
		out("nullPlusNonNullIsNull ? " + metadata.nullPlusNonNullIsNull());
		out("nullsAreSortedLow ? " + metadata.nullsAreSortedLow());
		out("storesLowerCaseIdentifiers ? " + metadata.storesLowerCaseIdentifiers());
		out("storesLowerCaseQuotedIdentifiers ? " + metadata.storesLowerCaseQuotedIdentifiers());
		out("storesUpperCaseQuotedIdentifiers ? " + metadata.storesUpperCaseQuotedIdentifiers());
		out("supportsANSI92EntryLevelSQL ? " + metadata.supportsANSI92EntryLevelSQL());
		out("supportsCoreSQLGrammar ? " + metadata.supportsCoreSQLGrammar());
		out("supportsAlterTableWithAddColumn ? " + metadata.supportsAlterTableWithAddColumn());
		out("supportsAlterTableWithDropColumn ? " + metadata.supportsAlterTableWithDropColumn());
		out("supportsBatchUpdates ? " + metadata.supportsBatchUpdates());
		out("supportsCatalogsInDataManipulation ? " + metadata.supportsCatalogsInDataManipulation());
		out("supportsCatalogsInIndexDefinitions ? " + metadata.supportsCatalogsInIndexDefinitions());
		out("supportsCatalogsInPrivilegeDefinitions ? " + metadata.supportsCatalogsInPrivilegeDefinitions());
		out("supportsCatalogsInProcedureCalls ? " + metadata.supportsCatalogsInProcedureCalls());
		out("supportsCatalogsInTableDefinitions ? " + metadata.supportsCatalogsInTableDefinitions());
		out("supportsColumnAliasing ? " + metadata.supportsColumnAliasing());
		out("supportsCorrelatedSubqueries ? " + metadata.supportsCorrelatedSubqueries());
		out("supportsDifferentTableCorrelationNames ? " + metadata.supportsDifferentTableCorrelationNames());
		out("supportsExpressionsInOrderBy ? " + metadata.supportsExpressionsInOrderBy());
		out("supportsGetGeneratedKeys ? " + metadata.supportsGetGeneratedKeys());
		out("supportsGroupBy ? " + metadata.supportsGroupBy());
		out("supportsGroupByBeyondSelect ? " + metadata.supportsGroupByBeyondSelect());
		out("supportsGroupByUnrelated ? " + metadata.supportsGroupByUnrelated());
		out("supportsLikeEscapeClause ? " + metadata.supportsLikeEscapeClause());
		out("supportsLimitedOuterJoins ? " + metadata.supportsLimitedOuterJoins());
		out("supportsMinimumSQLGrammar ? " + metadata.supportsMinimumSQLGrammar());
		out("supportsMultipleOpenResults ? " + metadata.supportsMultipleOpenResults());
		out("supportsMultipleResultSets ? " + metadata.supportsMultipleResultSets());
		out("supportsMultipleTransactions ? " + metadata.supportsMultipleTransactions());
		out("supportsNonNullableColumns ? " + metadata.supportsNonNullableColumns());
		out("supportsOuterJoins ? " + metadata.supportsOuterJoins());
		out("supportsSavepoints ? " + metadata.supportsSavepoints());
		out("supportsSelectForUpdate ? " + metadata.supportsSelectForUpdate());
		out("supportsStoredFunctionsUsingCallSyntax ? " + metadata.supportsStoredFunctionsUsingCallSyntax());
		out("supportsStoredProcedures ? " + metadata.supportsStoredProcedures());
		out("supportsSubqueriesInComparisons ? " + metadata.supportsSubqueriesInComparisons());
		out("supportsSubqueriesInExists ? " + metadata.supportsSubqueriesInExists());
		out("supportsSubqueriesInIns ? " + metadata.supportsSubqueriesInIns());
		out("supportsSubqueriesInQuantifieds ? " + metadata.supportsSubqueriesInQuantifieds());
		out("supportsTableCorrelationNames ? " + metadata.supportsTableCorrelationNames());
		out("supportsTransactions ? " + metadata.supportsTransactions());
		out("supportsUnion ? " + metadata.supportsUnion());
		out("supportsUnionAll ? " + metadata.supportsUnionAll());

		out("");

		out("Things which are false about MySQL Community Server 2.5.21 x64 for Windows");

		out("");

		out("isReadOnly ? " + metadata.isReadOnly());
		out("allProceduresAreCallable ? " + metadata.allProceduresAreCallable());
		out("allTablesAreSelectable ? " + metadata.allTablesAreSelectable());
		out("autoCommitFailureClosesAllResultSets ? " + metadata.autoCommitFailureClosesAllResultSets());
		out("dataDefinitionIgnoredInTransactions ? " + metadata.dataDefinitionIgnoredInTransactions());
		out("nullsAreSortedAtEnd ? " + metadata.nullsAreSortedAtEnd());
		out("nullsAreSortedAtStart ? " + metadata.nullsAreSortedAtStart());
		out("nullsAreSortedHigh ? " + metadata.nullsAreSortedHigh());
		out("storesMixedCaseIdentifiers ? " + metadata.storesMixedCaseIdentifiers());
		out("storesMixedCaseQuotedIdentifiers ? " + metadata.storesMixedCaseQuotedIdentifiers());
		out("storesUpperCaseIdentifiers ? " + metadata.storesUpperCaseIdentifiers());
		out("supportsANSI92IntermediateSQL ? " + metadata.supportsANSI92IntermediateSQL());
		out("supportsANSI92FullSQL ? " + metadata.supportsANSI92FullSQL());
		out("supportsConvert ? " + metadata.supportsConvert());
		out("supportsDataDefinitionAndDataManipulationTransactions ? "
				+ metadata.supportsDataDefinitionAndDataManipulationTransactions());
		out("supportsDataManipulationTransactionsOnly ? " + metadata.supportsDataManipulationTransactionsOnly());
		out("supportsExtendedSQLGrammar ? " + metadata.supportsExtendedSQLGrammar());
		out("supportsFullOuterJoins ? " + metadata.supportsFullOuterJoins());
		out("supportsIntegrityEnhancementFacility ? " + metadata.supportsIntegrityEnhancementFacility());
		out("supportsMixedCaseIdentifiers ? " + metadata.supportsMixedCaseIdentifiers());
		out("supportsMixedCaseQuotedIdentifiers ? " + metadata.supportsMixedCaseQuotedIdentifiers());
		out("supportsNamedParameters ? " + metadata.supportsNamedParameters());
		out("supportsOpenCursorsAcrossCommit ? " + metadata.supportsOpenCursorsAcrossCommit());
		out("supportsOpenCursorsAcrossRollback ? " + metadata.supportsOpenCursorsAcrossRollback());
		out("supportsOpenStatementsAcrossCommit ? " + metadata.supportsOpenStatementsAcrossCommit());
		out("supportsOpenStatementsAcrossRollback ? " + metadata.supportsOpenStatementsAcrossRollback());
		out("supportsOrderByUnrelated ? " + metadata.supportsOrderByUnrelated());
		out("supportsPositionedDelete ? " + metadata.supportsPositionedDelete());
		out("supportsPositionedUpdate ? " + metadata.supportsPositionedUpdate());
		out("supportsSchemasInDataManipulation ? " + metadata.supportsSchemasInDataManipulation());
		out("supportsSchemasInIndexDefinitions ? " + metadata.supportsSchemasInIndexDefinitions());
		out("supportsSchemasInPrivilegeDefinitions ? " + metadata.supportsSchemasInPrivilegeDefinitions());
		out("supportsSchemasInProcedureCalls ? " + metadata.supportsSchemasInProcedureCalls());
		out("supportsSchemasInTableDefinitions ? " + metadata.supportsSchemasInTableDefinitions());
		out("supportsStatementPooling ? " + metadata.supportsStatementPooling());
		out("usesLocalFilePerTable ? " + metadata.usesLocalFilePerTable());
		out("usesLocalFiles ? " + metadata.usesLocalFiles());

		out("");

		out("Some strings");

		out("");

		out("DatabaseProductName: " + metadata.getDatabaseProductName());
		out("DatabaseProductVersion: " + metadata.getDatabaseProductVersion());
		out("DriverName: " + metadata.getDriverName());
		out("DriverVersion: " + metadata.getDriverVersion());
		out("URL: " + metadata.getURL());
		out("UserName: " + metadata.getUserName());
		out("CatalogTerm: " + metadata.getCatalogTerm());
		out("CatalogSeparator: " + metadata.getCatalogSeparator());
		out("SchemaTerm: " + metadata.getSchemaTerm());
		out("IdentifierQuoteString: " + metadata.getIdentifierQuoteString());
		out("ProcedureTerm: " + metadata.getProcedureTerm());
		out("ExtraNameCharacters: " + metadata.getExtraNameCharacters());
		out("SearchStringEscape: " + metadata.getSearchStringEscape());
		out("NumericFunctions: " + metadata.getNumericFunctions());
		out("SQLKeywords: " + metadata.getSQLKeywords());
		out("StringFunctions: " + metadata.getStringFunctions());
		out("SystemFunctions: " + metadata.getSystemFunctions());
		out("TimeDateFunctions: " + metadata.getTimeDateFunctions());

		out("");

		out("Some integers");

		out("DatabaseMajorVersion: " + metadata.getDatabaseMajorVersion());
		out("DatabaseMinorVersion: " + metadata.getDatabaseMinorVersion());
		out("DriverMajorVersion: " + metadata.getDriverMajorVersion());
		out("DriverMinorVersion: " + metadata.getDriverMinorVersion());
		out("JDBCMajorVersion: " + metadata.getJDBCMajorVersion());
		out("JDBCMinorVersion: " + metadata.getJDBCMinorVersion());

		out("MaxConnections: " + metadata.getMaxConnections());
		out("MaxStatements: " + metadata.getMaxStatements());
		out("DefaultTransactionIsolation: " + metadata.getDefaultTransactionIsolation());

		out("SQLStateType: " + metadata.getSQLStateType());
		out("ResultSetHoldability: " + metadata.getResultSetHoldability());

		out("MaxCatalogNameLength: " + metadata.getMaxCatalogNameLength());
		out("MaxColumnNameLength: " + metadata.getMaxColumnNameLength());
		out("MaxCursorNameLength: " + metadata.getMaxCursorNameLength());
		out("MaxIndexLength: " + metadata.getMaxIndexLength());
		out("MaxProcedureNameLength: " + metadata.getMaxProcedureNameLength());
		out("MaxSchemaNameLength: " + metadata.getMaxSchemaNameLength());
		out("MaxTableNameLength: " + metadata.getMaxTableNameLength());
		out("MaxUserNameLength: " + metadata.getMaxUserNameLength());
		out("MaxStatementLength: " + metadata.getMaxStatementLength());
		out("MaxBinaryLiteralLength: " + metadata.getMaxBinaryLiteralLength());
		out("MaxCharLiteralLength: " + metadata.getMaxCharLiteralLength());
		out("MaxRowSize: " + metadata.getMaxRowSize());

		out("MaxColumnsInGroupBy: " + metadata.getMaxColumnsInGroupBy());
		out("MaxColumnsInIndex: " + metadata.getMaxColumnsInIndex());
		out("MaxColumnsInOrderBy: " + metadata.getMaxColumnsInOrderBy());
		out("MaxColumnsInSelect: " + metadata.getMaxColumnsInSelect());
		out("MaxColumnsInTable: " + metadata.getMaxColumnsInTable());
		out("MaxTablesInSelect: " + metadata.getMaxTablesInSelect());

		out("");

		out("Some result sets");

		out("");

		dumpResultSet("Catalogs", metadata.getCatalogs());
		dumpResultSet("ClientInfoProperties", metadata.getClientInfoProperties());
		dumpResultSet("Schemas", metadata.getSchemas());
		dumpResultSet("TableTypes", metadata.getTableTypes());
		dumpResultSet("TypeInfo", metadata.getTypeInfo());

		/*-
		public abstract boolean java.sql.DatabaseMetaData.updatesAreDetected(int) throws java.sql.SQLException
		
		 */

		/*-
		 * 
		public abstract boolean java.sql.DatabaseMetaData.supportsConvert(int,int) throws java.sql.SQLException
		public abstract boolean java.sql.DatabaseMetaData.supportsResultSetConcurrency(int,int) throws java.sql.SQLException
		public abstract boolean java.sql.Wrapper.isWrapperFor(java.lang.Class<?>) throws java.sql.SQLException
		
		 */

		/*-
		
		public abstract java.sql.ResultSet java.sql.DatabaseMetaData.getAttributes(java.lang.String,java.lang.String,java.lang.String,java.lang.String) throws java.sql.SQLException
		public abstract java.sql.ResultSet java.sql.DatabaseMetaData.getBestRowIdentifier(java.lang.String,java.lang.String,java.lang.String,int,boolean) throws java.sql.SQLException
		public abstract java.sql.ResultSet java.sql.DatabaseMetaData.getColumnPrivileges(java.lang.String,java.lang.String,java.lang.String,java.lang.String) throws java.sql.SQLException
		public abstract java.sql.ResultSet java.sql.DatabaseMetaData.getColumns(java.lang.String,java.lang.String,java.lang.String,java.lang.String) throws java.sql.SQLException
		public abstract java.sql.ResultSet java.sql.DatabaseMetaData.getCrossReference(java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String) throws java.sql.SQLException
		public abstract java.sql.ResultSet java.sql.DatabaseMetaData.getExportedKeys(java.lang.String,java.lang.String,java.lang.String) throws java.sql.SQLException
		public abstract java.sql.ResultSet java.sql.DatabaseMetaData.getFunctionColumns(java.lang.String,java.lang.String,java.lang.String,java.lang.String) throws java.sql.SQLException
		public abstract java.sql.ResultSet java.sql.DatabaseMetaData.getFunctions(java.lang.String,java.lang.String,java.lang.String) throws java.sql.SQLException
		public abstract java.sql.ResultSet java.sql.DatabaseMetaData.getImportedKeys(java.lang.String,java.lang.String,java.lang.String) throws java.sql.SQLException
		public abstract java.sql.ResultSet java.sql.DatabaseMetaData.getIndexInfo(java.lang.String,java.lang.String,java.lang.String,boolean,boolean) throws java.sql.SQLException
		public abstract java.sql.ResultSet java.sql.DatabaseMetaData.getPrimaryKeys(java.lang.String,java.lang.String,java.lang.String) throws java.sql.SQLException
		public abstract java.sql.ResultSet java.sql.DatabaseMetaData.getProcedureColumns(java.lang.String,java.lang.String,java.lang.String,java.lang.String) throws java.sql.SQLException
		public abstract java.sql.ResultSet java.sql.DatabaseMetaData.getProcedures(java.lang.String,java.lang.String,java.lang.String) throws java.sql.SQLException
		public abstract java.sql.ResultSet java.sql.DatabaseMetaData.getPseudoColumns(java.lang.String,java.lang.String,java.lang.String,java.lang.String) throws java.sql.SQLException
		public abstract java.sql.ResultSet java.sql.DatabaseMetaData.getSchemas(java.lang.String,java.lang.String) throws java.sql.SQLException
		public abstract java.sql.ResultSet java.sql.DatabaseMetaData.getSuperTables(java.lang.String,java.lang.String,java.lang.String) throws java.sql.SQLException
		public abstract java.sql.ResultSet java.sql.DatabaseMetaData.getSuperTypes(java.lang.String,java.lang.String,java.lang.String) throws java.sql.SQLException
		public abstract java.sql.ResultSet java.sql.DatabaseMetaData.getTablePrivileges(java.lang.String,java.lang.String,java.lang.String) throws java.sql.SQLException
		public abstract java.sql.ResultSet java.sql.DatabaseMetaData.getTables(java.lang.String,java.lang.String,java.lang.String,java.lang.String[]) throws java.sql.SQLException
		public abstract java.sql.ResultSet java.sql.DatabaseMetaData.getUDTs(java.lang.String,java.lang.String,java.lang.String,int[]) throws java.sql.SQLException
		public abstract java.sql.ResultSet java.sql.DatabaseMetaData.getVersionColumns(java.lang.String,java.lang.String,java.lang.String) throws java.sql.SQLException
		
		 */

		
		
		/*-
		
		public abstract java.sql.Connection java.sql.DatabaseMetaData.getConnection() throws java.sql.SQLException
		public default long java.sql.DatabaseMetaData.getMaxLogicalLobSize() throws java.sql.SQLException
		public abstract java.sql.RowIdLifetime java.sql.DatabaseMetaData.getRowIdLifetime() throws java.sql.SQLException
		public default boolean java.sql.DatabaseMetaData.supportsRefCursors() throws java.sql.SQLException
		public abstract <T> T java.sql.Wrapper.unwrap(java.lang.Class<T>) throws java.sql.SQLException
		
		 */

	}

	private static void dumpResultSet(String name, ResultSet rs) throws SQLException {
		out(name);
		// out("Cursor name: " + rs.getCursorName());
		// out("Holdability: " + rs.getHoldability());
		ResultSetMetaData m = rs.getMetaData();
		int count = m.getColumnCount();
		for (int c = 1; c <= count; ++c) {
			out(m.getColumnName(c) + " : " + typeToString(m.getColumnType(c)));
		}
		while (rs.next()) {
			for (int c = 1; c <= count; ++c) {
				int type = m.getColumnType(c);
				switch (type) {
				case java.sql.Types.INTEGER:
				case java.sql.Types.SMALLINT:
					out(" - " + rs.getInt(c));
					break;
				case java.sql.Types.BOOLEAN:
					out(" - " + rs.getBoolean(c));
					break;
				case java.sql.Types.VARCHAR:
				case java.sql.Types.CHAR:
					out(" - " + rs.getString(c));
					break;
				default:
					break;
				}
			}
			out("");
		}
	}

	private static String typeToString(int type) {
		try {
			for (Field f : java.sql.Types.class.getFields()) {
				if (Modifier.isStatic(f.getModifiers()) && int.class.isAssignableFrom(f.getType())) {
					if (Integer.class.cast(f.get(null)) == type) {
						return f.getName();
					}
				}
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		throw new RuntimeException("Unknown type " + type);
	}

	private static void out(Object data) {
		System.out.println(data);
	}

}
