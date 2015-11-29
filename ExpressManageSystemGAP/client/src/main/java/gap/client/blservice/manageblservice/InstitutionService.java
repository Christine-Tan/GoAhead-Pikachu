package gap.client.blservice.manageblservice;

import gap.client.vo.InstitutionVO;
import gap.common.util.ResultMessage;

import java.util.List;

public interface InstitutionService {
	public List<InstitutionVO> getAll();

	public InstitutionVO findById(String id);
	
	public List<InstitutionVO> findByCity(String city);

	public void modifyInstitution(InstitutionVO vo);

	public void deleteInstitution(String id);

	public void addInstitution(InstitutionVO vo);
}
