package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		Department dep = depDao.findById(1);
		System.out.println(dep);
		System.out.println();

		List<Department> list = depDao.findAll();
		for(Department d: list) {
			System.out.println(d);
		}
		/*
		Department department = new Department(null, "Music");
		depDao.insert(department);
		System.out.println("Inserted! " + department.getId());
		*/
		dep.setName("Computer");
		depDao.update(dep);
		System.out.println("UPDATED");
		
		depDao.deleteById(7);
	}

}
