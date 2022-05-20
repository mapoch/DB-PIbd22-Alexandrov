package com.lab.db;

import com.lab.db.address.Address;
import com.lab.db.address.AddressService;
import com.lab.db.contractor.Contractor;
import com.lab.db.contractor.ContractorService;
import com.lab.db.contractors_class.Contractor_classService;
import com.lab.db.contractors_class.Contractors_class;
import com.lab.db.expenditure.Expenditure;
import com.lab.db.expenditure.ExpenditureService;
import com.lab.db.expenditure_item.Expenditure_item;
import com.lab.db.expenditure_item.Expenditure_itemService;
import com.lab.db.nomenclature.Nomenclature;
import com.lab.db.nomenclature.NomenclatureService;
import com.lab.db.order.Order;
import com.lab.db.order.OrderService;
import com.lab.db.project.Project;
import com.lab.db.project.ProjectService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootTest
class DbApplicationTests {
	@Autowired
	private AddressService addressService;
	@Autowired
	private ContractorService contractorService;
	@Autowired
	private Contractor_classService contractor_classService;
	@Autowired
	private Expenditure_itemService expenditure_itemService;
	@Autowired
	private NomenclatureService nomenclatureService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private ExpenditureService expenditureService;

	@Test
	void addressTest() {
		Address addr = new Address();
		addr.setSettlement("Zujevka");
		addr.setStreet("Novaja");
		addr.setHouse(5);
		addr.setId(addressService.create(addr));
		addr.setHouse(3);
		addressService.update(addr.getId(), addr);
		Address foundaddr = addressService.findById(addr.getId());
		Assertions.assertNotEquals(addr, foundaddr);
	}

	@Test
	void projectTest() {
		Project proj = new Project();
		proj.setRooms(4);
		proj.setId(projectService.create(proj));
		proj.setRooms(3);
		projectService.update(proj.getId(), proj);
		Project foundproj = projectService.findById(proj.getId());
		Assertions.assertNotEquals(proj, foundproj);
	}

	@Test
	void contractor_classTest() {
		Contractors_class cont_class = new Contractors_class();
		cont_class.setName("default");
		cont_class.setId(contractor_classService.create(cont_class));
		cont_class.setName("notdefault");
		contractor_classService.update(cont_class.getId(), cont_class);
		Contractors_class foundcont_class = contractor_classService.findById(cont_class.getId());
		Assertions.assertNotEquals(cont_class, foundcont_class);
	}

	@Test
	void contractorTest() {
		Contractor cont = new Contractor();
		cont.setName("Siemion");
		cont.setPhone("555-33-35");
		cont.setId(contractorService.create(cont));
		cont.setName("Pietrovich");
		contractorService.update(cont.getId(), cont);
		Contractor foundcont = contractorService.findById(cont.getId());
		Assertions.assertNotEquals(cont, foundcont);
	}

	@Test
	void orderTest() {
		java.util.Date dateUtil = new java.util.Date();
		Order ord = new Order();
		ord.setWorks_start(new java.sql.Date(dateUtil.getTime()));
		ord.setId(orderService.create(ord));
		ord.setWorks_end(new java.sql.Date(dateUtil.getTime()));
		orderService.update(ord.getId(), ord);
		Order foundord = orderService.findById(ord.getId());
		Assertions.assertNotEquals(ord, foundord);
	}

	@Test
	void expenditure_itemTest() {
		Expenditure_item exp_item = new Expenditure_item();
		exp_item.setName("default");
		exp_item.setId(expenditure_itemService.create(exp_item));
		exp_item.setName("notdefault");
		expenditure_itemService.update(exp_item.getId(), exp_item);
		Expenditure_item foundaddr = expenditure_itemService.findById(exp_item.getId());
		Assertions.assertNotEquals(exp_item, foundaddr);
	}

	@Test
	void nomenclatureTest() {
		Nomenclature nomen = new Nomenclature();
		nomen.setName("default");
		nomen.setId(nomenclatureService.create(nomen));
		nomen.setName("notdefault");
		nomenclatureService.update(nomen.getId(), nomen);
		Nomenclature foundaddr = nomenclatureService.findById(nomen.getId());
		Assertions.assertNotEquals(nomen, foundaddr);
	}

	@Test
	void expenditureTest() {
		Expenditure exp = new Expenditure();
		exp.setExpense(new BigDecimal("300"));
		exp.setId(expenditureService.create(exp));
		exp.setExpense(new BigDecimal("302"));
		expenditureService.update(exp.getId(), exp);
		Expenditure foundaddr = expenditureService.findById(exp.getId());
		Assertions.assertNotEquals(exp, foundaddr);
	}

	@Test
	void advanceTest() {
		long start = System.currentTimeMillis();
		expenditureService.findAll();
		long finish = System.currentTimeMillis();
		System.out.println("findAllExpenditures: " + (finish - start));

		start = System.currentTimeMillis();
		expenditureService.getSortedDown();
		finish = System.currentTimeMillis();
		System.out.println("getSorted: " + (finish - start));

		start = System.currentTimeMillis();
		expenditureService.getGroupted();
		finish = System.currentTimeMillis();
		System.out.println("getGroupted: " + (finish - start));

		start = System.currentTimeMillis();
		expenditureService.getHigherExpense(50000);
		finish = System.currentTimeMillis();
		System.out.println("getHigher than 50000: " + (finish - start));

		start = System.currentTimeMillis();
		expenditureService.getHigherExpense(99000);
		finish = System.currentTimeMillis();
		System.out.println("getHigher than 99000: " + (finish - start));

		start = System.currentTimeMillis();
		orderService.getByYear(2023);
		finish = System.currentTimeMillis();
		System.out.println("getByYear: " + (finish - start));

		start = System.currentTimeMillis();
		addressService.getBySettlement("Moscow");
		finish = System.currentTimeMillis();
		System.out.println("getBySettlement: " + (finish - start));
	}
}
