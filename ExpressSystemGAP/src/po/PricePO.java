package po;

import java.io.Serializable;

public class PricePO implements Serializable {
        double rate;
        double base;
        String cityId;
        public PricePO(String id,double rate,double base){
        	this.rate=rate;
        	this.base=base;
        	cityId=id;
        }
		/**
		 * @return rate
		 */
		public double getRate() {
			return rate;
		}
		/**
		 * @param rate 要设置的 rate
		 */
		public void setRate(double rate) {
			this.rate = rate;
		}
		/**
		 * @return base
		 */
		public double getBase() {
			return base;
		}
		/**
		 * @param base 要设置的 base
		 */
		public void setBase(double base) {
			this.base = base;
		}
		/**
		 * @return cityId
		 */
		public String getCityId() {
			return cityId;
		}
		/**
		 * @param cityId 要设置的 cityId
		 */
		public void setCityId(String cityId) {
			this.cityId = cityId;
		}
        
}
