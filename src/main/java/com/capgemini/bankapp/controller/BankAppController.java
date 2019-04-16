package com.capgemini.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.bankapp.exception.BankAccountNotFoundException;
import com.capgemini.bankapp.exception.LowBalanceException;
import com.capgemini.bankapp.service.BankAccountService;
import com.capgemini.model.BankAccount;

@Controller
@RequestMapping("/bank")
public class BankAppController {


	@Autowired
	BankAccountService bankAccountService;

	@RequestMapping("/home")
	public String home() {
		return "mai_index";
	}

	@RequestMapping("/home/create_acc")
	public String inputpage() {
		return "create_acc";
	}

	@RequestMapping("/new")
	public String addNewAccount(@RequestParam("customername") String accountHolderName,
			@RequestParam("accounttype") String accountType, @RequestParam("customerbalance") double accountBalance,
			Model model) {

		bankAccountService.addNewbankAccount(new BankAccount(accountHolderName, accountType, accountBalance));
		//addaddNewBankAccount(new BankAccount(accountHolderName, accountType, accountBalance));
		model.addAttribute("message", "Account Added Succesfullly...");
		return "success";

	}
	
	//delete account-----

	@RequestMapping("home/deleteAccount")
	public String deletePage() {
		return "deleteAccount";
	}

	@RequestMapping("/delete")
	public String deleteAccount(@RequestParam("accountno") long accountId, Model model) {

		try {
			boolean result = bankAccountService.deleteBankaccount(accountId);
			model.addAttribute("message", "Account deleted Successfully..");
		} catch (BankAccountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
		}
		return "success";

	}

	//update account-----
	@RequestMapping("home/updateAccountDetails")
	public String updateAcc() {
		return "updateAccountDetails";
	}

	@RequestMapping("/updateaccount")
	public String searchForUpdateAccount(@RequestParam("account_id") long accountId,Model model) {
		try {
			BankAccount account=bankAccountService.searchAccount(accountId);
			model.addAttribute("account", account);
		} catch (BankAccountNotFoundException e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
		}
		return "updateaccount";

	}

	@RequestMapping("/updateaccountSuccess")
	public String updateAccount(@RequestParam("account_id") long accountId,
			@RequestParam("customer_name") String accountHolderName, @RequestParam("account_type") String accountType, Model model) {

		bankAccountService.updateAccount(accountId, accountHolderName, accountType);

		return "success";

	}
	
//withdraw-------------------------------

	@RequestMapping("home/withdraw")
	public String withdrawPage() {
		return "withdraw";
	}

	@RequestMapping("/withdrawSuccess")
	public String withdraw(@RequestParam("account_id") long accountId, @RequestParam("account_balance") double amount,
			Model model) {
		try {
			double balance = bankAccountService.withdraw(accountId, amount);
			model.addAttribute("message", "successful..");
		} catch (LowBalanceException e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
		} catch (BankAccountNotFoundException e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
		}
		return "success";
	}

	//deposit--------------
	@RequestMapping("home/deposit")
	public String depositPage() {
		return "Deposit";
	}

	@RequestMapping("/depositsuccess")
	public String deposit(@RequestParam("account_id") long accountId, @RequestParam("account_balance") double amount,
			Model model) {

		try {
			double balance = bankAccountService.deposit(accountId, amount);
			model.addAttribute("message", "successful...Your current Balance is:" + balance);
		} catch (BankAccountNotFoundException e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
		}
		return "success";
	}
	
	
	@RequestMapping("home/fundTransfer")
	public String fundTransferPage() {
		return "transferFund";
	}
	
	
	@RequestMapping("/fundtransferSuccess")
	public String fundtransfer(@RequestParam("FromAccount") long senderId,@RequestParam("ToAccount") long recipentId,
			@RequestParam("amount") double amount,Model model) {
		
		try {
			double balance=bankAccountService.fundTransfer(senderId, recipentId, amount);
			model.addAttribute("message", "successful...Your current Balance is:" + balance);
		} catch (LowBalanceException e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		} catch (BankAccountNotFoundException e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		
		return "success";
		
	}

	
	//check balance ---------------------
	@RequestMapping("home/check-balance")
	public String checkBalancePage() {
		return "checkbal";
	}

	@RequestMapping("/balSuccess")
	public String checkBalance(@RequestParam("accountno") long accountId, Model model) {
		try {
			double balance = bankAccountService.checkbalance(accountId);
			model.addAttribute("message", "Your current Balance is:" + balance);
		} catch (BankAccountNotFoundException e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
		}
		return "success";
	}

	
	//search account--------------
	
	@RequestMapping("home/searchAccountDetails")
	public String searchPage() {
		return "searchAccountDetails";
	}


	
	
	@RequestMapping("/searchAccount")
	public String searchAccount(@RequestParam("accountno") long accountId, Model model) {
		try {
			BankAccount account = bankAccountService.searchAccount(accountId);
			model.addAttribute("account", account);
		} catch (BankAccountNotFoundException e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
		}

		return "searchAccount";
	}

	//show details---------
	@RequestMapping("home/showDetails")
	public String showdetails(Model model) {
		
		List<BankAccount> accounts=bankAccountService.findAllbankAccounts();
		model.addAttribute("accounts", accounts);
		return "displayDetails";
		
	}
	
}
