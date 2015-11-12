package entity;

import entity.Apparatuss;
import entity.StudentResultsPK;
import entity.Students;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-12T14:23:38")
@StaticMetamodel(StudentResults.class)
public class StudentResults_ { 

    public static volatile SingularAttribute<StudentResults, StudentResultsPK> studentResultsPK;
    public static volatile SingularAttribute<StudentResults, Students> students;
    public static volatile SingularAttribute<StudentResults, Apparatuss> apparatuss;
    public static volatile SingularAttribute<StudentResults, Integer> intresult;

}