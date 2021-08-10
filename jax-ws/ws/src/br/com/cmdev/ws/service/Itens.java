
package br.com.cmdev.ws.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for itens complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="itens"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="itens" type="{http://service.ws.cmdev.com.br/}listaItens" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "itens", propOrder = {
    "itens"
})
public class Itens {

    protected ListaItens itens;

    /**
     * Gets the value of the itens property.
     * 
     * @return
     *     possible object is
     *     {@link ListaItens }
     *     
     */
    public ListaItens getItens() {
        return itens;
    }

    /**
     * Sets the value of the itens property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListaItens }
     *     
     */
    public void setItens(ListaItens value) {
        this.itens = value;
    }

}
