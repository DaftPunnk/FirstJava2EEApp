/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.StudentResults;
import entity.StudentResultsPK;
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
public class StudentResultsFacade extends AbstractFacade<StudentResults> {
    @PersistenceContext(unitName = "FirstJava2EEAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentResultsFacade() {
        super(StudentResults.class);
    }
    
    public void addResult(String studentID, String result, String apparatusID) {

   StudentResultsPK studentResultsPK = 
           new StudentResultsPK(Short.parseShort(studentID), Short.parseShort(apparatusID));
   
   StudentResults studentresults = new StudentResults(studentResultsPK, Integer.parseInt(result));
   
   em.persist(studentresults);
   em.flush();
   
   em.clear();
    }
    
    public List<StudentResults> findResultForStudent(Students studenttemp) {
        List<StudentResults> studentResults = 
        em.createQuery("SELECT t FROM StudentResults t WHERE t.students = :studentobj").setParameter("studentobj", studenttemp).getResultList();
        
        return studentResults;
    }
}


