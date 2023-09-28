package ar.com.lpa.entryservlet;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import ar.com.lpa.configuration.LPAServiceConfigurator;

@WebServlet("/EntryServlet")
public class EntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public EntryServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StringBuilder sb = new StringBuilder();
	    BufferedReader reader = request.getReader();
	    String line;
	    while ((line = reader.readLine()) != null) {
	      sb.append(line);
	    }
	    
	    String requestBody = sb.toString();
	    JSONObject json = new JSONObject(requestBody);
	    
	    LPAServiceConfigurator conf = new LPAServiceConfigurator();
	    conf.writeProperties(json);
	    
	    reader.close();
	    response.addHeader("Access-Control-Allow-Origin", "*");
		response.setStatus(HttpServletResponse.SC_OK);  // Doy permisos		
		
	}
}
