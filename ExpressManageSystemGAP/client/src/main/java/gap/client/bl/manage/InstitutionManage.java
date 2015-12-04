package gap.client.bl.manage;

import gap.client.blservice.manageblservice.InstitutionService;
import gap.client.datacontroller.ControllerFactory;
import gap.client.datacontroller.managedata.InstitutionDataController;
import gap.client.util.AbstractOperation;
import gap.client.util.Operation;
import gap.client.vo.InstitutionVO;
import gap.common.po.InstitutionPO;
import gap.common.util.ResultMessage;

import java.util.ArrayList;
import java.util.List;

public class InstitutionManage implements InstitutionService {
	private static final String ADD = "addInstitution", DELETE = "deleteInstitution", MODIFY = "modifyInstitution";
	List<Operation> operations;
	InstitutionDataController controller;

	public InstitutionManage() {
		controller = ControllerFactory.getInstitutionDataController();
		operations = new ArrayList<Operation>();
	}

	@Override
	public List<InstitutionVO> getAll() {
		// TODO Auto-generated method stub
		List<InstitutionVO> institutions = new ArrayList<InstitutionVO>();
		for (InstitutionPO po : controller.getAll()) {
			institutions.add(new InstitutionVO(po));
		}
		return institutions;
	}

	@Override
	public InstitutionVO findById(String id) {
		// TODO Auto-generated method stub
		return new InstitutionVO(controller.findById(id));
	}

	@Override
	public List<InstitutionVO> findByCity(String city) {
		// TODO Auto-generated method stub
		List<InstitutionVO> institutions = new ArrayList<InstitutionVO>();
		for (InstitutionPO po : controller.findByCity(city)) {
			institutions.add(new InstitutionVO(po));
		}
		return institutions;
	}

	@Override
	public void modifyInstitution(InstitutionVO vo) {
		// TODO Auto-generated method stub
		operations.add(new ModifyOperation(vo.toInstitutionPO()));
	}

	@Override
	public void deleteInstitution(String id) {
		// TODO Auto-generated method stub
		operations.add(new DeleteOperation(id));
	}

	@Override
	public void addInstitution(InstitutionVO vo) {
		// TODO Auto-generated method stub
		operations.add(new AddOperation(vo.toInstitutionPO()));
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

	class DeleteOperation extends AbstractOperation {
		public DeleteOperation(Object args) {
			super(controller, DELETE, args);
		}
	}

	class ModifyOperation extends AbstractOperation {
		public ModifyOperation(Object args) {
			super(controller, MODIFY, args);
		}
	}

}
