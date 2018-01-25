package com.bdliang.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class AIDLService extends Service {
    /**
     *
     */
    public static final String TAG = "AIDLService";

    List<Student> studentList = new ArrayList<>();

    public AIDLService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: ");
        return iBinder;
    }

    IBinder iBinder = new IStudentManger.Stub() {

        @Override
        public void addStudent(Student student) throws RemoteException {
            Log.d(TAG, "addStudent: " + student.toString());
            studentList.add(student);
        }

        @Override
        public Student getStudent(String name) throws RemoteException {
            Log.d(TAG, "getStudent: " + name);
            for (Student student : studentList) {
                if (student.getName().equals(name)) {
                    return student;
                }
            }
            return null;
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }
}
