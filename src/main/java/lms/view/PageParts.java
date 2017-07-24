package lms.view;

import lms.models.User;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**Creates static parts for HTML page
 */
public class PageParts {
static String faild = "<h4>Login or Password wrong!</h4>";




public static String getTag(String tag, StringBuilder setText, String attributes){
    attributes = attributes.length() > 0 ? " " + attributes : "";
    return "<" + tag + attributes + ">" + setText + "</" + tag + ">";
}
    public static String getTag(String tag, String setText, String attributes) {
        attributes = attributes.length() > 0 ? " " + attributes : "";
        return "<" + tag + attributes + ">" + setText + "</" + tag + ">";
    }
public static String getPartialHtml(String filename){
    StringBuilder strb = new StringBuilder();
    Path file = Paths.get(filename);
    Charset charset = Charset.forName("UTF-8");
    try(BufferedReader reader = Files.newBufferedReader(file, charset)) {
        String line = null;
        while ((line = reader.readLine()) != null){
            strb.append(line).append("\n");
        }
    } catch (IOException x){
        System.err.format("IOException: %s%n",x);
    }
    return strb.toString();
}
    public static ArrayList<String> DelDubl(ArrayList<String> array){
        ArrayList<String> result = new ArrayList<String>(new HashSet<String>(array));
        Collections.sort(result);
        return result;
    }
    public static StringBuilder Note(ArrayList<String> stringArrayList){
        StringBuilder stringBuilder = new StringBuilder();
        for (String x :stringArrayList)
            stringBuilder.append(x).append('\n');

        return stringBuilder;
    }

}
