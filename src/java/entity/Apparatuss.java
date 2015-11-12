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
@Table(name = "apparatuss")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Apparatuss.findAll", query = "SELECT a FROM Apparatuss a"),
    @NamedQuery(name = "Apparatuss.findByApparatusId", query = "SELECT a FROM Apparatuss a WHERE a.apparatusId = :apparatusId"),
    @NamedQuery(name = "Apparatuss.findByStrapparatusName", query = "SELECT a FROM Apparatuss a WHERE a.strapparatusName = :strapparatusName")})
public class Apparatuss implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "apparatus_id")
    private Short apparatusId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "strapparatus_name")
    private String strapparatusName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "apparatuss")
    private List<StudentResults> studentResultsList;

    public Apparatuss() {
    }

    public Apparatuss(Short apparatusId) {
        this.apparatusId = apparatusId;
    }

    public Apparatuss(Short apparatusId, String strapparatusName) {
        this.apparatusId = apparatusId;
        this.strapparatusName = strapparatusName;
    }

    public Short getApparatusId() {
        return apparatusId;
    }

    public void setApparatusId(Short apparatusId) {
        this.apparatusId = apparatusId;
    }

    public String getStrapparatusName() {
        return strapparatusName;
    }

    public void setStrapparatusName(String strapparatusName) {
        this.strapparatusName = strapparatusName;
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
        hash += (apparatusId != null ? apparatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apparatuss)) {
            return false;
        }
        Apparatuss other = (Apparatuss) object;
        if ((this.apparatusId == null && other.apparatusId != null) || (this.apparatusId != null && !this.apparatusId.equals(other.apparatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Apparatuss[ apparatusId=" + apparatusId + " ]";
    }
    
}
