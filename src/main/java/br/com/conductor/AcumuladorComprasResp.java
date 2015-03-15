/**
 * AcumuladorComprasResp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.conductor;

public class AcumuladorComprasResp  implements java.io.Serializable {
    private int codRetorno;

    private java.lang.String descricaoRetorno;

    private java.lang.String IDLog;

    private java.lang.String dataAtual;

    private br.com.conductor.AcumuladorCompras[] acumuladorCompras;

    public AcumuladorComprasResp() {
    }

    public AcumuladorComprasResp(
           int codRetorno,
           java.lang.String descricaoRetorno,
           java.lang.String IDLog,
           java.lang.String dataAtual,
           br.com.conductor.AcumuladorCompras[] acumuladorCompras) {
           this.codRetorno = codRetorno;
           this.descricaoRetorno = descricaoRetorno;
           this.IDLog = IDLog;
           this.dataAtual = dataAtual;
           this.acumuladorCompras = acumuladorCompras;
    }


    /**
     * Gets the codRetorno value for this AcumuladorComprasResp.
     * 
     * @return codRetorno
     */
    public int getCodRetorno() {
        return codRetorno;
    }


    /**
     * Sets the codRetorno value for this AcumuladorComprasResp.
     * 
     * @param codRetorno
     */
    public void setCodRetorno(int codRetorno) {
        this.codRetorno = codRetorno;
    }


    /**
     * Gets the descricaoRetorno value for this AcumuladorComprasResp.
     * 
     * @return descricaoRetorno
     */
    public java.lang.String getDescricaoRetorno() {
        return descricaoRetorno;
    }


    /**
     * Sets the descricaoRetorno value for this AcumuladorComprasResp.
     * 
     * @param descricaoRetorno
     */
    public void setDescricaoRetorno(java.lang.String descricaoRetorno) {
        this.descricaoRetorno = descricaoRetorno;
    }


    /**
     * Gets the IDLog value for this AcumuladorComprasResp.
     * 
     * @return IDLog
     */
    public java.lang.String getIDLog() {
        return IDLog;
    }


    /**
     * Sets the IDLog value for this AcumuladorComprasResp.
     * 
     * @param IDLog
     */
    public void setIDLog(java.lang.String IDLog) {
        this.IDLog = IDLog;
    }


    /**
     * Gets the dataAtual value for this AcumuladorComprasResp.
     * 
     * @return dataAtual
     */
    public java.lang.String getDataAtual() {
        return dataAtual;
    }


    /**
     * Sets the dataAtual value for this AcumuladorComprasResp.
     * 
     * @param dataAtual
     */
    public void setDataAtual(java.lang.String dataAtual) {
        this.dataAtual = dataAtual;
    }


    /**
     * Gets the acumuladorCompras value for this AcumuladorComprasResp.
     * 
     * @return acumuladorCompras
     */
    public br.com.conductor.AcumuladorCompras[] getAcumuladorCompras() {
        return acumuladorCompras;
    }


    /**
     * Sets the acumuladorCompras value for this AcumuladorComprasResp.
     * 
     * @param acumuladorCompras
     */
    public void setAcumuladorCompras(br.com.conductor.AcumuladorCompras[] acumuladorCompras) {
        this.acumuladorCompras = acumuladorCompras;
    }

    public br.com.conductor.AcumuladorCompras getAcumuladorCompras(int i) {
        return this.acumuladorCompras[i];
    }

    public void setAcumuladorCompras(int i, br.com.conductor.AcumuladorCompras _value) {
        this.acumuladorCompras[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AcumuladorComprasResp)) return false;
        AcumuladorComprasResp other = (AcumuladorComprasResp) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.codRetorno == other.getCodRetorno() &&
            ((this.descricaoRetorno==null && other.getDescricaoRetorno()==null) || 
             (this.descricaoRetorno!=null &&
              this.descricaoRetorno.equals(other.getDescricaoRetorno()))) &&
            ((this.IDLog==null && other.getIDLog()==null) || 
             (this.IDLog!=null &&
              this.IDLog.equals(other.getIDLog()))) &&
            ((this.dataAtual==null && other.getDataAtual()==null) || 
             (this.dataAtual!=null &&
              this.dataAtual.equals(other.getDataAtual()))) &&
            ((this.acumuladorCompras==null && other.getAcumuladorCompras()==null) || 
             (this.acumuladorCompras!=null &&
              java.util.Arrays.equals(this.acumuladorCompras, other.getAcumuladorCompras())));
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
        _hashCode += getCodRetorno();
        if (getDescricaoRetorno() != null) {
            _hashCode += getDescricaoRetorno().hashCode();
        }
        if (getIDLog() != null) {
            _hashCode += getIDLog().hashCode();
        }
        if (getDataAtual() != null) {
            _hashCode += getDataAtual().hashCode();
        }
        if (getAcumuladorCompras() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAcumuladorCompras());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAcumuladorCompras(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AcumuladorComprasResp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://conductor.com.br/", "AcumuladorComprasResp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codRetorno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://conductor.com.br/", "CodRetorno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descricaoRetorno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://conductor.com.br/", "DescricaoRetorno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IDLog");
        elemField.setXmlName(new javax.xml.namespace.QName("http://conductor.com.br/", "IDLog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataAtual");
        elemField.setXmlName(new javax.xml.namespace.QName("http://conductor.com.br/", "DataAtual"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("acumuladorCompras");
        elemField.setXmlName(new javax.xml.namespace.QName("http://conductor.com.br/", "AcumuladorCompras"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://conductor.com.br/", "AcumuladorCompras"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
