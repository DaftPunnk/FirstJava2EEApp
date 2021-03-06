/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Apparatuss;
import entity.Schools;
import entity.StudentResults;
import entity.Students;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.ApparatussFacade;
import session.SchoolsFacade;
import session.StudentResultsFacade;
import session.StudentsFacade;

/**
 *
 * @author william
 */
@WebServlet(name = "ControllerServlet", urlPatterns = {"/ControllerServlet","/showSchools","/showStudents","/showResults"
,"/getResults", "/insertNewResult", "/deleteResult"})
public class ControllerServlet extends HttpServlet {

    @EJB
    private SchoolsFacade schoolFacade;
    @EJB
    private StudentsFacade studentFacade;
    @EJB
    private ApparatussFacade apparatusFacade;
    @EJB
    private StudentResultsFacade studentresultFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Students selectedStudent;
        List<Apparatuss> selectedApparatus;
        List<StudentResults> studentResults;
        
       String userPath = request.getServletPath();
       
       if (userPath.equals("/showSchools")) {
           List<Schools> schools = schoolFacade.findAll();
           //System.out.println(schools.get(0).getStrschoolName());
           request.setAttribute("schoolslist", schools);
           userPath = "/showSchools";
       }
       
       else if (userPath.equals("/showStudents")){
           List<Schools> schools = schoolFacade.findAll();
           request.setAttribute("schoolslist", schools);
           userPath = "/showStudents";
       }else if (userPath.equals("/showResults")){
           List<Schools> schools = schoolFacade.findAll();
           
           System.out.println(schools.size());
           
          
           
           request.setAttribute("schoolslist", schools);
           userPath = "/showResults";
       }else if (userPath.equals("/getResults")) {
           
           String studentid = request.getQueryString();
           
           selectedStudent = studentFacade.find(Short.parseShort(studentid));
           
           request.setAttribute("selectedStudent", selectedStudent);
           
           studentResults = studentresultFacade.findResultForStudent(selectedStudent);
           
           request.setAttribute("studentResults", studentResults);
           
           selectedApparatus = apparatusFacade.findApparatusNoResult(selectedStudent);
           
           request.setAttribute("selectedApparatus", selectedApparatus);
           
           userPath = "/getResults";
           
       }
       
       String url = "/WEB-INF/view" + userPath + ".jsp";
       
       try{
           request.getRequestDispatcher(url).forward(request, response);
       }catch (Exception ex) {
           ex.printStackTrace();
       }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        Students selectedStudent;
        List<Apparatuss> selectedApparatus;
        List<StudentResults> studentResults;
        
        String userPath = request.getServletPath();
        
        if (userPath.equals("/insertNewResult")) {
            
            String apparatusID = request.getParameter("apparatusId");
            String result = request.getParameter("resultscore");
            String studentID = request.getParameter("studentId");
            
            if (studentID != null) {
                
                studentresultFacade.addResult(studentID, result, apparatusID);
                
                selectedStudent = studentFacade.find(Short.parseShort(studentID));
                
                System.out.println(selectedStudent.getStudentResultsList().size());
                
                request.setAttribute("selectedStudent", selectedStudent);
                
                studentResults = studentresultFacade.findResultForStudent(selectedStudent);
                request.setAttribute("studentResults", studentResults);
                
                selectedApparatus = apparatusFacade.findApparatusNoResult(selectedStudent);
                
                request.setAttribute("selectedApparatus",selectedApparatus );
            }
            userPath = "/getResults";
            
            String url = "/WEB-INF/view" + userPath + ".jsp";
       
       try{
           request.getRequestDispatcher(url).forward(request, response);
       }catch (Exception ex) {
           ex.printStackTrace();
        }
    }else if (userPath.equals("/deleteResult")) {
        
        String studentDelID = request.getParameter("studentId");
        String apparatusDelID = request.getParameter("apparatusId");
        
        if (studentDelID != null) {
            studentresultFacade.deleteStudentResult(studentDelID, apparatusDelID);
            
            selectedStudent = studentFacade.find(Short.parseShort(studentDelID));
            
            request.setAttribute("selectedStudent", selectedStudent);
            
            studentResults = studentresultFacade.findResultForStudent(selectedStudent);
            request.setAttribute("studentResults", studentResults);
            
            
            selectedApparatus = apparatusFacade.findApparatusNoResult(selectedStudent);
            
            request.setAttribute("selectedApparatus", selectedApparatus);
            
            userPath = "/getResults";
        }
    }
    }


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
