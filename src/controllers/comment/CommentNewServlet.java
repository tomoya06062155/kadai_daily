package controllers.comment;

import java.io.IOException;
import java.sql.Date;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Comment;
import models.Report;
import utils.DBUtil;

/**
 * Servlet implementation class CommentNewServlet
 */
@WebServlet("/comment/new")
public class CommentNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    EntityManager em = DBUtil.createEntityManager();


        Report r = em.find(Report.class, Integer.parseInt(request.getParameter("id")));
        Comment c = new Comment();

        em.close();



        c.setComment_date(new Date (System.currentTimeMillis()));
        request.setAttribute("comment", c);
        request.setAttribute("report", r);
        request.setAttribute("_token", request.getSession().getId());


        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/comment/new.jsp");
        rd.forward(request, response);
    }


    }

