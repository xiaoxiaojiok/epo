
package com.gzgb.epo.crawlerClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for crawlerOperationResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="crawlerOperationResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="crawlerResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "crawlerOperationResponse", propOrder = {
    "crawlerResult"
})
public class CrawlerOperationResponse {

    protected int crawlerResult;

    /**
     * Gets the value of the crawlerResult property.
     * 
     */
    public int getCrawlerResult() {
        return crawlerResult;
    }

    /**
     * Sets the value of the crawlerResult property.
     * 
     */
    public void setCrawlerResult(int value) {
        this.crawlerResult = value;
    }

}
