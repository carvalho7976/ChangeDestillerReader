package br.ufpr.com.gres.changedistiller.domain;

public class ClassDeclarationChanges {
	
	private int PARENT_CLASS_CHANGE;
	private int PARENT_CLASS_DELETE; 
	private int PARENT_CLASS_INSERT;
	private int CLASS_RENAMING;
	private int total;
	
	public ClassDeclarationChanges() {
		PARENT_CLASS_CHANGE = 0;
		PARENT_CLASS_DELETE  = 0;
		PARENT_CLASS_INSERT = 0;
		CLASS_RENAMING = 0;
		total = 0;
	}

	public int getPARENT_CLASS_CHANGE() {
		return PARENT_CLASS_CHANGE;
	}

	public void setPARENT_CLASS_CHANGE(int pARENT_CLASS_CHANGE) {
		PARENT_CLASS_CHANGE = pARENT_CLASS_CHANGE;
	}

	public int getPARENT_CLASS_DELETE() {
		return PARENT_CLASS_DELETE;
	}

	public void setPARENT_CLASS_DELETE(int pARENT_CLASS_DELETE) {
		PARENT_CLASS_DELETE = pARENT_CLASS_DELETE;
	}

	public int getPARENT_CLASS_INSERT() {
		return PARENT_CLASS_INSERT;
	}

	public void setPARENT_CLASS_INSERT(int pARENT_CLASS_INSERT) {
		PARENT_CLASS_INSERT = pARENT_CLASS_INSERT;
	}

	public int getCLASS_RENAMING() {
		return CLASS_RENAMING;
	}

	public void setCLASS_RENAMING(int cLASS_RENAMING) {
		CLASS_RENAMING = cLASS_RENAMING;
	}

	public int getTotal() {
		return this.CLASS_RENAMING + this.PARENT_CLASS_CHANGE + this.PARENT_CLASS_DELETE + this.PARENT_CLASS_INSERT;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	public  String[] getCsvDataSimple() {
        //[] header = {"PARENT_CLASS_CHANGE", "PARENT_CLASS_DELETE", "PARENT_CLASS_INSERT","CLASS_RENAMING","TOTAL_CLASSDECLARATIONCHANGES"};
        String[] record1 = {PARENT_CLASS_CHANGE+"", PARENT_CLASS_DELETE+"", PARENT_CLASS_INSERT+"",CLASS_RENAMING+"",this.getTotal()+""};
       

        return record1;
    }

	@Override
	public String toString() {
		return "ClassDeclarationChanges [PARENT_CLASS_CHANGE=" + PARENT_CLASS_CHANGE + ", PARENT_CLASS_DELETE="
				+ PARENT_CLASS_DELETE + ", PARENT_CLASS_INSERT=" + PARENT_CLASS_INSERT + ", CLASS_RENAMING="
				+ CLASS_RENAMING + ", total=" + getTotal() + "]";
	}
	
	
	

}
