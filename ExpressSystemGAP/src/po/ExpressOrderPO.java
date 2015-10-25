package po;

import java.io.Serializable;

public class ExpressOrderPO implements Serializable {
	private String sender_name, sender_address, sender_depart,
			sender_cellphone;
	private String receiver_name, receiver_address, receiver_depart,
			receiver_cellphone;
	private String order_id;
}
