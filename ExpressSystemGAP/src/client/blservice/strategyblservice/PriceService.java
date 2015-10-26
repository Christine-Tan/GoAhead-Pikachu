package client.blservice.strategyblservice;

import java.util.List;

import util.ResultMessage;
import client.vo.PriceVO;

public interface PriceService {
	public List<PriceVO> getAll();

	public ResultMessage modifyPrice(PriceVO vo);

	public PriceVO getPrice(String city_id);
}
