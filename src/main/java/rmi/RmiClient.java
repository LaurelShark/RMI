package main.java.rmi;

import VO.DisciplineVO;
import VO.StudentVO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class RmiClient {

    public static void main(String[] args) throws RemoteException, NamingException {
       /* Context namingContext = new InitialContext();
        String uri = "rmi:books";
        BookService bookService = (BookService) namingContext.lookup(uri);
        ArrayList<Book> books = bookService.getAllBooks();

        for (Book book: books) {
            System.out.println(book);
        }
*/
        Context namingContext = new InitialContext();
        String uri = "rmi:university";
        StudentService service = (StudentService) namingContext.lookup(uri);
        ArrayList<StudentVO> students = (ArrayList<StudentVO>) service.getStudents();
        System.out.println("Students: ");
        students.forEach(System.out::println);
        System.out.println("Disciplines: ");
        ArrayList<DisciplineVO> discpilines = (ArrayList<DisciplineVO>) service.getDiscipline();
        discpilines.forEach(System.out::println);

    }
}
