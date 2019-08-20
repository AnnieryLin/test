package net.lgs.exception;

/**
 * 自定义异常：评分记录已存在
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class ScoreExistException extends Exception {

	public ScoreExistException() {
		super();
	}

	public ScoreExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public ScoreExistException(String message) {
		super(message);
	}

	public ScoreExistException(Throwable cause) {
		super(cause);
	}

}
