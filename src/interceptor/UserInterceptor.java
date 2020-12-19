package interceptor;

import action.BookAction;
import action.UserAction;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UserInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        UserAction userAction= (UserAction) actionInvocation.getAction();
        if(userAction.getUser().getName().length()<2){
            userAction.addFieldError("user.name","拦截器:用户名长度不能小于2");
            return Action.INPUT;
        }
        return actionInvocation.invoke();
    }
}
