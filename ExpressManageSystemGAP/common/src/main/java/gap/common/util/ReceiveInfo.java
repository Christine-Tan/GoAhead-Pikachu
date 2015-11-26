package gap.common.util;

import java.io.Serializable;

public class ReceiveInfo implements Serializable {
	private String receiver_name, receive_time, delivery_id, comment;

	public ReceiveInfo(String receiver_name, String receive_time,
			String delivery_id, String comment) {
		super();
		this.receiver_name = receiver_name;
		this.receive_time = receive_time;
		this.delivery_id = delivery_id;
		this.comment = comment;
	}

	public String getDelivery_id() {
		return delivery_id;
	}

	public void setDelivery_id(String delivery_id) {
		this.delivery_id = delivery_id;
	}

	public String getReceiver_name() {
		return receiver_name;
	}

	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}

	public String getReceive_time() {
		return receive_time;
	}

	public void setReceive_time(String receive_time) {
		this.receive_time = receive_time;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
