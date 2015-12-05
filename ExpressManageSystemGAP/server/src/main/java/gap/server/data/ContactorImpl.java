package gap.server.data;

import gap.common.dataservice.Contactor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 用于测试客户端和服务器连接是否正常的类
 * @author YangYanfei
 *
 */
public class ContactorImpl extends UnicastRemoteObject implements Contactor {

	public ContactorImpl() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	@Override
	public boolean getInfo() throws RemoteException {
		// TODO 自动生成的方法存根
		return true;
	}

}
