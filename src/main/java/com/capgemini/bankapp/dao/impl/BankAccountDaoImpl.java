package com.capgemini.bankapp.dao.impl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.capgemini.bankappDao.*;
import com.capgemini.bankapp.exception.*;
import com.capgemini.bankappDao.BankAccountDao;
import com.capgemini.model.BankAccount;

public class BankAccountDaoImpl implements BankAccountDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public BankAccountDaoImpl(JdbcTemplate jdbcTemplate)
	{
		
		this.jdbcTemplate= jdbcTemplate;
			
	}

	@Override
	public boolean addNewbankAccount(BankAccount account)  {

		String query="insert into bankaccount(customer_name,account_type,account_balance) values(?,?,?)";
       
                Object[] inputs = new Object[] {account.getAccountHolderName(), account.getAccountType(), account.getAccountbalance()};
                int result=jdbcTemplate.update(query, inputs);		
			if(result==1)
			{
				return true;
			}
		
		return false;
	}

	@Override
	public boolean deleteBankaccount(long accountId) {

		String query = "delete from bankaccount where account_id=?";
		int result=jdbcTemplate.update(query,accountId);
	
	
			if (result == 1) {
				return true;
			}

		
		return false;
	}

	

	@Override
	public double getBalance(long accountId) throws BankAccountNotFoundException  {
		
		String query = "select account_balance from bankaccount where account_id="+ accountId;
		double balance = -1;
		try
		{
			balance=jdbcTemplate.queryForObject(query,(rs,rowNum)->
			{
				double accountBalance = rs.getDouble(1);
				return accountBalance ;

			});
	
		}
		catch(EmptyResultDataAccessException ex){
			BankAccountNotFoundException  re= new BankAccountNotFoundException("Bank Account not Found");
			ex.initCause(re);
			throw re;

		}
		
		return balance;

	} 


	@Override
	public void updateBalance(long accountId, double newBalance) {
				
		String query="update bankaccount set account_balance=? where account_id="+accountId;
		jdbcTemplate.update(query,newBalance);	

	}

	

	@Override
	public List<BankAccount> findAllbankAccounts() {

		String query="select * from bankaccount";
		
		List<BankAccount> accountList=jdbcTemplate.query(query,(rs,rowNum)->
		{
			
				long id=rs.getInt(1);
				String name=rs.getString(2);
				String type=rs.getString(3);
				double balance=rs.getDouble(4);
				BankAccount bankAccount=new BankAccount(id,name,type,balance);
				return bankAccount;

		});
	
				
	
		return accountList;
	}

	@Override
	public BankAccount searchAccount(long accountId)throws BankAccountNotFoundException {
		String query="select * from bankaccount where account_id=?";
		BankAccount bank=null;
		try
		{
		bank=jdbcTemplate.queryForObject(query,new Object[]{accountId} ,(rs,rowNum)->
		{
			
				long id=rs.getInt(1);
				String name=rs.getString(2);
				String type=rs.getString(3);
				double balance=rs.getDouble(4);
				BankAccount bankAccount=new BankAccount(id,name,type,balance);
				 return bankAccount;
		
		});
		}catch(EmptyResultDataAccessException ex){
			BankAccountNotFoundException  re= new BankAccountNotFoundException("Bank Account not Found");
			ex.initCause(re);
			throw re;

		}
	
		
                return bank;          
       
	}

	@Override
	public boolean updateAccount(long accountId, String accountHolderName, String accountType) {
				
		String query="update bankaccount set account_type=?,customer_name=? where account_id="+accountId;
		     	 
		int result= jdbcTemplate.update(query,accountType,accountHolderName);
		if(result==1)
		 	{
			return true;
		 	}
		
		return false;
	}

	
}
