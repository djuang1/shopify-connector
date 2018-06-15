package org.mule.modules.shopify;

import org.mule.api.annotations.Config;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;

import java.io.IOException;
import java.util.Map;

import org.mule.api.annotations.ReconnectOn;
import org.mule.api.annotations.display.FriendlyName;
import org.mule.api.annotations.display.Summary;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Payload;
import org.mule.api.annotations.rest.HttpMethod;
import org.mule.api.annotations.rest.RestCall;
import org.mule.api.annotations.rest.RestHeaderParam;
import org.mule.api.annotations.rest.RestUriParam;

import org.mule.modules.shopify.config.ConnectorConfig;

@Connector(name="shopify", friendlyName="Shopify")
public abstract class ShopifyConnector {

    @Config
    ConnectorConfig config;
    
    @Configurable
    @RestUriParam("storeUrl")
    @Summary("The Store URL")
    @Default("wwe-test.myshopify.com")
    @FriendlyName("Store URL")
	private String storeUrl;
    
	public String getStoreUrl() {
		return storeUrl;
	}

	public void setStoreUrl(String storeUrl) {
		this.storeUrl = storeUrl;
	}
	
    /**
     * Retrieves a list of orders
     *
     * @return Orders.
     * @throws IOException Comment for Exception
     */
    @Processor
    @ReconnectOn(exceptions = { Exception.class })
    @RestCall(uri="https://{storeUrl}/admin/orders.json", method=HttpMethod.GET, contentType = "application/json")
    public abstract String getOrders() throws IOException;  
    
    /**
     * Creates an order
     *
     * @return Order.
     * @throws IOException Comment for Exception
     */
    @Processor
    @ReconnectOn(exceptions = { Exception.class })
    @RestCall(uri="https://{storeUrl}/admin/orders.json", method=HttpMethod.POST, contentType = "application/json")
    public abstract String createOrders(@Payload String request) throws IOException;  

    public ConnectorConfig getConfig() {
        return config;
    }

    public void setConfig(ConnectorConfig config) {
        this.config = config;
    }

}