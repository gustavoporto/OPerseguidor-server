package br.com.conductor;

import java.rmi.RemoteException;

import br.com.conductor.AcumuladorSegurosResp;
import br.com.conductor.FlashVendasSoapProxy;

public class ClienteWS {

	public static void main(String[] args) {

		try {

			FlashVendasSoapProxy sampleFlashVendasSoapProxyid = new FlashVendasSoapProxy();

			AcumuladorSegurosResp acumuladorSegurosAderidos35mtemp = sampleFlashVendasSoapProxyid
					.acumuladorSegurosAderidos();

			System.out
					.println(acumuladorSegurosAderidos35mtemp.getCodRetorno());

			System.out.println(acumuladorSegurosAderidos35mtemp
					.getAcumuladorSeguros().length);

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
