package com.lenin.demoWeb;


import java.util.Map;
import java.util.Properties;
import javax.xml.ws.BindingProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoWebApplication.class, args);
                //Properties props=new Properties();
               // props.setProperty("javax.net.ssl.keyStore","C:\Program Files\Java\jdk1.8.0_231\jre\lib\security\cacerts");
                
               // String prop=System.setProperty("javax.net.ssl.keyStore","C:\Program Files\Java\jdk1.8.0_231\jre\lib\security\cacerts");
               // Properties p = new Properties(System.getProperties());
                
                
//                try { // Call Web Service Operation
//                    
//                   //  System.out.println(System.getProperties());
//                    com.lenin.demoWeb.services.Service_Service service = new com.lenin.demoWeb.services.Service_Service();
//                    com.lenin.demoWeb.services.Service port = service.getServicePort();
//                    // TODO initialize WS operation arguments here
//                    java.lang.String name = "";
//                    // TODO process result here
//                    java.lang.String result = port.hello(name);
//                    System.out.println("Result = "+result);
//                    //System.out.println(System.getProperties());
//                    
//                } catch (Exception ex) {
//                    // TODO handle custom exceptions here
//                    ex.printStackTrace();
//                }


                
            //    try { // Call Web Service Operation
//                    MathServices_Service service = new MathServices_Service();
//                   MathServices port = service.getMathServicesPort();
                    // TODO initialize WS operation arguments here
                    
                    
//                    Map requestCtx = ((BindingProvider) port).getRequestContext();
                    
//                    requestCtx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8080/WebApplication1/MathServices?WSDL");
//                    requestCtx.put(BindingProvider.USERNAME_PROPERTY,"mzheng");
//                    requestCtx.put(BindingProvider.PASSWORD_PROPERTY, "great");
//                    requestCtx.put(BindingProvider.SOAPACTION_USE_PROPERTY, Boolean.TRUE);
//                    requestCtx.put(BindingProvider.SESSION_MAINTAIN_PROPERTY, Boolean.TRUE);
//                    
                    
//                    int a = 0;
//                    int b = 0;
                    // TODO process result here
//                    int result = port.suma(a, b);
//                    System.out.println("Result = "+result);
                //} catch (Exception ex) {
                    // TODO handle custom exceptions here
                //}

                
                
	}

}
