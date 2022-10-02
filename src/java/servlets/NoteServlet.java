package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author marce
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = getServletContext().getRealPath("/WEB-INF/note.txt");

        BufferedReader br = new BufferedReader(new FileReader(new File(path)));

        String title = br.readLine();
        String contents = br.readLine();
        br.close();
                
        Note note = new Note(title, contents);
        request.setAttribute("note", note);

        String editFile = request.getParameter("edit");
                 
        if (editFile == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
        } 
        else {
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
                .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String path = getServletContext().getRealPath("/WEB-INF/note.txt");

            String title = request.getParameter("title");
            String contents = request.getParameter("contents");

            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));

            if (title == null || title.equals("") || contents == null || contents.equals("")) {
                request.setAttribute("title", title);
                request.setAttribute("contents", contents);
                request.setAttribute("message", "Invalid entries.");

                getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
                    .forward(request, response);

                return;
            }

            Note note = new Note(title, contents);
            request.setAttribute("note", note);

            pw.print(title + "\n");
            pw.print(contents);
            pw.close();

            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
    }
}