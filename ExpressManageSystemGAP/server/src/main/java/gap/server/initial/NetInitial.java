package gap.server.initial;

import gap.server.databaseutility.Lancher;

public class NetInitial {

	public static void initial() {
		NetModule.excutor = Lancher.lanch();
	}

	public static void main(String[] args) {
		initial();
	}
}
