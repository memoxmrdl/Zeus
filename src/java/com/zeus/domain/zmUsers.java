/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.domain;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
        
/**
 *
 * @author Guillermo
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
@XmlRootElement(name="zmUsers")
public class zmUsers implements Serializable {
    
    @XmlTransient
    private static final long serialVersionUID = 1L;
    
    @XmlAttribute
    private String user_id;
    
    @XmlAttribute
    private String name;
    
    @XmlAttribute
    private String type_user;
    
    @XmlAttribute
    private String name_alias;
    
    @XmlAttribute
    private String email;
    
    public void setUserId(String user_id) {
        this.user_id = user_id;
    }
    
    public String getUserId() {
        return this.user_id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setTypeUser(String type_user) {
        this.type_user = type_user;
    }
    
    public String getTypeUser() {
        return this.type_user;
    }
    
    public void setNameAlias(String name_alias) {
        this.name_alias = name_alias;
    }
    
    public String getNameAlias() {
        return this.name_alias;
    }
    
    public void setEmail(String email) {
        this.email = email;
    } 
    
    public String getEmail() {
        return this.email;
    }
    
}
