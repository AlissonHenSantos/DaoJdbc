package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("=== TEST 1: seller findById ====");
		Seller seller = sellerDao.findById(1);
		System.out.println(seller);
		
		System.out.println("\n === TEST 2: seller findByDepartment ====");
		List<Seller> listSeller = sellerDao.findByDepartment(new Department(2, null));

		for(Seller s : listSeller) {
			System.out.println(s);
		}
		
		System.out.println("\n === TEST 3: seller findAllt ====");
		listSeller = sellerDao.findAll();
		
		for(Seller s : listSeller) {
			System.out.println(s);
		}
		
		System.out.println("\n === TEST 4: seller insert ====");
		
		Seller newSeller = new Seller(null, "Greg", "Greg@gmail.com", new Date(), 4000.00, new Department(1, null));
		
		sellerDao.insert(newSeller);
		System.out.println("Inserted! new id = " + newSeller.getId());
	}

}
