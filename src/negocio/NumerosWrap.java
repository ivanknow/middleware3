package negocio;

import java.io.Serializable;

public class NumerosWrap implements Serializable{

private	Integer op1,op2,result;

public Integer getOp1() {
	return op1;
}

public void setOp1(Integer op1) {
	this.op1 = op1;
}

public Integer getOp2() {
	return op2;
}

public void setOp2(Integer op2) {
	this.op2 = op2;
}

public Integer getResult() {
	return result;
}

public void setResult(Integer result) {
	this.result = result;
}

@Override
public String toString() {
	return "NumerosWrap [op1=" + op1 + ", op2=" + op2 + ", result=" + result + "]";
}

public NumerosWrap(Integer op1, Integer op2) {
	super();
	this.op1 = op1;
	this.op2 = op2;
}
	
	
}
