package ws;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import ws.GameWSStub.Play;


public class GameServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public GameServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        // redirect request
        RequestDispatcher dispatcher = (RequestDispatcher) getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get min value parameter
        int minValue = Integer.parseInt(request.getParameter("minval"));
        
        // get max value parameter
        int maxValue = Integer.parseInt(request.getParameter("maxval"));
        
        // get try value parameter
        int tryNumber = Integer.parseInt(request.getParameter("trynum"));
        
        GameWSStub gameWs = new GameWSStub("http://localhost:8080/GameService/services/GameWS?wsdl");
        
        Play play = new Play();
        play.setMinValue(minValue);
        play.setMaxValue(maxValue);
        play.setTryNumber(tryNumber);
        
        boolean res = gameWs.play(play).get_return();
                
        if (res) {
            response.sendRedirect(request.getContextPath() + "/congrats.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/attempt.jsp");
        }
	}
}
