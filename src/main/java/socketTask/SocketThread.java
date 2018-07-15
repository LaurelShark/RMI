package main.java.socketTask;

import VO.DisciplineVO;
import VO.StudentVO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.List;

public class SocketThread implements Runnable {
    private Socket soket;


    public SocketThread(Socket soket) {
        this.soket = soket;
    }

    private SocketThread() {

    }


    @Override
    public void run() {
        try {
            BufferedReader inStream = new BufferedReader(new InputStreamReader(soket.getInputStream()));
            PrintWriter outStream = new PrintWriter(soket.getOutputStream(), true);
            while (true) {
                String input = inStream.readLine();
                if (input != null) {
                    String treatedInput = input.trim().toUpperCase();

                    if (treatedInput.equals("BYE")) {
                        SocketServer.numberOfConnections--;
                        System.out.println("Client disconnected");
                        System.out.println("Number of connections is " + SocketServer.numberOfConnections);
                        inStream.close();
                        outStream.close();
                        soket.close();
                        break;
                    } else if (treatedInput.equals("DATE")) {
                        outStream.println("The date is " + new Date());
                    } else if (treatedInput.equals("GET_DISCIPLINES")) {
                        List<DisciplineVO> disciplines = SocketServer.disciplineDao.getAll();
                        outStream.println("The disciplines are " + disciplines);
                    } else if (treatedInput.equals("GET_STUDENTS")) {
                        List<StudentVO> students = SocketServer.studentDao.getAll();
                        outStream.println("The students are " + students);
                    } else outStream.println("Unrecognized command");

                }

            }

            inStream.close();
            outStream.close();
            soket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
