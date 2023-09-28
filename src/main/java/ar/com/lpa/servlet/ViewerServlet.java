package ar.com.lpa.servlet;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.HttpHeaders;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

@WebServlet("/ViewerServlet")
public class ViewerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static final String urlFromViewerGetMarcks = "http://localhost:8081/example"; // Esta url hay que obtenerla
	// desde la url que llama al visor
	private static final String urlFromViewerSaveMarcks = "http://localhost:8081/save";
	private static final String urlFromViewerGetMarcks = "http://localhost:8081/example";
	private static final String DOCUMENT_ID= "1223432544545"; 

	// Trabajemos con el byte[] o .txt para el get, que el mapeo a Objetos lo haga el servicio de xcontent
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OutputStream out = new DataOutputStream(response.getOutputStream());
		final HttpPost httpPost = new HttpPost(urlFromViewerGetMarcks);
	    
	    JSONObject jsonBody = new JSONObject();
	    jsonBody.put("documentId", DOCUMENT_ID);
		String body = jsonBody.toString();
	    final StringEntity entity = new StringEntity(body);
	    httpPost.setEntity(entity);
	    
		String rspBody = this.apiCallAndGetResponse(httpPost); // TRAIGO LAS ANOTACIONES
		JSONObject rspJson = new JSONObject(rspBody);
		Object annotation = rspJson.get("annotation");
		Object document = rspJson.get("document");
		byte[] annotationDecodedBytes = Base64.getDecoder().decode(annotation.toString()); // Obtengo los byte[] tanto de la imagen
		out.write(annotationDecodedBytes); // Escribo las anotaciones...
		// como de las anotaciones
		//byte[] documentDecodedBytes = Base64.getDecoder().decode(document.toString());
		out.close();
	}

	// Guardo las anotaciones/marcas sobre el documento
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		InputStream in = request.getInputStream();
		int nRead;
		byte[] data = new byte[1024];
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		
		while ((nRead = in.read(data, 0, data.length)) != -1) {
			buffer.write(data, 0, nRead);
		}
		byte[] targetArray = buffer.toByteArray(); // Genero los byte[] con las nuevas anotaciones
		String idImage = "367473647324632476"; // Este id de la imagen lo obtengo desde la url del visor
		
		// Genero el json para enviar las anotaciones y el id de la imagen/documento
		JSONObject json = new JSONObject();
		json.put("imageId", idImage);
		json.put("targetArray", targetArray);
		String body = json.toString();
	    final StringEntity entity = new StringEntity(body);
	    final HttpPost httpPost = new HttpPost(urlFromViewerSaveMarcks); // Esta url la tendria que obtener de
	    // del mismo modo que obtengo la url para llamar al Get
	    httpPost.setEntity(entity);
	    this.apiCallAndGetResponse(httpPost); // GUARDO LAS ANOTACIONES
		
		// GUARDO LAS ANOTACIONES PARA DESPUES OBTENERLAS Y USARLAS EN MOCKOON
		File file = new File("myfile.txt"); // Busco el File o lo genero si no existe
		if (!file.exists()) {
			file.createNewFile();
		}
		try (FileOutputStream stream = new FileOutputStream(file, false)) {
			stream.write(targetArray);
		} catch (FileNotFoundException e) {
			System.out.println("No existe el File 'myfile.txt'");
		}
		buffer.flush();
		in.close();
	}
	
	private String apiCallAndGetResponse(HttpEntityEnclosingRequestBase httpEntity) throws IOException {
		String token ="eyJhbGciOiXXXzUxMiJ9.eyJzdWIiOiPyc2hhcm1hQHBsdW1zbGljZS5jb206OjE6OjkwIiwiZXhwIjoxNTM3MzQyNTIxLCJpYXQiOjE1MzY3Mzc3MjF9.O33zP2l_0eDNfcqSQz29jUGJC-_THYsXllrmkFnk85dNRbAw66dyEKBP5dVcFUuNTA8zhA83kk3Y41_qZYx43T";
		httpEntity.setHeader(HttpHeaders.ACCEPT, "application/json");
		httpEntity.setHeader(HttpHeaders.CONTENT_TYPE,"application/json");
		httpEntity.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token);
	    
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			 try (CloseableHttpResponse rsp = httpClient.execute(httpEntity)) {
				 StatusLine statusLine = rsp.getStatusLine();
				 System.out.println(statusLine.getStatusCode() + " " + statusLine.getReasonPhrase());
				 String responseBody = EntityUtils.toString(rsp.getEntity(), StandardCharsets.UTF_8);
				 rsp.close();
				 httpClient.close();
				 return responseBody;
			 }
		}
	}
}