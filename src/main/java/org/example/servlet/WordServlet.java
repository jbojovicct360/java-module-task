package org.example.servlet;

import org.example.io.Reader;
import org.example.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "WordServlet", urlPatterns = "/word")
public class WordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Reader reader = new Reader();
        List<String> valuesFromFile = reader.getValuesFromInputFile();
        String valuesString = "";
        for(String currentValue : valuesFromFile) {
            valuesString += currentValue + '\n';
        }
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().write(valuesString);
        resp.getWriter().flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String word = req.getParameter("word");
        if(word != null) {
            Writer.writeIntoInput(word);
            resp.setStatus(HttpServletResponse.SC_CREATED);
        }
        resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
    }
}
