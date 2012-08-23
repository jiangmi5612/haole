/**
 * 切面类
 */
package commons;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.opensymphony.xwork2.ActionContext;

@Aspect
public class AspectBean {
	
	//对action.Admin中除了login之外的方法都执行session验证
	//即如果session中没有username项则抛出异常
	@Before("execution(String action.Admin.*(..))")
	public void checkIfAdministratorLogin() throws Exception{
		if(ActionContext.getContext().get("username") == null){
			//若用户尚未登陆，则抛出管理员未登录异常
			throw new UnLoginException();
		}
	}
}
