package pages;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class SessionListener implements HttpSessionListener {

	private static int total_no_of_sessions;
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		total_no_of_sessions++;
		System.out.println("Total no of sessions = " +total_no_of_sessions);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		total_no_of_sessions--;
		System.out.println("Total no of inactive sessions = " +total_no_of_sessions);
		
	}

}
