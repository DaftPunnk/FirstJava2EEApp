/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author william
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id"),
    @NamedQuery(name = "Users.findByStrusername", query = "SELECT u FROM Users u WHERE u.strusername = :strusername"),
    @NamedQuery(name = "Users.findByStruserpassword", query = "SELECT u FROM Users u WHERE u.struserpassword = :struserpassword"),
    @NamedQuery(name = "Users.findByStrfullname", query = "SELECT u FROM Users u WHERE u.strfullname = :strfullname"),
    @NamedQuery(name = "Users.findByIntuserlevel", query = "SELECT u FROM Users u WHERE u.intuserlevel = :intuserlevel")})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "strusername")
    private String strusername;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "struserpassword")
    private String struserpassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "strfullname")
    private String strfullname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "intuserlevel")
    private int intuserlevel;

    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Users(Integer id, String strusername, String struserpassword, String strfullname, int intuserlevel) {
        this.id = id;
        this.strusername = strusername;
        this.struserpassword = struserpassword;
        this.strfullname = strfullname;
        this.intuserlevel = intuserlevel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStrusername() {
        return strusername;
    }

    public void setStrusername(String strusername) {
        this.strusername = strusername;
    }

    public String getStruserpassword() {
        return struserpassword;
    }

    public void setStruserpassword(String struserpassword) {
        this.struserpassword = struserpassword;
    }

    public String getStrfullname() {
        return strfullname;
    }

    public void setStrfullname(String strfullname) {
        this.strfullname = strfullname;
    }

    public int getIntuserlevel() {
        return intuserlevel;
    }

    public void setIntuserlevel(int intuserlevel) {
        this.intuserlevel = intuserlevel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Users[ id=" + id + " ]";
    }
    
}
