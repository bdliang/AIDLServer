// IStudentManger.aidl
package com.bdliang.aidlserver;

// Declare any non-default types here with import statements
import com.bdliang.aidlserver.Student;
import com.bdliang.aidlserver.ICallback;

interface IStudentManger {

    void addStudent(in Student student);
    Student getStudent(String name);
     void registerCallback(in ICallback cb);
      void unregisterCallback(in ICallback cb);
}
