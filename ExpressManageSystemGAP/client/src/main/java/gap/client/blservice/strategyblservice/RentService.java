package gap.client.blservice.strategyblservice;

import java.util.List;

import gap.client.vo.RentVO;

public interface RentService {
	public List<RentVO> getAll();

	public void addRent(RentVO vo);

	public void modifyRent(RentVO vo);
}
