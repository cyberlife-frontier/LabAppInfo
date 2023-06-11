package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.dto.LabAppStat;
import com.service.InfoStatService;
import com.service.impl.InfoStatServiceImpl;
import com.dto.YearAppStat;

@WebServlet("/InfoStatistics")
/**
 * Servlet implementation class InfoStatServlet
 */
public class InfoStatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private InfoStatService InfoStatService = new InfoStatServiceImpl();
    
    List<YearAppStat> YearAppStat = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoStatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String method = request.getParameter("method");
		switch(method) {
		case "labAppStat":
			List<String> InfoStat = this.InfoStatService.InfoStat();
			String value = request.getParameter("value");
			if( value == null ) value = "031005";
			List<LabAppStat> LabAppStat = this.InfoStatService.LabAppStat(value);
			request.setAttribute("InfoStat", InfoStat);
			request.setAttribute("LabAppStat", LabAppStat);
			request.setAttribute("YearAppStat", YearAppStat);
			request.setAttribute("LabNum", value);
			request.getRequestDispatcher("AppInfoStat").forward(request, response);
			break;
		case "yearAppStat":
			YearAppStat = this.InfoStatService.YearAppStat();
			
			request.getRequestDispatcher("InfoStatistics?method=labAppStat").forward(request, response);
			
			break;
		
		}
		
	}

}
