package controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import dto.ProductVO;



public class ProductDetailAction implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		
		String url = "Shopingmall/member/product_detail.jsp";
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int pseq = Integer.parseInt(request.getParameter("pseq"));
		ProductDAO productDAO = ProductDAO.getInstance();
		ProductVO product = new ProductVO();
		try {
			product = productDAO.getOne(pseq);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("product", product);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
		
	}
}
