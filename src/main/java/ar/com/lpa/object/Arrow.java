package ar.com.lpa.object;

public class Arrow extends AnnotationType {
	
	private Integer X1;
	private Integer Y1;
	private Integer X2;
	private Integer Y2;
	private Integer ARROWHEADSIZE = 1; // default value // Ojo, esto no es int deberia ser Natural
	
	// Empty Constructor:
    public Arrow() {}
    
    Arrow(int PAGE, boolean EDIT) {
    	super(PAGE, EDIT);
    };
    
    @Override
    public void printFull() {
    	System.out.println("[ARROW]");
    	super.printFull();
    	System.out.println("X1" + "=" + this.getX1());
    	System.out.println("Y1" + "=" + this.getY1());
    	System.out.println("X2" + "=" + this.getX2());
    	System.out.println("Y2" + "=" + this.getY2());
    	System.out.println("ARROWHEADSIZE" + "=" + this.getARROWHEADSIZE());
	}

	@Override
	public void fill(String property) {
		super.fill(property);
		if(property.contains("X1")) {
			this.setX1(X1);
		}
		else {
			if(property.contains("Y1")) {
				this.setY1(Y1);
			}
			else {
				if(property.contains("X2")) {
					this.setX2(X2);
				}
				else {
					if(property.contains("Y2")) {
						this.setY2(Y2);
					}
					else {
						if(property.contains("ARROWHEADSIZE")) {
							this.setARROWHEADSIZE(ARROWHEADSIZE);
						}
					}
				}
			}
		}
	}

	public Integer getX1() {
		return X1;
	}

	public void setX1(Integer x1) {
		X1 = x1;
	}

	public Integer getY1() {
		return Y1;
	}

	public void setY1(Integer y1) {
		Y1 = y1;
	}

	public Integer getX2() {
		return X2;
	}

	public void setX2(Integer x2) {
		X2 = x2;
	}

	public Integer getY2() {
		return Y2;
	}

	public void setY2(Integer y2) {
		Y2 = y2;
	}

	public Integer getARROWHEADSIZE() {
		return ARROWHEADSIZE;
	}

	public void setARROWHEADSIZE(Integer aRROWHEADSIZE) {
		ARROWHEADSIZE = aRROWHEADSIZE;
	}
	
    

}
