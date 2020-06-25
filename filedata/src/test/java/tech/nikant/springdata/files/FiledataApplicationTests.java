package tech.nikant.springdata.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tech.nikant.springdata.files.entities.Image;
import tech.nikant.springdata.files.repos.ImageRepository;

@SpringBootTest
class FiledataApplicationTests {

	@Autowired
	ImageRepository repository;

	@Test
	public void test_ImageSave() throws IOException {
		Image image = new Image();
		image.setId(2);
		image.setName("Resume.docx");

		File file = new File("D://DataStructures/Opteamix_Resume_Nikant.docx");
		byte[] fileContent = new byte[(int) file.length()];
		FileInputStream inputStream = new FileInputStream(file);
		inputStream.read(fileContent);

		image.setData(fileContent);

		repository.save(image);

		inputStream.close();
	}

	@Test
	public void test_readImage() throws IOException {
		Image image = repository.findById(2L).get();
		File file = new File("D://DataStructures/" + image.getName());
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		fileOutputStream.write(image.getData());
		fileOutputStream.close();
	}

}
