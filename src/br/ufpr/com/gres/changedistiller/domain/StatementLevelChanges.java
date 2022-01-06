package br.ufpr.com.gres.changedistiller.domain;

import java.util.ArrayList;
import java.util.List;

public class StatementLevelChanges {
	
	private int STATEMENT_DELETE;
	private int STATEMENT_INSERT;
	private int STATEMENT_ORDERING_CHANGE; 
	private int STATEMENT_PARENT_CHANGE;
	private int STATEMENT_UPDATE;
	private int total;
	public StatementLevelChanges() {
		STATEMENT_DELETE = 0;
		STATEMENT_INSERT = 0;
		STATEMENT_ORDERING_CHANGE = 0; 
		STATEMENT_PARENT_CHANGE = 0;
		STATEMENT_UPDATE = 0;
		total = 0;
	}
	public int getSTATEMENT_DELETE() {
		return STATEMENT_DELETE;
	}
	public void setSTATEMENT_DELETE(int sTATEMENT_DELETE) {
		STATEMENT_DELETE = sTATEMENT_DELETE;
	}
	public int getSTATEMENT_INSERT() {
		return STATEMENT_INSERT;
	}
	public void setSTATEMENT_INSERT(int sTATEMENT_INSERT) {
		STATEMENT_INSERT = sTATEMENT_INSERT;
	}
	public int getSTATEMENT_ORDERING_CHANGE() {
		return STATEMENT_ORDERING_CHANGE;
	}
	public void setSTATEMENT_ORDERING_CHANGE(int sTATEMENT_ORDERING_CHANGE) {
		STATEMENT_ORDERING_CHANGE = sTATEMENT_ORDERING_CHANGE;
	}
	public int getSTATEMENT_PARENT_CHANGE() {
		return STATEMENT_PARENT_CHANGE;
	}
	public void setSTATEMENT_PARENT_CHANGE(int sTATEMENT_PARENT_CHANGE) {
		STATEMENT_PARENT_CHANGE = sTATEMENT_PARENT_CHANGE;
	}
	public int getSTATEMENT_UPDATE() {
		return STATEMENT_UPDATE;
	}
	public void setSTATEMENT_UPDATE(int sTATEMENT_UPDATE) {
		STATEMENT_UPDATE = sTATEMENT_UPDATE;
	}
	public int getTotal() {
		return this.STATEMENT_DELETE + this.STATEMENT_INSERT + this.STATEMENT_ORDERING_CHANGE + this.STATEMENT_PARENT_CHANGE + this.STATEMENT_UPDATE;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	public  String[] getCsvDataSimple() {
        //[] header = {"STATEMENT_DELETE", "STATEMENT_INSERT", "STATEMENT_ORDERING_CHANGE","STATEMENT_PARENT_CHANGE","STATEMENT_UPDATE","TOTAL_STATEMENTLEVELCHANGES"};
        String[] record1 = {STATEMENT_DELETE+"", STATEMENT_INSERT+"", STATEMENT_ORDERING_CHANGE+"",STATEMENT_PARENT_CHANGE+"",STATEMENT_UPDATE+"",this.getTotal()+""};
        //String[] record2 = {"2", "second name", "address 2", "22222"};

        //List<String[]> list = new ArrayList<>();
       // list.add(record1);

        return record1;
    }
	
	@Override
	public String toString() {
		return "StatementLevelChanges [STATEMENT_DELETE=" + STATEMENT_DELETE + ", STATEMENT_INSERT=" + STATEMENT_INSERT
				+ ", STATEMENT_ORDERING_CHANGE=" + STATEMENT_ORDERING_CHANGE + ", STATEMENT_PARENT_CHANGE="
				+ STATEMENT_PARENT_CHANGE + ", STATEMENT_UPDATE=" + STATEMENT_UPDATE + ", total=" + this.getTotal() + "]";
	}
	
	
	
	

}
