package main.java.rmi;

import VO.DisciplineVO;
import VO.StudentVO;
import hibernateDao.HibernateDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class StudentServiceImpl extends UnicastRemoteObject implements StudentService {

    private HibernateDao<DisciplineVO, Integer> disciplineDao;
    private HibernateDao<StudentVO, Integer> studentDao;

    public StudentServiceImpl() throws RemoteException {
        super();
        final String CONFIG = "hibernate.cfg.xml";
        Configuration conf = new Configuration();
        conf.addAnnotatedClass(StudentVO.class);
        conf.addAnnotatedClass(DisciplineVO.class);
        conf.configure(CONFIG);
        SessionFactory sessionFactory = conf.buildSessionFactory();
        Session session = sessionFactory.openSession();

        disciplineDao = new HibernateDao<>(DisciplineVO.class, conf, session);
        studentDao = new HibernateDao<>(StudentVO.class, conf, session);

    }

    public List<StudentVO> getStudents() {
        return studentDao.getAll();
    }

    public List<DisciplineVO> getDiscipline() {
        return disciplineDao.getAll();
    }


}
