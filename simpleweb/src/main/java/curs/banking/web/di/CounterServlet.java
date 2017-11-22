package curs.banking.web.di;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curs.banking.di.ByOneCounter;
import curs.banking.di.ByTwoCounter;
import curs.banking.di.Counter;
import curs.banking.di.CounterIntf;
import curs.banking.di.MessageHolder;

/**
 * Servlet implementation class CounterServlet
 */
@WebServlet("/cs")
public class CounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	@ByOneCounter
	private CounterIntf mCounter;
	
	@Inject
	private MessageHolder mMsgHolder;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CounterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("<H1><B> Counter: ")
		.append("" + mCounter.incrementAndGet())
		.append("</B></H1>")
		.append("<h1><b><i>").append(mMsgHolder.getMessage())
		.append("</i></b></h1>");
	}

}
