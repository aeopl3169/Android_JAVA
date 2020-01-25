package com.shiva.pillu.headlines;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MyAsyncTask extends AsyncTask<Void, Void, ArrayList<HashMap<String, String>>> {

    ResultsCallBackInterface resultsCallBackInterface = null;
    FragmentTOI fragmentTOI;
    Context context;

    public MyAsyncTask(ResultsCallBackInterface resultsCallBackInterface) {
        this.resultsCallBackInterface = resultsCallBackInterface;
    }

    public MyAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute ();
        fragmentTOI = new FragmentTOI ();
        if (resultsCallBackInterface != null){
            resultsCallBackInterface.onPreExecuteInterface ();
        }
    }

    @Override
    protected ArrayList<HashMap<String, String>> doInBackground(Void... voids) {
        String toiUrl = "https://timesofindia.indiatimes.com/rssfeeds/1221656.cms";
        ArrayList<HashMap<String, String>> hashMapArrayList = new ArrayList<> ();
        try {
            URL url = new URL (toiUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection ();
            InputStream inputStream = httpURLConnection.getInputStream ();
            hashMapArrayList = processXMLMethod (inputStream);
        } catch (MalformedURLException e) {
            e.printStackTrace ();
        } catch (IOException e) {
            e.printStackTrace ();
        } catch (ParserConfigurationException e) {
            e.printStackTrace ();
        } catch (SAXException e) {
            e.printStackTrace ();
        }
        return hashMapArrayList;
    }

    private ArrayList<HashMap<String, String>> processXMLMethod(InputStream inputStream) throws ParserConfigurationException, IOException, SAXException {
        ArrayList<HashMap<String, String>> hashMapArrayList = new ArrayList<> ();
        HashMap<String, String> hashMap;
        // XML DOM API's
        // DocumentBuilderFactory is a singleton class. Only one object exits for this type of class.
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance ();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder ();
        Document xmlDocument = documentBuilder.parse (inputStream);
        // getDocumentElement will return the root element of the xml document.
        Element rootElement = xmlDocument.getDocumentElement ();
        Log.d ("XML", "Root: " + rootElement.getTagName ());
        // List start
        NodeList nodeList = rootElement.getElementsByTagName ("item");
        Log.i ("XML", "Node list: " + nodeList + ", node length:   " + nodeList.getLength ());
        Node currentNode = null;
        NodeList nodeListChildren = null;
        Node currentNodeChild = null;
        for (int i = 0; i < nodeList.getLength (); i++) {
            hashMap = new HashMap<> ();
            currentNode = nodeList.item (i);
            Log.d ("XML", "Current node: " + currentNode + ", node name:   " + currentNode.getNodeName ());
            nodeListChildren = currentNode.getChildNodes ();
            Log.e ("XML", "Current node child: " + currentNode.getChildNodes ());
            int a = 0;
            Log.d ("XML","NodeListChildren: "+nodeListChildren.getLength ());
            for (int j=0; j<nodeListChildren.getLength (); j++){
                currentNodeChild = nodeListChildren.item (j);
                if (currentNodeChild.getNodeName ().equalsIgnoreCase ("title")){
                    Log.w ("XML", "title: " + currentNodeChild.getTextContent ());
                    hashMap.put ("title",currentNodeChild.getTextContent ());
                }
            }
            if (hashMap != null && !hashMap.isEmpty ()){
                hashMapArrayList.add (hashMap);
            }
        }
        return hashMapArrayList;
    }

    @Override
    protected void onPostExecute(ArrayList<HashMap<String, String>> hashMaps) {
        super.onPostExecute (hashMaps);
        Log.d ("XML", "onPostExecute: " + hashMaps);
        if (hashMaps!=null) {
//            resultsCallBackInterface.onPostExecuteInterface (hashMaps);
        }
        fragmentTOI.receive (hashMaps);
    }

    public void onAttachMethod(ResultsCallBackInterface resultsCallBackInterface) {
        this.resultsCallBackInterface = resultsCallBackInterface;
    }

    public void onDetachMethod() {
        resultsCallBackInterface = null;
    }
}
