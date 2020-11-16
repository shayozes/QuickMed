package com.shayo.quickmed;

import android.content.res.AssetManager;
import android.os.SystemClock;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.IOException;

public class QuizHandler {

    private final String INDEX_URL = "https://docs.google.com/forms/d/e/1FAIpQLSc-v8KA4ut7r6OgCgWcgQSEzse6CjD3GHQwlhyaig_z3mHuGA/viewform";
    private final String QUIZ_URL = "https://docs.google.com/forms/d/e/1FAIpQLSc-v8KA4ut7r6OgCgWcgQSEzse6CjD3GHQwlhyaig_z3mHuGA/formResponse";
    private final int[] QUIZ_ANSWERS = {0, 3, 5, 7, 9, 11, 13, 15, 17};

    private String jsFunctions;
    private CallbackLogger callbackLogger;
    private WebView wv;
    private AssetManager assets;


    public QuizHandler(WebView wv, AssetManager assets) {
        this.wv = wv;
        this.assets = assets;
        this.callbackLogger = CallbackLogger.getInstance();
        this.loadJS();
    }

    public void startQuiz() {
        wv.loadUrl(INDEX_URL);

        wv.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                if (QUIZ_URL.equals(url)) {
                    view.evaluateJavascript(jsFunctions, callbackLogger);

                    for (int answer : QUIZ_ANSWERS) {
                        clickOnQuizAnswer(answer);
                    }

                    SystemClock.sleep(500);
                    clickOnQuizSubmitButton();
                }
            }
        });
    }

    private void loadJS() {
        WebSettings settings = wv.getSettings();
        settings.setJavaScriptEnabled(true);
        try {
            jsFunctions = Utills.readAsset("script.js", assets);
        } catch (IOException e) {
        }
    }

    private void clickOnQuizAnswer(int answer) {
        wv.evaluateJavascript(String.format("clickOnQuizAnswer(%s)", answer), callbackLogger);
    }

    private void clickOnQuizSubmitButton() {
        wv.evaluateJavascript("clickOnQuizSubmitButton()", callbackLogger);
    }
}
