package util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.sound.midi.SysexMessage;

public class PropertyReaderUtil {
	public static String getProperty(String key) throws IOException
	{
		String filePath= System.getProperty("user.dir")+"\\src\\test\\resources\\variables.properties";
		FileReader fileReader = new FileReader(filePath);
        Properties properties = new Properties();
        properties.load(fileReader);
        return properties.getProperty(key);
	}
}