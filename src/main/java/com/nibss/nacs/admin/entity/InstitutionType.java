/*
 * Copyright 2014 NIBSS
 * http://www.nibss-plc.com.ng
 * 
 */
package com.nibss.nacs.admin.entity;

import com.nibss.hawk.admin.entity.Fee;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author oogunjimi
 */
@Entity
@Table(name = "institution_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InstitutionType.findAll", query = "SELECT i FROM InstitutionType i")})
public class InstitutionType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "institution_type_id")
    private Long institutionTypeId;
    @Basic(optional = false)
    @Column(name = "institution_type_name")
    private String institutionTypeName;
    @OneToMany(mappedBy = "institutionType", fetch = FetchType.LAZY)
    private List<Role> roleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "institutionType", fetch = FetchType.LAZY)
    private List<Fee> feeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "institutionType", fetch = FetchType.LAZY)
    private List<Institution> institutionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "institutionType", fetch = FetchType.LAZY)
    private List<UserRole> userRoleList;

    public InstitutionType() {
    }

    public InstitutionType(Long institutionTypeId) {
        this.institutionTypeId = institutionTypeId;
    }

    public InstitutionType(Long institutionTypeId, String institutionTypeName) {
        this.institutionTypeId = institutionTypeId;
        this.institutionTypeName = institutionTypeName;
    }

    public Long getInstitutionTypeId() {
        return institutionTypeId;
    }

    public void setInstitutionTypeId(Long institutionTypeId) {
        this.institutionTypeId = institutionTypeId;
    }

    public String getInstitutionTypeName() {
        return institutionTypeName;
    }

    public void setInstitutionTypeName(String institutionTypeName) {
        this.institutionTypeName = institutionTypeName;
    }

    @XmlTransient
    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @XmlTransient
    public List<Fee> getFeeList() {
        return feeList;
    }

    public void setFeeList(List<Fee> feeList) {
        this.feeList = feeList;
    }

    @XmlTransient
    public List<Institution> getInstitutionList() {
        return institutionList;
    }

    public void setInstitutionList(List<Institution> institutionList) {
        this.institutionList = institutionList;
    }

    @XmlTransient
    public List<UserRole> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<UserRole> userRoleList) {
        this.userRoleList = userRoleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (institutionTypeId != null ? institutionTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstitutionType)) {
            return false;
        }
        InstitutionType other = (InstitutionType) object;
        if ((this.institutionTypeId == null && other.institutionTypeId != null) || (this.institutionTypeId != null && !this.institutionTypeId.equals(other.institutionTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getClass().getName()+"[ institutionTypeId=" + institutionTypeId + " ]";
    }
    
}
