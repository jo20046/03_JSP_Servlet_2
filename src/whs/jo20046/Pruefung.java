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
        checkConnectionAndRedirect(request, response, session);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void checkConnectionAndRedirect(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {

        String[] urls = {request.getParameter("url1"), request.getParameter("url2"), request.getParameter("url3")};
        session.setAttribute("urlInput1", urls[0]);
        session.setAttribute("urlInput2", urls[1]);
        session.setAttribute("urlInput3", urls[2]);
        boolean allConnectionsOK = true;

        for (int i = 0, urlsLength = urls.length; i < urlsLength; i++) {
            String urlInput = urls[i];

            if (!urlInput.startsWith("https://")) {
                urlInput = "https://" + urlInput;
            }

            try {
                URL url = new URL(urlInput);
                HttpURLConnection huc = (HttpURLConnection) url.openConnection();
                huc.setRequestMethod("GET");
                huc.getResponseCode();
                session.setAttribute("notFoundText" + (i + 1), "");
            } catch (Exception e) {
                allConnectionsOK = false;
                session.setAttribute("notFoundText" + (i + 1), "Eingebene URL konnte nicht gefunden werden.");
                int j = 0;
            }
        }

        if (allConnectionsOK) {
            response.sendRedirect("whs/jo20046/ausgabe.jsp");
        } else {
            response.sendRedirect("whs/jo20046/eingabe.jsp");
        }
    }
}
