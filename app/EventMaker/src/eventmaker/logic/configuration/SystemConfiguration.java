/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmaker.logic.configuration;

/**
 *
 * @author dsvma_000
 */
public class SystemConfiguration {
    private final String name;
    private final String dbUrl;
    private final String dbName;

    public SystemConfiguration(final String name, final String dbUrl, final String dbName) {
        this.name = name;
        this.dbUrl = dbUrl;
        this.dbName = dbName;
    }

    public String getName() {
        return name;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbName() {
        return dbName;
    }
    
    
}
