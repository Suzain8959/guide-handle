package Guide.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Guide.backend.entity.Guide;
import Guide.backend.service.GuideService;


@RestController
@RequestMapping("/api/guide")
public class GuideController {

	private GuideService guideService;
	
	@Autowired
	public GuideController(GuideService guideService) {
		this.guideService = guideService;
	}
	
	//creating employee rest api
	//convert json to pojo or vice versa is done by @requestbody
	//response entitiy = execute the method with additional features
		
	@PostMapping
	public ResponseEntity<Guide> saveGuide(@RequestBody Guide guide){
		return new ResponseEntity<Guide>(guideService.saveguide(guide),HttpStatus.CREATED);		
	}
	
	@GetMapping
	public List <Guide> getAllGuide(){
		return guideService.getAllguide(); 
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Guide> findGuideeById(@PathVariable("id")long guideId){
		return new ResponseEntity<Guide>(guideService.getguideById(guideId),HttpStatus.OK);
		// if any data is passing then u can only access it throw pathVariable annotation
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Guide> updateGuide(@PathVariable("id")long id,@RequestBody Guide guide){
		return new ResponseEntity<Guide>(guideService.updateguide(guide, id),HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Guide> deleteGuide(@PathVariable("id")long id){
		return new ResponseEntity<Guide>(guideService.deleteguide(id),HttpStatus.OK);
	}
	
}
