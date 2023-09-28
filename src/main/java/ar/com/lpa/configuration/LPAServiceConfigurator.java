package ar.com.lpa.configuration;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Base64;
import java.util.Properties;
import org.json.JSONObject;

public class LPAServiceConfigurator {
	
	String image;
	
	public LPAServiceConfigurator() {}
	
	public void readProperties() {
		Properties props = getProperties();
		String image = props.getProperty("image");
		setImage(image);
	}
	
	public Properties getProperties() {
		var properties = new Properties();
		try (var stream = Thread.currentThread().getContextClassLoader()
	            .getResourceAsStream("config.properties")) {
            properties.load(stream);
            stream.close();
        } catch (IOException e) {
        	System.out.println("sucedio un error: " + e);
		}
        return properties;
	}
	
	public void writeProperties(JSONObject json) throws FileNotFoundException, IOException {
		var props = new Properties();
		Object imageProp = json.getString("image");
		Object extension = json.getString("extension");
		Object name = json.getString("name");
		
		String fileName = name.toString();
		String ext = extension.toString();	
		String prefix = this.mkPrefix(fileName, ext);
		
		byte[] imageBase64 = Base64.getDecoder().decode(imageProp.toString());
		InputStream is = new ByteArrayInputStream(imageBase64);
		File newFile = new File("C:\\Users\\nicol\\LPAView-workspace\\ViewerAngularLPA\\src\\main\\webapp\\" 
		+ prefix);
		if (!newFile.exists()) {
			newFile.createNewFile();
		}
		int nRead;
		byte[] data = new byte[1024];
		FileOutputStream fos = new FileOutputStream(newFile, false);
		// while ((count = in.read(buffer)) > 0)
		//fos.write(imageBase64);
		while ((nRead = is.read(data))  > 0) {
			fos.write(data, 0, nRead);
		}
		fos.close();
		
		String finalPath = mkFinalPath(prefix);	
		props.setProperty("image", finalPath);
		props.setProperty("extension", ext);
		props.setProperty("filename", fileName);
		URL url = Thread.currentThread().getContextClassLoader()
	            .getResource("config.properties");
	    try {
	        File file = new File(url.toURI().getPath());
	        FileOutputStream fos2 = new FileOutputStream(file);
	        props.store(fos2, "");
	        fos2.close();   
	    } catch (URISyntaxException e) {
	        e.printStackTrace();
	    }
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}

	private String mkPrefix(String filename, String extension) {
		return "images\\" + filename + "." + extension;
	}
	private String mkFinalPath(String partialPath) {
		return partialPath.replace("\\", "/");
	}   

}
