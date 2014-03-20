
package com.gzgb.epo.crawlerClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for webGatherNodeBean complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="webGatherNodeBean">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="weBSiteName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="webSiteID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="wgnAllowDomain" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wgnAllowRule" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wgnConfigItem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wgnCookiesEnable" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
 *         &lt;element name="wgnCreateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="wgnDelay" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
 *         &lt;element name="wgnDelete" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
 *         &lt;element name="wgnDenyRule" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wgnDepthLimit" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
 *         &lt;element name="wgnEntryUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wgnIsClean" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
 *         &lt;element name="wgnJobId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wgnLoginAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wgnLoginEnable" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
 *         &lt;element name="wgnLoginEntry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wgnLoginPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wgnName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wgnNextPage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wgnProcessLinks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wgnProxies" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wgnSpiderEnable" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
 *         &lt;element name="wgnTimeInterval" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="wgnTimeRefresh" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="wgnTraditional" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
 *         &lt;element name="wgnType" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
 *         &lt;element name="wgnUniqueId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wgnUpdateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="wgnUserAgents" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wgnWeight" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "webGatherNodeBean", propOrder = {
    "id",
    "weBSiteName",
    "webSiteID",
    "wgnAllowDomain",
    "wgnAllowRule",
    "wgnConfigItem",
    "wgnCookiesEnable",
    "wgnCreateTime",
    "wgnDelay",
    "wgnDelete",
    "wgnDenyRule",
    "wgnDepthLimit",
    "wgnEntryUrl",
    "wgnIsClean",
    "wgnJobId",
    "wgnLoginAccount",
    "wgnLoginEnable",
    "wgnLoginEntry",
    "wgnLoginPassword",
    "wgnName",
    "wgnNextPage",
    "wgnProcessLinks",
    "wgnProxies",
    "wgnSpiderEnable",
    "wgnTimeInterval",
    "wgnTimeRefresh",
    "wgnTraditional",
    "wgnType",
    "wgnUniqueId",
    "wgnUpdateTime",
    "wgnUserAgents",
    "wgnWeight"
})
public class WebGatherNodeBean {

    protected Long id;
    protected String weBSiteName;
    protected Long webSiteID;
    protected String wgnAllowDomain;
    protected String wgnAllowRule;
    protected String wgnConfigItem;
    protected Byte wgnCookiesEnable;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar wgnCreateTime;
    protected Byte wgnDelay;
    protected Byte wgnDelete;
    protected String wgnDenyRule;
    protected Byte wgnDepthLimit;
    protected String wgnEntryUrl;
    protected Byte wgnIsClean;
    protected String wgnJobId;
    protected String wgnLoginAccount;
    protected Byte wgnLoginEnable;
    protected String wgnLoginEntry;
    protected String wgnLoginPassword;
    protected String wgnName;
    protected String wgnNextPage;
    protected String wgnProcessLinks;
    protected String wgnProxies;
    protected Byte wgnSpiderEnable;
    protected Integer wgnTimeInterval;
    protected Integer wgnTimeRefresh;
    protected Byte wgnTraditional;
    protected Byte wgnType;
    protected String wgnUniqueId;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar wgnUpdateTime;
    protected String wgnUserAgents;
    protected Byte wgnWeight;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the weBSiteName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWeBSiteName() {
        return weBSiteName;
    }

