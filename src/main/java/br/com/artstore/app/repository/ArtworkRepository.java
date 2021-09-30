package br.com.artstore.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.artstore.app.models.Artwork;

public interface ArtworkRepository extends JpaRepository<Artwork, Long> {

	Artwork findById(long id);
	
}
