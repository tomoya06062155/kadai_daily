package controllers.comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CommentShowServlet
 */
@WebServlet("/comment/show")
public class CommentShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	    EntityManager em = DBUtil.createEntityManager();
//
//	    List<Comment> comments = em.createNamedQuery("getAllComments_ascending_order", Comment.class)
//                                   .getResultList();
////	Report r = em.find(Report.class, (Integer)(request.getSession().getAttribute("id")));
//	    em.close();
//
//
//	    request.setAttribute("comments", comments);
////	    request.setAttribute("report", r);
////	    request.getSession().setAttribute("comment_id", c.getId());
////	    request.setAttribute("_token", request.getSession().getId());
//
//	    response.sendRedirect(request.getContextPath() + "/reports/show");
//
//

	}

}
