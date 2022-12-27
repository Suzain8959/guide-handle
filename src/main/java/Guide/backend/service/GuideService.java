package Guide.backend.service;

import java.util.List;

import Guide.backend.entity.Guide;


public interface GuideService {

	Guide saveguide(Guide guide);

	//retriving data
	List<Guide> getAllguide();
	
	//retriving data by id
	Guide getguideById(long id);
	
	//updating data
	Guide updateguide(Guide guide,Long id);
	
	//deleting data
	Guide deleteguide(Long id);
}
