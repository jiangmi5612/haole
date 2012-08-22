/**
 * 自定义异常，管理员未登陆异常，主要用于管理员权限控制
 */
package commons;

public class UnLoginException extends Exception {
	
	public UnLoginException() {
		super();
	}
	
	public UnLoginException(String msg) {
		super(msg);
	}
}
