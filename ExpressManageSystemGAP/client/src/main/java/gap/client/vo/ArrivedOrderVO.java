package gap.client.vo;

import gap.common.po.ArrivedOrderPO;
import gap.common.po.ExpressOrderPO;

import java.util.List;
import java.util.Map;

public class ArrivedOrderVO {
	// 到达单订单
	public Map<String, String> orders;
	// 生成时间
	public String time;
	// 到达单编号
	public String id;
	// 发货机构编号
	public String from_ins_id;
	// 到达机构编号
	public String des_ins_id;
	// 备注
	public String comment;

	public ArrivedOrderVO() {
		// TODO 自动生成的构造函数存根
	}

	public ArrivedOrderPO toPO() {
		return new ArrivedOrderPO(orders, time, id, from_ins_id, des_ins_id,
				comment);
	}

	public ArrivedOrderVO(Map<String, String> orders, String time, String id,
			String from_ins_id, String des_ins_id, String comment) {
		super();
		this.orders = orders;
		this.time = time;
		this.id = id;
		this.from_ins_id = from_ins_id;
		this.des_ins_id = des_ins_id;
		this.comment = comment;
	}

}
