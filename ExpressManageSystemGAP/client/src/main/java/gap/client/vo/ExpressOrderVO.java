package gap.client.vo;

import gap.common.po.ExpressOrderPO;
import gap.common.util.CargoInfo;
import gap.common.util.ExpressType;
import gap.common.util.PeopleInfo;

public class ExpressOrderVO {
	// 寄件人收件人信息姓名、地址、单位、电话
	private PeopleInfo sender_info, receiver_info;
	// 快递类型
	private ExpressType expressType;
	// 快递价格
	private double price;
	// 货物信息
	private CargoInfo cargoInfo;
	// 是否接收
	private boolean received;
	// 快递单号
	private String order_id;
	// 快递所在机构编号和即将发往的机构编号
	private String currentins_id, targetins_id;

	public ExpressOrderVO() {

	}

	public ExpressOrderVO(ExpressOrderPO po) {
		this.sender_info = po.getSenderInfo();
		receiver_info = po.getReceiverInfo();
		price = po.getPrice();
		cargoInfo = po.getCargoInfo();
		received = po.isReceived();
		order_id = po.getOrder_id();
		currentins_id = po.getCurrentins_id();
		targetins_id = po.getTargetins_id();
	}

	public ExpressOrderVO(PeopleInfo sender_info, PeopleInfo receiver_info,
			ExpressType expressType, double price, CargoInfo cargoInfo,
			boolean received, String order_id, String currentins_id,
			String targetins_id) {
		super();
		this.sender_info = sender_info;
		this.receiver_info = receiver_info;
		this.expressType = expressType;
		this.price = price;
		this.cargoInfo = cargoInfo;
		this.received = received;
		this.order_id = order_id;
		this.currentins_id = currentins_id;
		this.targetins_id = targetins_id;
	}

	public ExpressOrderPO toPO() {
		ExpressOrderPO po = new ExpressOrderPO(sender_info, receiver_info,
				expressType, cargoInfo, order_id, price, currentins_id,
				targetins_id);
		return po;
	}

	public ExpressOrderVO(String sender_name, String sender_address,
			String sender_depart, String sender_cellphone,
			String receiver_name, String receiver_address,
			String receiver_depart, String receiver_cellphone,
			ExpressType expressType, CargoInfo cargoInfo, boolean received,
			String order_id, String currentins_id, String targetins_id) {
		super();
		this.expressType = expressType;
		this.cargoInfo = cargoInfo;
		this.received = received;
		this.order_id = order_id;
		this.currentins_id = currentins_id;
		this.targetins_id = targetins_id;

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

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
