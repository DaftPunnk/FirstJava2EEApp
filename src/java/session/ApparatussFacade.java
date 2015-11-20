/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Apparatuss;
import entity.Students;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author william
 */
@Stateless
public class ApparatussFacade extends AbstractFacade<Apparatuss> {
    @PersistenceContext(unitName = "FirstJava2EEAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ApparatussFacade() {
        super(Apparatuss.class);
    }
    
    public List<Apparatuss> findApparatusNoResult(Students studenttemp) {
        em.flush();
        
        String sqlString = "SELECT t FROM Apparatuss t WHERE t.studentResultsList<>"
                + "ALL (SELECT u FROM StudentResults u WHERE u.students = :studentobj)";
        
        return em.createQuery(sqlString).setParameter("studentobj", studenttemp).getResultList();
    }
    
}
