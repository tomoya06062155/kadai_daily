package controllers.comment;


import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Comment;
import models.Employee;
import models.Report;
import models.validators.CommentValidator;
import utils.DBUtil;

/**
 * Servlet implementation class CommentCreateServlet
 */
@WebServlet("/comment/create")
public class CommentCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String _token = (String)request.getParameter("_token");
		    if(_token != null && _token.equals(request.getSession().getId())){

		        EntityManager em = DBUtil.createEntityManager();
//		        report_idの取得
		        Report r = em.find(Report.class, (Integer)(request.getSession().getAttribute("report_id")));
//              Commentインスタンス化
		        Comment c = new Comment();

		        //Stringの日付をDate型に
    		    Date comment_date = new Date(System.currentTimeMillis());
    		    String rd_str = request.getParameter("comment_date");
    		    if(rd_str != null && !rd_str.equals("")) {
    		        comment_date = Date.valueOf(request.getParameter("comment_date"));
    		    }c.setComment_date(comment_date);

//    		    Reportフィールドにreport_idをいれる
    		    c.setReport((Report)(r));

//    		    Employeeフィールドにlogin_employeeをいれる
    		    c.setEmployee((Employee)request.getSession().getAttribute("login_employee"));

    		    String content = request.getParameter("content");
    		    c.setContent(content);

    		    //現在日時の情報を日付型のオブジェクトで取得
                Timestamp currentTime = new Timestamp(System.currentTimeMillis());
                c.setCreated_at(currentTime);

                List<String> errors = CommentValidator.validate(c);
                if(errors.size()>0){
                    em.close();

                    request.setAttribute("_token", request.getSession().getId());
                    request.setAttribute("comments", c);
                    request.setAttribute("errors", errors);

                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/comment/new.jsp");
                    rd.forward(request,  response);
                }else{
                    em.getTransaction().begin();
                    em.persist(c);
                    em.getTransaction().commit();
                    request.getSession().setAttribute("flush", "コメントをしました");
                    em.close();

                    request.getSession().removeAttribute("report_id");
                    response.sendRedirect(request.getContextPath() + "/reports/index");

            }
		}
	}
}