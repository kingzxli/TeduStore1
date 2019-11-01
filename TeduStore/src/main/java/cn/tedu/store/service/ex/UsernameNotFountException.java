package cn.tedu.store.service.ex;

public class UsernameNotFountException extends RuntimeException{
	private static final long serialVersionUID = -5916370894847140757L;
	public UsernameNotFountException() {
	}
	public UsernameNotFountException(String msg) {
		super(msg);
	}
}
