package app.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import app.goods.GoodsBean;
import app.goods.GoodsDAO;

@SuppressWarnings("serial")
@WebServlet("/InstQueryServlet")
public class InstQueryServlet extends HttpServlet {
	private final static String CONTENT_TYPE = "text/html; charset=UTF-8";

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		BufferedReader br = request.getReader();
		StringBuffer jsonIn = new StringBuffer();
		String line = null;
		while ((line = br.readLine()) != null) {
			jsonIn.append(line);
		}

		JsonObject jsonObject = gson.fromJson(jsonIn.toString(), JsonObject.class);
		MemberDAO mDAO = new MemberDAO();
		String action = jsonObject.get("action").getAsString();

		System.out.println("------1action: " + action);
		if (action.equals("getMemQuery")) {
			String memqry = jsonObject.get("queryString").getAsString();
			List<MemberBean> member = mDAO.getQueryMem(memqry);
			System.out.println("query = " + memqry);
			writeText(response, gson.toJson(member));}
		
		if (action.equals("getInstQuery")) {
			String instqry = jsonObject.get("queryString").getAsString();
			List<InstiutionBean> inst = mDAO.getQueryInst(instqry);
			System.out.println("query = " + instqry);
			writeText(response, gson.toJson(inst));}
	}
		
		
		
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GoodsDAOForList goodsDAO = new GoodsDaoMysqlImpl();

		// GoodsDAO gDAO = new GoodsDAO();
		// List<GoodsBean> gList = gDAO.getAll("jack");
		//
		// writeText(response, new Gson().toJson(gList));
	}

	private void writeText(HttpServletResponse response, String outText) throws IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		// System.out.println("outText: " + outText);
		out.print(outText);
	}
}