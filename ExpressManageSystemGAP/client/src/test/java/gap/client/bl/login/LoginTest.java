package gap.client.bl.login;

import gap.client.datacontroller.NetModule;
import gap.client.util.LocalInfo;
import gap.client.vo.LogVO;
import junit.framework.TestCase;

public class LoginTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
		NetModule.connect();
	}

	public void testLogin() {
		Login log = new Login();
		LogVO logVO = log.login("yyf", "123456");
		assertEquals(logVO.isSucceed(), true);
		assertEquals(LocalInfo.localuser.getName(), "杨雁飞");
	}

}
