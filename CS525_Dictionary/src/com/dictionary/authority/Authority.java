package com.dictionary.authority;

public class Authority {

	private boolean register;
	private boolean addArticle;
	private boolean viewArticle;
	private boolean deleteArticle;
	private boolean addUser;
	private boolean viewUser;
	private boolean deleteUser;

	public Authority(boolean register, boolean addArticle, boolean viewArticle, boolean deleteArticle, boolean addUser,
			boolean viewUser, boolean deleteUser) {
		super();
		this.register = register;
		this.addArticle = addArticle;
		this.viewArticle = viewArticle;
		this.deleteArticle = deleteArticle;
		this.addUser = addUser;
		this.viewUser = viewUser;
		this.deleteUser = deleteUser;
	}

	public static Authority anonymous() {

		return new Authority(true, false, true, false, false, false, false);
	}

	public static Authority regularUser() {
		return new Authority(true, true, true, false, false, false, false);
	}

	public static Authority administrator() {
		return new Authority(true, true, true, true, true, true, true);
	}

	public boolean isRegister() {
		return register;
	}

	public void setRegister(boolean register) {
		this.register = register;
	}

	public boolean isAddArticle() {
		return addArticle;
	}

	public void setAddArticle(boolean addArticle) {
		this.addArticle = addArticle;
	}

	public boolean isViewArticle() {
		return viewArticle;
	}

	public void setViewArticle(boolean viewArticle) {
		this.viewArticle = viewArticle;
	}

	public boolean isDeleteArticle() {
		return deleteArticle;
	}

	public void setDeleteArticle(boolean deleteArticle) {
		this.deleteArticle = deleteArticle;
	}

	public boolean isAddUser() {
		return addUser;
	}

	public void setAddUser(boolean addUser) {
		this.addUser = addUser;
	}

	public boolean isViewUser() {
		return viewUser;
	}

	public void setViewUser(boolean viewUser) {
		this.viewUser = viewUser;
	}

	public boolean isDeleteUser() {
		return deleteUser;
	}

	public void setDeleteUser(boolean deleteUser) {
		this.deleteUser = deleteUser;
	}

}
