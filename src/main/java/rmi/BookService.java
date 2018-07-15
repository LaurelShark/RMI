package main.java.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface BookService extends Remote {

    public ArrayList<Book> getAllBooks() throws RemoteException;
}
