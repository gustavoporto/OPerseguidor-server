/**
 * AcumuladorSegurosResp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.conductor;

public class AcumuladorSegurosResp  implements java.io.Serializable {
    private int codRetorno;

    private java.lang.String descricaoRetorno;

    private java.lang.String IDLog;

    private java.lang.String dataAtual;

    private br.com.conductor.AcumuladorSeguros[] acumuladorSeguros;    

    public AcumuladorSegurosResp() {
    }

    public AcumuladorSegurosResp(
           int codRetorno,
           java.lang.String descricaoRetorno,
           java.lang.String IDLog,
           java.lang.String dataAtual,
           br.com.conductor.AcumuladorSeguros[] acumuladorSeguros) {
           this.codRetorno = codRetorno;
           this.descricaoRetorno = descricaoRetorno;
           this.IDLog = IDLog;
           this.dataAtual = dataAtual;
           this.acumuladorSeguros = acumuladorSeguros;
    }


    /**
     * Gets the codRetorno value for this AcumuladorSegurosResp.
     * 
     * @return codRetorno
     */
    public int getCodRetorno() {
        return codRetorno;
    }


    /**
     * Sets the codRetorno value for this AcumuladorSegurosResp.
     * 
     * @param codRetorno
     */
    public void setCodRetorno(int codRetorno) {
        this.codRetorno = codRetorno;
    }


    /**
     * Gets the descricaoRetorno value for this AcumuladorSegurosResp.
     * 
     * @return descricaoRetorno
     */
    public java.lang.String getDescricaoRetorno() {
        return descricaoRetorno;
    }


    /**
     * Sets the descricaoRetorno value for this AcumuladorSegurosResp.
     * 
     * @param descricaoRetorno
     */
    public void setDescricaoRetorno(java.lang.String descricaoRetorno) {
        this.descricaoRetorno = descricaoRetorno;
    }


    /**
     * Gets the IDLog value for this AcumuladorSegurosResp.
     * 
     * @return IDLog
     */
    public java.lang.String getIDLog() {
        return IDLog;
    }


    /**
     * Sets the IDLog value for this AcumuladorSegurosResp.
     * 
     * @param IDLog
     */
    public void setIDLog(java.lang.String IDLog) {
        this.IDLog = IDLog;
    }


    /**
     * Gets the dataAtual value for this AcumuladorSegurosResp.
     * 
     * @return dataAtual
     */
    public java.lang.String getDataAtual() {
        return dataAtual;
    }


    /**
     * Sets the dataAtual value for this AcumuladorSegurosResp.
     * 
     * @param dataAtual
     */
    public void setDataAtual(java.lang.String dataAtual) {
        this.dataAtual = dataAtual;
    }


    /**
     * Gets the acumuladorSeguros value for this AcumuladorSegurosResp.
     * 
     * @return acumuladorSeguros
     */
    public br.com.conductor.AcumuladorSeguros[] getAcumuladorSeguros() {
        return acumuladorSeguros;
    }


    /**
     * Sets the acumuladorSeguros value for this AcumuladorSegurosResp.
     * 
     * @param acumuladorSeguros
     */
    public void setAcumuladorSeguros(br.com.conductor.AcumuladorSeguros[] acumuladorSeguros) {
        this.acumuladorSeguros = acumuladorSeguros;
    }

    public br.com.conductor.AcumuladorSeguros getAcumuladorSeguros(int i) {
        return this.acumuladorSeguros[i];
    }

    public void setAcumuladorSeguros(int i, br.com.conductor.AcumuladorSeguros _value) {
        this.acumuladorSeguros[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AcumuladorSegurosResp)) return false;
        AcumuladorSegurosResp other = (AcumuladorSegurosResp) obj;
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
            ((this.acumuladorSeguros==null && other.getAcumuladorSeguros()==null) || 
             (this.acumuladorSeguros!=null &&
              java.util.Arrays.equals(this.acumuladorSeguros, other.getAcumuladorSeguros())));
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
        if (getAcumuladorSeguros() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAcumuladorSeguros());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAcumuladorSeguros(), i);
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
        new org.apache.axis.description.TypeDesc(AcumuladorSegurosResp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://conductor.com.br/", "AcumuladorSegurosResp"));
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
        elemField.setFieldName("acumuladorSeguros");
        elemField.setXmlName(new javax.xml.namespace.QName("http://conductor.com.br/", "AcumuladorSeguros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://conductor.com.br/", "AcumuladorSeguros"));
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
