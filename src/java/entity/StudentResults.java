/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author william
 */
@Entity
@Table(name = "student_results")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentResults.findAll", query = "SELECT s FROM StudentResults s"),
    @NamedQuery(name = "StudentResults.findByStudentId", query = "SELECT s FROM StudentResults s WHERE s.studentResultsPK.studentId = :studentId"),
    @NamedQuery(name = "StudentResults.findByApparatusId", query = "SELECT s FROM StudentResults s WHERE s.studentResultsPK.apparatusId = :apparatusId"),
    @NamedQuery(name = "StudentResults.findByIntresult", query = "SELECT s FROM StudentResults s WHERE s.intresult = :intresult")})
public class StudentResults implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StudentResultsPK studentResultsPK;
    @Column(name = "intresult")
    private Integer intresult;
    @JoinColumn(name = "apparatus_id", referencedColumnName = "apparatus_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Apparatuss apparatuss;
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Students students;

    public StudentResults() {
    }

    public StudentResults(StudentResultsPK studentResultsPK, Integer intresult) {
        this.studentResultsPK = studentResultsPK;
        this.intresult = intresult;
    }

    public StudentResults(StudentResultsPK studentResultsPK) {
        this.studentResultsPK = studentResultsPK;
    }

    public StudentResults(short studentId, short apparatusId) {
        this.studentResultsPK = new StudentResultsPK(studentId, apparatusId);
    }

    public StudentResultsPK getStudentResultsPK() {
        return studentResultsPK;
    }

    public void setStudentResultsPK(StudentResultsPK studentResultsPK) {
        this.studentResultsPK = studentResultsPK;
    }

    public Integer getIntresult() {
        return intresult;
    }

    public void setIntresult(Integer intresult) {
        this.intresult = intresult;
    }

    public Apparatuss getApparatuss() {
        return apparatuss;
    }

    public void setApparatuss(Apparatuss apparatuss) {
        this.apparatuss = apparatuss;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentResultsPK != null ? studentResultsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentResults)) {
            return false;
        }
        StudentResults other = (StudentResults) object;
        if ((this.studentResultsPK == null && other.studentResultsPK != null) || (this.studentResultsPK != null && !this.studentResultsPK.equals(other.studentResultsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.StudentResults[ studentResultsPK=" + studentResultsPK + " ]";
    }
    
}
