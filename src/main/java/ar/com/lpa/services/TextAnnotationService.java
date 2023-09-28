package ar.com.lpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.com.lpa.object.TextAnnotation;
import ar.com.lpa.repository.TextAnnotationRepository;

@Service
public class TextAnnotationService {
	
	@Autowired
	TextAnnotationRepository textRepository;
	
	@Transactional
	public boolean addTextAnnotation(TextAnnotation annotation) {
		return textRepository.save(annotation) != null;
	}

}
