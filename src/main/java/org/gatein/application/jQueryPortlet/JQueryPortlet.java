package org.gatein.application.jQueryPortlet;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.MimeResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.w3c.dom.Element;

public class JQueryPortlet extends GenericPortlet
{
	public JQueryPortlet()
	{
		
	}
	
	@Override
	public void doView(RenderRequest request, RenderResponse response)
	{
		PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher("/jsp/index.jsp");
        try {
			prd.include(request, response);
		} catch (PortletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void doHeaders(RenderRequest request, RenderResponse response)
	{
		Element css = response.createElement("link");
		css.setAttribute("id", "jqueryDemo");
		css.setAttribute("type", "text/css");
		css.setAttribute("rel", "stylesheet");
		css.setAttribute("href", request.getContextPath() + "/css/jqueryDemo.css");
        response.addProperty(MimeResponse.MARKUP_HEAD_ELEMENT, css);
		
		Element jQuery = response.createElement("script");
		jQuery.setAttribute("type", "text/javascript");
		jQuery.setAttribute("src", request.getContextPath() + "/js/jquery-1.4.2.min.js");
        response.addProperty(MimeResponse.MARKUP_HEAD_ELEMENT, jQuery);

		Element jQueryUI = response.createElement("script");
		jQueryUI.setAttribute("type", "text/javascript");
		jQueryUI.setAttribute("src", request.getContextPath() + "/js/jquery-ui-1.8.1.custom.min.js");
        response.addProperty(MimeResponse.MARKUP_HEAD_ELEMENT, jQueryUI);

        Element myJS = response.createElement("script");
		myJS.setAttribute("type", "text/javascript");
		myJS.setAttribute("src", request.getContextPath() + "/js/myJS.js");
        response.addProperty(MimeResponse.MARKUP_HEAD_ELEMENT, myJS);
        
	}
}
