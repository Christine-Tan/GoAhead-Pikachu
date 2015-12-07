package gap.common.util;

public enum SectorType {
FLEX,CAR,TRAIN,PLANE;
	
	//航运，铁运，汽运，机动
	String name;
	
	public static SectorType getSectorTypeByChinese(String name){
		switch(name){
		case "汽运区" : return CAR;
		case "铁运区" : return TRAIN;
		case "航运区" : return PLANE;
		case "机动区" : return FLEX;
		default: return null;
		}
		
	}
	
	public static SectorType getSectorType(String name){
		switch(name){
		case "CAR" : return CAR;
		case "TRAIN" : return TRAIN;
		case "PLANE" : return PLANE;
		case "FLEX" : return FLEX;
		default: return null;
		}
		
	}
	
	public static String getSectorId(String ins_id,SectorType name){
		switch(name){
		case CAR : return ins_id+"1";
		case TRAIN : return ins_id+"2";
		case PLANE : return ins_id+"3";
		case FLEX : return ins_id+"0";
		default: return null;
		}
	}
}
