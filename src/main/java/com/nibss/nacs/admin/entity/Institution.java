/*
 * Copyright 2014 NIBSS
 * http://www.nibss-plc.com.ng
 * 
 */
package com.nibss.nacs.admin.entity;

import com.nibss.hawk.admin.entity.Aggregator;

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
@Table(name = "institution")
@XmlRootElement

@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("1")
@DiscriminatorColumn(name = "institution_type_id", discriminatorType = DiscriminatorType.INTEGER)
@NamedQueries({
    @NamedQuery(name = "Institution.findAll", query = "SELECT i FROM Institution i")})
public class Institution implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "institution_id")
    private Long institutionId;
    @Column(name = "flag")
    private String flag;
    @Basic(optional = false)
    @Column(name = "institution_code")
    private String institutionCode;
    @Basic(optional = false)
    @Column(name = "institution_name")
    private String institutionName;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "institution", fetch = FetchType.LAZY)
    private Aggregator aggregator;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventInstitution", fetch = FetchType.LAZY)
    private List<ActivityLog> activityLogList;
    @JoinColumn(name = "institution_type", referencedColumnName = "institution_type_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private InstitutionType institutionType;
   /* @OneToOne(cascade = CascadeType.ALL, mappedBy = "institution", fetch = FetchType.LAZY)
    private Bank bank;*/
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "institution", fetch = FetchType.LAZY)
    private List<UserIdentity> userIdentityList;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "institution", fetch = FetchType.LAZY)
    private List<Payment> paymentList;*/
    /*@OneToOne(cascade = CascadeType.ALL, mappedBy = "institution", fetch = FetchType.LAZY)
    private ThirdParty thirdParty;*/
   /* @OneToMany(mappedBy = "settlementInstitution", fetch = FetchType.LAZY)
    private List<ThirdParty> thirdPartyList;*/

    public Institution() {
    }

    public Institution(Long institutionId) {
        this.institutionId = institutionId;
    }

    public Institution(Long institutionId, String institutionCode, String institutionName) {
        this.institutionId = institutionId;
        this.institutionCode = institutionCode;
        this.institutionName = institutionName;
    }

    public Long getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Long institutionId) {
        this.institutionId = institutionId;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getInstitutionCode() {
        return institutionCode;
    }

    public void setInstitutionCode(String institutionCode) {
        this.institutionCode = institutionCode;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public Aggregator getAggregator() {
        return aggregator;
    }

    public void setAggregator(Aggregator aggregator) {
        this.aggregator = aggregator;
    }

    @XmlTransient
    public List<ActivityLog> getActivityLogList() {
        return activityLogList;
    }

    public void setActivityLogList(List<ActivityLog> activityLogList) {
        this.activityLogList = activityLogList;
    }

    public InstitutionType getInstitutionType() {
        return institutionType;
    }

    public void setInstitutionType(InstitutionType institutionType) {
        this.institutionType = institutionType;
    }

   /* public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }*/

    @XmlTransient
    public List<UserIdentity> getUserIdentityList() {
        return userIdentityList;
    }

    public void setUserIdentityList(List<UserIdentity> userIdentityList) {
        this.userIdentityList = userIdentityList;
    }

    /*@XmlTransient
    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }
*/
    /*public ThirdParty getThirdParty() {
        return thirdParty;
    }

    public void setThirdParty(ThirdParty thirdParty) {
        this.thirdParty = thirdParty;
    }

    @XmlTransient
    public List<ThirdParty> getThirdPartyList() {
        return thirdPartyList;
    }

    public void setThirdPartyList(List<ThirdParty> thirdPartyList) {
        this.thirdPartyList = thirdPartyList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (institutionId != null ? institutionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Institution)) {
            return false;
        }
        Institution other = (Institution) object;
        if ((this.institutionId == null && other.institutionId != null) || (this.institutionId != null && !this.institutionId.equals(other.institutionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[ institutionId=" + institutionId + " ]";
    }

}
