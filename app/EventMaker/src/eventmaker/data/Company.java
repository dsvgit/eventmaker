/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmaker.data;

import org.apache.commons.lang3.Validate;
/**
 *
 * @author dsvma_000
 */
public class Company extends Entity {
    private String id;
    private String name;
    private String description;
    private String organazer;
    
    public Company(final String id,final String name,final String description,final String organazer) {
        Validate.notNull(id, "id is required");
        Validate.notNull(name, "name is required");
        Validate.notNull(description, "description is required");
        Validate.notNull(organazer, "organazer is required");
        
        this.id = id;
        this.name = name;
        this.description = description;
        this.organazer = organazer;
    }
    
    public String getOrganazer() {
        return organazer;
    }

    public void setOrganazer(String organazer) {
        this.organazer = organazer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }      

    @Override
    Object getIdentifier() {
        return id;
    }
}
