package util;

import java.io.Serializable;

public class ResultMessage implements Serializable {
	private String message;

	public ResultMessage(String message) {
		this.message = message;
	}

	public static ResultMessage EXITED, SUCCEED, NOTFOUND;
	static {
		EXITED = new ResultMessage("exited");
		SUCCEED = new ResultMessage("succeed");
		NOTFOUND = new ResultMessage("not found");

	}
}
