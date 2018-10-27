package com.example.zhongxian.kotlintutoriallearn

import android.content.Context
import android.net.Uri
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
 * Activities that contain this fragment must implement the
 * [FunctionsFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [FunctionsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class FunctionsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val v = inflater.inflate(R.layout.fragment_functions, container, false)
        val webView = v.findViewById<View>(R.id.webView_functions) as WebView
        var htmlAsString  = "<style>\n" +
                "pre {background-color:#aaa}\n" +
                "code {background-color:#aaa}\n" +
                "</style>\n<h1>Kotlin Functions</h1><p><a id=\"introduction\" name=\"introduction\"></a>In programming, function is a group of related statements that perform a specific task.</p><p>Functions are used to break a large program into smaller and modular chunks. For example, you need to create and color a circle based on input from the user. You can create two functions to solve this problem:</p>\n" +
                "\n" +
                "<ul>\n" +
                "\t<li><code>createCircle()</code> Function</li>\n" +
                "\t<li><code>colorCircle()</code> Function</li>\n" +
                "</ul>\n" +
                "\n" +
                "<p>Dividing a complex program into smaller components makes our program more organized and manageable.</p>\n" +
                "\n" +
                "<p>Furthermore, it avoids repetition and makes code reusable.</p>\n" +
                "\n" +
                "<hr />\n" +
                "<h2>Types of Functions</h2>\n" +
                "\n" +
                "<p>Depending on whether a function is defined by the user, or available in <a href=\"https://kotlinlang.org/api/latest/jvm/stdlib/\" title=\"Kotlin standard Library\">standard library</a>, there are two types of functions:</p>\n" +
                "\n" +
                "<ul>\n" +
                "\t<li>Kotlin Standard Library Function</li>\n" +
                "\t<li>User-defined functions</li>\n" +
                "</ul>\n" +
                "\n" +
                "<hr /><h3><a id=\"standard-library\" name=\"standard-library\"></a>Kotlin Standard Library Function</h3>\n" +
                "\n" +
                "<p>The standard library functions are built-in functions in Kotlin that are readily available for use. For example,</p>\n" +
                "\n" +
                "<ul>\n" +
                "\t<li><code>print()</code> is a library function that prints message to the standard output stream (monitor).</li>\n" +
                "\t<li><code>sqrt()</code> returns square root of a number (<code>Double</code> value)</li>\n" +
                "</ul>\n" +
                "\n" +
                "<pre>\n" +
                "<code>fun main(args: Array&lt;String&gt;) {\n" +
                "\n" +
                "    var number = 5.5\n" +
                "    print(&quot;Result = \${Math.sqrt(number)}&quot;)\n" +
                "}</code></pre>\n" +
                "\n" +
                "<p>When you run the program, the output will be:</p>\n" +
                "\n" +
                "<pre>\n" +
                "<samp>Result = 2.345207879911715</samp></pre>\n" +
                "\n" +
                "<p>Here is a link to the <a href=\"https://kotlinlang.org/api/latest/jvm/stdlib/\" title=\"Kotlin Standard Library\">Kotlin Standard Library</a> for you to explore.</p>\n" +
                "\n" +
                "<hr />\n" +
                "<h3><a id=\"user-defined\" name=\"user-defined\"></a>User-defined Functions</h3>\n" +
                "\n" +
                "<p>As mentioned, you can create functions yourself. Such functions are called user-defined functions.</p>\n" +
                "\n" +
                "<hr />\n" +
                "<h3><a id=\"create-user-defined\" name=\"create-user-defined\"></a>How to create a user-defined function in Kotlin?</h3>\n" +
                "\n" +
                "<p>Before you can use (call) a function, you need to define it.</p>\n" +
                "\n" +
                "<p>Here&#39;s how you can define a function in Kotlin:</p>\n" +
                "\n" +
                "<pre>\n" +
                "fun callMe() {\n" +
                "    // function body\n" +
                "}\n" +
                "</pre>\n" +
                "\n" +
                "<p>To define a function in Kotlin, <code>fun</code> keyword is used. Then comes the name of the function (<a href=\"/kotlin-programming/keywords-identifiers#identifiers\" title=\"Kotlin identifiers\">identifier</a>). Here, the name of the function is <var>callMe</var>.</p>\n" +
                "\n" +
                "<p>In the above program, the parenthesis <code>( )</code> is empty. It means, this function doesn&#39;t accept any argument. You will learn about arguments later in this article.</p>\n" +
                "\n" +
                "<p>The codes inside curly braces <code>{ }</code> is the body of the function.</p>\n" +
                "\n" +
                "<hr />\n" +
                "<h3><a id=\"call-function\" name=\"call-function\"></a>How to call a function?</h3>\n" +
                "\n" +
                "<p>You have to call the function to run codes inside the body of the function. Here&#39;s how:</p>\n" +
                "\n" +
                "<pre>\n" +
                "callme()</pre>\n" +
                "\n" +
                "<p>This statement calls the <code>callMe()</code> function declared earlier.</p>\n" +
                "\n" +
                "\n" +
                "<hr />\n" +
                "<h3><a id=\"example-1\" name=\"example-1\"></a>Example: Simple Function Program</h3>\n" +
                "\n" +
                "<pre>\n" +
                "<code>fun callMe() {\n" +
                "    println(&quot;Printing from callMe() function.&quot;)\n" +
                "    println(&quot;This is cool (still printing from inside).&quot;)\n" +
                "}\n" +
                "\n" +
                "fun main(args: Array&lt;String&gt;) {\n" +
                "    callMe()\n" +
                "    println(&quot;Printing outside from callMe() function.&quot;)\n" +
                "}</code></pre>\n" +
                "\n" +
                "<p>When you run the program, the output will be:</p>\n" +
                "\n" +
                "<pre>\n" +
                "<samp>Printing from callMe() function.\n" +
                "This is cool (still printing from inside).\n" +
                "Printing outside from callMe() function.</samp></pre>\n" +
                "\n" +
                "<p>The <code>callMe()</code> function in the above code doesn&#39;t accept any argument.</p>\n" +
                "\n" +
                "<p>Also, the function doesn&#39;t return any value (return type is <code>Unit</code>).</p>\n" +
                "\n" +
                "<p><div  id=\"block-inject-1\" class=\"block-inject block-inject-1\"><div id=\"block-block-123\" class=\"block block-block\">\n" +
                "\n" +
                "    \n" +
                "  <div class=\"content\">\n" +
                "    <!-- /8095840/.2_A.34657.4_Programiz.com_tier1 -->\n" +
                "<div id='div-gpt-ad-1527670353707-0'>\n" +
                "<script>\n" +
                "if (window.innerWidth < 900) {\n" +
                "          googletag.cmd.push(function() { googletag.display('div-gpt-ad-1527670353707-0'); });\n" +
                "      }\n" +
                "</script>\n" +
                "</div>\n" +
                "\n" +
                "<!-- /8095840/.2_A.34660.4_Programiz.com_tier1 -->\n" +
                "<div id='div-gpt-ad-1527670429257-0'>\n" +
                "<script>\n" +
                "if (window.innerWidth >= 900) {\n" +
                "    googletag.cmd.push(function() { googletag.display('div-gpt-ad-1527670429257-0'); });\n" +
                "}\n" +
                "</script>\n" +
                "</div>  </div>\n" +
                "</div>\n" +
                "</div><div class=\"clearfix\"></div><p>Let&#39;s take another function example. This function will accept arguments and also returns a value.</p>\n" +
                "\n" +
                "<hr /><h3><a id=\"argument-return-value\" name=\"argument-return-value\"></a>How functions with arguments and return value work?</h3>\n" +
                "\n" +
                "<p>Here, two arguments <var>number1</var> and <var>number2</var> of type <code>Double</code> are passed to the <code>addNumbers()</code> function during function call. These arguments are called actual arguments.</p>\n" +
                "\n" +
                "<pre>\n" +
                "result = addNumbers(number1, number2)</pre>\n" +
                "\n" +
                "<p>The parameters <var>n1</var> and <var>n2</var> accepts the passed arguments (in the function definition). These arguments are called formal arguments (or parameters).</p>\n" +
                "\n" +
                "<p><img alt=\"Passing arguments to a function in Kotlin\" src=\"//cdn.programiz.com/sites/tutorial2program/files/passing-arguments-function-kotlin.jpg\" /></p>\n" +
                "\n" +
                "<p>In Kotlin, arguments are separated using commas. Also, the type of the formal argument must be explicitly typed.</p>\n" +
                "\n" +
                "<p>Note that, the data type of actual and formal arguments should match, i.e., the data type of first actual argument should match the type of first formal argument. Similarly, the type of second actual argument must match the type of second formal argument and so on.</p>\n" +
                "\n" +
                "<hr />\n" +
                "<p>Here,</p>\n" +
                "\n" +
                "<pre>\n" +
                "return sumInteger</pre>\n" +
                "\n" +
                "<p>is the return statement. This code terminates the <code>addNumbers()</code> function, and control of the program jumps to the <code>main()</code> function.</p>\n" +
                "\n" +
                "<p>In the program, <var>sumInteger</var> is returned from <code>addNumbers()</code> function. This value is assigned to the variable <var>result</var>.</p>\n" +
                "\n" +
                "<p><img alt=\"Return value from a function in Kotlin\" src=\"//cdn.programiz.com/sites/tutorial2program/files/return-value-function-kotlin.jpg\" /></p>\n" +
                "\n" +
                "<p>Notice,</p>\n" +
                "\n" +
                "<ul>\n" +
                "\t<li>both <var>sumInteger</var> and <var>result</var> are of type <code>Int</code>.</li>\n" +
                "\t<li>the return type of the function is specified in the function definition.\n" +
                "\t\t<pre>\n" +
                "// return type is Int\n" +
                "fun addNumbers(n1: Double, n2: Double): Int {\n" +
                "    ... .. ...\n" +
                "}</pre>\n" +
                "\t</li>\n" +
                "</ul>\n" +
                "\n" +
                "<p>If the function doesn&#39;t return any value, its return type is <code>Unit</code>. It is optional to specify the return type in the function definition if the return type is <code>Unit</code>.</p>\n" +
                "\n" +
                "<hr />Read the full tutorial about kotlin <a href=\\\"https://www.programiz.com/kotlin-programming#tutorial\\\" title=\\\"Java Keywords and Identifiers\\\">here</a>"
        webView.loadDataWithBaseURL(null, htmlAsString, "text/html", "utf-8", null);
        return v
    }


}
