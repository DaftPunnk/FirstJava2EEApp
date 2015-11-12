package entity;

import entity.Students;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-12T15:02:40")
@StaticMetamodel(Schools.class)
public class Schools_ { 

    public static volatile SingularAttribute<Schools, String> strschoolName;
    public static volatile SingularAttribute<Schools, Short> schoolId;
    public static volatile ListAttribute<Schools, Students> studentsList;

}