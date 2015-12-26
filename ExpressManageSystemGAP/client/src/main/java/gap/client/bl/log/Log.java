package gap.client.bl.log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gap.client.blservice.logblservice.LogService;
import gap.client.datacontroller.ControllerFactory;
import gap.client.datacontroller.LogDataController;
import gap.client.vo.LogVO;
import gap.common.po.LogPO;

public class Log implements LogService {
	LogDataController controller;
	List<LogVO> logs;
	HashMap<String, List<LogVO>> logByDate;

	public Log() {
		// TODO Auto-generated constructor stub
		controller = ControllerFactory.getLogDataController();
	}

	@Override
	public List<LogVO> getLogList() {
		// TODO Auto-generated method stub
		logs = new ArrayList<>();
		for (LogPO po : controller.getLogList()) {
			logs.add(new LogVO(po));
		}
		return logs;
	}

	public HashMap<String, List<LogVO>> getLogByDate(){
		logByDate=new HashMap<String,List<LogVO>>();
		logs=this.getLogList();
		for(int i=0;i<logs.size();i++){
			String date=logs.get(i).getDate().substring(0, 10);
			if(logByDate.containsKey(date)){
				logByDate.get(date).add(logs.get(i));
			}else{
				List<LogVO> logs=new ArrayList<>();
				logByDate.put(date, logs);
			}			
		}
		return logByDate;		
	}

}
