package com.jantvrdik.intellij.latte.settings;

import com.intellij.util.xmlb.annotations.Attribute;
import com.jantvrdik.intellij.latte.config.LatteConfiguration;
import com.jantvrdik.intellij.latte.utils.LattePhpType;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.Objects;

public class LatteVariableSettings extends BaseLatteSettings implements Serializable {

	private String varName;
	private String varType;

	public LatteVariableSettings() {
		super();
	}

	public LatteVariableSettings(String varName, String varType) {
		this(varName, varType, LatteConfiguration.Vendor.OTHER, "");
	}

	public LatteVariableSettings(String varName, String varType, LatteConfiguration.Vendor vendor, String vendorName) {
		super(vendor, vendorName);
		this.varName = varName;
		this.varType = varType;
	}

	public void setVarName(String varName) {
		this.varName = varName;
	}

	public void setVarType(String varType) {
		this.varType = varType;
	}

	public LattePhpType toPhpType() {
		return LattePhpType.create(varName, varType);
	}

	@Attribute("VarName")
	public String getVarName() {
		return varName;
	}

	@Attribute("VarType")
	public String getVarType() {
		return varType;
	}

	@Override
	public LatteVariableSettings setVendor(LatteConfiguration.Vendor vendor) {
		super.setVendor(vendor);
		return this;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.varName)
				.append(this.varType)
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof LatteVariableSettings &&
				Objects.equals(((LatteVariableSettings) obj).getVarName(), this.getVarName()) &&
				Objects.equals(((LatteVariableSettings) obj).getVarType(), this.getVarType());
	}
}
