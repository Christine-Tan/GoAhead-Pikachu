package gap.client.blservice.loginblservice;

import gap.client.vo.LogVO;

public interface LoginService {
	public LogVO login(String username, String password);
}
