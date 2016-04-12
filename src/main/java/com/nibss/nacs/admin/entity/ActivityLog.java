/*
 * Copyright 2014 NIBSS
 * http://www.nibss-plc.com.ng
 * 
 */
package com.nibss.nacs.admin.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author oogunjimi
 */
@Entity
@Table(name = "activity_log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActivityLog.findAll", query = "SELECT a FROM ActivityLog a")})
public class ActivityLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "activity_log_id")
    private Long activityLogId;
    @Lob
    @Column(name = "data_log")
    private String dataLog;
    @Basic(optional = false)
    @Column(name = "entity_class")
    private String entityClass;
    @Column(name = "entity_id")
    private String entityId;
    @Basic(optional = false)
    @Column(name = "event_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventDate;
    @Column(name = "event_ip")
    private String eventIp;
    @JoinColumn(name = "event_by", referencedColumnName = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserIdentity eventBy;
    @JoinColumn(name = "event_institution", referencedColumnName = "institution_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Institution eventInstitution;
    @JoinColumn(name = "event_status", referencedColumnName = "status_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Status eventStatus;

    public ActivityLog() {
    }

    public ActivityLog(Long activityLogId) {
        this.activityLogId = activityLogId;
    }

    public ActivityLog(Long activityLogId, String entityClass, Date eventDate) {
        this.activityLogId = activityLogId;
        this.entityClass = entityClass;
        this.eventDate = eventDate;
    }

    public Long getActivityLogId() {
        return activityLogId;
    }

    public void setActivityLogId(Long activityLogId) {
        this.activityLogId = activityLogId;
    }

    public String getDataLog() {
        return dataLog;
    }

    public void setDataLog(String dataLog) {
        this.dataLog = dataLog;
    }

    public String getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(String entityClass) {
        this.entityClass = entityClass;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventIp() {
        return eventIp;
    }

    public void setEventIp(String eventIp) {
        this.eventIp = eventIp;
    }

    public UserIdentity getEventBy() {
        return eventBy;
    }

    public void setEventBy(UserIdentity eventBy) {
        this.eventBy = eventBy;
    }

    public Institution getEventInstitution() {
        return eventInstitution;
    }

    public void setEventInstitution(Institution eventInstitution) {
        this.eventInstitution = eventInstitution;
    }

    public Status getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(Status eventStatus) {
        this.eventStatus = eventStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (activityLogId != null ? activityLogId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActivityLog)) {
            return false;
        }
        ActivityLog other = (ActivityLog) object;
        if ((this.activityLogId == null && other.activityLogId != null) || (this.activityLogId != null && !this.activityLogId.equals(other.activityLogId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[ activityLogId=" + activityLogId + " ]";
    }

}
