package gap.common.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import gap.common.po.UserPO;

/**
 * 用于测试客户端和网络端连接是否正常的接口
 * @author YangYanfei
 *
 */
public interface Contactor extends Remote {

	public boolean getInfo(String IP,UserPO userPO) throws RemoteException;

}
