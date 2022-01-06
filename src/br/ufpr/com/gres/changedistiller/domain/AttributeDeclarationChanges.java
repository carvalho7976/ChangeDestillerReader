package br.ufpr.com.gres.changedistiller.domain;

public class AttributeDeclarationChanges {
	
	private int ATTRIBUTE_RENAMING; 
	private int ATTRIBUTE_TYPE_CHANGE;
	private int total;
	
	public AttributeDeclarationChanges() {
		ATTRIBUTE_RENAMING = 0;
		ATTRIBUTE_TYPE_CHANGE = 0;
		total = 0;
	}

	public int getATTRIBUTE_RENAMING() {
		return ATTRIBUTE_RENAMING;
	}

	public void setATTRIBUTE_RENAMING(int aTTRIBUTE_RENAMING) {
		ATTRIBUTE_RENAMING = aTTRIBUTE_RENAMING;
	}

	public int getATTRIBUTE_TYPE_CHANGE() {
		return ATTRIBUTE_TYPE_CHANGE;
	}

	public void setATTRIBUTE_TYPE_CHANGE(int aTTRIBUTE_TYPE_CHANGE) {
		ATTRIBUTE_TYPE_CHANGE = aTTRIBUTE_TYPE_CHANGE;
	}

	public int getTotal() {
		return this.ATTRIBUTE_RENAMING + this.ATTRIBUTE_TYPE_CHANGE;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	public  String[] getCsvDataSimple() {
	       // String[] record1 = {"ATTRIBUTE_RENAMING","ATTRIBUTE_TYPE_CHANGE","TOTAL_ATTRIBUTEDECLARATIONCHANGES"};
	        String[] record1 = {ATTRIBUTE_RENAMING+"",ATTRIBUTE_TYPE_CHANGE+"",getTotal()+""};


	        return record1;
	}

	@Override
	public String toString() {
		return "AttributeDeclarationChanges [ATTRIBUTE_RENAMING=" + ATTRIBUTE_RENAMING + ", ATTRIBUTE_TYPE_CHANGE="
				+ ATTRIBUTE_TYPE_CHANGE + ", total=" + getTotal() + "]";
	}
	
	
	
	

}
