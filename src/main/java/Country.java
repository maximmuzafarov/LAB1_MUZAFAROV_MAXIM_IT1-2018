import soap.countryws.client.generated.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.List;


public class Country extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        generateView(request, response);
        
        
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        generateView(request, response);
        
        
    }

    public void generateView(HttpServletRequest request,
    HttpServletResponse response)
            throws IOException {

        
       
        CountryInfoService countryIS = new CountryInfoService();
        CountryInfoServiceSoapType countryISS = countryIS.getCountryInfoServiceSoap();
        

        ArrayOftContinent arrayOftContinent = countryISS.listOfContinentsByName();
        List<TContinent> tContinent = arrayOftContinent.getTContinent();
        

        ArrayOftCountryCodeAndName arrayOftCountryCodeAndName = countryISS.listOfCountryNamesByName();
        List<TCountryCodeAndName> tCountryCodeAndNames = arrayOftCountryCodeAndName.getTCountryCodeAndName();

        response.setContentType("text/html; charset=UTF-8");
        ResultSet resultSet = null;
        PrintWriter out = response.getWriter();
        
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Country</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>List of сountries</h1>");
        out.println("<table cellpadding=\"4\">");
        out.println("<tr>\n" +
                "        <th>NAME</th>\n" +
                "        <th>LANGUAGE</th>\n" +
                "        <th>FLAG</th>\n" +
                "        <th>INFO</th>\n" +
                "    </tr>");
        
        
        System.out.println(tContinent.toString());
        for (TCountryCodeAndName countryCodeAndName : tCountryCodeAndNames) {
            int lastIndex = tCountryCodeAndNames.lastIndexOf(countryCodeAndName);

            
            out.print("<tr>");
            out.print(" <td>" + countryCodeAndName.getSName() + "</td>");
            out.print(" <td><a href=\"/language?countryCode=" + countryCodeAndName.getSISOCode() + "\"> " + "language" + "</a></td>");
            out.print(" <td><a href=\"/flag?countryCode=" + countryCodeAndName.getSISOCode() + "\"> " + "flag" + "</a></td>");
            out.print(" <td><a href=\"/inf?countryCode=" + countryCodeAndName.getSISOCode() + "\"> " + "information" + "</a></td>");
            out.print("</tr>");
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}