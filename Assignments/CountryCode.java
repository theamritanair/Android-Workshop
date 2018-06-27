import java.util.Scanner;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CountryCode{

	// public String getCountry(String code){
		


	// }
	public static void main(String[] args){

		HashMap<String, String> cc= new HashMap<>();

		cc.put("AFG","Afghanistan");
		cc.put("ALB","Albania");
		cc.put("DZA","Algeria");
		cc.put("ASM", "American Samoa");
		cc.put("AND","Andorra");
		cc.put("AGO","Angola");
		cc.put("AIA","Anguilla");
		cc.put("ATA","Antartcica");
		cc.put("ATG","Antigua and Barbuda");
		cc.put("ARG","Argentina");
		cc.put("ARM","Armenia");
		cc.put("ABW","Aruba");
		cc.put("AUS","Australia");
		cc.put("AUT","Austria");
		cc.put("AZE","Azerbaijain");
		cc.put("BHS","Bahamas");
		cc.put("BHR","Bahrain");
		cc.put("BGD","Bangladesh");
		cc.put("BRB","Barbados");
		cc.put("BLR","Belarus");
		cc.put("BEL","Belgium");
		cc.put("BLZ","Belize");
		cc.put("BEN","Benin");
		cc.put("BMU","Bemruda");
		cc.put("BTN","Bhutan");
		cc.put("BOL","Bolivia");
		cc.put("BIH","Bosnia and Herzegovina");
		cc.put("BWA","Bostwana");
		cc.put("BRA","Brazil");
		cc.put("IOT","British Indian Ocean Territory");
		cc.put("VGB"."British Virgin Islands");
		cc.put("BRN","Brunei");
		cc.put("BGR","Bulgaria");
		cc.put("BFA","Burkina Faso");;
		cc.put("BDI","Burundi");
		cc.put("KHM","Cambodia");
		cc.put("CMR","Cameroon");
		cc.put("CAN","Canada");
		cc.put("CPV","Cape Verde");
		cc.put("CYM","Cayman Islands");
		cc.put("CAF","Central African Republic");
		cc.put("TCD","Chad");
		cc.put("CHL","Chile");
		cc.put("CHN","China");
		cc.put("CXR","Christmas Island");
		cc.put("COK","Cocos Island");
		cc.put("CRI","Costa Rica");
		cc.put("HRV","Crotia");
		cc.put("CUB","Cuba");
		cc.put("CUW","Curacao");
		cc.put("CYP","Cyprus");
		cc.put("CZE","Czech Republic");
		cc.put("COD","Democratic Republic of the Congo");
		cc.put("DNK","Denmark");
		cc.put("DJI","Dijibouti");
		cc.put("DMA","Dominica");
		cc.put("DOM","Dominican Republic");
		cc.put("TLS","East Timor");
		cc.put("ECU","Ecuador");
		cc.put("EGY","Egypt");
		cc.put("SLV","EL Salvador");
		cc.put("GNQ","Equatorial Guinea");
		cc.put("ERI","Eritea");
		cc.put("EST","Estonia");
		cc.put("ETH","Ethiopia");
		cc.put("FLK","Falkland Islands");
		cc.put("FRO","Faroe Islands");
		cc.put("FJI","Fiji");
		cc.put("FIN","Finland");
		cc.put("FRA","France");
		cc.put("PYF","French Polynesia");
		cc.put("GAB","Gabon");
		cc.put("GMB","Gambia");
		cc.put("GEO","Georgia");
		cc.put("DEU","Germany");
		cc.put("GHA","Ghana");
		cc.put("GIB","Gibraltar");
		cc.put("GRC","Greece");
		cc.out("GRL","Greenland");
		cc.put("GRD","Grenada");
		cc.put("IND","India");
		cc.put("IDN","Indonesia");
		cc.put("UGA","Uganda");
		cc.put("UKR","Ukraine");
		cc.put("ARE","United Arab Emirates");
		cc.put("GBR","united Kingdom");
		cc.put("USA","United States of America");
		cc.put("URY","Uruguay");
		cc.put("UZB","Uzbekistan");
		cc.put("VUT","Vanuatu");
		cc.put("VAT","Vatican");
		cc.put("VEN","Venezuela");
		cc.put("VNM","Vietnam");
		cc.put("WLF","Wallis and Futuna");
		cc.put("ESH","Western Sahara");
		cc.put("YEM,""Yemen");
		cc.put("ZMB","Zambia");
		cc.put("ZWE","Zimbabwe");







		

	
		Iterator <Map.Entry<String, String>> it = cc.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, String> pair = it.next();
			System.out.println(pair.getKey() + " - " + pair.getValue());
			}
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String found = cc.get(s);
		System.out.println(found);
	}


}