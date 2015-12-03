package gap.client.blcontroller;

import java.util.List;

import gap.client.bl.manage.InstitutionManage;
import gap.client.vo.InstitutionVO;
import gap.common.util.ResultMessage;

public class InstitutionController {
           public static InstitutionManage institutionManage=new InstitutionManage();
           
       	public List<InstitutionVO> getAll(){
       		return institutionManage.getAll();
       	}

    	public InstitutionVO findById(String id){
    		return institutionManage.findById(id);
    	}
    	
    	public List<InstitutionVO> findByCity(String city){
    		return institutionManage.findByCity(city);
    	}

    	public void modifyInstitution(InstitutionVO vo){
    		institutionManage.modifyInstitution(vo);
    	}

    	public void deleteInstitution(String id){
    		institutionManage.deleteInstitution(id);
    	}

    	public void addInstitution(InstitutionVO vo){
    		institutionManage.addInstitution(vo);
    	}
    	
    	public ResultMessage flush(){
    		 return institutionManage.flush();
    	}
}
