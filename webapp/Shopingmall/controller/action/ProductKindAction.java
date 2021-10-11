package controller.action;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import dto.ProductVO;

public class ProductKindAction implements Action {
public void execute(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		
		String url = "Shopingmall/product_show/product_kind.jsp";
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int kind = Integer.parseInt(request.getParameter("kind"));
		ProductDAO productDAO = ProductDAO.getInstance();
		ArrayList<ProductVO> product_kinds = new ArrayList<>();
		try {
			product_kinds = productDAO.getKind(kind);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("product_kinds", product_kinds);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
		
	}
}
