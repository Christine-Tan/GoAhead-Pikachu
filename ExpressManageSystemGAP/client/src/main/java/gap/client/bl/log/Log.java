package gap.client.bl.log;

import java.util.ArrayList;
import java.util.List;

import gap.client.blservice.logblservice.LogService;
import gap.client.datacontroller.ControllerFactory;
import gap.client.datacontroller.LogDataController;
import gap.client.vo.LogVO;
import gap.common.po.LogPO;

public class Log implements LogService {
	LogDataController controller;
   List<LogVO> logs;
	public Log() {
		// TODO Auto-generated constructor stub
		controller = ControllerFactory.getLogDataController();
	}

	@Override
	public List<LogVO> getLogList() {
		// TODO Auto-generated method stub
		logs=new ArrayList<>();
		for(LogPO po:controller.getLogList()){
				logs.add(new LogVO(po));
		}
		return logs;
	}

}
