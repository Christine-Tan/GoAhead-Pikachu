package stub_drivers.blservice.log;

import client.blservice.logblservice.LogService;
import client.vo.LogListVO;

public class Log_stub implements LogService {

	@Override
	public LogListVO getLog() {
		// TODO Auto-generated method stub
		return new LogListVO();
	}

}
