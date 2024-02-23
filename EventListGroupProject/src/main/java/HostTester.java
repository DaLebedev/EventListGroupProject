import java.util.List;

import controller.HostHelper;
import model.Host;

public class HostTester {

	public static void main(String[] args) {
		
		Host bill = new Host("Daniel");
		Host jim = new Host("Joshua");
		HostHelper hh = new HostHelper();
		
		hh.insertHost(bill);
		hh.insertHost(jim);
		
		List<Host> allHosts = hh.showAllHosts();
		
		for(Host a: allHosts) {
			System.out.println(a.toString());
		}
	}
}
