package interceptor;

import action.BookAction;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * BookAction的拦截器实现类：   BookInterceptor
 */
public class BookInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        BookAction bookAction= (BookAction) actionInvocation.getAction();
        if(bookAction.getBook().getPrice()<20){
            bookAction.addFieldError("book.price","拦截器:价格不能小于20");
            return Action.INPUT;
        }
        return actionInvocation.invoke();
    }
}
