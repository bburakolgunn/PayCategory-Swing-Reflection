package PayCategory;

public class OdemeIslemiFactory {
	
	
	public IOdemeTipi createInstance(String className)
	{
		IOdemeTipi iOdemeTipi = null;
		try
		{
			Class c;
			c = Class.forName("PayCategory."+className);
			iOdemeTipi = (IOdemeTipi)c.newInstance();
		}
		catch(Exception ex) {
			System.out.println("Hata oluştu : " + ex.getMessage().toString());
		}
		return iOdemeTipi;  //KrediKarti IOdemeTipi
	}

}
