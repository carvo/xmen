package br.com.mutant.entity;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "DNA")
public class DNAEntity {

	@DynamoDBHashKey(attributeName = "Id")
	@DynamoDBAutoGeneratedKey
	private String id;

	@DynamoDBRangeKey(attributeName = "Mutant")
	private boolean mutant;

	@DynamoDBAttribute(attributeName = "DNA")
	private List<String> dna;

	public DNAEntity() {
	}

	public DNAEntity(boolean mutant, List<String> dna) {
		this.mutant = mutant;
		this.dna = dna;
	}

	public String getId() {
		return id;
	}

	@DynamoDBIndexHashKey(globalSecondaryIndexName = "Mutant-index", attributeName = "Mutant")
	public boolean isMutant() {
		return mutant;
	}

	public List<String> getDna() {
		return dna;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setMutant(boolean mutant) {
		this.mutant = mutant;
	}

	public void setDna(List<String> dna) {
		this.dna = dna;
	}
}