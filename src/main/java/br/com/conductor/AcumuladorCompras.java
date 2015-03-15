/**
 * AcumuladorCompras.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.conductor;

public class AcumuladorCompras  implements java.io.Serializable {
    private int id_Estabelecimento;

    private java.lang.String nomeEstabelecimento;

    private java.lang.String descricaoStatusCompra;

    private int quantidadeTotalCompras;

    private java.lang.String valorTotalCompras;

    private int quantidadeComprasComJuros;

    private java.lang.String valorComprasComJurosParceladas;

    private java.lang.String valorContratoComJurosParceladas;

    public AcumuladorCompras() {
    }

    public AcumuladorCompras(
           int id_Estabelecimento,
           java.lang.String nomeEstabelecimento,
           java.lang.String descricaoStatusCompra,
           int quantidadeTotalCompras,
           java.lang.String valorTotalCompras,
           int quantidadeComprasComJuros,
           java.lang.String valorComprasComJurosParceladas,
           java.lang.String valorContratoComJurosParceladas) {
           this.id_Estabelecimento = id_Estabelecimento;
           this.nomeEstabelecimento = nomeEstabelecimento;
           this.descricaoStatusCompra = descricaoStatusCompra;
           this.quantidadeTotalCompras = quantidadeTotalCompras;
           this.valorTotalCompras = valorTotalCompras;
           this.quantidadeComprasComJuros = quantidadeComprasComJuros;
           this.valorComprasComJurosParceladas = valorComprasComJurosParceladas;
           this.valorContratoComJurosParceladas = valorContratoComJurosParceladas;
    }


    /**
     * Gets the id_Estabelecimento value for this AcumuladorCompras.
     * 
     * @return id_Estabelecimento
     */
    public int getId_Estabelecimento() {
        return id_Estabelecimento;
    }


    /**
     * Sets the id_Estabelecimento value for this AcumuladorCompras.
     * 
     * @param id_Estabelecimento
     */
    public void setId_Estabelecimento(int id_Estabelecimento) {
        this.id_Estabelecimento = id_Estabelecimento;
    }


    /**
     * Gets the nomeEstabelecimento value for this AcumuladorCompras.
     * 
     * @return nomeEstabelecimento
     */
    public java.lang.String getNomeEstabelecimento() {
        return nomeEstabelecimento;
    }


    /**
     * Sets the nomeEstabelecimento value for this AcumuladorCompras.
     * 
     * @param nomeEstabelecimento
     */
    public void setNomeEstabelecimento(java.lang.String nomeEstabelecimento) {
        this.nomeEstabelecimento = nomeEstabelecimento;
    }


    /**
     * Gets the descricaoStatusCompra value for this AcumuladorCompras.
     * 
     * @return descricaoStatusCompra
     */
    public java.lang.String getDescricaoStatusCompra() {
        return descricaoStatusCompra;
    }


    /**
     * Sets the descricaoStatusCompra value for this AcumuladorCompras.
     * 
     * @param descricaoStatusCompra
     */
    public void setDescricaoStatusCompra(java.lang.String descricaoStatusCompra) {
        this.descricaoStatusCompra = descricaoStatusCompra;
    }


    /**
     * Gets the quantidadeTotalCompras value for this AcumuladorCompras.
     * 
     * @return quantidadeTotalCompras
     */
    public int getQuantidadeTotalCompras() {
        return quantidadeTotalCompras;
    }


    /**
     * Sets the quantidadeTotalCompras value for this AcumuladorCompras.
     * 
     * @param quantidadeTotalCompras
     */
    public void setQuantidadeTotalCompras(int quantidadeTotalCompras) {
        this.quantidadeTotalCompras = quantidadeTotalCompras;
    }


    /**
     * Gets the valorTotalCompras value for this AcumuladorCompras.
     * 
     * @return valorTotalCompras
     */
    public java.lang.String getValorTotalCompras() {
        return valorTotalCompras;
    }


    /**
     * Sets the valorTotalCompras value for this AcumuladorCompras.
     * 
     * @param valorTotalCompras
     */
    public void setValorTotalCompras(java.lang.String valorTotalCompras) {
        this.valorTotalCompras = valorTotalCompras;
    }


    /**
     * Gets the quantidadeComprasComJuros value for this AcumuladorCompras.
     * 
     * @return quantidadeComprasComJuros
     */
    public int getQuantidadeComprasComJuros() {
        return quantidadeComprasComJuros;
    }


    /**
     * Sets the quantidadeComprasComJuros value for this AcumuladorCompras.
     * 
     * @param quantidadeComprasComJuros
     */
    public void setQuantidadeComprasComJuros(int quantidadeComprasComJuros) {
        this.quantidadeComprasComJuros = quantidadeComprasComJuros;
    }


    /**
     * Gets the valorComprasComJurosParceladas value for this AcumuladorCompras.
     * 
     * @return valorComprasComJurosParceladas
     */
    public java.lang.String getValorComprasComJurosParceladas() {
        return valorComprasComJurosParceladas;
    }


    /**
     * Sets the valorComprasComJurosParceladas value for this AcumuladorCompras.
     * 
     * @param valorComprasComJurosParceladas
     */
    public void setValorComprasComJurosParceladas(java.lang.String valorComprasComJurosParceladas) {
        this.valorComprasComJurosParceladas = valorComprasComJurosParceladas;
    }


    /**
     * Gets the valorContratoComJurosParceladas value for this AcumuladorCompras.
     * 
     * @return valorContratoComJurosParceladas
     */
    public java.lang.String getValorContratoComJurosParceladas() {
        return valorContratoComJurosParceladas;
    }


    /**
     * Sets the valorContratoComJurosParceladas value for this AcumuladorCompras.
     * 
     * @param valorContratoComJurosParceladas
     */
    public void setValorContratoComJurosParceladas(java.lang.String valorContratoComJurosParceladas) {
        this.valorContratoComJurosParceladas = valorContratoComJurosParceladas;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AcumuladorCompras)) return false;
        AcumuladorCompras other = (AcumuladorCompras) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.id_Estabelecimento == other.getId_Estabelecimento() &&
            ((this.nomeEstabelecimento==null && other.getNomeEstabelecimento()==null) || 
             (this.nomeEstabelecimento!=null &&
              this.nomeEstabelecimento.equals(other.getNomeEstabelecimento()))) &&
            ((this.descricaoStatusCompra==null && other.getDescricaoStatusCompra()==null) || 
             (this.descricaoStatusCompra!=null &&
              this.descricaoStatusCompra.equals(other.getDescricaoStatusCompra()))) &&
            this.quantidadeTotalCompras == other.getQuantidadeTotalCompras() &&
            ((this.valorTotalCompras==null && other.getValorTotalCompras()==null) || 
             (this.valorTotalCompras!=null &&
              this.valorTotalCompras.equals(other.getValorTotalCompras()))) &&
            this.quantidadeComprasComJuros == other.getQuantidadeComprasComJuros() &&
            ((this.valorComprasComJurosParceladas==null && other.getValorComprasComJurosParceladas()==null) || 
             (this.valorComprasComJurosParceladas!=null &&
              this.valorComprasComJurosParceladas.equals(other.getValorComprasComJurosParceladas()))) &&
            ((this.valorContratoComJurosParceladas==null && other.getValorContratoComJurosParceladas()==null) || 
             (this.valorContratoComJurosParceladas!=null &&
              this.valorContratoComJurosParceladas.equals(other.getValorContratoComJurosParceladas())));
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
        _hashCode += getId_Estabelecimento();
        if (getNomeEstabelecimento() != null) {
            _hashCode += getNomeEstabelecimento().hashCode();
        }
        if (getDescricaoStatusCompra() != null) {
            _hashCode += getDescricaoStatusCompra().hashCode();
        }
        _hashCode += getQuantidadeTotalCompras();
        if (getValorTotalCompras() != null) {
            _hashCode += getValorTotalCompras().hashCode();
        }
        _hashCode += getQuantidadeComprasComJuros();
        if (getValorComprasComJurosParceladas() != null) {
            _hashCode += getValorComprasComJurosParceladas().hashCode();
        }
        if (getValorContratoComJurosParceladas() != null) {
            _hashCode += getValorContratoComJurosParceladas().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AcumuladorCompras.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://conductor.com.br/", "AcumuladorCompras"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("descricaoStatusCompra");
        elemField.setXmlName(new javax.xml.namespace.QName("http://conductor.com.br/", "DescricaoStatusCompra"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quantidadeTotalCompras");
        elemField.setXmlName(new javax.xml.namespace.QName("http://conductor.com.br/", "QuantidadeTotalCompras"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valorTotalCompras");
        elemField.setXmlName(new javax.xml.namespace.QName("http://conductor.com.br/", "ValorTotalCompras"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quantidadeComprasComJuros");
        elemField.setXmlName(new javax.xml.namespace.QName("http://conductor.com.br/", "QuantidadeComprasComJuros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valorComprasComJurosParceladas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://conductor.com.br/", "ValorComprasComJurosParceladas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valorContratoComJurosParceladas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://conductor.com.br/", "ValorContratoComJurosParceladas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
