package com.orasi.utils.io;

import java.io.BufferedReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orasi.utils.exceptions.InvalidFileException;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

public class TestFileLoader {
    @Features("Utils")
    @Stories("FileLoader")
    @Title("getAbosutePathForResource")
    @Test
    public void getAbosutePathForResource() {
        Assert.assertNotNull(FileLoader.getAbosutePathForResource("/json/sample.json"));
    }

    @Features("Utils")
    @Stories("FileLoader")
    @Title("getAbosutePathForResourceNofile")
    @Test
    public void getAbosutePathForResourceNoFile() {
        Assert.assertNotNull(FileLoader.getAbosutePathForResource(System.getProperty("java.io.tmpdir")));
    }

    @Features("Utils")
    @Stories("FileLoader")
    @Title("isReadableFileResource")
    @Test
    public void isReadableFileResource() {
        Assert.assertTrue(FileLoader.isReadableFile("/json/sample.json"));
    }

    @Features("Utils")
    @Stories("FileLoader")
    @Title("isReadableFileFullPath")
    @Test
    public void isReadableFileFullPath() {
        Assert.assertTrue(FileLoader.isReadableFile(this.getClass().getResource("/json/sample.json").getPath()));
    }

    @Features("Utils")
    @Stories("FileLoader")
    @Title("isReadableFileMissingFile")
    @Test
    public void isReadableFileMissingFile() {
        Assert.assertFalse(FileLoader.isReadableFile("/json/blah.json"));
    }

    @Features("Utils")
    @Stories("FileLoader")
    @Title("openTextFileFromProject")
    @Test
    public void openTextFileFromProject() {
        try (BufferedReader reader = FileLoader.openTextFileFromProject("/json/sample.json")) {
            Assert.assertNotNull(reader);
        } catch (IOException e) {
            Assert.fail();
        }
    }

    @Features("Utils")
    @Stories("FileLoader")
    @Title("openTextFileFromProject")
    @Test
    public void openTextFileFromProjectMissingLeadingSlash() {
        try (BufferedReader reader = FileLoader.openTextFileFromProject("json/sample.json")) {
            Assert.assertNotNull(reader);
        } catch (IOException e) {
            Assert.fail();
        }
    }

    @Features("Utils")
    @Stories("FileLoader")
    @Title("openTextFileFromProject")
    @Test
    public void openTextFileFromProjectMissingFile() {
        try (BufferedReader reader = FileLoader.openTextFileFromProject("/json/blah.json")) {
        } catch (IOException e) {
            Assert.fail();
        } catch (InvalidFileException ife) {
            // Success
        }
    }

    @Features("Utils")
    @Stories("FileLoader")
    @Title("isReadableFileMissingFile")
    @Test
    public void loadFileFromProjectAsString() throws IOException {
        Assert.assertNotNull(FileLoader.loadFileFromProjectAsString("/json/sample.json"));
    }

}
