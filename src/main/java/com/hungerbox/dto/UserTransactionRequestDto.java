package com.hungerbox.dto;

public class UserTransactionRequestDto {

	private long from_account_number;
	private long to_account_number;
	private long transfer_amount;
	private String user_comment;
	
	public long getFrom_account_number() {
		return from_account_number;
	}
	public void setFrom_account_number(long from_account_number) {
		this.from_account_number = from_account_number;
	}
	public long getTo_account_number() {
		return to_account_number;
	}
	public void setTo_account_number(long to_account_number) {
		this.to_account_number = to_account_number;
	}
	public long getTransfer_amount() {
		return transfer_amount;
	}
	public void setTransfer_amount(long transfer_amount) {
		this.transfer_amount = transfer_amount;
	}
	public String getUser_comment() {
		return user_comment;
	}
	public void setUser_comment(String user_comment) {
		this.user_comment = user_comment;
	}
	
	
}
