package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(urlPatterns = { "/sendsms" })
@MultipartConfig
public class SendSMSServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Part p1 = request.getPart("file");
		BufferedReader br = new BufferedReader(new InputStreamReader(p1.getInputStream()));

		ArrayList<String> numbers = new ArrayList<>();

		String line = br.readLine();
		while (line != null) {
			if (line.trim().length() > 0) {
				String parts[] = line.split(",");
				for (String p : parts)
					numbers.add(p);
			}

			line = br.readLine();
		}
		br.close();

    // list phone numbers uploaded from file 
		out.println("<ul>");
		for (String number : numbers) {
			out.println("<li>" + number + "</li>");
		}
		out.println("</ul>");

	}

}
