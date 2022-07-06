package bootrestbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import bootrestbook.helper.FileUploadHelper;

@RestController 
public class FileUploadController {
	@Autowired
	private FileUploadHelper fileuploadhelper;
	
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
		
	/*System.out.println(file.getOriginalFilename());
	System.out.println(file.getSize());
	System.out.println(file.getContentType());
	System.out.println(file.getName());*/
		try {
		if(file.isEmpty()) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
		}
		
		if(file.getContentType().equals("image.jpg")) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain image");
		}
		
	    boolean f	=fileuploadhelper.uploadFile(file);
	if (f) {
		
		// return ResponseEntity.ok("file uploaded successfully");
		return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").
				path(file.getOriginalFilename()).toString());
	}
	
		}
		catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("try again later");

		}
		return ResponseEntity.ok("successful");
	
	}

}
