package gap.client.blcontroller;

import java.util.List;

import gap.client.bl.log.Log;
import gap.client.vo.LogVO;

public class LogController {
	private static Log logManage = new Log();

	public LogController() {
		// TODO Auto-generated constructor stub
	}

	public static List<LogVO> getLogList(){
	      return logManage.getLogList();
	}
}
