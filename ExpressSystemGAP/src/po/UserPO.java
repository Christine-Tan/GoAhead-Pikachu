package po;

import java.io.Serializable;

public class UserPO implements Serializable {
           private long userId;
           private String type;
           private String userName;
           private int rank;
           
           public UserPO (long id,String type,String name){
        	   userId=id;
        	   this.type=type;
        	   rank=0;//rank要根据id算出来；
           }
            
           public void setName(String name){
        	   userName=name;
           }

		/**
		 * @return userId
		 */
		public long getUserId() {
			return userId;
		}

		/**
		 * @param userId 要设置的 userId
		 */
		public void setUserId(long userId) {
			this.userId = userId;
		}

		/**
		 * @return type
		 */
		public String getType() {
			return type;
		}

		/**
		 * @param type 要设置的 type
		 */
		public void setType(String type) {
			this.type = type;
		}

		/**
		 * @return userName
		 */
		public String getUserName() {
			return userName;
		}

		/**
		 * @param userName 要设置的 userName
		 */
		public void setUserName(String userName) {
			this.userName = userName;
		}

		/**
		 * @return rank
		 */
		public int getRank() {
			return rank;
		}

		/**
		 * @param rank 要设置的 rank
		 */
		public void setRank(int rank) {
			this.rank = rank;
		}
          
}
