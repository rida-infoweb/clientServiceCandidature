package com.InstitutUIT.presentaion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/verificationCandidature")
public class VerificationCandidature extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerificationCandidature() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String cin = request.getParameter("cin");
			String num = request.getParameter("num");
			URL url = new
			URL("http://localhost:8081/serviceCandidature/services/verification/candidature?cin="+cin+"&num="+num);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "text/plain");
			if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " +conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(
			new InputStreamReader((conn.getInputStream())));
			String output;
			System.out.println("Output from Server .... \n");
			if ((output = br.readLine()) != null) {
				request.setAttribute("admis",output);
			}

			}
			catch (MalformedURLException e) {

			e.printStackTrace();
			}
			catch (IOException e) {
			e.printStackTrace();
			}
		RequestDispatcher rd = request.getRequestDispatcher("ind.jsp");
		rd.forward(request, response);
		

		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
