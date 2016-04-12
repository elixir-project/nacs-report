/*
 * Copyright 2014 NIBSS
 * http://www.nibss-plc.com.ng
 * 
 */
package com.nibss.nacs.admin.entity;

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
@Table(name = "user_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserRole.findAll", query = "SELECT u FROM UserRole u")})
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_role_id")
    private Long userRoleId;
    @Basic(optional = false)
    @Column(name = "flag")
    private String flag;
    @Lob
    @Column(name = "role_config")
    private String roleConfig;
    @Basic(optional = false)
    @Column(name = "user_role_name")
    private String userRoleName;
    @JoinColumn(name = "institution_type", referencedColumnName = "institution_type_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private InstitutionType institutionType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userRole", fetch = FetchType.LAZY)
    private List<UserIdentity> userIdentityList;

    public UserRole() {
    }

    public UserRole(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public UserRole(Long userRoleId, String flag, String userRoleName) {
        this.userRoleId = userRoleId;
        this.flag = flag;
        this.userRoleName = userRoleName;
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getRoleConfig() {
        return roleConfig;
    }

    public void setRoleConfig(String roleConfig) {
        this.roleConfig = roleConfig;
    }

    public String getUserRoleName() {
        return userRoleName;
    }

    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }

    public InstitutionType getInstitutionType() {
        return institutionType;
    }

    public void setInstitutionType(InstitutionType institutionType) {
        this.institutionType = institutionType;
    }

    @XmlTransient
    public List<UserIdentity> getUserIdentityList() {
        return userIdentityList;
    }

    public void setUserIdentityList(List<UserIdentity> userIdentityList) {
        this.userIdentityList = userIdentityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userRoleId != null ? userRoleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRole)) {
            return false;
        }
        UserRole other = (UserRole) object;
        if ((this.userRoleId == null && other.userRoleId != null) || (this.userRoleId != null && !this.userRoleId.equals(other.userRoleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getClass().getName()+"[ userRoleId=" + userRoleId + " ]";
    }
    
}
