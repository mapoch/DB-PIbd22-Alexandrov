package com.lab.db;

import com.lab.db.address.Address;
import com.lab.db.address.AddressService;
import com.lab.db.project.Project;
import com.lab.db.project.ProjectService;
import com.lab.db.contractors_class.Contractors_class;
import com.lab.db.contractors_class.Contractor_classService;
import com.lab.db.contractor.Contractor;
import com.lab.db.contractor.ContractorService;
import com.lab.db.order.Order;
import com.lab.db.order.OrderService;
import com.lab.db.expenditure_item.Expenditure_item;
import com.lab.db.expenditure_item.Expenditure_itemService;
import com.lab.db.nomenclature.Nomenclature;
import com.lab.db.nomenclature.NomenclatureService;
import com.lab.db.expenditure.Expenditure;
import com.lab.db.expenditure.ExpenditureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.Date;

@Component
public class App {
    @Autowired
    AddressService addressService;
    @Autowired
    ProjectService projectService;
    @Autowired
    Contractor_classService contractor_classService;
    @Autowired
    ContractorService contractorService;
    @Autowired
    OrderService orderService;
    @Autowired
    Expenditure_itemService expenditure_itemService;
    @Autowired
    NomenclatureService nomenclatureService;
    @Autowired
    ExpenditureService expenditureService;

