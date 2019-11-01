package cn.tedu.store.service.ex;

public class PasswordNotMatchException extends RuntimeException{
	private static final long serialVersionUID = -5916370894847140757L;
	public PasswordNotMatchException() {
	}
	public PasswordNotMatchException(String msg) {
		super(msg);
	}
}
