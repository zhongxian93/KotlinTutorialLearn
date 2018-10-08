package com.example.zhongxian.kotlintutoriallearn


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import android.webkit.WebSettings
import android.webkit.WebView




// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class VariablesTypesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_variables_types, container, false)
        //possible to load web content via link

        val webView = v.findViewById<View>(R.id.webView) as WebView
        var htmlAsString  = "<h1>Kotlin Variables and Basic Types</h1><div class=\"page-short-description\">\n" +
                "In this tutorial, you will learn about variables, how to create them, and basic data types that Kotlin supports for creating variables.</div><h3><a id=\"declaring-variables\" name=\"declaring-variables\"></a>How to declare a variable in Kotlin?</h3>"+
                "<p>To declare a variable in Kotlin, either <code  style=\"background-color:#aaa\">var</code> or <code  style=\"background-color:#aaa\">val</code> keyword is used. Here is an example:</p>"+
                "<div style=\"background-color:#aaa\">var language = \"French\"\n" +
                "val score = 95</div>"+
                "<p>The difference in using <code  style=\"background-color:#aaa\">var</code> and <code  style=\"background-color:#aaa\">var</code> is discussed later in the article. For now, let's focus on variable declaration.</p>"+"<p>Here, <var  style=\"background-color:#aaa\">language</var> is a variable of type <code  style=\"background-color:#aaa\">String</code>, and <code  style=\"background-color:#aaa\">score</code> is a variable of type <code  style=\"background-color:#aaa\">Int</code>. You don't have to specify the type of variables; Kotlin implicitly does that for you. The compiler knows this by initializer expression (<var  style=\"background-color:#aaa\">\"French\"</var> is a <code  style=\"background-color:#aaa\">String</code>, and <var  style=\"background-color:#aaa\">95</var> is an integer value in the above program). This is called type inference in programming.</p>"+
                "<p>However, you can explicitly specify the type if you want to:</p>"+
                "<pre style=\"background-color:#aaa\">var language: String = \"French\"\n" +
                "val score: Int = 95</pre>"+
                "<p>We have initialized variable during declaration in above examples. However, it's not necessary. You can declare variable and specify its type in one statement, and initialize the variable in another statement later in the program.</p>"+
                "<div style=\"background-color:#aaa\">var language: String   // variable declaration<br/>" +
                "... .. ...<br/>" +
                "language = \"French\" <br/>// variable initialization<br/>" +
                "<br/>" +
                "val score: Int    // variable declaration <br/>" +
                "... .. ...<br/>" +
                "score = 95 <br/>  // variable initialization </div>" +"<hr>" +
                "<p>Here are few examples that results into error.</p>" +
                "<pre style=\"background-color:#aaa\">var language           // Error \n" +
                "language = \"French\"</pre>"+
                "<p>Here, the type of <var style=\"background-color:#aaa\">language</var> variable is not explicitly specified, nor the variable is initialized during declaration.</p>"+
                "<pre style=\"background-color:#aaa\">var language: String\n" +
                "language = 14         // Error</pre>"+
                "<p>\u200B\u200B\u200B\u200BHere, we are trying to assign 14 (integer value) to variable of different type (<code  style=\"background-color:#aaa\">String</code>).</p>"+
                "<hr>"+
                "<h3><a id=\"var-val\" name=\"var-val\"></a>Difference Between var and val</h3>"+
                "<ul>\n" +
                "\t<li><strong>val</strong> (Immutable reference) - The variable declared using <code  style=\"background-color:#aaa\">val</code> keyword cannot be changed once the value is assigned. It is similar to <em>final variable in Java</em>.</li>\n" +
                "\t<li><strong>var</strong> (Mutable reference) - The variable declared using <code style=\"background-color:#aaa\">var</code> keyword can be changed later in the program. It corresponds to regular Java variable.</li>\n" +
                "</ul>"+
                "<p>Here are few examples:</p>"+"<pre style=\"background-color:#aaa\">var language = \"French\"\n" +
                "language = \"German\"     </pre>"+
                "<p>Here, <code  style=\"background-color:#aaa\">language</code> variable is reassigned to <var style=\"background-color:#aaa\">German</var>. Since, the variable is declared using <code  style=\"background-color:#aaa\">var</code>, this code work perfectly.</p>"+
                "<pre style=\"background-color:#aaa\">val language = \"French\"\n" +
                "language = \"German\"      // Error</pre>"+
                "<p>You cannot reassign <var style=\"background-color:#aaa\">language</var> variable to <code  style=\"background-color:#aaa\">German</code> in the above example because the variable is declared using <code  style=\"background-color:#aaa\">val</code>.</p>"+
                "<hr>"+
                "<p>Now, you know what Kotlin variables are, it's time to learn different values a Kotlin variable can take.</p>"+
                "<hr>"+"<h2><a id=\"basic-types\" name=\"basic-types\"></a>Kotlin Basic Types</h2>"+
                "<p>Kotlin is a statically typed language like Java. That is, the type of a variable is known during the compile time. For example,</p>"+
                "<pre style=\"background-color:#aaa\">val language: Int\n" +
                "val marks = 12.3</pre>"+
                "<p>Here, the compiler knows that <var style=\"background-color:#aaa\">language</var> is of type <code style=\"background-color:#aaa\">Int</code>, and <var style=\"background-color:#aaa\">marks</var> is of type <code style=\"background-color:#aaa\">Double</code> before the compile time.</p>"+
                "<ul>\n" +
                "\t<li>Numbers</li>\n" +
                "\t<li>Characters</li>\n" +
                "\t<li>Booleans</li>\n" +
                "\t<li>Arrays</li>\n" +
                "</ul>"+"<hr>"+"Read the full tutorial about kotlin <a href=\"https://www.programiz.com/kotlin-programming#tutorial\" title=\"Java Keywords and Identifiers\">here</a>"
        webView.loadDataWithBaseURL(null, htmlAsString, "text/html", "utf-8", null);
        /*
        val mWebView = v.findViewById(R.id.webView) as WebView
        mWebView.loadUrl("https://www.programiz.com/kotlin-programming/variable-types")

        // Enable Javascript
        val webSettings = mWebView.getSettings()
        webSettings.setJavaScriptEnabled(true)

        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(WebViewClient())
        */
        return v
    }


}
