package br.ufpr.com.gres.changedistiller.reader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import com.opencsv.CSVWriter;

import br.ufpr.com.gres.changedistiller.domain.AttributeDeclarationChanges;
import br.ufpr.com.gres.changedistiller.domain.ClassDeclarationChanges;
import br.ufpr.com.gres.changedistiller.domain.DeclarationPartChange;
import br.ufpr.com.gres.changedistiller.domain.MethodDeclarationChanges;
import br.ufpr.com.gres.changedistiller.domain.StatementLevelChanges;
import ch.uzh.ifi.seal.changedistiller.ChangeDistiller;
import ch.uzh.ifi.seal.changedistiller.ChangeDistiller.Language;
import ch.uzh.ifi.seal.changedistiller.distilling.FileDistiller;
import ch.uzh.ifi.seal.changedistiller.model.entities.SourceCodeChange;

public class DistillerReader {

	public static void main(String[] args) {
		
		
		String classPreviousCommit = args[0];
		String classCurrentCommit = args[1]; 
		String csvPath = args[2];
		String projectName  = args[3];
		String currentCommit  = args[4];
		String previousCommit  = args[5];
		

		
		File left = new File(classPreviousCommit);
		File right = new File(classCurrentCommit);

		FileDistiller distiller = ChangeDistiller.createFileDistiller(Language.JAVA);
	

		
		try {
		    distiller.extractClassifiedSourceCodeChanges(left, right);
		} catch(Exception e) {
		    /* An exception most likely indicates a bug in ChangeDistiller. Please file a
		       bug report at https://bitbucket.org/sealuzh/tools-changedistiller/issues and
		       attach the full stack trace along with the two files that you tried to distill. */
		    System.err.println("Warning: error while change distilling. " + e.getMessage());
		}
		List<SourceCodeChange> changes = distiller.getSourceCodeChanges();
		StatementLevelChanges statementLevelChanges = new StatementLevelChanges();
		ClassDeclarationChanges classDeclarationChanges = new ClassDeclarationChanges();
		MethodDeclarationChanges methodDeclarationChanges = new MethodDeclarationChanges();
		AttributeDeclarationChanges attributeDeclarationChanges = new AttributeDeclarationChanges();
		DeclarationPartChange declarationPartChange = new DeclarationPartChange();
		
		if(changes != null) {
		    for (SourceCodeChange sc : changes) {
				if(sc.getChangeType().toString().contains("STATEMENT_")) {
					if(sc.getChangeType().toString().equals("STATEMENT_DELETE")) {
						statementLevelChanges.setSTATEMENT_DELETE(statementLevelChanges.getSTATEMENT_DELETE() + 1);
					}
					if(sc.getChangeType().toString().equals("STATEMENT_INSERT")) {
						statementLevelChanges.setSTATEMENT_INSERT(statementLevelChanges.getSTATEMENT_INSERT() + 1);
					}
					if(sc.getChangeType().toString().equals("STATEMENT_ORDERING_CHANGE")) {
						statementLevelChanges.setSTATEMENT_ORDERING_CHANGE(statementLevelChanges.getSTATEMENT_ORDERING_CHANGE() + 1);
					}
					if(sc.getChangeType().toString().equals("STATEMENT_PARENT_CHANGE")) {
						statementLevelChanges.setSTATEMENT_PARENT_CHANGE(statementLevelChanges.getSTATEMENT_PARENT_CHANGE() + 1);
					}
					if(sc.getChangeType().toString().equals("STATEMENT_UPDATE")) {
						statementLevelChanges.setSTATEMENT_UPDATE(statementLevelChanges.getSTATEMENT_UPDATE() + 1);
					}
				}
				if(sc.getChangeType().toString().contains("PARENT_CLASS_CHANGE") || sc.getChangeType().toString().equals("CLASS_RENAMING") ) {
					if(sc.getChangeType().toString().equals("PARENT_CLASS_CHANGE")) {
						classDeclarationChanges.setPARENT_CLASS_CHANGE(classDeclarationChanges.getPARENT_CLASS_CHANGE() + 1);
					}
					if(sc.getChangeType().toString().equals("PARENT_CLASS_DELETE")) {
						classDeclarationChanges.setPARENT_CLASS_DELETE(classDeclarationChanges.getPARENT_CLASS_DELETE() + 1);
					}
					if(sc.getChangeType().toString().equals("PARENT_CLASS_INSERT")) {
						classDeclarationChanges.setPARENT_CLASS_INSERT(classDeclarationChanges.getPARENT_CLASS_INSERT() + 1);
					}
					if(sc.getChangeType().toString().equals("CLASS_RENAMING")) {
						classDeclarationChanges.setCLASS_RENAMING(classDeclarationChanges.getCLASS_RENAMING() + 1);
					}
					
				}
				if(sc.getChangeType().toString().contains("RETURN_TYPE_") || sc.getChangeType().toString().contains("PARAMETER_") || sc.getChangeType().toString().equals("METHOD_RENAMING") ) {
					if(sc.getChangeType().toString().equals("RETURN_TYPE_CHANGE")) {
						methodDeclarationChanges.setRETURN_TYPE_CHANGE(methodDeclarationChanges.getRETURN_TYPE_CHANGE() + 1);
					}
					if(sc.getChangeType().toString().equals("RETURN_TYPE_DELETE")) {
						methodDeclarationChanges.setRETURN_TYPE_DELETE(methodDeclarationChanges.getRETURN_TYPE_DELETE() + 1);
					}
					if(sc.getChangeType().toString().equals("RETURN_TYPE_INSERT")) {
						methodDeclarationChanges.setRETURN_TYPE_INSERT(methodDeclarationChanges.getRETURN_TYPE_INSERT() + 1);
					}
					if(sc.getChangeType().toString().equals("METHOD_RENAMING")) {
						methodDeclarationChanges.setMETHOD_RENAMING(methodDeclarationChanges.getMETHOD_RENAMING() + 1);
					}
					if(sc.getChangeType().toString().equals("PARAMETER_DELETE")) {
						methodDeclarationChanges.setPARAMETER_DELETE(methodDeclarationChanges.getPARAMETER_DELETE() + 1);
					}
					if(sc.getChangeType().toString().equals("PARAMETER_INSERT")) {
						methodDeclarationChanges.setPARAMETER_INSERT(methodDeclarationChanges.getPARAMETER_INSERT() + 1);
					}
					if(sc.getChangeType().toString().equals("PARAMETER_ORDERING_CHANGE")) {
						methodDeclarationChanges.setPARAMETER_ORDERING_CHANGE(methodDeclarationChanges.getPARAMETER_ORDERING_CHANGE() + 1);
					}
					if(sc.getChangeType().toString().equals("PARAMETER_RENAMING")) {
						methodDeclarationChanges.setPARAMETER_RENAMING(methodDeclarationChanges.getPARAMETER_RENAMING() + 1);
					}
					if(sc.getChangeType().toString().equals("PARAMETER_TYPE_CHANGE")) {
						methodDeclarationChanges.setPARAMETER_TYPE_CHANGE(methodDeclarationChanges.getPARAMETER_TYPE_CHANGE() + 1);
					}
				}
				
				if(sc.getChangeType().toString().equals("ATTRIBUTE_RENAMING") || sc.getChangeType().toString().equals("ATTRIBUTE_TYPE_CHANGE") ) {
					if(sc.getChangeType().toString().equals("ATTRIBUTE_RENAMING")) {
						attributeDeclarationChanges.setATTRIBUTE_RENAMING(attributeDeclarationChanges.getATTRIBUTE_RENAMING() + 1);
					}
					if(sc.getChangeType().toString().equals("ATTRIBUTE_TYPE_CHANGE")) {
						attributeDeclarationChanges.setATTRIBUTE_TYPE_CHANGE(attributeDeclarationChanges.getATTRIBUTE_TYPE_CHANGE() + 1);
					}
				}
				
				if(sc.getChangeType().toString().contains("MODIFIABILITY")
					|| sc.getChangeType().toString().contains("DERIVABILITY")
					|| sc.getChangeType().toString().contains("OVERRIDABILITY")) {
					
					if(sc.getChangeType().toString().equals("ADDING_ATTRIBUTE_MODIFIABILITY")) {
						declarationPartChange.setADDING_ATTRIBUTE_MODIFIABILITY(declarationPartChange.getADDING_ATTRIBUTE_MODIFIABILITY() + 1);
					}
					if(sc.getChangeType().toString().equals("REMOVING_ATTRIBUTE_MODIFIABILITY")) {
						declarationPartChange.setREMOVING_ATTRIBUTE_MODIFIABILITY(declarationPartChange.getREMOVING_ATTRIBUTE_MODIFIABILITY() + 1);
					}
					if(sc.getChangeType().toString().equals("REMOVING_CLASS_DERIVABILITY")) {
						declarationPartChange.setREMOVING_CLASS_DERIVABILITY(declarationPartChange.getREMOVING_CLASS_DERIVABILITY() + 1);
					}
					if(sc.getChangeType().toString().equals("REMOVING_METHOD_OVERRIDABILITY")) {
						declarationPartChange.setREMOVING_METHOD_OVERRIDABILITY(declarationPartChange.getREMOVING_METHOD_OVERRIDABILITY() + 1);
					}
					if(sc.getChangeType().toString().equals("ADDING_CLASS_DERIVABILITY")) {
						declarationPartChange.setADDING_CLASS_DERIVABILITY(declarationPartChange.getADDING_CLASS_DERIVABILITY() + 1);
					}
					if(sc.getChangeType().toString().equals("ADDING_METHOD_OVERRIDABILITY")) {
						declarationPartChange.setADDING_METHOD_OVERRIDABILITY(declarationPartChange.getADDING_METHOD_OVERRIDABILITY() + 1);
					}
					
					
					
				}
				 
				
			}
		    //para cada projeto (em um determinado commit) gerar um csv contendo o nome do projeto, commit analisado ( commit N e N-1), classe, os FGC e total de FGC
					
		    System.out.println(statementLevelChanges.toString());
		    System.out.println(classDeclarationChanges.toString());
		    System.out.println(methodDeclarationChanges.toString());
		    System.out.println(attributeDeclarationChanges.toString());
		    System.out.println(declarationPartChange.toString());
		    
		    String[] header = {"PROJECT_NAME", "CURRENT_COMMIT", "PREVIOUS_COMMIT", "CLASS_CURRENTCOMMIT","CLASS_PREVIOUSCOMMIT",
		    		"STATEMENT_DELETE", "STATEMENT_INSERT", "STATEMENT_ORDERING_CHANGE","STATEMENT_PARENT_CHANGE","STATEMENT_UPDATE","TOTAL_STATEMENTLEVELCHANGES",
		    		"PARENT_CLASS_CHANGE", "PARENT_CLASS_DELETE", "PARENT_CLASS_INSERT","CLASS_RENAMING","TOTAL_CLASSDECLARATIONCHANGES",
		    		"RETURN_TYPE_CHANGE","RETURN_TYPE_DELETE","RETURN_TYPE_INSERT","METHOD_RENAMING","PARAMETER_DELETE","PARAMETER_INSERT","PARAMETER_ORDERING_CHANGE","PARAMETER_RENAMING","PARAMETER_TYPE_CHANGE","TOTAL_METHODDECLARATIONSCHANGES",
		    		"ATTRIBUTE_RENAMING","ATTRIBUTE_TYPE_CHANGE","TOTAL_ATTRIBUTEDECLARATIONCHANGES",
		    		"ADDING_ATTRIBUTE_MODIFIABILITY","REMOVING_ATTRIBUTE_MODIFIABILITY","REMOVING_CLASS_DERIVABILITY","REMOVING_METHOD_OVERRIDABILITY","ADDING_CLASS_DERIVABILITY","ADDING_CLASS_DERIVABILITY","ADDING_METHOD_OVERRIDABILITY", "TOTAL_DECLARATIONPARTCHANGES"};
		    String[] data1 = {projectName,currentCommit,previousCommit,classCurrentCommit,classPreviousCommit};
		    String[] data2 = ArrayUtils.addAll(data1,statementLevelChanges.getCsvDataSimple());
		    String[] data3 = ArrayUtils.addAll(data2,classDeclarationChanges.getCsvDataSimple());
		    String[] data4 = ArrayUtils.addAll(data3,methodDeclarationChanges.getCsvDataSimple());
		    String[] data5 = ArrayUtils.addAll(data4,attributeDeclarationChanges.getCsvDataSimple());
		    String[] dataFinal = ArrayUtils.addAll(data5,declarationPartChange.getCsvDataSimple());
		    
		    List<String[]> csvData = new ArrayList<>();

		    try (CSVWriter writer = new CSVWriter(new FileWriter(csvPath))) {
	            writer.writeAll(csvData);
	        
		    } catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
	
	
	
}
