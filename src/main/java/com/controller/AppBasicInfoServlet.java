package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


import com.entity.ApplianceInfo;
import com.service.AppBasicInfoService;
import com.service.InfoStatService;
import com.service.impl.AppBasicInfoServiceImpl;
import com.service.impl.InfoStatServiceImpl;

@WebServlet("/AppBasicInfo")
/**
 * Servlet implementation class AppBasicInfoServlet
 */
public class AppBasicInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AppBasicInfoService AppBasicInfoService = new AppBasicInfoServiceImpl();
    private InfoStatService InfoStatService = new InfoStatServiceImpl();
    private List<String> AppNum = null;
    private List<String> InfoStat = null;//LabNum
    private List<String> PersonnelAdmin = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppBasicInfoServlet() {
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
		List<ApplianceInfo> ApplianceInfo = null;
		String method = request.getParameter("method");
		switch(method) {
		case "AllInfo":
			ApplianceInfo = this.AppBasicInfoService.ApplianceInfo();
			InfoStat = this.InfoStatService.InfoStat();
			PersonnelAdmin = this.AppBasicInfoService.PersonnelAdmin();
			AppNum = ApplianceInfo.stream().map(com.entity.ApplianceInfo::getApp_num).collect(Collectors.toList());
			request.setAttribute("ApplianceInfo", ApplianceInfo);
			request.setAttribute("AppNum", AppNum);
			request.setAttribute("InfoStat", InfoStat);
			request.setAttribute("PersonnelAdmin", PersonnelAdmin);
			request.getRequestDispatcher("BasicInfo.jsp").forward(request, response);
			break;
		case "queryinfo":
			String key = request.getParameter("key");
			String value = request.getParameter("value");
			ApplianceInfo = this.AppBasicInfoService.InfoQuery(key, value);
			request.setAttribute("ApplianceInfo", ApplianceInfo);
			request.setAttribute("AppNum", AppNum);
			request.setAttribute("InfoStat", InfoStat);
			request.setAttribute("PersonnelAdmin", PersonnelAdmin);
			request.getRequestDispatcher("BasicInfo.jsp").forward(request, response);
			break;
		case "addAppInfo":
			String app_num = request.getParameter("app_num");
			String app_name = request.getParameter("app_name");
			String lab_num = request.getParameter("lab_num");
			String date_purchase = request.getParameter("date_purchase");
			String str[] = request.getParameterValues("app_admin");
			this.AppBasicInfoService.addInfo(app_num, app_name, lab_num, date_purchase, str);
			
			response.sendRedirect("AppBasicInfo?method=AllInfo");
			break;
		case "delAppInfo":
			 app_num = request.getParameter("app_num");
			this.AppBasicInfoService.delInfo(app_num);
			
			response.sendRedirect("AppBasicInfo?method=AllInfo");
			break;
		case "showAppPic":
			app_num = request.getParameter("app_num");
			List<String> showPic = this.AppBasicInfoService.showAppPic(app_num);
			request.setAttribute("app_num", app_num);
			
			request.getRequestDispatcher("ShowPic.jsp").forward(request, response);

			break;

		}
		
		
		
	}

}
