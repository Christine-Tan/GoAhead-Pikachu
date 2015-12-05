package gap.client.bl.strategy;

import gap.client.blservice.strategyblservice.PriceService;
import gap.client.datacontroller.ControllerFactory;
import gap.client.datacontroller.PriceDataController;
import gap.client.util.AbstractOperation;
import gap.client.util.Operation;
import gap.client.vo.PriceVO;
import gap.common.po.PricePO;
import gap.common.util.ResultMessage;

import java.util.ArrayList;
import java.util.List;

public class PriceManage implements PriceService {
	private static final String ADD = "addPrice", MODIFY = "modifyPrice";
	PriceDataController controller;
	List<Operation> operations;

	public PriceManage() {
		controller = ControllerFactory.getPriceDataController();
		operations = new ArrayList<Operation>();
	}

	@Override
	public List<PriceVO> getAll() {
		// TODO Auto-generated method stub
		List<PriceVO> prices = new ArrayList<PriceVO>();
		for (PricePO po : controller.getAll()) {
			prices.add(new PriceVO(po));
		}
		return prices;
	}

	@Override
	public PriceVO getPrice(String city) {
		// TODO Auto-generated method stub
		return new PriceVO(controller.find(city));
	}

	@Override
	public void modifyPrice(PriceVO vo) {
		// TODO Auto-generated method stub
		operations.add(new ModifyOperation(vo.toPricePO()));
	}

	@Override
	public void addPrice(PriceVO vo) {
		// TODO Auto-generated method stub
		operations.add(new AddOperation(vo.toPricePO()));
	}

	/**
	 * 将操作缓存起来，按序处理缓存队列
	 * 
	 * @return
	 */
	public ResultMessage flush() {
		for (Operation ope : operations) {
			ResultMessage re = ope.excute();
			if (!re.equals(ResultMessage.SUCCEED)) {
				operations.clear();
				return re;
			}
		}
		operations.clear();
		return ResultMessage.SUCCEED;
	}

	class AddOperation extends AbstractOperation {
		public AddOperation(Object args) {
			super(controller, ADD, args);
		}
	}

	class ModifyOperation extends AbstractOperation {
		public ModifyOperation(Object args) {
			super(controller, MODIFY, args);
		}
	}
}
