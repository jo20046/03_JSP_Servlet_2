package whs.jo20046;

import whs.jo20046.beans.Data;

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
        checkConnectionAndRedirect(request, response, session);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void checkConnectionAndRedirect(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {

        String[] urls = {request.getParameter("url1"), request.getParameter("url2"), request.getParameter("url3")};
        Data data = new Data();
        data.setUrl(0, request.getParameter("url1"));
        data.setUrl(1, request.getParameter("url2"));
        data.setUrl(2, request.getParameter("url3"));
        boolean allConnectionsOK = true;

        session.setAttribute("Data", data);

        for (int i = 0, urlsLength = urls.length; i < urlsLength; i++) {
            String urlInput = data.getUrl(i);

            if (!urlInput.startsWith("https://")) {
                urlInput = "https://" + urlInput;
            }

            try {
                URL url = new URL(urlInput);
                HttpURLConnection huc = (HttpURLConnection) url.openConnection();
                huc.setRequestMethod("GET");
                huc.getResponseCode();
                data.setNotFoundText(i, "");
            } catch (Exception e) {
                allConnectionsOK = false;
                data.setNotFoundText(i, "Eingebene URL konnte nicht gefunden werden.");
            }
        }

        if (allConnectionsOK) {
            response.sendRedirect("whs/jo20046/ausgabe.jsp");
        } else {
            response.sendRedirect("whs/jo20046/eingabe.jsp");
        }
    }
}
