package br.com.acad.logic.model;


public class DataField {

	private String value;
	private FieldType fieldType;

	public DataField(String value, FieldType fieldType) {
		super();
		this.value = value;
		this.fieldType = fieldType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public FieldType getFieldType() {
		return fieldType;
	}

	public void setFieldType(FieldType fieldType) {
		this.fieldType = fieldType;
	}

}
