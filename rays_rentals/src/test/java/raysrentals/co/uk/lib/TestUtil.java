package raysrentals.co.uk.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.mock.web.MockMultipartFile;

/**
 * Holds utilities for helping in tests.
 * 
 * @author echhung
 * @author mwaude
 */
public class TestUtil extends JdbcDaoSupport
{
	
	/**
	 * Accepts a String resourceLocation which is used to find and return a resource from resource directories.<p>
	 * Example usage: {@code Resource exampleTextFile = TestUtil.getResource("classpath:exampleFolder/exampleFile.txt");}
	 * @param resourceLocation the location of where the resource can be found
	 * @return a Resource Object of the resource requested
	 */
	public static Resource getResource(String resourceLocation)
	{
		FileSystemResourceLoader resourceLoader = new FileSystemResourceLoader();
		resourceLoader.setClassLoader(TestUtil.class.getClassLoader());
		
		Resource resource = resourceLoader.getResource(resourceLocation);
		
		// TODO what happens if the resource is null? Throw an Exception?
		
		return resource;
	}

	/**
	 * Executes an SQL script on a selected DataSource, See {@link FileUploadControllerTest} setup() method for a practical implementation.<p>
	 * Example usage: {@code TestUtil.executeSqlScript(dataSource, "classpath:testdata/testdata.sql");}
	 * @param dataSource the datasource of the database
	 * @param scriptPath the location of the SQL script
	 * @throws ScriptException
	 * @throws CannotGetJdbcConnectionException
	 * @see FileUploadControllerTest
	 */
	public static void executeSqlScript(DataSource dataSource, String scriptPath) throws ScriptException, CannotGetJdbcConnectionException
	{
		Resource resource = getResource(scriptPath);
		try {
			Connection connection = DataSourceUtils.getConnection(dataSource);
			ScriptUtils.executeSqlScript(connection, resource);
		} catch (CannotGetJdbcConnectionException connectionException) { 
			throw connectionException;
		} catch (ScriptException scriptException) {
			throw scriptException;
		}
	}

	/**
	 * <p>Builds a MultipartFile from a String path to a file in the resources
	 * <p>Example usage: {@code TestUtil.buildMultipartFile("/csvfiles/csvuploadservice/invalidExtension.txt")}
	 * @param filePath The path to the file in resources
	 * @return A MockMultipartFile implementation of MultipartFile for the file requested
	 * @throws IOException
	 */
	public static MockMultipartFile buildMultipartFile(String filePath) throws IOException
	{
		String pathname = TestUtil.class.getResource(filePath).getFile();
		File file = new File(pathname);
		// No need to close the InputStream as the MockMultipartFile closes it after it has been used.
		// If you close the InputStream manually, the MockMultipartFile will have no content.
		InputStream inputStream = new FileInputStream(file);
		MockMultipartFile multipartFile = new MockMultipartFile(file.getName(), file.getName(), "multi-part", inputStream);
		return multipartFile;
	}
	
	/**
	 * <p>Builds a MultipartFile from a String path to a file in the resources
	 * <p>Example usage: {@code TestUtil.buildMultipartFile("csvFile", "/csvfiles/csvuploadservice/invalidExtension.txt")}
	 * @param multipartName The name of the MultipartFile
	 * @param filePath The path to the file in resources
	 * @return A MockMultipartFile implementation of MultipartFile for the file requested
	 * @throws IOException
	 */
	public static MockMultipartFile buildMultipartFile(String multipartName, String filePath) throws IOException
	{
		String pathname = TestUtil.class.getResource(filePath).getFile();
		File file = new File(pathname);
		// No need to close the InputStream as the MockMultipartFile closes it after it has been used.
		// If you close the InputStream manually, the MockMultipartFile will have no content.
		InputStream inputStream = new FileInputStream(file);
		MockMultipartFile multipartFile = new MockMultipartFile(multipartName, file.getName(), "multi-part", inputStream);
		return multipartFile;
	}
}
