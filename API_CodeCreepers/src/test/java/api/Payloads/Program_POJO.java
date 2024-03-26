package api.Payloads;

import java.util.Date;

public class Program_POJO
{
	int programId;
	String programName;
	String programDescription;
	String programStatus;
	Date creationTime;
	Date lastModTime;
	
	public int getProgramId() {
		return programId;
	}
	public void setProgramId(int programId) {
		this.programId = programId;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getProgramDescription() {
		return programDescription;
	}
	public void setProgramDescription(String programDescription) {
		this.programDescription = programDescription;
	}
	public String getProgramStatus() {
		return programStatus;
	}
	public void setProgramStatus(String programStatus) {
		this.programStatus = programStatus;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public Date getLastModTime() {
		return lastModTime;
	}
	public void setLastModTime(Date lastModTime) {
		this.lastModTime = lastModTime;
	}
	
	
}
