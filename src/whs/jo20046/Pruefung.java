package whs.jo20046;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@WebServlet(name = "Pruefung")
public class Pruefung extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String urlInput;
        boolean connectionOK;

        urlInput = request.getParameter("url");

        if (!urlInput.startsWith("https://")) {
            urlInput = "https://" + urlInput;
        }
        try {
            URL url = new URL(urlInput);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            huc.setRequestMethod("GET");
            connectionOK = huc.getResponseCode() == HttpURLConnection.HTTP_OK;
        } catch (Exception e) {
            connectionOK = false;
        }

        session.setAttribute("urlInput", urlInput);
        if (connectionOK) {
            session.setAttribute("notFoundText", "");
            response.sendRedirect("ausgabe.jsp");
        } else {
            session.setAttribute("notFoundText", "Eingebene URL konnte nicht gefunden werden.");
            response.sendRedirect("eingabe.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
