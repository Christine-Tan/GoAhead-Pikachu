package client.dataservice.userdataservice;

import client.po.ResultMessage;
import client.po.UserPO;

public interface UserDataService {
          public ResultMessage  insert(UserPO po);
          public UserPO find(String user_id);
          public ResultMessage delete(String user_id);
          public ResultMessage update(UserPO po);
}
