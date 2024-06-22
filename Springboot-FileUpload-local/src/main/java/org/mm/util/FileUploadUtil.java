package org.mm.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadUtil
{
	public final String UPLOAD_DIR = "M:\\SpringBootCodeRepo\\SpringBoot_FileUpload_LocalStorage\\Springboot-FileUpload-local\\src\\main\\resources\\static\\images";
	
	public void uploadFile(MultipartFile file) throws IOException
	{
		String uuid = UUID.randomUUID().toString();
		String ext = StringUtils.getFilenameExtension(file.getOriginalFilename());
		String newFilename = uuid+"."+ext;
		
		Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+newFilename), StandardCopyOption.REPLACE_EXISTING);
	}
}
