package com.lab.db;

import com.lab.db.address.Address;
import com.lab.db.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;

public class App {
    @Autowired
    AddressService addressService;

    public App() {
    }

    public void start() {
        String s = new String();
        while (s != null) {
            System.out.println("What entity you want operate?");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                s = br.readLine();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            switch (convert(s)) {
                case -1:
                    s = null;
                    break;
                case 0:
                    break;
                case 1:
                    addresses();
                    break;
                case 2:
                    s = null;
                    break;
                case 3:
                    s = null;
                    break;
                case 4:
                    s = null;
                    break;
                case 5:
                    s = null;
                    break;
                case 6:
                    s = null;
                    break;
                case 7:
                    s = null;
                    break;
                case 8:
                    s = null;
                    break;
            }
        }
    }

    private int convert(String str) {
        if (str.contains("addresses")) return 1;
        if (str.contains("projects")) return 2;
        if (str.contains("contractor_classes")) return 3;
        if (str.contains("contractors")) return 4;
        if (str.contains("order")) return 5;
        if (str.contains("expenditure_items")) return 6;
        if (str.contains("nomenclatures")) return 7;
        if (str.contains("expenditures")) return 8;
        if (str.contains("exit")) return -1;
        return 0;
    }

    private int convertCommand(String str) {
        if (str.contains("find")) return 1;
        if (str.contains("findAll")) return 2;
        if (str.contains("create")) return 3;
        if (str.contains("update")) return 4;
        if (str.contains("delete")) return 5;
        if (str.contains("exit")) return -1;
        return 0;
    }

    private void addresses() {
        String s = new String();
        while (s != null) {
            System.out.println("What operation you need?");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                s = br.readLine();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            switch (convertCommand(s)) {
                case -1:
                    s = null;
                    break;
                case 0:
                    break;
                case 1:
                    try {
                        System.out.println("Provide id:");
                        int i = Integer.parseInt(br.readLine());
                        System.out.println(addressService.findById(i).toString());
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 2:
                    for (Address addr: addressService.findAll()) {
                        System.out.println(addr.toString());
                    }
                    break;
                case 3:
                    try {
                        Address addr = new Address();
                        System.out.println("Provide settlement:");
                        addr.setSettlement(br.readLine());
                        System.out.println("Provide street:");
                        addr.setStreet(br.readLine());
                        System.out.println("Provide house:");
                        int h = Integer.parseInt(br.readLine());
                        addr.setHouse(h);
                        addressService.create(addr);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Provide id:");
                        int i = Integer.parseInt(br.readLine());
                        Address addr = addressService.findById(i);
                        System.out.println("Provide settlement:");
                        addr.setSettlement(br.readLine());
                        System.out.println("Provide street:");
                        addr.setStreet(br.readLine());
                        System.out.println("Provide house:");
                        int h = Integer.parseInt(br.readLine());
                        addr.setHouse(h);
                        addressService.update(i, addr);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 5:
                    try {
                        System.out.println("Provide id:");
                        int i = Integer.parseInt(br.readLine());
                        addressService.delete(i);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }
        }
    }
}
