package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

public class FileSystemTest {
    FileSystem fs;

    @BeforeAll
    public void setUpFS(){
        fs = TestFixtureInitializer.createFS();
    }
}