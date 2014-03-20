
package com.gzgb.epo.crawlerClient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.gzgb.epo.crawlerClient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CrawlerOperation_QNAME = new QName("http://service.gzgb.org/", "crawlerOperation");
    private final static QName _CrawlerOperationResponse_QNAME = new QName("http://service.gzgb.org/", "crawlerOperationResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.gzgb.epo.crawlerClient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CrawlerOperationResponse }
     * 
     */
    public CrawlerOperationResponse createCrawlerOperationResponse() {
        return new CrawlerOperationResponse();
    }

    /**
     * Create an instance of {@link CrawlerOperation }
     * 
     */
    public CrawlerOperation createCrawlerOperation() {
        return new CrawlerOperation();
    }

    /**
     * Create an instance of {@link WebGatherNodeBean }
     * 
     */
    public WebGatherNodeBean createWebGatherNodeBean() {
        return new WebGatherNodeBean();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrawlerOperation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.gzgb.org/", name = "crawlerOperation")
    public JAXBElement<CrawlerOperation> createCrawlerOperation(CrawlerOperation value) {
        return new JAXBElement<CrawlerOperation>(_CrawlerOperation_QNAME, CrawlerOperation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrawlerOperationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.gzgb.org/", name = "crawlerOperationResponse")
    public JAXBElement<CrawlerOperationResponse> createCrawlerOperationResponse(CrawlerOperationResponse value) {
        return new JAXBElement<CrawlerOperationResponse>(_CrawlerOperationResponse_QNAME, CrawlerOperationResponse.class, null, value);
    }

}
