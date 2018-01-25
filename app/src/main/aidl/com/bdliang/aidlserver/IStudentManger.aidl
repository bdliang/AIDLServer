// IStudentManger.aidl
package com.bdliang.aidlserver;

// Declare any non-default types here with import statements
import com.bdliang.aidlserver.Student;

interface IStudentManger {

    void addStudent(in Student student);
    Student getStudent(String name);
}
