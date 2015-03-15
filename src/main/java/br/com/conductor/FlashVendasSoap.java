/**
 * FlashVendasSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.conductor;

public interface FlashVendasSoap extends java.rmi.Remote {

    /**
     * Controlar produtividade de acordo com propostas cadastradas
     */
    public br.com.conductor.AcumuladorPropostasResp acumuladorPropostas() throws java.rmi.RemoteException;

    /**
     * Controlar produtividade de acordo com propostas ativadas
     */
    public br.com.conductor.AcumuladorPropostasAtivadasResp acumuladorPropostasAtivadas() throws java.rmi.RemoteException;

    /**
     * Controlar produtividade de acordo com seguros aderidos
     */
    public br.com.conductor.AcumuladorSegurosResp acumuladorSegurosAderidos() throws java.rmi.RemoteException;

    /**
     * Controlar produtividade de acordo com seguros cancelados
     */
    public br.com.conductor.AcumuladorSegurosResp acumuladorSegurosCancelados() throws java.rmi.RemoteException;

    /**
     * Controlar produtividade de acordo com transacoes realizadas
     * pelo cliente
     */
    public br.com.conductor.AcumuladorComprasResp acumuladorCompras() throws java.rmi.RemoteException;
}
