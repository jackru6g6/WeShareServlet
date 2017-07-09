package app.goods;

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

@SuppressWarnings("serial")
@WebServlet("/GoodsQueryServlet")
public class GoodsQueryServlet extends HttpServlet {
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
		GoodsDAO gDAO = new GoodsDAO();
		String action = jsonObject.get("action").getAsString();

		System.out.println("------1action: " + action);
		// String userId = jsonObject.get("user").getAsString();
		// System.out.println("userId: " + userId);
		if (action.equals("getGoodsQuery")) {
			String goodsqry = jsonObject.get("queryString").getAsString();
			List<GoodsBean> goods = gDAO.getQuery(goodsqry);
			System.out.println("querygoods = " + goodsqry);
			writeText(response, gson.toJson(goods));}
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
