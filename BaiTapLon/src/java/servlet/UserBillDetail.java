package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Bill;
import models.Item;
import models.DAO.BillDAO;
import models.DAO.ItemDAO;

/**
 * Servlet implementation class UserBillDetail
 */
@WebServlet("/UserBillDetail")
public class UserBillDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserBillDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idbill=Integer.parseInt(request.getParameter("id"));
		Bill bill=BillDAO.getByID(idbill);
		ArrayList<Item> items=ItemDAO.getByBillID(idbill);
		request.setAttribute("items", items);
		request.setAttribute("bill", bill);
		request.getRequestDispatcher("UserBillDetail.jsp").forward(request, response);
	}

}
