package app.french.Assignment;

import android.Manifest;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import app.french.R;

public class Assignment extends AppCompatActivity {

    private WebView mWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.noheadingweblesson);

//        //setting page heading as Assignment
//        TextView textView_Lno = (TextView) findViewById(R.id.lesson_number);
//        textView_Lno.setText("Assignments");

        //getting webview layout control in activity
        mWebview  = (WebView) findViewById(R.id.weblesson_content);
        mWebview.getSettings().setBuiltInZoomControls(true);
        mWebview.getSettings().setJavaScriptEnabled(true);

        final String link = getString(R.string.AssignmentLink);
        final Activity activity = this;
        mWebview.setWebViewClient(new WebViewClient() {
            //Operations to be proceeded with in case of an error
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                //Copy url to clipboard in case of loading error
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText(null,failingUrl);
                clipboard.setPrimaryClip(clip);

                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
                Toast.makeText(activity, "URL copied to clipboard, paste and use it in other browser manually", Toast.LENGTH_LONG).show();
                Toast.makeText(activity, "Else try opening it here again", Toast.LENGTH_SHORT).show();
                finish();
            }
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (URLUtil.isNetworkUrl(url))
                    return false;
                return true;
            }
        });
        //load assignment link
        mWebview.loadUrl(link);

        //Checks for download request from site
        mWebview.setDownloadListener(new DownloadListener() {
                                         @Override
                                         public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimeType, long contentLength) {
                                             DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
                                             ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);

                                             request.setMimeType(mimeType);
                                             //------------------------COOKIE!!------------------------
                                             String cookies = CookieManager.getInstance().getCookie(url);
                                             request.addRequestHeader("cookie", cookies);
                                             //------------------------COOKIE!!------------------------
                                             request.addRequestHeader("User-Agent", userAgent);
                                             request.setDescription("Downloading file...");
                                             request.allowScanningByMediaScanner();
                                             request.setTitle(URLUtil.guessFileName(url, contentDisposition, mimeType));
                                             request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                                             request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, URLUtil.guessFileName(url, contentDisposition, mimeType));
                                             DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                                             dm.enqueue(request);
                                             Toast.makeText(getApplicationContext(), "Downloading File", Toast.LENGTH_LONG).show();

                                          }
                                     });
    }

    //Return to previous page on pressing back key on mobile
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN)
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (mWebview.canGoBack())
                        mWebview.goBack();
                    else
                        finish();
                    return true;
            }
        return super.onKeyDown(keyCode, event);
    }
}