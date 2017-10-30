package application;


import menu.Menu;
import menu.MenuEntry;
import model.Price;
import serviceSoap.ServiceSoap;
import serviceSoap.WebServiceSOAP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

public class App {
    public static void main(String[] args)  {
        Menu menu = new Menu();
        menu.addEntry(new MenuEntry("Добавление цены") {
            @Override
            public void run() {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                try {
                    System.out.println("Введите продукт и цену");
                    String name = reader.readLine();
                    String price = reader.readLine();
                    ServiceSoap service = new ServiceSoap();
                    WebServiceSOAP webServiceSOAP= service.getServiceSoapPort();
                    webServiceSOAP.create(new Price(name , Double.parseDouble(price)));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        menu.addEntry(new MenuEntry("Изменение цены") {
            @Override
            public void run() {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                try {
                    System.out.println("Введите продукт и цену");
                    String name = reader.readLine();
                    String price = reader.readLine();
                    ServiceSoap service = new ServiceSoap();
                    WebServiceSOAP webServiceSOAP= service.getServiceSoapPort();
                    webServiceSOAP.update(new Price(name , Double.parseDouble(price)));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        menu.addEntry(new MenuEntry("Просмотр цены") {
            @Override
            public void run() {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                try {
                    System.out.println("Введите продукт");
                    String line = reader.readLine();
                    ServiceSoap service = new ServiceSoap();
                    WebServiceSOAP webServiceSOAP= service.getServiceSoapPort();
                    System.out.println(webServiceSOAP.getPriceByName(line).getValue());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        menu.run();
    }
}
