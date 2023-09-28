package ar.com.lpa.object;

import ar.com.lpa.utils.Utils;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TEXT")
public class TextAnnotation extends AnnotationType {
	
	@Column(name = "X")
	private Integer X; // Mandatory
	@Column(name = "Y")
	private Integer Y; // Mandatory
	@Column(name = "TEXT")
	private String TEXT; // Mandatory // Indicate a new line by using the <N> identifier.
	@Column(name = "FONTHEIGHT")
	private Integer FONTHEIGHT = 1; // Mandatory // The minimum value is 61.
	
	// Optional properties
	@Column(name = "FILLCOLOR")
	private String FILLCOLOR;
	@Column(name = "ROTATION")
	private Integer ROTATION = 0; // Default value 0 // The value is in degrees. Valid values are 0, 90, 180, 270, 360. The default is 0.
	@Column(name = "TEXTROTATION")
	private Integer TEXTROTATION = 0; // Default value 0 // A valid value is an integer 0 - 359
	@Column(name = "TRANSPARENT")
	private Integer TRANSPARENT = 1; // A Boolean value that indicates whether the overlay is transparent. False=0, True=1
	 							// The default value is 1.
	@Column(name = "SEMITRANSPARENT")
	private Integer SEMITRANSPARENT = 0; //A Boolean value that indicates whether the text is semi-transparent. False=0, True=1.   
								// The default value is 0.

	public TextAnnotation() {}

	@Override
	public void fill(String property) {
		super.fill(property);
		String pname = Utils.subtractName(property);
		String value = Utils.subtractValue(property);
		if(pname.contentEquals("X")) {
			this.setX(Integer.parseInt(value));
		}
		else {
			if(pname.contentEquals("Y")) {
				this.setY(Integer.parseInt(value));
			}
			else {
				if(pname.contentEquals("TEXT")) {
					this.setTEXT(value);
				}
				else {
					if(pname.contentEquals("FONTHEIGHT")) {
						this.setFONTHEIGHT(Integer.parseInt(value));
					}
					else {
						if(pname.contentEquals("FILLCOLOR")) {
							this.setFILLCOLOR(value);
						}
						else {
							if(pname.contentEquals("ROTATION")) {
								this.setROTATION(Integer.parseInt(value));
							}
							else {
								if(pname.contentEquals("TEXTROTATION")) {
									this.setTEXTROTATION(Integer.parseInt(value));
								}
								else {
									if(pname.contentEquals("TRANSPARENT")) {
										this.setTRANSPARENT(Integer.parseInt(value));
									}
									else { 
										if(pname.contentEquals("SEMITRANSPARENT")) {
											this.setSEMITRANSPARENT(Integer.parseInt(value));
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	@Override
    public void printFull() {
    	System.out.println("[TEXT]");
    	super.printFull();
    	Utils.printLnProperty(this.getPropertyNameX(), this.getX());
    	Utils.printLnProperty(this.getPropertyNameY(), this.getY());
    	Utils.printLnProperty(this.getPropertyNameTEXT(), this.getTEXT());
    	Utils.printLnProperty(this.getPropertyNameFONTHEIGHT(), this.getFONTHEIGHT());
		System.out.println("");
	}
	
	public String getPropertyNameX() {
		return "X";
	}
	
	public String getPropertyNameY() {
		return "Y";
	}
	public String getPropertyNameTEXT() {
		return "TEXT";
	}
	
	public String getPropertyNameFONTHEIGHT() {
		return "FONTHEIGHT";
	}
 	
	public void setX(Integer X) {
		this.X = X;
	}
	
	public Integer getX() {
		return this.X;
	}
	
	public Integer getY() {
		return this.Y;
	}
	
	public void setY(Integer Y) {
		this.Y = Y;
	}
	
	public String getTEXT() {
		return this.TEXT;
	}
	
	public void setTEXT(String TEXT) {
		this.TEXT = TEXT;
	}
	
	public Integer getFONTHEIGHT() {
		return this.FONTHEIGHT;
	}
	
	public void setFONTHEIGHT(Integer FONTHEIGHT) {
		this.FONTHEIGHT = FONTHEIGHT;
	}

	public String getFILLCOLOR() {
		return FILLCOLOR;
	}

	public void setFILLCOLOR(String fILLCOLOR) {
		FILLCOLOR = fILLCOLOR;
	}

	public Integer getROTATION() {
		return ROTATION;
	}

	public void setROTATION(Integer rOTATION) {
		ROTATION = rOTATION;
	}

	public Integer getTEXTROTATION() {
		return TEXTROTATION;
	}

	public void setTEXTROTATION(Integer tEXTROTATION) {
		TEXTROTATION = tEXTROTATION;
	}

	public Integer getTRANSPARENT() {
		return TRANSPARENT;
	}

	public void setTRANSPARENT(Integer tRANSPARENT) {
		TRANSPARENT = tRANSPARENT;
	}

	public Integer getSEMITRANSPARENT() {
		return SEMITRANSPARENT;
	}

	public void setSEMITRANSPARENT(Integer sEMITRANSPARENT) {
		SEMITRANSPARENT = sEMITRANSPARENT;
	}
}
