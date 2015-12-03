package gap.client.bl.strategy;

import java.util.ArrayList;
import java.util.List;

import gap.client.blservice.strategyblservice.SalaryService;
import gap.client.datacontroller.ControllerFactory;
import gap.client.datacontroller.strategydata.SalaryDataController;
import gap.client.util.AbstractOperation;
import gap.client.util.Operation;
import gap.client.vo.SalaryVO;
import gap.common.po.SalaryPO;
import gap.common.util.ResultMessage;
import gap.common.util.UserType;

public class SalaryManage implements SalaryService {
	private static final String ADD = "addSalary", MODIFY = "modifySalary";
	SalaryDataController controller;
	List<Operation> operations;

	public SalaryManage() {
		operations = new ArrayList<Operation>();
		controller = ControllerFactory.getSalaryDataController();
	}

	@Override
	public List<SalaryVO> getAll() {
		// TODO Auto-generated method stub
		List<SalaryVO> salaries=new ArrayList<SalaryVO>();
		for(SalaryPO po:controller.getAll()){
			salaries.add(new SalaryVO(po));
		}
		return salaries;
	}

	@Override
	public SalaryVO getSalary(UserType type) {
		// TODO Auto-generated method stub
		return new SalaryVO(controller.find(type));
	}

	@Override
	public void modifySalary(SalaryVO vo) {
		// TODO Auto-generated method stub
       operations.add(new ModifyOperation(vo.toSalaryPO()));
	}

	@Override
	public void addSalary(SalaryVO vo) {
		// TODO Auto-generated method stub
       operations.add(new AddOperation(vo.toSalaryPO()));
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