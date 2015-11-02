package gap.client.vo;

public class GoodsVO {
	//快递编号10位0~9数字
	private String expressorder_id;
	//仓库中存放位置
	private String location;
	//所属分区
	private String sector;
	//入库日期
	private String date;
	
	
	
	public GoodsVO(String expressorder_id, String location, String sector,
			String date) {
		super();
		this.expressorder_id = expressorder_id;
		this.location = location;
		this.sector = sector;
		this.date = date;
	}
	public String getExpressorder_id() {
		return expressorder_id;
	}
	public void setExpressorder_id(String expressorder_id) {
		this.expressorder_id = expressorder_id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
}
