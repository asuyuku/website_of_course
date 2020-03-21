package com.graduation.one.exception;


/**
 * 
 * @ClassName: QueryFailedException
 * @Description: 事务需要回滚事，抛出该异常
 * @author Yujn
 * @date 2018年9月29日
 *
 */
public class RollBackException extends GlobalException {
	private static final long serialVersionUID = 2110658694693754789L;
	public RollBackException() {
		super();
	}

	public RollBackException(String message, Throwable cause, boolean enableSuppression,
							 boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public RollBackException(String message, Throwable cause) {
		super(message, cause);
	}

	public RollBackException(String message) {
		super(message);
	}

	public RollBackException(Throwable cause) {
		super(cause);
	}
}
