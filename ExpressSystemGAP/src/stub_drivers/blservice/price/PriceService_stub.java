package stub_drivers.blservice.price;

import java.util.ArrayList;
import java.util.List;

import po.PricePO;
import po.UserPO;
import stub_drivers.dataservice.pricedata.PriceDataService_stub;
import stub_drivers.dataservice.userdata.UserDataService_stub;
import util.ResultMessage;
import client.blservice.strategyblservice.PriceService;
import client.vo.PriceVO;
import client.vo.UserVO;

public class PriceService_stub implements PriceService{
	PriceDataService_stub datastub;

	public PriceService_stub() {
		datastub = new PriceDataService_stub();
	}
	
	@Override
	public ResultMessage modifyPrice(PriceVO vo) {
		// TODO 自动生成的方法存根
		return datastub.modify(getPO(vo));
	}

	@Override
	public PriceVO getPrice(String city_id) {
		// TODO 自动生成的方法存根
		return getVO(datastub.find(city_id));
	}

	@Override
	public List<PriceVO> getAll() {
		// TODO 自动生成的方法存根
		List<PriceVO> list = new ArrayList<PriceVO>();
		for (PricePO price : datastub.getAll())
			list.add(getVO(price));
		return list;
	}

	private PriceVO getVO(PricePO po) {
		return new PriceVO();
	}

	private PricePO getPO(PriceVO vo) {
		return new PricePO();
	}

	@Override
	public ResultMessage add(PriceVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}
}
