package main.java.rmi;

import main.java.rmi.StudentService;
import main.java.rmi.StudentServiceImpl;

import java.rmi.RemoteException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiServer {
    private static Registry registry = null;
    public static void main(String[] args) throws RemoteException, NamingException {
        /*
        BookServiceImpl bookService = new BookServiceImpl();
        Context namingContext = new InitialContext();
        namingContext.rebind("rmi:books",bookService);
        System.out.println("Server is working...");

*/
      //
        //  java.rmi.registry.LocateRegistry.createRegistry(8800);
        //Registry registry = LocateRegistry.createRegistry(8800);
        System.out.println("Server started ...");
        StudentService service = new StudentServiceImpl();
        Context namingContext = new InitialContext();
        namingContext.rebind("rmi:university", service);
        System.out.println("Server is working...");

    }
}
