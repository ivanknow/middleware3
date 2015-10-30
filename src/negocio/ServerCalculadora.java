package negocio;

public class ServerCalculadora {

	public NumerosWrap soma(NumerosWrap n){
		n.setResult( n.getOp1()+n.getOp2());
		return n;
	}
	
	public NumerosWrap sub(NumerosWrap n){
		n.setResult( n.getOp1()-n.getOp2());
		return n;
	}
	
	public NumerosWrap mult(NumerosWrap n){
		n.setResult( n.getOp1()*n.getOp2());
		return n;
	}
	
	public NumerosWrap div(NumerosWrap n){
		n.setResult( n.getOp1()/n.getOp2());
		return n;
	}
}
