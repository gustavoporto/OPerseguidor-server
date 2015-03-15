/**
 * AcumuladorPropostasAtivadas.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.conductor;

public class AcumuladorPropostasAtivadas  implements java.io.Serializable {
    private java.lang.String CPF;

    private java.lang.String login;

    private int id_Estabelecimento;

    private java.lang.String nomeEstabelecimento;

    private int quantidadePropostasAtivadas;

    public AcumuladorPropostasAtivadas() {
    }

    public AcumuladorPropostasAtivadas(
           java.lang.String CPF,
           java.lang.String login,
           int id_Estabelecimento,
           java.lang.String nomeEstabelecimento,
           int quantidadePropostasAtivadas) {
           this.CPF = CPF;
           this.login = login;
           this.id_Estabelecimento = id_Estabelecimento;
           this.nomeEstabelecimento = nomeEstabelecimento;
           this.quantidadePropostasAtivadas = quantidadePropostasAtivadas;
    }


    /**
     * Gets the CPF value for this AcumuladorPropostasAtivadas.
     * 
     * @return CPF
     */
    public java.lang.String getCPF() {
        return CPF;
    }


    /**
     * Sets the CPF value for this AcumuladorPropostasAtivadas.
     * 
     * @param CPF
     */
    public void setCPF(java.lang.String CPF) {
        this.CPF = CPF;
    }


    /**
     * Gets the login value for this AcumuladorPropostasAtivadas.
     * 
     * @return login
     */
    public java.lang.String getLogin() {
        return login;
    }


    /**
     * Sets the login value for this AcumuladorPropostasAtivadas.
     * 
     * @param login
     */
    public void setLogin(java.lang.String login) {
        this.login = login;
    }


    /**
     * Gets the id_Estabelecimento value for this AcumuladorPropostasAtivadas.
     * 
     * @return id_Estabelecimento
     */
    public int getId_Estabelecimento() {
        return id_Estabelecimento;
    }


    /**
     * Sets the id_Estabelecimento value for this AcumuladorPropostasAtivadas.
     * 
     * @param id_Estabelecimento
     */
    public void setId_Estabelecimento(int id_Estabelecimento) {
        this.id_Estabelecimento = id_Estabelecimento;
    }


    /**
     * Gets the nomeEstabelecimento value for this AcumuladorPropostasAtivadas.
     * 
     * @return nomeEstabelecimento
     */
    public java.lang.String getNomeEstabelecimento() {
        return nomeEstabelecimento;
    }


    /**
     * Sets the nomeEstabelecimento value for this AcumuladorPropostasAtivadas.
     * 
     * @param nomeEstabelecimento
     */
    public void setNomeEstabelecimento(java.lang.String nomeEstabelecimento) {
        this.nomeEstabelecimento = nomeEstabelecimento;
    }


    /**
     * Gets the quantidadePropostasAtivadas value for this AcumuladorPropostasAtivadas.
     * 
     * @return quantidadePropostasAtivadas
     */
    public int getQuantidadePropostasAtivadas() {
        return quantidadePropostasAtivadas;
    }


    /**
     * Sets the quantidadePropostasAtivadas value for this AcumuladorPropostasAtivadas.
     * 
     * @param quantidadePropostasAtivadas
     */
    public void setQuantidadePropostasAtivadas(int quantidadePropostasAtivadas) {
        this.quantidadePropostasAtivadas = quantidadePropostasAtivadas;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AcumuladorPropostasAtivadas)) return false;
        AcumuladorPropostasAtivadas other = (AcumuladorPropostasAtivadas) obj;
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
            this.quantidadePropostasAtivadas == other.getQuantidadePropostasAtivadas();
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
        _hashCode += getQuantidadePropostasAtivadas();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AcumuladorPropostasAtivadas.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://conductor.com.br/", "AcumuladorPropostasAtivadas"));
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
        elemField.setFieldName("quantidadePropostasAtivadas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://conductor.com.br/", "QuantidadePropostasAtivadas"));
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
