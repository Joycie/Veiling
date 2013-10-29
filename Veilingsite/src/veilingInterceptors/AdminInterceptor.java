package veilingInterceptors;

import java.util.Map;

import veilingAware.UserAware;
import veilingDomain.Gebruiker;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

@SuppressWarnings("serial")
public class AdminInterceptor implements Interceptor {

	public void destroy() {
	}

	public void init() {
	}

	public String intercept( ActionInvocation actionInvocation ) throws Exception {

		@SuppressWarnings("rawtypes")
		Map session = actionInvocation.getInvocationContext().getSession();
		
		Gebruiker gebruiker = (Gebruiker) session.get("gebruiker" );
		if (gebruiker == null)
		{
			return Action.INPUT;
		}
		if (gebruiker.getRol() != 1){
		    return Action.INPUT;
		} 
		else {	    
		    return actionInvocation.invoke();
		}
	}
}
