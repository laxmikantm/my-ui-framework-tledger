package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;
import managers.FileReaderManager;
import testDataTypes.UserCredentials;
/**************************
 *  (C) L Somni            *
 ***************************/
public class JsonDataReader {
	private final String credentialsFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath()
			+ "TestUserCredentials.json";
	private List<UserCredentials> userCredentialsList;

	public JsonDataReader() {
		userCredentialsList = getCredentialsData();
	}

	private List<UserCredentials> getCredentialsData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(credentialsFilePath));
			UserCredentials[] userCredentials = gson.fromJson(bufferReader, UserCredentials[].class);
			return Arrays.asList(userCredentials);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + credentialsFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}


}