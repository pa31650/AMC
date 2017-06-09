package com.orasi.utils.io;

import static com.orasi.utils.TestReporter.logTrace;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orasi.utils.exceptions.DataProviderInputFileNotFoundException;
import com.orasi.utils.exceptions.FailedToMapJsonException;
import com.orasi.utils.exceptions.InvalidFileException;

public class JsonHelper {
    public static <T> T readJsonFromFile(String filePath, Class<T> clazz) {
        logTrace("Entering RestService#readJsonFromFile");

        filePath = FileLoader.getAbosutePathForResource(filePath);
        logTrace("Loading resource [ " + filePath + " ]");
        String json = null;

        try {
            json = FileLoader.loadFileFromProjectAsString(filePath);
        } catch (InvalidFileException ife) {
            throw new DataProviderInputFileNotFoundException("Failed to locate json file in path [ " + filePath + " ]");
        } catch (IOException ioe) {
            throw new InvalidFileException("Failed to read json file", ioe);
        }
        return mapJSONToObject(json, clazz);
    }

    /**
     * Can pass in any json as a string and map to object
     *
     * @param clazz
     * @return
     * @throws IOException
     */
    public static <T> T mapJSONToObject(String stringResponse, Class<T> clazz) {
        ObjectMapper mapper = new ObjectMapper();
        T map = null;
        try {
            map = mapper.readValue(stringResponse, clazz);
        } catch (JsonMappingException e) {
            throw new FailedToMapJsonException("Failed to Map JSON", e);
        } catch (IOException e) {
            throw new InvalidFileException("Failed to output JSON", e);
        }
        return map;
    }
}
