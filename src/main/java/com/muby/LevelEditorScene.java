package com.muby;

import java.awt.*;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL20;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;

public class LevelEditorScene extends Scene {

    private String vertexShaderSrc = "#version 330 core\n" +
    "layout (location=0) in vec3 aPos;\n" +
    "layout (location=1) in vec4 aColor;\n" +
    "\n" +
    "out vec4 fColor;\n" +
    "\n" +
    "void main() {\n" +
    "    fColor = aColor;\n" +
    "    gl_Position = vec4(aPos, 1.0);\n" +
    "}";

    private String fragmentShaderSrc = "#version 330 core\n" +
    "\n" +
    "in vec4 fColor;\n" +
    "out vec4 color;\n" +
    "\n" +
    "void main() {\n" +
    "    color - fColor;\n" +
    "}";

    private int vertexID, fragmentID, shaderProgram;
    public LevelEditorScene() {
        System.out.println("Inside level editor scene");
    }

    @Override
    public void init() {
        //Compile and link shaders

        //load and compile vertex shader
        vertexID = glCreateShader(GL_VERTEX_SHADER);
        //Pass the shader source to GPU
        glShaderSource(vertexID, vertexShaderSrc);
        glCompileShader(vertexID);

        //Check for errors
        int success = glGetShaderi(vertexID, GL_COMPILE_STATUS);
        if (success == GL_FALSE){
            int length = glGetShaderi(vertexID, GL_INFO_LOG_LENGTH);
            System.out.println("Oppsie: 'defaultShader.glsl'\n\tVertex shader compilation failed");
            System.out.println(glGetShaderInfoLog(vertexID, length));
            assert false: "";
        }

                //load and compile vertex shader
                vertexID = glCreateShader(GL_VERTEX_SHADER);
                //Pass the shader source to GPU
                glShaderSource(vertexID, vertexShaderSrc);
                glCompileShader(vertexID);
        
                //Check for errors
                int succes = glGetShaderi(vertexID, GL_COMPILE_STATUS);
                if (succes == GL_FALSE){
                    int length = glGetShaderi(vertexID, GL_INFO_LOG_LENGTH);
                    System.out.println("Oppsie: 'defaultShader.glsl'\n\tVertex shader compilation failed");
                    System.out.println(glGetShaderInfoLog(vertexID, length));
                    assert false: "";
                }
    }

    @Override
        public void update(float dt) {

        //System.out.println("" + (1.0f/dt) + "FPS");


    }
}
