package br.com.conductor;

public class FlashVendasSoapProxy implements br.com.conductor.FlashVendasSoap {
  private String _endpoint = null;
  private br.com.conductor.FlashVendasSoap flashVendasSoap = null;
  
  public FlashVendasSoapProxy() {
    _initFlashVendasSoapProxy();
  }
  
  public FlashVendasSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initFlashVendasSoapProxy();
  }
  
  private void _initFlashVendasSoapProxy() {
    try {
      flashVendasSoap = (new br.com.conductor.FlashVendasLocator()).getFlashVendasSoap();
      if (flashVendasSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)flashVendasSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)flashVendasSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (flashVendasSoap != null)
      ((javax.xml.rpc.Stub)flashVendasSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.com.conductor.FlashVendasSoap getFlashVendasSoap() {
    if (flashVendasSoap == null)
      _initFlashVendasSoapProxy();
    return flashVendasSoap;
  }
  
  public br.com.conductor.AcumuladorPropostasResp acumuladorPropostas() throws java.rmi.RemoteException{
    if (flashVendasSoap == null)
      _initFlashVendasSoapProxy();
    return flashVendasSoap.acumuladorPropostas();
  }
  
  public br.com.conductor.AcumuladorPropostasAtivadasResp acumuladorPropostasAtivadas() throws java.rmi.RemoteException{
    if (flashVendasSoap == null)
      _initFlashVendasSoapProxy();
    return flashVendasSoap.acumuladorPropostasAtivadas();
  }
  
  public br.com.conductor.AcumuladorSegurosResp acumuladorSegurosAderidos() throws java.rmi.RemoteException{
    if (flashVendasSoap == null)
      _initFlashVendasSoapProxy();
    return flashVendasSoap.acumuladorSegurosAderidos();
  }
  
  public br.com.conductor.AcumuladorSegurosResp acumuladorSegurosCancelados() throws java.rmi.RemoteException{
    if (flashVendasSoap == null)
      _initFlashVendasSoapProxy();
    return flashVendasSoap.acumuladorSegurosCancelados();
  }
  
  public br.com.conductor.AcumuladorComprasResp acumuladorCompras() throws java.rmi.RemoteException{
    if (flashVendasSoap == null)
      _initFlashVendasSoapProxy();
    return flashVendasSoap.acumuladorCompras();
  }
  
  
}