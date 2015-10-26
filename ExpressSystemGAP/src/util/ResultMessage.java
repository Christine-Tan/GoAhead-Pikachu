package util;

import java.io.Serializable;

public class ResultMessage implements Serializable {
	private String message;

	public ResultMessage(String message) {
		this.message = message;
	}

	public boolean equals(Object ob) {
		if (!(ob instanceof ResultMessage))
			return false;
		return ((ResultMessage) ob).getMessage().equals(message);

	}

	public String getMessage() {
		return message;
	}

	public static ResultMessage EXITED, SUCCEED, NOTFOUND;
	static {
		EXITED = new ResultMessage("exited");
		SUCCEED = new ResultMessage("succeed");
		NOTFOUND = new ResultMessage("not found");

	}
}
