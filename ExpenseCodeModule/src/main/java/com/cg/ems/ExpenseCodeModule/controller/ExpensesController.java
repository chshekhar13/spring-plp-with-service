package com.cg.ems.ExpenseCodeModule.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.ExpenseCodeModule.exception.ExpenseDetailsNotFound;
import com.cg.ems.ExpenseCodeModule.model.ExpenseCodeModule;
import com.cg.ems.ExpenseCodeModule.repository.ExpensesRepo;
import com.cg.ems.ExpenseCodeModule.service.ExpenseCodeModuleService;

@RestController
public class ExpensesController {

	@Autowired
	ExpenseCodeModule exp;
//	@Autowired
//	ExpensesRepo repo;
	@Autowired
	ExpenseCodeModuleService service;
	
	//display all
	@GetMapping("/expensecodemodule/")
	@CrossOrigin("http://localhost:4200")
	public List<ExpenseCodeModule> displayExpenses() {
		//List<ExpenseCodeModule> list = (List<ExpenseCodeModule>) repo.findAll();
		List<ExpenseCodeModule> list = service.findAll();
		if(list.isEmpty()) {
			throw new ExpenseDetailsNotFound("Expense Details not Found");
		}
		return list;
	}
	
	//display by id
	@GetMapping("/expensecodemodule/{id}")
	@CrossOrigin("http://localhost:4200")
	public Optional<ExpenseCodeModule> displayById(@PathVariable("id") int id) {
		//Optional<ExpenseCodeModule> expense = repo.findById(id);
		Optional<ExpenseCodeModule> expense = service.displayById(id);
		if(expense.isPresent()) {
			return expense;
		}
		else
			throw new ExpenseDetailsNotFound("Expenses of the ID: "+id+" not found!");
	}

	//update details
	@PutMapping("/expensecodemodule/{id}")
	public String update(@RequestBody ExpenseCodeModule expense, @PathVariable("id") int id) {
		//Optional<ExpenseCodeModule> expense1 = repo.findById(id);
		Optional<ExpenseCodeModule> expense1 = service.displayById(id);
		if(expense1.isPresent()) {
			expense.setExpense_code(id);
			//repo.save(expense);
			return service.update(expense);
		}
		else {
			throw new ExpenseDetailsNotFound("Expenses of the ID: "+id+" not found!");
		}
	}
	
	//delete details
	@DeleteMapping("/expensecodemodule/{id}")
	public String delete(@PathVariable("id") int id) {
		//Optional<ExpenseCodeModule> expense1 = repo.findById(id);
		Optional<ExpenseCodeModule> expense1 = service.displayById(id);
		if(expense1.isPresent()) {
			//repo.deleteById(id);
			return service.delete(id);
			//return "Record deleted Successfully";
		}
		else {
			throw new ExpenseDetailsNotFound("Expenses of the ID: "+id+" not found!");
	
		}
	}
	
	//add details
	@PostMapping("/expensecodemodule/")
	public String add(@RequestBody ExpenseCodeModule expense) {
		//repo.save(expense);
		return service.add(expense);
		//return "Record Added Successfully";
	}
	
//	@ExceptionHandler(ExpenseDetailsNotFound.class)
//	public ResponseEntity<Object> ExpenseDetailsNotFoundHandler(){
//		return new ResponseEntity<>("Expense Details not found",HttpStatus.NOT_FOUND);
//	}
	
}
