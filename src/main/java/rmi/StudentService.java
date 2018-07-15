package main.java.rmi;

import VO.DisciplineVO;
import VO.StudentVO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface StudentService extends Remote {

    public List<StudentVO> getStudents() throws RemoteException;

    public List<DisciplineVO> getDiscipline() throws RemoteException;
}

