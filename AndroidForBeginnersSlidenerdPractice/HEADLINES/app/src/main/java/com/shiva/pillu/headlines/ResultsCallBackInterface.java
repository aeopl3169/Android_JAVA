package com.shiva.pillu.headlines;

import java.util.ArrayList;
import java.util.HashMap;

public interface ResultsCallBackInterface {
    public void onPreExecuteInterface();

    public void onPostExecuteInterface(ArrayList<HashMap<String, String>> results);
}
