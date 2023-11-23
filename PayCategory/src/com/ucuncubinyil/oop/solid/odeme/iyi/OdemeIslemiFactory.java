package com.ucuncubinyil.oop.solid.odeme.iyi;

public class OdemeIslemiFactory {
	
	
	public IOdemeTipi createInstance(String className)
	{
		IOdemeTipi iOdemeTipi = null;
		try
		{
			Class c;
			c = Class.forName("com.ucuncubinyil.oop.solid.odeme.iyi."+className);
			iOdemeTipi = (IOdemeTipi)c.newInstance();
		}
		catch(Exception ex) {
			System.out.println("Hata oluştu : " + ex.getMessage().toString());
		}
		return iOdemeTipi;  //KrediKarti IOdemeTipi
	}

}
