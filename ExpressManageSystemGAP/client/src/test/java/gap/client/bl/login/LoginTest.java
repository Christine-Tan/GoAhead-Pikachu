package gap.client.bl.login;

import gap.client.util.LocalInfo;
import gap.client.vo.LogVO;
import junit.framework.TestCase;

public class LoginTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testLogin() {
		Login log = new Login();
		LogVO logVO = log.login("yyf", "123456");
		if (logVO.isSucceed()) {
			System.out.println("succeed");
			System.out.println("Name:" + LocalInfo.localuser.getName());
			System.out.println("Type:" + LocalInfo.localuser.getUserType());
		} else {
			System.out.println("failed");
		}
	}

}
