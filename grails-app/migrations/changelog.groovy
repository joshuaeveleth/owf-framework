import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

//main changelog file
//includes other changelog files which are organized by version
databaseChangeLog = {

    // On MS SQL Server, we use numeric(19, 0) for the person id, but we use bigint everywhere else. Use this property like:
    // 	    column(name: "edited_by_id", type: '${owf.personIdType}')
    // but only use SINGLE QUOTES around the ${}, because Spring needs to do the interpretation, not Groovy.
    property([name:"owf.personIdType", value:"java.sql.Types.BIGINT", dbms:"hsqldb, postgresql, mysql, oracle"])
    property([name:"owf.personIdType", value:"numeric(19,0)", dbms:"mssql"])

    property([name:"appconfig.valColumn", value:"VALUE", dbms:"hsqldb"])
    property([name:"appconfig.valColumn", value:"value", dbms:"mysql, oracle, postgresql, mssql"])

    //previous version change logs go here
    include file: 'changelog_3.7.0.groovy'
    include file: 'changelog_3.8.0.groovy'
    include file: 'changelog_3.8.1.groovy'
    include file: 'changelog_4.0.0.groovy'
    include file: 'changelog_5.0.0.groovy'
    include file: 'changelog_6.0.0.groovy'
    include file: 'changelog_6.0.1.groovy'
    include file: 'changelog_6.0.2.groovy'
    include file: 'changelog_7.0.0.groovy'
    include file: 'changelog_7.0.1.groovy'
    include file: 'changelog_7.1.0.groovy'
    include file: 'changelog_7.2.0.groovy'
    include file: 'changelog_7.3.0.groovy'
    include file: 'changelog_7.4.0.groovy'
    include file: 'changelog_7.5.0.groovy'
    include file: 'changelog_7.6.0.groovy'
    include file: 'changelog_7.7.0.groovy'
    include file: 'changelog_7.8.0.groovy'
    include file: 'changelog_7.9.0.groovy'
    include file: 'changelog_7.10.0.groovy'
    include file: 'changelog_7.11.0.groovy'
    include file: 'changelog_7.12.0.groovy'
    include file: 'changelog_7.13.0.groovy'

    //include/exclude current version's change log based on existence of dbmBuildPreviousVersion
    if (!System.properties.dbmBuildPreviousVersion) {
      include file: "changelog_${CH.config?.server.baseVersion}.groovy"
    }
    else {
      println "Building up to the previous version of the database"
    }
}
