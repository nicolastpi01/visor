package ar.com.lpa.object;

import ar.com.lpa.utils.Utils;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AnnotationType {

	@Id
    private Long Id;	
	@Column(name = "EDIT")
	private Boolean EDIT; // mandatory
	@Column(name = "PAGE")
	private Integer PAGE; // mandatory
	@Column(name = "PAGEURL")
	private String PAGEURL;
	@Column(name = "COLOR")
	private String COLOR = "255, 0, 0";
	@Column(name = "LABEL")
	private String LABEL;
	@Column(name = "PAGESIZE")
	private String PAGESIZE;
	@Column(name = "CREATEDATE")
	private String CREATEDATE;
	@Column(name = "MODIFIEDDATE")
	private String MODIFIEDDATE;
	@Column(name = "LINEWIDTH")
	private Integer LINEWIDTH = 0; // THIS IS NOT AVAILABLE FOR TEXT ANNOTATION
	@Column(name = "CREATEDID")
	private String CREATEDID;
	@Column(name = "BLANKOUTIMAGE")
	private boolean BLANKOUTIMAGE; // Optional
	@Column(name = "FONTTYPE")
	private String FONTTYPE;
	@Column(name = "BORDER")
	private Integer BORDER = 0;

	// Empty constructor
	public AnnotationType() {}

	public AnnotationType(int PAGE, boolean EDIT) {
		this.setPAGE(PAGE);
		this.setEDIT(EDIT);
	}

	public void printFull() {
		Utils.printLnProperty("EDIT", this.getEDIT());
		Utils.printLnProperty("PAGE", this.getPAGE());
		Utils.printLnProperty("PAGEURL", this.getPAGEURL());
	}
	

	public void fill(String property) {
		String pname = Utils.subtractName(property);
		String value = Utils.subtractValue(property);
		if (pname.contentEquals("PAGE")) {
			this.setPAGE(Integer.parseInt(value));
		} else {
			if (pname.contentEquals("PAGEURL")) {
				this.setPAGEURL(value);
			} else {
				if (pname.contentEquals("LINEWIDTH")) {
					this.setLINEWIDTH(Integer.parseInt(value));
				} else {
					if (pname.contentEquals("COLOR")) {
						this.setCOLOR(value);
					} else {
						if (pname.contentEquals("LABEL")) {
							this.setLABEL(value);
						} else {
							if (pname.contentEquals("PAGESIZE")) {
								this.setPAGESIZE(value);
							} else {
								if (pname.contentEquals("EDIT")) {
									this.setEDIT(Boolean.valueOf(value));
								} else {
									if (pname.contentEquals("CREATEDATE")) {
										this.setCREATEDATE(value);
									} else {
										if (pname.contentEquals("MODIFIEDDATE")) {
											this.setMODIFIEDDATE(value);
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

	public String getPAGEURL() {
		return PAGEURL;
	}

	public void setPAGEURL(String pAGEURL) {
		PAGEURL = pAGEURL;
	}

	public Integer getLINEWIDTH() {
		return LINEWIDTH;
	}

	public void setLINEWIDTH(Integer lINEWIDTH) {
		LINEWIDTH = lINEWIDTH;
	}

	public String getCOLOR() {
		return COLOR;
	}

	public void setCOLOR(String cOLOR) {
		COLOR = cOLOR;
	}

	public String getLABEL() {
		return LABEL;
	}

	public void setLABEL(String lABEL) {
		LABEL = lABEL;
	}

	public String getPAGESIZE() {
		return PAGESIZE;
	}

	public void setPAGESIZE(String pAGESIZE) {
		PAGESIZE = pAGESIZE;
	}

	public String getCREATEDATE() {
		return CREATEDATE;
	}

	public void setCREATEDATE(String cREATEDATE) {
		CREATEDATE = cREATEDATE;
	}

	public String getMODIFIEDDATE() {
		return MODIFIEDDATE;
	}

	public void setMODIFIEDDATE(String mODIFIEDDATE) {
		MODIFIEDDATE = mODIFIEDDATE;
	}

	public int getPAGE() {
		return PAGE;
	}

	public void setPAGE(int pAGE) {
		PAGE = pAGE;
	}

	public boolean isEDIT() {
		return EDIT;
	}

	public void setEDIT(boolean eDIT) {
		EDIT = eDIT;
	}
	
	public Boolean getEDIT() {
		return EDIT;
	}

	public String getCREATEDID() {
		return CREATEDID;
	}

	public void setCREATEDID(String cREATEDID) {
		CREATEDID = cREATEDID;
	}

	public boolean isBLANKOUTIMAGE() {
		return BLANKOUTIMAGE;
	}

	public void setBLANKOUTIMAGE(boolean bLANKOUTIMAGE) {
		BLANKOUTIMAGE = bLANKOUTIMAGE;
	}

	public String getFONTTYPE() {
		return FONTTYPE;
	}

	public void setFONTTYPE(String fONTTYPE) {
		FONTTYPE = fONTTYPE;
	}

	public Integer getBORDER() {
		return BORDER;
	}

	public void setBORDER(Integer bORDER) {
		BORDER = bORDER;
	}
}
