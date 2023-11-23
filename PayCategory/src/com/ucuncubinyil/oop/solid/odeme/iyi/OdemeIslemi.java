package com.ucuncubinyil.oop.solid.odeme.iyi;

public class OdemeIslemi {
	
	private IOdemeTipi iOdemeTipi;
	
	public OdemeIslemi(IOdemeTipi iOdemeTipi)
	{
		this.iOdemeTipi = iOdemeTipi;
	}
	
	public String OdemeYap(double tutar)
	{
		return iOdemeTipi.Ode(tutar);
	}

}
