package com.cg.ems.ExpenseCodeModule.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.ExpenseCodeModule.model.ExpenseCodeModule;
import com.cg.ems.ExpenseCodeModule.repository.ExpensesRepo;

@Service
public class ExpenseCodeModuleServiceImpl implements ExpenseCodeModuleService {

	@Autowired
	ExpensesRepo repo;
	
	@Override
	public List<ExpenseCodeModule> findAll() {
		return (List<ExpenseCodeModule>) repo.findAll();
	}

	@Override
	public Optional<ExpenseCodeModule> displayById(int id) {
		return repo.findById(id); 
	}

	@Override
	public String update( ExpenseCodeModule expense) {
		repo.save(expense);
		return "Record Updated Successfully";
	}

	@Override
	public String delete(int id) {
		repo.deleteById(id);
		return "Record deleted Successfully";
	}

	@Override
	public String add(ExpenseCodeModule expense) {
		repo.save(expense);
		return "Record Added Successfully";
	}

}
