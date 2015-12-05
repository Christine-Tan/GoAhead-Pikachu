package gap.common.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 用于测试客户端和网络端连接是否正常的类
 * @author YangYanfei
 *
 */
public class Contactor extends UnicastRemoteObject implements Remote {

	public Contactor() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public boolean getInfo() {
		return true;
	}

}
