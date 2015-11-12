/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author william
 */
@Embeddable
public class StudentResultsPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "student_id")
    private short studentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "apparatus_id")
    private short apparatusId;

    public StudentResultsPK() {
    }

    public StudentResultsPK(short studentId, short apparatusId) {
        this.studentId = studentId;
        this.apparatusId = apparatusId;
    }

    public short getStudentId() {
        return studentId;
    }

    public void setStudentId(short studentId) {
        this.studentId = studentId;
    }

    public short getApparatusId() {
        return apparatusId;
    }

    public void setApparatusId(short apparatusId) {
        this.apparatusId = apparatusId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) studentId;
        hash += (int) apparatusId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentResultsPK)) {
            return false;
        }
        StudentResultsPK other = (StudentResultsPK) object;
        if (this.studentId != other.studentId) {
            return false;
        }
        if (this.apparatusId != other.apparatusId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.StudentResultsPK[ studentId=" + studentId + ", apparatusId=" + apparatusId + " ]";
    }
    
}
