package api.Payloads;

import java.util.List;

public class User_Proj_Batch_Pojo {
	
	int programId;
	String roleId;
	String userId;
	
	List<User_Map_Prog_Batch_Pojo>userRoleProgramBatches;
	
	public int getProgramId() {
		return programId;
	}
	public void setProgramId(int programId) {
		this.programId = programId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<User_Map_Prog_Batch_Pojo> getUserRoleProgramBatches() {
		return userRoleProgramBatches;
	}
	public void setUserRoleProgramBatches(List<User_Map_Prog_Batch_Pojo> userRoleProgramBatches) {
		this.userRoleProgramBatches = userRoleProgramBatches;
	}
	

}
