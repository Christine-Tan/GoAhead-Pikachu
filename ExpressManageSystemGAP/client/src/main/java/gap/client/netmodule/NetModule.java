package gap.client.netmodule;

import gap.common.dataservice.Contactor;
import gap.common.dataservice.accountdataservice.AccountDataService;
import gap.common.dataservice.expressorderdataservice.ExpressOrderDataService;
import gap.common.dataservice.logdataservice.LogDataService;
import gap.common.dataservice.managedataservice.InstitutionDataService;
import gap.common.dataservice.orderdataservice.ArrivedOrderDataService;
import gap.common.dataservice.orderdataservice.DeliveryOrderDataService;
import gap.common.dataservice.orderdataservice.LoadOrderDataService;
import gap.common.dataservice.receiptdataservice.BillOrderDataService;
import gap.common.dataservice.receiptdataservice.PaymentdataService;
import gap.common.dataservice.strategydataservice.CityDataService;
import gap.common.dataservice.strategydataservice.PriceDataService;
import gap.common.dataservice.strategydataservice.RentDataService;
import gap.common.dataservice.strategydataservice.SalaryDataService;
import gap.common.dataservice.transdataservice.CarDataService;
import gap.common.dataservice.transdataservice.DriverDataService;
import gap.common.dataservice.userdataservice.UserDataService;

public class NetModule {
	private AccountDataService accountDataService;
	private UserDataService userdataservice;
	private LogDataService logdataservice;
	private CarDataService cardataservice;
	private DriverDataService driverdataservice;
	private ArrivedOrderDataService arrivedOrderdataservice;
	private ExpressOrderDataService expressorderdataservice;
	private DeliveryOrderDataService deliveryorderdataservice;
	private LoadOrderDataService loadorderdataservice;
	private PriceDataService pricedataservice;
	private RentDataService rentdataservice;
	private SalaryDataService salarydataservice;
	private CityDataService citydataservice;
	private InstitutionDataService institutiondataservice;
	private BillOrderDataService billorderdataservice;
	private PaymentdataService paymentdataService;

	private Contactor contactor;
}
