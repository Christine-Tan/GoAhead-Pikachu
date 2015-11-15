package gap.common.po;

import gap.common.util.CargoInfo;
import gap.common.util.ExpressType;
import gap.common.util.PeopleInfo;

import java.io.Serializable;

public class ExpressOrderPO implements Serializable {
	// 寄件人姓名、地址、单位、电话
	private PeopleInfo senderInfo;
	// 收件人姓名、地址、单位、电话
	private PeopleInfo receiverInfo;
	// 快递类型
	private ExpressType expressType;
	// 货物信息
	private CargoInfo cargoInfo;
	// 是否接收
	private boolean received;
	// 快递单号
	private String order_id;
	// 快递所在机构编号和即将发往的机构编号
	private String currentins_id, targetins_id;
	// 寄件单所属于的营业厅装车单、营业厅到达单、中专中心装车单、中转中心到达单、派件单编号
	private String clerkLoadOrder_id, clerkArrivedOrder_id, centerLoadOrder_id,
			centerArrived_id, DeliveryOrder_id;

	public ExpressOrderPO() {

	}

	public ExpressOrderPO(String sender_name, String sender_address,
			String sender_depart, String sender_cellphone,
			String receiver_name, String receiver_address,
			String receiver_depart, String receiver_cellphone,
			ExpressType expressType, CargoInfo cargoInfo, boolean received,
			String order_id, String currentins_id, String targetins_id,
			String clerkLoadOrder_id, String clerkArrivedOrder_id,
			String centerLoadOrder_id, String centerArrived_id,
			String deliveryOrder_id) {
		super();
		senderInfo = new PeopleInfo(sender_name, sender_address, sender_depart,
				sender_cellphone);
		receiverInfo = new PeopleInfo(receiver_name, receiver_address,
				receiver_depart, receiver_cellphone);
		this.expressType = expressType;
		this.cargoInfo = cargoInfo;
		this.received = received;
		this.order_id = order_id;
		this.currentins_id = currentins_id;
		this.targetins_id = targetins_id;
		this.clerkLoadOrder_id = clerkLoadOrder_id;
		this.clerkArrivedOrder_id = clerkArrivedOrder_id;
		this.centerLoadOrder_id = centerLoadOrder_id;
		this.centerArrived_id = centerArrived_id;
		DeliveryOrder_id = deliveryOrder_id;
	}

	public boolean isReceived() {
		return received;
	}

	public void setReceived(boolean received) {
		this.received = received;
	}

	public ExpressType getExpressType() {
		return expressType;
	}

	public void setExpressType(ExpressType expressType) {
		this.expressType = expressType;
	}

	public CargoInfo getCargoInfo() {
		return cargoInfo;
	}

	public void setCargoInfo(CargoInfo cargoInfo) {
		this.cargoInfo = cargoInfo;
	}

	public String getCurrentins_id() {
		return currentins_id;
	}

	public void setCurrentins_id(String currentins_id) {
		if (currentins_id == null)
			return;
		targetins_id = null;// currentins_id与targetins_id不能同时被设置为非null值
		this.currentins_id = currentins_id;
	}

	public String getTargetins_id() {
		return targetins_id;
	}

	public void setTargetins_id(String targetins_id) {
		if (targetins_id == null)
			return;
		currentins_id = null;
		this.targetins_id = targetins_id;
	}

	public String getClerkLoadOrder_id() {
		return clerkLoadOrder_id;
	}

	public void setClerkLoadOrder_id(String clerkLoadOrder_id) {
		this.clerkLoadOrder_id = clerkLoadOrder_id;
	}

	public String getClerkArrivedOrder_id() {
		return clerkArrivedOrder_id;
	}

	public void setClerkArrivedOrder_id(String clerkArrivedOrder_id) {
		this.clerkArrivedOrder_id = clerkArrivedOrder_id;
	}

	public String getCenterLoadOrder_id() {
		return centerLoadOrder_id;
	}

	public void setCenterLoadOrder_id(String centerLoadOrder_id) {
		this.centerLoadOrder_id = centerLoadOrder_id;
	}

	public String getCenterArrived_id() {
		return centerArrived_id;
	}

	public void setCenterArrived_id(String centerArrived_id) {
		this.centerArrived_id = centerArrived_id;
	}

	public String getDeliveryOrder_id() {
		return DeliveryOrder_id;
	}

	public void setDeliveryOrder_id(String deliveryOrder_id) {
		DeliveryOrder_id = deliveryOrder_id;
	}

	public PeopleInfo getSenderInfo() {
		return senderInfo;
	}

	public void setSenderInfo(PeopleInfo senderInfo) {
		this.senderInfo = senderInfo;
	}

	public PeopleInfo getReceiverInfo() {
		return receiverInfo;
	}

	public void setReceiverInfo(PeopleInfo receiverInfo) {
		this.receiverInfo = receiverInfo;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

}
