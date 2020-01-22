/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientcalc;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import static java.lang.System.console;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;

/**
 *
 * @author informatica
 */
public class ClientCalc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, MalformedURLException, ParserConfigurationException {

        //wsdl URL: http://www.genivia.com/calc.wsdl
        //endpoint URL: http://websrv.cs.fsu.edu/~engelen/calcserver.cgi
        Scanner in = new Scanner(System.in);
        String scelta, num;

        do {
            System.out.println("1)Somma");
            System.out.println("2)Sottrazione");
            System.out.println("3)Moltiplicazione");
            System.out.println("4)Divisione");
            System.out.println("5)Potenza");
            System.out.println("0)Uscita");

            scelta = in.nextLine();
            String xml;
            switch (scelta) {
                case "1":
                    xml = "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:calc\">\n"
                            + "<soapenv:Header/>\n"
                            + "<soapenv:Body>\n"
                            + "<urn:add soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n"
                            + "<a xsi:type=\"xsd:double\">zz</a>\n"
                            + "<b xsi:type=\"xsd:double\">yy</b>\n"
                            + "</urn:add>\n"
                            + "</soapenv:Body>\n"
                            + "</soapenv:Envelope>";
                    
                    System.out.println("Primo numero:");
                    num = in.nextLine();
                    xml = xml.replace("zz", num);
                    
                    System.out.println("Secondo numero:");
                    num = in.nextLine();
                    xml = xml.replace("yy", num);
                    
                    connection(xml);
                    break;

                case "2":
                    xml = "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:calc\">\n"
                            + "<soapenv:Header/>\n"
                            + "<soapenv:Body>\n"
                            + "<urn:sub soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n"
                            + "<a xsi:type=\"xsd:double\">zz</a>\n"
                            + "<b xsi:type=\"xsd:double\">yy</b>\n"
                            + "</urn:sub>\n"
                            + "</soapenv:Body>\n"
                            + "</soapenv:Envelope>";
                    
                    System.out.println("Primo numero:");
                    num = in.nextLine();
                    xml = xml.replace("zz", num);
                    
                    System.out.println("Secondo numero:");
                    num = in.nextLine();
                    xml = xml.replace("yy", num);
                    
                    connection(xml);
                    break;

                case "3":
                    xml = "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:calc\">\n"
                            + "<soapenv:Header/>\n"
                            + "<soapenv:Body>\n"
                            + "<urn:mul soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n"
                            + "<a xsi:type=\"xsd:double\">zz</a>\n"
                            + "<b xsi:type=\"xsd:double\">yy</b>\n"
                            + "</urn:mul>\n"
                            + "</soapenv:Body>\n"
                            + "</soapenv:Envelope>";
                    
                    System.out.println("Primo numero:");
                    num = in.nextLine();
                    xml = xml.replace("zz", num);
                    
                    System.out.println("Secondo numero:");
                    num = in.nextLine();
                    xml = xml.replace("yy", num);
                    
                    connection(xml);
                    break;

                case "4":
                    xml = "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:calc\">\n"
                            + "<soapenv:Header/>\n"
                            + "<soapenv:Body>\n"
                            + "<urn:div soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n"
                            + "<a xsi:type=\"xsd:double\">zz</a>\n"
                            + "<b xsi:type=\"xsd:double\">yy</b>\n"
                            + "</urn:div>\n"
                            + "</soapenv:Body>\n"
                            + "</soapenv:Envelope>";
                    
                    System.out.println("Primo numero:");
                    num = in.nextLine();
                    xml = xml.replace("zz", num);
                    
                    System.out.println("Secondo numero:");
                    num = in.nextLine();
                    xml = xml.replace("yy", num);
                    
                    connection(xml);
                    break;

                case "5":
                    xml = "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:calc\">\n"
                            + "<soapenv:Header/>\n"
                            + "<soapenv:Body>\n"
                            + "<urn:pow soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n"
                            + "<a xsi:type=\"xsd:double\">zz</a>\n"
                            + "<b xsi:type=\"xsd:double\">yy</b>\n"
                            + "</urn:pow>\n"
                            + "</soapenv:Body>\n"
                            + "</soapenv:Envelope>";
                    
                    System.out.println("Primo numero:");
                    num = in.nextLine();
                    xml = xml.replace("zz", num);
                    
                    System.out.println("Secondo numero:");
                    num = in.nextLine();
                    xml = xml.replace("yy", num);
                    
                    connection(xml);
                    break;
            }

        } while (!scelta.equals("0"));
    }

    public static void connection(String xml) throws MalformedURLException, IOException, ParserConfigurationException {
        String responseString = "";
        String outputString = "";
        String wsEndPoint = "http://websrv.cs.fsu.edu/~engelen/calcserver.cgi";
        URL url = new URL(wsEndPoint);
        URLConnection connection = url.openConnection();
        HttpURLConnection httpConn = (HttpURLConnection) connection;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        String xmlInput = xml;
        byte[] buffer = new byte[xmlInput.length()];
        buffer = xmlInput.getBytes();
        bout.write(buffer);
        byte[] b = bout.toByteArray();
        String SOAPAction = "getUserDetails";
        httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
        httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        httpConn.setRequestProperty("SOAPAction", SOAPAction);
        httpConn.setRequestMethod("POST");
        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);
        OutputStream out = httpConn.getOutputStream();
        // Write the content of the request to the outputstream of the HTTP
        // Connection.
        out.write(b);
        out.close();
        // Ready with sending the request.
        // Read the response.
        InputStreamReader isr = new InputStreamReader(httpConn.getInputStream(), Charset.forName("UTF-8"));
        BufferedReader in = new BufferedReader(isr);
        // Write the SOAP message response to a String.
        while ((responseString = in.readLine()) != null) {
            outputString = outputString + responseString;
        }
        //String formattedSOAPResponse = formatXML(outputString);
        System.out.println(outputString);
    }
}
