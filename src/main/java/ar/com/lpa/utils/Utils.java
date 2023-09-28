package ar.com.lpa.utils;

import ar.com.lpa.object.AnnotInfo;
import ar.com.lpa.object.AnnotationType;
import ar.com.lpa.object.Arrow;
import ar.com.lpa.object.Custom;
import ar.com.lpa.object.Empty;
import ar.com.lpa.object.FreeHand;
import ar.com.lpa.object.Highlight;
import ar.com.lpa.object.HighlighyPolygon;
import ar.com.lpa.object.Note;
import ar.com.lpa.object.OpenPolygon;
import ar.com.lpa.object.Oval;
import ar.com.lpa.object.Polygon;
import ar.com.lpa.object.Rectangle;
import ar.com.lpa.object.Redact;
import ar.com.lpa.object.RedactPolygon;
import ar.com.lpa.object.Stamp;
import ar.com.lpa.object.TextAnnotation;

public class Utils {

	public static AnnotationType determineAnnotation(String annotation) {
		switch (annotation) {
		case "[EMPTY]":
			return new Empty();
		case "[ARROW]":
			return new Arrow();
		case "[ANNOTINFO]":
			return new AnnotInfo();
		case "[CUSTOM]":
			return new Custom();
		case "[FREEHAND]":
			return new FreeHand();
		case "[HIGHLIGHT]":
			return new Highlight();
		case "[HIGHLIGHTPOLYGON]":
			return new HighlighyPolygon();
		case "[NOTE]":
			return new Note();
		case "[OPENPOLYGON]":
			return new OpenPolygon();
		case "[OVAL]":
			return new Oval();
		case "[POLYGON]":
			return new Polygon();
		case "[RECTANGLE]":
			return new Rectangle();
		case "[REDACT]":
			return new Redact();
		case "[REDACTPOLYGON]":
			return new RedactPolygon();
		case "[STAMP]":
			return new Stamp();
		case "[TEXT]":
			return new TextAnnotation();
		default:
			return new Empty(); // Sacar esto despues!!!
		}
	}
	
	// return the property value
	public static  String subtractValue(String property) {
		return property.substring(property.indexOf("=")+1).trim();
	}
		
	// return the property value
	public static  String subtractName(String property) {
		return property.substring(0, property.indexOf("=")).trim();
	}
	
	public static  void printLnProperty(String property, Object obj) {
		System.out.println(property + "=" + obj);
	}

}
