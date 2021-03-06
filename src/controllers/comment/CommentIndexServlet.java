package controllers.comment;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Comment;
import utils.DBUtil;

/**
 * Servlet implementation class CommentIndexServlet
 */
@WebServlet("/comment/index")
public class CommentIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = DBUtil.createEntityManager();

		List<Comment> comments = em.createNamedQuery("getAllComments_descending_order", Comment.class)
		                           .getResultList();

		em.close();

		request.setAttribute("comments", comments);

		if(request.getSession().getAttribute("flusf") != null){
		    request.setAttribute("flush", request.getSession().getAttribute("flush"));
		    request.getSession().removeAttribute("flush");
		}


		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/comment/index.jsp");
		rd.forward(request, response);


	}

}
