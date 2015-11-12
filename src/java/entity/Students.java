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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "students")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Students.findAll", query = "SELECT s FROM Students s"),
    @NamedQuery(name = "Students.findByStudentId", query = "SELECT s FROM Students s WHERE s.studentId = :studentId"),
    @NamedQuery(name = "Students.findByStrstudentLname", query = "SELECT s FROM Students s WHERE s.strstudentLname = :strstudentLname"),
    @NamedQuery(name = "Students.findByStrstudentFname", query = "SELECT s FROM Students s WHERE s.strstudentFname = :strstudentFname")})
public class Students implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "student_id")
    private Short studentId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "strstudent_lname")
    private String strstudentLname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "strstudent_fname")
    private String strstudentFname;
    @JoinColumn(name = "school_id", referencedColumnName = "school_id")
    @ManyToOne(optional = false)
    private Schools schoolId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "students")
    private List<StudentResults> studentResultsList;

    public Students() {
    }

    public Students(Short studentId) {
        this.studentId = studentId;
    }

    public Students(Short studentId, String strstudentLname, String strstudentFname) {
        this.studentId = studentId;
        this.strstudentLname = strstudentLname;
        this.strstudentFname = strstudentFname;
    }

    public Short getStudentId() {
        return studentId;
    }

    public void setStudentId(Short studentId) {
        this.studentId = studentId;
    }

    public String getStrstudentLname() {
        return strstudentLname;
    }

    public void setStrstudentLname(String strstudentLname) {
        this.strstudentLname = strstudentLname;
    }

    public String getStrstudentFname() {
        return strstudentFname;
    }

    public void setStrstudentFname(String strstudentFname) {
        this.strstudentFname = strstudentFname;
    }

    public Schools getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Schools schoolId) {
        this.schoolId = schoolId;
    }

    @XmlTransient
    public List<StudentResults> getStudentResultsList() {
        return studentResultsList;
    }

    public void setStudentResultsList(List<StudentResults> studentResultsList) {
        this.studentResultsList = studentResultsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentId != null ? studentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Students)) {
            return false;
        }
        Students other = (Students) object;
        if ((this.studentId == null && other.studentId != null) || (this.studentId != null && !this.studentId.equals(other.studentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Students[ studentId=" + studentId + " ]";
    }
    
}
