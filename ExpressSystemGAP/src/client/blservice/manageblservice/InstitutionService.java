package client.blservice.manageblservice;

import client.vo.InstitutionVO;

public interface InstitutionService {
    public InstitutionVO[] getAll();
    public InstitutionVO getSingle(String id);
    public void modify(InstitutionVO vo);
    public void delete(String id);
    public void add(InstitutionVO vo);
}
