/**
 * AcumuladorPropostasAtivadasResp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.conductor;

public class AcumuladorPropostasAtivadasResp  implements java.io.Serializable {
    private int codRetorno;

    private java.lang.String descricaoRetorno;

    private java.lang.String IDLog;

    private java.lang.String dataAtual;

    private br.com.conductor.AcumuladorPropostasAtivadas[] acumuladorPropostasAtivadas;

    public AcumuladorPropostasAtivadasResp() {
    }

    public AcumuladorPropostasAtivadasResp(
           int codRetorno,
           java.lang.String descricaoRetorno,
           java.lang.String IDLog,
           java.lang.String dataAtual,
           br.com.conductor.AcumuladorPropostasAtivadas[] acumuladorPropostasAtivadas) {
           this.codRetorno = codRetorno;
           this.descricaoRetorno = descricaoRetorno;
           this.IDLog = IDLog;
           this.dataAtual = dataAtual;
           this.acumuladorPropostasAtivadas = acumuladorPropostasAtivadas;
    }


    /**
     * Gets the codRetorno value for this AcumuladorPropostasAtivadasResp.
     * 
     * @return codRetorno
     */
    public int getCodRetorno() {
        return codRetorno;
    }


    /**
     * Sets the codRetorno value for this AcumuladorPropostasAtivadasResp.
     * 
     * @param codRetorno
     */
    public void setCodRetorno(int codRetorno) {
        this.codRetorno = codRetorno;
    }


    /**
     * Gets the descricaoRetorno value for this AcumuladorPropostasAtivadasResp.
     * 
     * @return descricaoRetorno
     */
    public java.lang.String getDescricaoRetorno() {
        return descricaoRetorno;
    }


    /**
     * Sets the descricaoRetorno value for this AcumuladorPropostasAtivadasResp.
     * 
     * @param descricaoRetorno
     */
    public void setDescricaoRetorno(java.lang.String descricaoRetorno) {
        this.descricaoRetorno = descricaoRetorno;
    }


    /**
     * Gets the IDLog value for this AcumuladorPropostasAtivadasResp.
     * 
     * @return IDLog
     */
    public java.lang.String getIDLog() {
        return IDLog;
    }


    /**
     * Sets the IDLog value for this AcumuladorPropostasAtivadasResp.
     * 
     * @param IDLog
     */
    public void setIDLog(java.lang.String IDLog) {
        this.IDLog = IDLog;
    }


    /**
     * Gets the dataAtual value for this AcumuladorPropostasAtivadasResp.
     * 
     * @return dataAtual
     */
    public java.lang.String getDataAtual() {
        return dataAtual;
    }


    /**
     * Sets the dataAtual value for this AcumuladorPropostasAtivadasResp.
     * 
     * @param dataAtual
     */
    public void setDataAtual(java.lang.String dataAtual) {
        this.dataAtual = dataAtual;
    }


    /**
     * Gets the acumuladorPropostasAtivadas value for this AcumuladorPropostasAtivadasResp.
     * 
     * @return acumuladorPropostasAtivadas
     */
    public br.com.conductor.AcumuladorPropostasAtivadas[] getAcumuladorPropostasAtivadas() {
        return acumuladorPropostasAtivadas;
    }


    /**
     * Sets the acumuladorPropostasAtivadas value for this AcumuladorPropostasAtivadasResp.
     * 
     * @param acumuladorPropostasAtivadas
     */
    public void setAcumuladorPropostasAtivadas(br.com.conductor.AcumuladorPropostasAtivadas[] acumuladorPropostasAtivadas) {
        this.acumuladorPropostasAtivadas = acumuladorPropostasAtivadas;
    }

    public br.com.conductor.AcumuladorPropostasAtivadas getAcumuladorPropostasAtivadas(int i) {
        return this.acumuladorPropostasAtivadas[i];
    }

    public void setAcumuladorPropostasAtivadas(int i, br.com.conductor.AcumuladorPropostasAtivadas _value) {
        this.acumuladorPropostasAtivadas[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AcumuladorPropostasAtivadasResp)) return false;
        AcumuladorPropostasAtivadasResp other = (AcumuladorPropostasAtivadasResp) obj;
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
            ((this.acumuladorPropostasAtivadas==null && other.getAcumuladorPropostasAtivadas()==null) || 
             (this.acumuladorPropostasAtivadas!=null &&
              java.util.Arrays.equals(this.acumuladorPropostasAtivadas, other.getAcumuladorPropostasAtivadas())));
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
        if (getAcumuladorPropostasAtivadas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAcumuladorPropostasAtivadas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAcumuladorPropostasAtivadas(), i);
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
        new org.apache.axis.description.TypeDesc(AcumuladorPropostasAtivadasResp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://conductor.com.br/", "AcumuladorPropostasAtivadasResp"));
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
        elemField.setFieldName("acumuladorPropostasAtivadas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://conductor.com.br/", "AcumuladorPropostasAtivadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://conductor.com.br/", "AcumuladorPropostasAtivadas"));
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
