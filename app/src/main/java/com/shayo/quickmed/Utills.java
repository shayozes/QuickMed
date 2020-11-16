package com.shayo.quickmed;

import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Utills {

    private Utills() {
    }

    public static String readAsset(String path, AssetManager assets) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputStream is = assets.open(path);
        BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        String str;
        while ((str = br.readLine()) != null) {
            sb.append(str);
        }
        br.close();

        return sb.toString();
    }
}
