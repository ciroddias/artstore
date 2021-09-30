package br.com.artstore.app.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.artstore.app.models.Artwork;
import br.com.artstore.app.repository.ArtworkRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="Artworks REST CRUD")
@CrossOrigin(origins="*")
public class ArtworkResource {

	@Autowired
	ArtworkRepository artworkRepository;
	
	
	@GetMapping("/artworks")
	@ApiOperation(value="Returns an Artwork list")
	public List<Artwork> listArtworks(){
		return artworkRepository.findAll();
	}

	
	@GetMapping("/artworks/{id}")
	@ApiOperation(value="Returns an Artwork by id")
	public Artwork listArtworkById(@PathVariable(value="id") long id) {
		return artworkRepository.findById(id);
	}
	
	
	@PostMapping("/artwork")
	@ApiOperation(value="Saves an Artwork")
	public Artwork saveArtwork(@RequestBody Artwork artwork) {
		return artworkRepository.save(artwork);
	}
	
	@DeleteMapping("/artwork")
	@ApiOperation(value="Deletes an Artwork")
	public void deleteArtwork(@RequestBody Artwork artwork) {
		artworkRepository.delete(artwork);
	}
	
	@PutMapping("/artwork")
	@ApiOperation(value="Updates an Artwork")
	public Artwork updateArtwork(@RequestBody Artwork artwork) {
		return artworkRepository.save(artwork);
	}
	
}
