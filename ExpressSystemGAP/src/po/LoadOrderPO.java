package po;

import java.io.Serializable;
import java.util.List;

public class LoadOrderPO implements Serializable {
	//
	private String date, number, departureins_id, targetins_id, loaded_id,
			trans_id;
	private List<String> orders_id;
}