    /**
     * Sets the value of the weBSiteName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWeBSiteName(String value) {
        this.weBSiteName = value;
    }

    /**
     * Gets the value of the webSiteID property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getWebSiteID() {
        return webSiteID;
    }

    /**
     * Sets the value of the webSiteID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setWebSiteID(Long value) {
        this.webSiteID = value;
    }

    /**
     * Gets the value of the wgnAllowDomain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWgnAllowDomain() {
        return wgnAllowDomain;
    }

    /**
     * Sets the value of the wgnAllowDomain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWgnAllowDomain(String value) {
        this.wgnAllowDomain = value;
    }

    /**
     * Gets the value of the wgnAllowRule property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWgnAllowRule() {
        return wgnAllowRule;
    }

    /**
     * Sets the value of the wgnAllowRule property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWgnAllowRule(String value) {
        this.wgnAllowRule = value;
    }

    /**
     * Gets the value of the wgnConfigItem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWgnConfigItem() {
        return wgnConfigItem;
    }

    /**
     * Sets the value of the wgnConfigItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWgnConfigItem(String value) {
        this.wgnConfigItem = value;
    }

    /**
     * Gets the value of the wgnCookiesEnable property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getWgnCookiesEnable() {
        return wgnCookiesEnable;
    }

    /**
     * Sets the value of the wgnCookiesEnable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setWgnCookiesEnable(Byte value) {
        this.wgnCookiesEnable = value;
    }

    /**
     * Gets the value of the wgnCreateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getWgnCreateTime() {
        return wgnCreateTime;
    }

    /**
     * Sets the value of the wgnCreateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setWgnCreateTime(XMLGregorianCalendar value) {
        this.wgnCreateTime = value;
    }

    /**
     * Gets the value of the wgnDelay property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getWgnDelay() {
        return wgnDelay;
    }

    /**
     * Sets the value of the wgnDelay property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setWgnDelay(Byte value) {
        this.wgnDelay = value;
    }

    /**
     * Gets the value of the wgnDelete property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getWgnDelete() {
        return wgnDelete;
    }

    /**
     * Sets the value of the wgnDelete property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setWgnDelete(Byte value) {
        this.wgnDelete = value;
    }

    /**
     * Gets the value of the wgnDenyRule property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWgnDenyRule() {
        return wgnDenyRule;
    }

    /**
     * Sets the value of the wgnDenyRule property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWgnDenyRule(String value) {
        this.wgnDenyRule = value;
    }

    /**
     * Gets the value of the wgnDepthLimit property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getWgnDepthLimit() {
        return wgnDepthLimit;
    }

    /**
     * Sets the value of the wgnDepthLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setWgnDepthLimit(Byte value) {
        this.wgnDepthLimit = value;
    }

    /**
     * Gets the value of the wgnEntryUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWgnEntryUrl() {
        return wgnEntryUrl;
    }

    /**
     * Sets the value of the wgnEntryUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWgnEntryUrl(String value) {
        this.wgnEntryUrl = value;
    }

    /**
     * Gets the value of the wgnIsClean property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getWgnIsClean() {
        return wgnIsClean;
    }

    /**
     * Sets the value of the wgnIsClean property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setWgnIsClean(Byte value) {
        this.wgnIsClean = value;
    }

    /**
     * Gets the value of the wgnJobId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWgnJobId() {
        return wgnJobId;
    }

    /**
     * Sets the value of the wgnJobId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWgnJobId(String value) {
        this.wgnJobId = value;
    }

    /**
     * Gets the value of the wgnLoginAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWgnLoginAccount() {
        return wgnLoginAccount;
    }

    /**
     * Sets the value of the wgnLoginAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWgnLoginAccount(String value) {
        this.wgnLoginAccount = value;
    }

    /**
     * Gets the value of the wgnLoginEnable property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getWgnLoginEnable() {
        return wgnLoginEnable;
    }

    /**
     * Sets the value of the wgnLoginEnable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setWgnLoginEnable(Byte value) {
        this.wgnLoginEnable = value;
    }

    /**
     * Gets the value of the wgnLoginEntry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWgnLoginEntry() {
        return wgnLoginEntry;
    }

    /**
     * Sets the value of the wgnLoginEntry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWgnLoginEntry(String value) {
        this.wgnLoginEntry = value;
    }

    /**
     * Gets the value of the wgnLoginPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWgnLoginPassword() {
        return wgnLoginPassword;
    }

    /**
     * Sets the value of the wgnLoginPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWgnLoginPassword(String value) {
        this.wgnLoginPassword = value;
    }

    /**
     * Gets the value of the wgnName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWgnName() {
        return wgnName;
    }

    /**
     * Sets the value of the wgnName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWgnName(String value) {
        this.wgnName = value;
    }

    /**
     * Gets the value of the wgnNextPage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWgnNextPage() {
        return wgnNextPage;
    }

    /**
     * Sets the value of the wgnNextPage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWgnNextPage(String value) {
        this.wgnNextPage = value;
    }

    /**
     * Gets the value of the wgnProcessLinks property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWgnProcessLinks() {
        return wgnProcessLinks;
    }

    /**
     * Sets the value of the wgnProcessLinks property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWgnProcessLinks(String value) {
        this.wgnProcessLinks = value;
    }

    /**
     * Gets the value of the wgnProxies property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWgnProxies() {
        return wgnProxies;
    }

    /**
     * Sets the value of the wgnProxies property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWgnProxies(String value) {
        this.wgnProxies = value;
    }

    /**
     * Gets the value of the wgnSpiderEnable property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getWgnSpiderEnable() {
        return wgnSpiderEnable;
    }

    /**
     * Sets the value of the wgnSpiderEnable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setWgnSpiderEnable(Byte value) {
        this.wgnSpiderEnable = value;
    }

    /**
     * Gets the value of the wgnTimeInterval property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWgnTimeInterval() {
        return wgnTimeInterval;
    }

    /**
     * Sets the value of the wgnTimeInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWgnTimeInterval(Integer value) {
        this.wgnTimeInterval = value;
    }

    /**
     * Gets the value of the wgnTimeRefresh property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWgnTimeRefresh() {
        return wgnTimeRefresh;
    }

    /**
     * Sets the value of the wgnTimeRefresh property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWgnTimeRefresh(Integer value) {
        this.wgnTimeRefresh = value;
    }

    /**
     * Gets the value of the wgnTraditional property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getWgnTraditional() {
        return wgnTraditional;
    }

    /**
     * Sets the value of the wgnTraditional property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setWgnTraditional(Byte value) {
        this.wgnTraditional = value;
    }

    /**
     * Gets the value of the wgnType property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getWgnType() {
        return wgnType;
    }

    /**
     * Sets the value of the wgnType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setWgnType(Byte value) {
        this.wgnType = value;
    }

    /**
     * Gets the value of the wgnUniqueId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWgnUniqueId() {
        return wgnUniqueId;
    }

    /**
     * Sets the value of the wgnUniqueId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWgnUniqueId(String value) {
        this.wgnUniqueId = value;
    }

    /**
     * Gets the value of the wgnUpdateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getWgnUpdateTime() {
        return wgnUpdateTime;
    }

    /**
     * Sets the value of the wgnUpdateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setWgnUpdateTime(XMLGregorianCalendar value) {
        this.wgnUpdateTime = value;
    }

    /**
     * Gets the value of the wgnUserAgents property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWgnUserAgents() {
        return wgnUserAgents;
    }

    /**
     * Sets the value of the wgnUserAgents property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWgnUserAgents(String value) {
        this.wgnUserAgents = value;
    }

    /**
     * Gets the value of the wgnWeight property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getWgnWeight() {
        return wgnWeight;
    }

    /**
     * Sets the value of the wgnWeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setWgnWeight(Byte value) {
        this.wgnWeight = value;
    }

}
