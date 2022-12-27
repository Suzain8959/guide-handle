package Guide.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Guide.backend.entity.Guide;
import Guide.backend.exception.ResourceNotFoundException;
import Guide.backend.repository.GuideRepository;

@Service
public class GuideServiceImpl implements GuideService{

	private GuideRepository guideRepository;
	
	@Autowired
	public GuideServiceImpl(GuideRepository guideRepository) {
		this.guideRepository = guideRepository;
	}
	
	@Override
	public Guide saveguide(Guide guide) {
		return guideRepository.save(guide);
	}

	@Override
	public List<Guide> getAllguide() {
		return guideRepository.findAll();
	}

	@Override
	public Guide getguideById(long id) {
		return guideRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("guide","id",id));
	}

	@Override
	public Guide updateguide(Guide guide, Long id) {
		Guide existingGuide = guideRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Employee","Id",id));
		
		existingGuide.setName(guide.getName());
		existingGuide.setDepartment(guide.getDepartment());
		existingGuide.setSpecialization(guide.getSpecialization());
		
		guideRepository.save(existingGuide);

		return existingGuide;
	}

	@Override
	public Guide deleteguide(Long id) {
		Guide availableGuide = guideRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Employee","Id",id));
		guideRepository.deleteById(id);
		return availableGuide;
	}

}

