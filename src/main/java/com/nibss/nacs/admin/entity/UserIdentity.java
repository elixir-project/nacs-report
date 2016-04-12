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
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 *
 * @author oogunjimi
 */
@Entity
@Table(name = "user_identity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserIdentity.findAll", query = "SELECT u FROM UserIdentity u")})
public class UserIdentity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Long userId;
    @Basic(optional = false)
    @Column(name = "access_count")
    private int accessCount;
    @Column(name = "created_by")
    private BigInteger createdBy;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Column(name = "first_accessed_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date firstAccessedDate;
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "flag")
    private String flag;
    @Column(name = "last_accessed_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastAccessedDate;
    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "last_password_change_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastPasswordChangeDate;
    @Column(name = "password")
    private String password;
    @Column(name = "phone_no")
    private String phoneNo;
    @OneToMany(mappedBy = "eventBy", fetch = FetchType.LAZY)
    private List<ActivityLog> activityLogList;
    @JoinColumn(name = "institution", referencedColumnName = "institution_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Institution institution;
    @JoinColumn(name = "user_role", referencedColumnName = "user_role_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UserRole userRole;

    public UserIdentity() {
    }

    public UserIdentity(Long userId) {
        this.userId = userId;
    }

    public UserIdentity(Long userId, int accessCount, String email, String firstName, String flag, String lastName) {
        this.userId = userId;
        this.accessCount = accessCount;
        this.email = email;
        this.firstName = firstName;
        this.flag = flag;
        this.lastName = lastName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getAccessCount() {
        return accessCount;
    }

    public void setAccessCount(int accessCount) {
        this.accessCount = accessCount;
    }

    public BigInteger getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(BigInteger createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFirstAccessedDate() {
        return firstAccessedDate;
    }

    public void setFirstAccessedDate(Date firstAccessedDate) {
        this.firstAccessedDate = firstAccessedDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Date getLastAccessedDate() {
        return lastAccessedDate;
    }

    public void setLastAccessedDate(Date lastAccessedDate) {
        this.lastAccessedDate = lastAccessedDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getLastPasswordChangeDate() {
        return lastPasswordChangeDate;
    }

    public void setLastPasswordChangeDate(Date lastPasswordChangeDate) {
        this.lastPasswordChangeDate = lastPasswordChangeDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @XmlTransient
    public List<ActivityLog> getActivityLogList() {
        return activityLogList;
    }

    public void setActivityLogList(List<ActivityLog> activityLogList) {
        this.activityLogList = activityLogList;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserIdentity)) {
            return false;
        }
        UserIdentity other = (UserIdentity) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getClass().getName()+"[ userId=" + userId + " ]";
    }
    
}