    public void start() {
        if (addressService == null) {System.out.println("fail");return;}
        String s = new String();
        while (s != null) {
            System.out.println("What table you want operate?");
            System.out.println("addresses, projects, contractor_classes, contractors,\n" +
                    "order, expenditure_items, nomenclatures, expenditures\nType exit to exit");
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
                    projects();
                    break;
                case 3:
                    contractor_classes();
                    break;
                case 4:
                    contractors();
                    break;
                case 5:
                    orders();
                    break;
                case 6:
                    expenditures_items();
                    break;
                case 7:
                    nomenclatures();
                    break;
                case 8:
                    expenditures();
                    break;
            }
        }
    }

    private int convert(String str) {
        if (str.equals("addresses")) return 1;
        if (str.equals("projects")) return 2;
        if (str.equals("contractor_classes")) return 3;
        if (str.equals("contractors")) return 4;
        if (str.equals("orders")) return 5;
        if (str.equals("expenditure_items")) return 6;
        if (str.equals("nomenclatures")) return 7;
        if (str.equals("expenditures")) return 8;
        if (str.equals("exit")) return -1;
        return 0;
    }

    private int convertCommand(String str) {
        if (str.equals("find")) return 1;
        if (str.equals("findAll")) return 2;
        if (str.equals("create")) return 3;
        if (str.equals("update")) return 4;
        if (str.equals("delete")) return 5;
        if (str.equals("exit")) return -1;
        return 0;
    }

    private void addresses() {
        String s = new String();
        while (s != null) {
            System.out.println("What operation you need?");
            System.out.println("find, findAll, create, update, delete\nType exit to exit");
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

    private void projects() {
        String s = new String();
        while (s != null) {
            System.out.println("What operation you need?");
            System.out.println("find, findAll, create, update, delete\nType exit to exit");
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
                        System.out.println(projectService.findById(i).toString());
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 2:
                    for (Project proj: projectService.findAll()) {
                        System.out.println(proj.toString());
                    }
                    break;
                case 3:
                    try {
                        Project proj = new Project();
                        System.out.println("Provide rooms:");
                        int h = Integer.parseInt(br.readLine());
                        proj.setRooms(h);
                        projectService.create(proj);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Provide id:");
                        int i = Integer.parseInt(br.readLine());
                        Project proj = projectService.findById(i);
                        System.out.println("Provide rooms:");
                        int h = Integer.parseInt(br.readLine());
                        proj.setRooms(h);
                        projectService.update(i, proj);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 5:
                    try {
                        System.out.println("Provide id:");
                        int i = Integer.parseInt(br.readLine());
                        projectService.delete(i);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }
        }
    }

    private void contractor_classes() {
        String s = new String();
        while (s != null) {
            System.out.println("What operation you need?");
            System.out.println("find, findAll, create, update, delete\nType exit to exit");
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
                        System.out.println(contractor_classService.findById(i).toString());
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 2:
                    for (Contractors_class cont_class: contractor_classService.findAll()) {
                        System.out.println(cont_class.toString());
                    }
                    break;
                case 3:
                    try {
                        Contractors_class cont_class = new Contractors_class();
                        System.out.println("Provide name:");
                        cont_class.setName(br.readLine());
                        contractor_classService.create(cont_class);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Provide id:");
                        int i = Integer.parseInt(br.readLine());
                        Contractors_class cont_class = contractor_classService.findById(i);
                        System.out.println("Provide name:");
                        cont_class.setName(br.readLine());
                        contractor_classService.update(i, cont_class);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 5:
                    try {
                        System.out.println("Provide id:");
                        int i = Integer.parseInt(br.readLine());
                        contractor_classService.delete(i);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }
        }
    }

    private void contractors() {
        String s = new String();
        while (s != null) {
            System.out.println("What operation you need?");
            System.out.println("find, findAll, create, update, delete\nType exit to exit");
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
                        System.out.println(contractorService.findById(i).toString());
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 2:
                    for (Contractor cont: contractorService.findAll()) {
                        System.out.println(cont.toString());
                    }
                    break;
                case 3:
                    try {
                        Contractor cont = new Contractor();
                        System.out.println("Provide name:");
                        cont.setName(br.readLine());
                        System.out.println("Provide phone:");
                        cont.setPhone(br.readLine());
                        contractorService.create(cont);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Provide id:");
                        int i = Integer.parseInt(br.readLine());
                        Contractor cont = contractorService.findById(i);
                        System.out.println("Provide name:");
                        cont.setName(br.readLine());
                        System.out.println("Provide phone:");
                        cont.setPhone(br.readLine());
                        contractorService.update(i, cont);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 5:
                    try {
                        System.out.println("Provide id:");
                        int i = Integer.parseInt(br.readLine());
                        contractorService.delete(i);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }
        }
    }

    private void orders() {
        String s = new String();
        while (s != null) {
            System.out.println("What operation you need?");
            System.out.println("find, findAll, create, update, delete\nType exit to exit");
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
                        System.out.println(orderService.findById(i).toString());
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 2:
                    for (Order cont: orderService.findAll()) {
                        System.out.println(cont.toString());
                    }
                    break;
                case 3:
                    try {
                        Order ord = new Order();
                        System.out.println("Provide works start:");
                        ord.setWorks_start(Date.valueOf(br.readLine()));
                        System.out.println("Provide works end:");
                        ord.setWorks_end(Date.valueOf(br.readLine()));
                        orderService.create(ord);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Provide id:");
                        int i = Integer.parseInt(br.readLine());
                        Order ord = orderService.findById(i);
                        System.out.println("Provide works start:");
                        ord.setWorks_start(Date.valueOf(br.readLine()));
                        System.out.println("Provide works end:");
                        ord.setWorks_end(Date.valueOf(br.readLine()));
                        orderService.update(i, ord);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 5:
                    try {
                        System.out.println("Provide id:");
                        int i = Integer.parseInt(br.readLine());
                        orderService.delete(i);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }
        }
    }

    private void expenditures_items() {
        String s = new String();
        while (s != null) {
            System.out.println("What operation you need?");
            System.out.println("find, findAll, create, update, delete\nType exit to exit");
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
                        System.out.println(expenditure_itemService.findById(i).toString());
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 2:
                    for (Expenditure_item exp_item: expenditure_itemService.findAll()) {
                        System.out.println(exp_item.toString());
                    }
                    break;
                case 3:
                    try {
                        Expenditure_item exp_item = new Expenditure_item();
                        System.out.println("Provide name:");
                        exp_item.setName(br.readLine());
                        expenditure_itemService.create(exp_item);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Provide id:");
                        int i = Integer.parseInt(br.readLine());
                        Expenditure_item exp_item = expenditure_itemService.findById(i);
                        System.out.println("Provide name:");
                        exp_item.setName(br.readLine());
                        expenditure_itemService.update(i, exp_item);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 5:
                    try {
                        System.out.println("Provide id:");
                        int i = Integer.parseInt(br.readLine());
                        expenditure_itemService.delete(i);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }
        }
    }

    private void nomenclatures() {
        String s = new String();
        while (s != null) {
            System.out.println("What operation you need?");
            System.out.println("find, findAll, create, update, delete\nType exit to exit");
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
                        System.out.println(nomenclatureService.findById(i).toString());
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 2:
                    for (Nomenclature nomen: nomenclatureService.findAll()) {
                        System.out.println(nomen.toString());
                    }
                    break;
                case 3:
                    try {
                        Nomenclature nomen = new Nomenclature();
                        System.out.println("Provide name:");
                        nomen.setName(br.readLine());
                        nomenclatureService.create(nomen);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Provide id:");
                        int i = Integer.parseInt(br.readLine());
                        Nomenclature nomen = nomenclatureService.findById(i);
                        System.out.println("Provide name:");
                        nomen.setName(br.readLine());
                        nomenclatureService.update(i, nomen);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 5:
                    try {
                        System.out.println("Provide id:");
                        int i = Integer.parseInt(br.readLine());
                        nomenclatureService.delete(i);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }
        }
    }

    private void expenditures() {
        String s = new String();
        while (s != null) {
            System.out.println("What operation you need?");
            System.out.println("find, findAll, create, update, delete\nType exit to exit");
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
                        System.out.println(expenditureService.findById(i).toString());
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 2:
                    for (Expenditure exp: expenditureService.findAll()) {
                        System.out.println(exp.toString());
                    }
                    break;
                case 3:
                    try {
                        Expenditure exp = new Expenditure();
                        System.out.println("Provide name:");
                        BigDecimal ex = new BigDecimal(br.readLine());
                        exp.setExpense(ex);
                        expenditureService.create(exp);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Provide id:");
                        int i = Integer.parseInt(br.readLine());
                        Expenditure exp = expenditureService.findById(i);
                        System.out.println("Provide expense:");
                        BigDecimal ex = new BigDecimal(br.readLine());
                        exp.setExpense(ex);
                        expenditureService.update(i, exp);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 5:
                    try {
                        System.out.println("Provide id:");
                        int i = Integer.parseInt(br.readLine());
                        expenditureService.delete(i);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }
        }
    }
}
