package stub_drivers.dataservice.distancedata;

import dataservice.strategydataservice.DistanceDataService;

public class DistanceDataService_driver {
         DistanceDataService distance_driver;
         
         public DistanceDataService_driver(){
        	 distance_driver=new DistanceDataService_stub();
         }
         
         
}
