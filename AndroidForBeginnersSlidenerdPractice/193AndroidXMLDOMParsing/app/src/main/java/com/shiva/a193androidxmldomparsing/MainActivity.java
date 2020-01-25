package com.shiva.a193androidxmldomparsing;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {

    PlaceholderFragment placeholderFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        if (savedInstanceState == null) {
            placeholderFragment = new PlaceholderFragment ();
            getSupportFragmentManager ().beginTransaction ()
                    .add (placeholderFragment, "MyFragment").commit ();
        } else {
            placeholderFragment = (PlaceholderFragment) getSupportFragmentManager ().findFragmentByTag ("MyFragment");
        }
        placeholderFragment.startTask ();
    }

    public static class PlaceholderFragment extends Fragment {
        TechCrunchAsyncTask techCrunchAsyncTask;

        public PlaceholderFragment() {
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated (savedInstanceState);
            // By calling setRetainInstance the fragment will not destroy.
            setRetainInstance (true);
        }

        public void startTask() {
            //if the download is empty then cancel, else start the task
            if (techCrunchAsyncTask != null) {
                techCrunchAsyncTask.cancel (true);
            } else {
                techCrunchAsyncTask = new TechCrunchAsyncTask ();
                techCrunchAsyncTask.execute ();
            }
        }
    }

    public static class TechCrunchAsyncTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            String downloadURL = "http://feeds.feedburner.com/techcrunch/android?format=xml";
            try {
                URL url = new URL (downloadURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection ();
                httpURLConnection.setRequestMethod ("GET");
                // getInputStream will return InputStream object from where we can read the data.
                InputStream inputStream = httpURLConnection.getInputStream ();
                processXML (inputStream);
            } catch (Exception e) {
                e.printStackTrace ();
                Log.d ("XML", " " + e);
            }
            return null;
        }

        public void processXML(InputStream inputStream) throws Exception {
            // XML DOM API's
            // DocumentBuilderFactory is a singleton class. Only one object exits for this type of class.
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance ();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder ();
            // Parsing the XML
            Document xmlDocument = documentBuilder.parse (inputStream);
            // getDocumentElement will return the root element of the xml document.
            Element rootElement = xmlDocument.getDocumentElement ();
            Log.d ("XML", "Root: " + rootElement.getTagName ());

            // List
            NodeList nodeList = rootElement.getElementsByTagName ("item");
            Log.i ("XML", "Node list: " + nodeList + ", node length:   " + nodeList.getLength ());
            Node currentNode = null;
            NodeList nodeListChildren = null;
            Node currentNodeChild = null;
            for (int i = 0; i < nodeList.getLength (); i++) {
                currentNode = nodeList.item (i);
                Log.d ("XML", "Current node: " + currentNode + ", node name:   " + currentNode.getNodeName ());
                nodeListChildren = currentNode.getChildNodes ();
                Log.e ("XML", "Current node child: " + currentNode.getChildNodes ());
                Log.i ("XML", "Node List Children: " + nodeListChildren + ", Node list length:    " + nodeListChildren.getLength ());
                for (int j = 0; j < nodeListChildren.getLength (); j++) {
                    currentNodeChild = nodeListChildren.item (j);
                    Log.i ("XML", "Current Node child: " + currentNodeChild);
                    if (currentNodeChild.getNodeName ().equalsIgnoreCase ("title")) {
                        Log.w ("XML", "Title: " + currentNodeChild.getTextContent ());
                    }
                }
            }
        }
    }
}