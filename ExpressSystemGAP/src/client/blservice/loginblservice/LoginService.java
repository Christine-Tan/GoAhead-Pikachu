package client.blservice.loginblservice;

import client.vo.LogVO;

public interface LoginService {
	public LogVO login(String username, String password);
}
