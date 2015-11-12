/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author william
 */
@Entity
@Table(name = "schools")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Schools.findAll", query = "SELECT s FROM Schools s"),
    @NamedQuery(name = "Schools.findBySchoolId", query = "SELECT s FROM Schools s WHERE s.schoolId = :schoolId"),
    @NamedQuery(name = "Schools.findByStrschoolName", query = "SELECT s FROM Schools s WHERE s.strschoolName = :strschoolName")})
public class Schools implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "school_id")
    private Short schoolId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "strschool_name")
    private String strschoolName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schoolId")
    private List<Students> studentsList;

    public Schools() {
    }

    public Schools(Short schoolId) {
        this.schoolId = schoolId;
    }

    public Schools(Short schoolId, String strschoolName) {
        this.schoolId = schoolId;
        this.strschoolName = strschoolName;
    }

    public Short getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Short schoolId) {
        this.schoolId = schoolId;
    }

    public String getStrschoolName() {
        return strschoolName;
    }

    public void setStrschoolName(String strschoolName) {
        this.strschoolName = strschoolName;
    }

    @XmlTransient
    public List<Students> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Students> studentsList) {
        this.studentsList = studentsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (schoolId != null ? schoolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Schools)) {
            return false;
        }
        Schools other = (Schools) object;
        if ((this.schoolId == null && other.schoolId != null) || (this.schoolId != null && !this.schoolId.equals(other.schoolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Schools[ schoolId=" + schoolId + " ]";
    }
    
}
