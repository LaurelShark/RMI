package main.java.rmi;

import main.java.rmi.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class BookServiceImpl extends UnicastRemoteObject implements BookService {

    private static ArrayList<Book> books = new ArrayList<Book>();

    static {

        books.add(new Book("Ivanov", "Addicted to murders"));
        books.add(new Book("Petrov", "Innocent victims"));
        books.add(new Book("Sidorov", "We use Java. not C#"));

    }

    public BookServiceImpl() throws RemoteException {


    }

    public ArrayList<Book> getAllBooks() throws RemoteException {

        return books;

    }

}
