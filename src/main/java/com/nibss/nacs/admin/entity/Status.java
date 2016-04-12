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
@Table(name = "status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Status.findAll", query = "SELECT s FROM Status s")})
public class Status implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "status_id")
    private Long statusId;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "status_code")
    private int statusCode;
    @Basic(optional = false)
    @Column(name = "status_type")
    private String statusType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventStatus", fetch = FetchType.LAZY)
    private List<ActivityLog> activityLogList;

    public Status() {
    }

    public Status(Long statusId) {
        this.statusId = statusId;
    }

    public Status(Long statusId, String description, int statusCode, String statusType) {
        this.statusId = statusId;
        this.description = description;
        this.statusCode = statusCode;
        this.statusType = statusType;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    @XmlTransient
    public List<ActivityLog> getActivityLogList() {
        return activityLogList;
    }

    public void setActivityLogList(List<ActivityLog> activityLogList) {
        this.activityLogList = activityLogList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statusId != null ? statusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Status)) {
            return false;
        }
        Status other = (Status) object;
        if ((this.statusId == null && other.statusId != null) || (this.statusId != null && !this.statusId.equals(other.statusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getClass().getName()+"[ statusId=" + statusId + " ]";
    }
    
}
