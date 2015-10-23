package client.blservice.strategyblservice;

import client.vo.PriceVO;

public interface PriceService {
	public void modifyPrice(PriceVO vo);

	public PriceVO getPrice();
}
