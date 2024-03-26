package api.Payloads;

public class User_Update_Roles_POJO {

	String roleId;
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getUserRoleStatus() {
		return userRoleStatus;
	}
	public void setUserRoleStatus(String userRoleStatus) {
		this.userRoleStatus = userRoleStatus;
	}
	String userRoleStatus;
}
