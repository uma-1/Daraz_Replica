package com.example.darazreplica.serverresponse;

public class ImageResponse {
    private String Filename;

    public ImageResponse(String filename) {
        Filename = filename;
    }

    public String getFilename() {
        return Filename;
    }

    public void setFilename(String filename) {
        Filename = filename;
    }
}
