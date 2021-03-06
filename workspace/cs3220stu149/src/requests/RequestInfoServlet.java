package requests;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/requests/RequestInfo")
public class RequestInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Request Info</title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("	<h1>Request Info</h1>");
		
		// Insert the page-specific content here...
        out.println( "<h3><small>Request Method: </small>" + request.getMethod() + "</h3>" );
        out.println( "<h3><small>Request URI: </small>" + request.getRequestURI() + "</h3>" );
        out.println( "<h3><small>Context Path: </small>" + request.getContextPath() + "</h3>" );
        
        out.println( "<h3><small>You are from: </small>" + request.getRemoteAddr() + "</h3>" );

        String acceptEncodingHeader = request.getHeader("Accept-Encoding");
        boolean isGzipSupported = acceptEncodingHeader.indexOf( "gzip" ) >= 0;

        if( isGzipSupported )
            out.println( "<h3>Yes, gzip is supported.</h3>" );
        else
            out.println( "<h3>No, gzip is not supported. </h3>" );
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
