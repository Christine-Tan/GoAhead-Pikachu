package client.vo;

import java.util.Map;

import po.ExpressOrderPO;

public class DeliveryOrderVO {
	// 派件信息，记录派件快递员和对应派件快递
	private Map<String, ExpressOrderPO> deliveryInfo;
	// 派件单生成时间
	private String time;
	// 派件单编号
	private String id;

	public DeliveryOrderVO() {

	}

	public DeliveryOrderVO(Map<String, ExpressOrderPO> deliveryInfo,
			String time, String id) {
		super();
		this.deliveryInfo = deliveryInfo;
		this.time = time;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, ExpressOrderPO> getDeliveryInfo() {
		return deliveryInfo;
	}

	public final void setDeliveryInfo(Map<String, ExpressOrderPO> deliveryInfo) {
		this.deliveryInfo = deliveryInfo;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
