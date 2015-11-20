package entity;

import entity.Schools;
import entity.StudentResults;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-20T12:07:57")
@StaticMetamodel(Students.class)
public class Students_ { 

    public static volatile SingularAttribute<Students, Short> studentId;
    public static volatile SingularAttribute<Students, String> strstudentFname;
    public static volatile SingularAttribute<Students, String> strstudentLname;
    public static volatile ListAttribute<Students, StudentResults> studentResultsList;
    public static volatile SingularAttribute<Students, Schools> schoolId;

}