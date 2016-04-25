/**
 *  Student
 *  com.alaric.norris.study.rxjava
 *  Function:       ${TODO}
 *  date            author
 *  *****************************************************
 *  2016/4/22         AlaricNorris
 *  Copyright (c) 2016, TNT All Rights Reserved.
 */
package com.alaric.norris.study.rxjavastudy;

import java.util.ArrayList;
/**
 @formatter:off ClassName:      Student
 @formatter:off Function:       ${TODO}  ADD FUNCTION
 @formatter:off Contact:        Norris.sly@gmail.com
 @formatter:off @author         AlaricNorris
 @formatter:off @version        Ver 1.0
 @formatter:off @since          I used to be a programmer like you, then I took an arrow in the knee
 @formatter:off ***************************************************************************************************
 @formatter:off Modified By     AlaricNorris     2016/4/22    17:00
 @formatter:off Modifications:  ${TODO}
 @formatter:off ***************************************************************************************************
 */
public class Student {

    private ArrayList< Course > courses;

    private String name;
    public Student ( ArrayList< Course > inCourses, String inName ) {
        courses = inCourses;
        name = inName;
    }
    public Student ( ArrayList< Course > inCourses ) {

        courses = inCourses;
    }
    public Student () {

    }
    public String getName () {
        return name;
    }
    public void setName ( String inName ) {
        name = inName;
    }
    public ArrayList< Course > getCourses () {
        return courses;
    }
    public void setCourses ( ArrayList< Course > inCourses ) {
        courses = inCourses;
    }
}
