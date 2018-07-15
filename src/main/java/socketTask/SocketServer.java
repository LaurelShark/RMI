package main.java.socketTask;

import java.net.ServerSocket;
import java.net.Socket;

import VO.DisciplineVO;
import VO.StudentVO;
import hibernateDao.HibernateDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SocketServer {

    static HibernateDao<DisciplineVO, Integer> disciplineDao;
    static HibernateDao<StudentVO, Integer> studentDao;
    static int numberOfConnections = 0;

    public static void main(String[] args) throws Exception {

      /* if (args.length != 1) {
            System.out.println("Usage: start java sokservis port");
            System.exit(0);
        }
        */
        final String CONFIG = "hibernate.cfg.xml";
        Configuration conf = new Configuration();
        conf.addAnnotatedClass(DisciplineVO.class);
        conf.addAnnotatedClass(StudentVO.class);
        conf.configure(CONFIG);
        SessionFactory sessionFactory = conf.buildSessionFactory();
        Session session = sessionFactory.openSession();


        final ServerSocket servsock = new ServerSocket(8800);
        System.out.println("Server registered at port 8800");

        disciplineDao = new HibernateDao<>(DisciplineVO.class, conf, session);
        studentDao = new HibernateDao<>(StudentVO.class, conf, session);


        while (true) {

            System.out.println("Number of connections is " + SocketServer.numberOfConnections);
            Socket soket = servsock.accept();
            SocketServer.numberOfConnections++;
            new Thread(new SocketThread(soket)).start();
            System.out.println("New client connected");

        }
    }

}
