package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
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
		
		System.out.println("\n === TEST 5: seller Update ====");
		
		seller = sellerDao.findById(1);
		
		seller.setName("Martha Weine");
		sellerDao.update(seller);
		System.out.println("Update Completed");
		
		System.out.println("\n === TEST 6: seller Delete ====");
		System.out.println("Enter id for delete teste: ");
		int id = sc.nextInt();
		
		sellerDao.deleteById(id);
		System.out.println("Delete Completed");
		
		sc.close();
	}

}
