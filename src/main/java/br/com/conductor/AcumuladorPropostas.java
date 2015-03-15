/**
 * AcumuladorPropostas.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.conductor;

public class AcumuladorPropostas  implements java.io.Serializable {
    private java.lang.String CPF;

    private java.lang.String login;

    private int id_Estabelecimento;

    private java.lang.String nomeEstabelecimento;

    private int quantidadePropostasCadastradas;

    private int quantidadePropostasAprovadas;

    private int quantidadePropostasNegadas;

    public AcumuladorPropostas() {
    }

    public AcumuladorPropostas(
           java.lang.String CPF,
           java.lang.String login,
           int id_Estabelecimento,
           java.lang.String nomeEstabelecimento,
           int quantidadePropostasCadastradas,
           int quantidadePropostasAprovadas,
           int quantidadePropostasNegadas) {
           this.CPF = CPF;
           this.login = login;
           this.id_Estabelecimento = id_Estabelecimento;
           this.nomeEstabelecimento = nomeEstabelecimento;
           this.quantidadePropostasCadastradas = quantidadePropostasCadastradas;
           this.quantidadePropostasAprovadas = quantidadePropostasAprovadas;
           this.quantidadePropostasNegadas = quantidadePropostasNegadas;
    }


    /**
     * Gets the CPF value for this AcumuladorPropostas.
     * 
     * @return CPF
     */
    public java.lang.String getCPF() {
        return CPF;
    }


    /**
     * Sets the CPF value for this AcumuladorPropostas.
     * 
     * @param CPF
     */
    public void setCPF(java.lang.String CPF) {
        this.CPF = CPF;
    }


    /**
     * Gets the login value for this AcumuladorPropostas.
     * 
     * @return login
     */
    public java.lang.String getLogin() {
        return login;
    }


    /**
     * Sets the login value for this AcumuladorPropostas.
     * 
     * @param login
     */
    public void setLogin(java.lang.String login) {
        this.login = login;
    }


    /**
     * Gets the id_Estabelecimento value for this AcumuladorPropostas.
     * 
     * @return id_Estabelecimento
     */
    public int getId_Estabelecimento() {
        return id_Estabelecimento;
    }


    /**
     * Sets the id_Estabelecimento value for this AcumuladorPropostas.
     * 
     * @param id_Estabelecimento
     */
    public void setId_Estabelecimento(int id_Estabelecimento) {
        this.id_Estabelecimento = id_Estabelecimento;
    }


    /**
     * Gets the nomeEstabelecimento value for this AcumuladorPropostas.
     * 
     * @return nomeEstabelecimento
     */
    public java.lang.String getNomeEstabelecimento() {
        return nomeEstabelecimento;
    }


    /**
     * Sets the nomeEstabelecimento value for this AcumuladorPropostas.
     * 
     * @param nomeEstabelecimento
     */
    public void setNomeEstabelecimento(java.lang.String nomeEstabelecimento) {
        this.nomeEstabelecimento = nomeEstabelecimento;
    }


    /**
     * Gets the quantidadePropostasCadastradas value for this AcumuladorPropostas.
     * 
     * @return quantidadePropostasCadastradas
     */
    public int getQuantidadePropostasCadastradas() {
        return quantidadePropostasCadastradas;
    }


    /**
     * Sets the quantidadePropostasCadastradas value for this AcumuladorPropostas.
     * 
     * @param quantidadePropostasCadastradas
     */
    public void setQuantidadePropostasCadastradas(int quantidadePropostasCadastradas) {
        this.quantidadePropostasCadastradas = quantidadePropostasCadastradas;
    }


    /**
     * Gets the quantidadePropostasAprovadas value for this AcumuladorPropostas.
     * 
     * @return quantidadePropostasAprovadas
     */
    public int getQuantidadePropostasAprovadas() {
        return quantidadePropostasAprovadas;
    }


    /**
     * Sets the quantidadePropostasAprovadas value for this AcumuladorPropostas.
     * 
     * @param quantidadePropostasAprovadas
     */
    public void setQuantidadePropostasAprovadas(int quantidadePropostasAprovadas) {
        this.quantidadePropostasAprovadas = quantidadePropostasAprovadas;
    }


    /**
     * Gets the quantidadePropostasNegadas value for this AcumuladorPropostas.
     * 
     * @return quantidadePropostasNegadas
     */
    public int getQuantidadePropostasNegadas() {
        return quantidadePropostasNegadas;
    }


    /**
     * Sets the quantidadePropostasNegadas value for this AcumuladorPropostas.
     * 
     * @param quantidadePropostasNegadas
     */
    public void setQuantidadePropostasNegadas(int quantidadePropostasNegadas) {
        this.quantidadePropostasNegadas = quantidadePropostasNegadas;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AcumuladorPropostas)) return false;
        AcumuladorPropostas other = (AcumuladorPropostas) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.CPF==null && other.getCPF()==null) || 
             (this.CPF!=null &&
              this.CPF.equals(other.getCPF()))) &&
            ((this.login==null && other.getLogin()==null) || 
             (this.login!=null &&
              this.login.equals(other.getLogin()))) &&
            this.id_Estabelecimento == other.getId_Estabelecimento() &&
            ((this.nomeEstabelecimento==null && other.getNomeEstabelecimento()==null) || 
             (this.nomeEstabelecimento!=null &&
              this.nomeEstabelecimento.equals(other.getNomeEstabelecimento()))) &&
            this.quantidadePropostasCadastradas == other.getQuantidadePropostasCadastradas() &&
            this.quantidadePropostasAprovadas == other.getQuantidadePropostasAprovadas() &&
            this.quantidadePropostasNegadas == other.getQuantidadePropostasNegadas();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCPF() != null) {
            _hashCode += getCPF().hashCode();
        }
        if (getLogin() != null) {
            _hashCode += getLogin().hashCode();
        }
        _hashCode += getId_Estabelecimento();
        if (getNomeEstabelecimento() != null) {
            _hashCode += getNomeEstabelecimento().hashCode();
        }
        _hashCode += getQuantidadePropostasCadastradas();
        _hashCode += getQuantidadePropostasAprovadas();
        _hashCode += getQuantidadePropostasNegadas();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AcumuladorPropostas.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://conductor.com.br/", "AcumuladorPropostas"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CPF");
        elemField.setXmlName(new javax.xml.namespace.QName("http://conductor.com.br/", "CPF"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("login");
        elemField.setXmlName(new javax.xml.namespace.QName("http://conductor.com.br/", "Login"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id_Estabelecimento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://conductor.com.br/", "Id_Estabelecimento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeEstabelecimento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://conductor.com.br/", "NomeEstabelecimento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quantidadePropostasCadastradas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://conductor.com.br/", "QuantidadePropostasCadastradas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quantidadePropostasAprovadas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://conductor.com.br/", "QuantidadePropostasAprovadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quantidadePropostasNegadas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://conductor.com.br/", "QuantidadePropostasNegadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
