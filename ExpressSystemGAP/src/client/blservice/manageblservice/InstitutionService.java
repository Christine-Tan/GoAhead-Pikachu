package client.blservice.manageblservice;

import java.util.List;

import util.ResultMessage;
import client.vo.InstitutionVO;

public interface InstitutionService {
	public List<InstitutionVO> getAll();

	public InstitutionVO getSingle(String id);

	public ResultMessage modify(InstitutionVO vo);

	public ResultMessage delete(String id);

	public ResultMessage add(InstitutionVO vo);
}
