package tech.nikant.springdata.files.repos;

import org.springframework.data.repository.CrudRepository;

import tech.nikant.springdata.files.entities.Image;

public interface ImageRepository extends CrudRepository<Image, Long> {

}
