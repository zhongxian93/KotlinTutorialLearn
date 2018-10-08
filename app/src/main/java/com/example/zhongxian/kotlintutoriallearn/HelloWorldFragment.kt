package com.example.zhongxian.kotlintutoriallearn


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class HelloWorldFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_hello_world, container, false)
        val webView = v.findViewById<View>(R.id.webView) as WebView
        var htmlAsString  = "<div style=\"background-color:#aaa\">// Hello World Program\n" +
                "<br/><br/>" +
                "fun main(args : Array<String>) {<br/>" +
                "    println(\"Hello, World!\")<br/>" +
                "}</div>";
        webView.loadDataWithBaseURL(null, htmlAsString, "text/html", "utf-8", null);

        val webView2 = v.findViewById<View>(R.id.webView2) as WebView
        var htmlAsString2  = "<h3><a id=\"how-hello-world-works\" name=\"how-hello-world-works\"></a>How this program works?</h3><ol>\n" +
                "\t<li><code style=\"background-color:#aaa\">// Hello World Program</code><br>\n" +
                "\t\t<br>\n" +
                "\t\tAny line starting with <code style=\"background-color:#aaa\">//</code> is a comment in Kotlin (similar to Java). Comments are ignored by the compiler. They are intended for person reading the code to better understand the intent and functionality of the program. To learn more, visit <em>Kotlin comments</em>.</li>\n" +
                "\t<li><code style=\"background-color:#aaa\">fun main(args : Array&lt;String&gt;) { ... }</code><br>\n" +
                "\t\t<br>\n" +
                "\t\tThis is the <code style=\"background-color:#aaa\">main</code> function, which is mandatory in every Kotlin application. The Kotlin compiler starts executing the code from the <code style=\"background-color:#aaa\">main</code> function.<br>\n" +
                "\t\t<br>\n" +
                "\t\tThe function takes array of strings as a parameter and returns Unit. You will learn about functions and parameters in later chapters.<br>\n" +
                "\t\t<br>\n" +
                "\t\tFor now, just remember that <code style=\"background-color:#aaa\">main</code> function is a mandatory function which is the entry point of every Kotlin program. The signature of <code style=\"background-color:#aaa\">main</code> function is:\n" +
                "\t\t<pre style=\"background-color:#aaa\">fun main(args : Array&lt;String&gt;) {\n" +
                "    ... .. ...\n" +
                "}</pre>\n" +
                "\t</li>\n" +
                "\t<li><code style=\"background-color:#aaa\">println(\"Hello, World!\")</code><br>\n" +
                "\t\t<br>\n" +
                "\t\tThe <code style=\"background-color:#aaa\">println()</code> function prints the given message inside the quotation marks and newline to the standard output stream. In this program, it prints <code style=\"background-color:#aaa\">Hello, World!</code> and new line.</li>\n" +
                "</ol>"+
                "<hr>"+"Read the full tutorial about kotlin <a href=\"https://www.programiz.com/kotlin-programming#tutorial\" title=\"Java Keywords and Identifiers\">here</a>"
        webView2.loadDataWithBaseURL(null, htmlAsString2, "text/html", "utf-8", null);
        return v
    }


}
