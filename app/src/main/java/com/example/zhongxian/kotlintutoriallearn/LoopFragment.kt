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


class LoopFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val v = inflater.inflate(R.layout.fragment_loop, container, false)
        val webView = v.findViewById<View>(R.id.webView_loop) as WebView
        var htmlAsString  = "<style>\n" +
                "pre {background-color:#aaa}\n" +
                "code {background-color:#aaa}\n" +
                "</style>\n<h1>Kotlin while and do...while Loop</h1><p>Loop is used in programming to repeat a specific block of code until certain condition is met (test expression is <code>false)</code>.</p>\n" +
                "\n" +
                "<p>Loops are what makes computers interesting machines. Imagine you need to print a sentence 50 times on your screen. Well, you can do it by using print statement 50 times (without using loops). How about you need to print a sentence one million times? You need to use loops.</p>\n" +
                "\n" +
                "<p>You will learn about two loops <code>while</code> and <code>do..while</code> in this article with the help of examples.</p>\n" +
                "\n" +
                "<p>If you are familiar with <a href=\"/java-programming/do-while-loop\" title=\"Java while and do...while Loop\">while and do...while loops in Java</a>, you are already familiar with these loops in Kotlin as well.</p>\n" +
                "\n" +
                "<hr />\n" +
                "<h2><a id=\"while-loop\" name=\"while-loop\"></a>Kotlin while Loop</h2>\n" +
                "\n" +
                "<p>The syntax of <code>while</code> loop is:</p>\n" +
                "\n" +
                "<pre>\n" +
                "while (testExpression) {\n" +
                "    // codes inside body of while loop\n" +
                "}</pre>\n" +
                "\n" +
                "<hr />\n" +
                "<h3><a id=\"syntax-while\" name=\"syntax-while\"></a>How while loop works?</h3>\n" +
                "\n" +
                "<p>The test expression inside the parenthesis is a <a href=\"/kotlin-programming/variable-types#boolean\" title=\"Kotlin Boolean type\">Boolean</a> expression.</p>\n" +
                "\n" +
                "<p>If the test expression is evaluated to <code>true</code>,</p>\n" +
                "\n" +
                "<ul>\n" +
                "\t<li>statements inside the while loop are executed.</li>\n" +
                "\t<li>then, the test expression is evaluated again.</li>\n" +
                "</ul>\n" +
                "\n" +
                "<p>This process goes on until the test expression is evaluated to <code>false</code>.</p>\n" +
                "\n" +
                "<p>If the test expression is evaluated to <code>false</code>,</p>\n" +
                "\n" +
                "<ul>\n" +
                "\t<li>while loop is terminated.</li>\n" +
                "</ul>\n" +
                "\n" +
                "<hr />\n" +
                "<h3><a id=\"example-while\" name=\"example-while\"></a>Example: Kotlin while Loop</h3>\n" +
                "\n" +
                "<pre>\n" +
                "// Program to print line 5 times\n" +
                "\n" +
                "<code>fun main(args: Array&lt;String&gt;) {\n" +
                "\n" +
                "    var i = 1\n" +
                "\n" +
                "    while (i &lt;= 5) {\n" +
                "        println(&quot;Line \$i&quot;)\n" +
                "        ++i\n" +
                "    }\n" +
                "}</code></pre>\n" +
                "\n" +
                "<p>When you run the program, the output will be:</p>\n" +
                "\n" +
                "<pre>\n" +
                "<samp>Line 1\n" +
                "Line 2\n" +
                "Line 3\n" +
                "Line 4\n" +
                "Line 5</samp></pre>\n" +
                "\n" +
                "<p>Notice, <code>++i</code> statement inside the <code>while</code> loop. After 5 iterations, variable <var>i</var> will be incremented to 6. Then, the test expression <code>i &lt;= 5</code> is evaluated to <code>false</code> and the loop terminates.</p>\n" +
                "\n"  +
                "<p>If the body of loop has only one statement, it&#39;s not necessary to use curly braces <code>{ }</code>.&nbsp;</p>\n" +
                "\n" +
                "<hr />\n" +
                "<h3>Example: Compute sum of Natural Numbers</h3>\n" +
                "\n" +
                "<pre>\n" +
                "<code>// Program to compute the sum of natural numbers from 1 to 100.\n" +
                "fun main(args: Array&lt;String&gt;) {\n" +
                "\n" +
                "    var sum = 0\n" +
                "    var i = 100\n" +
                "\n" +
                "    while (i != 0) {\n" +
                "        sum += i     // sum = sum + i;\n" +
                "        --i\n" +
                "    }\n" +
                "    println(&quot;sum = \$sum&quot;)\n" +
                "}</code></pre>\n" +
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
                "</div><div class=\"clearfix\"></div><p>When you run the program, the output will be:</p>\n" +
                "\n" +
                "<pre>\n" +
                "<samp>sum = 5050</samp></pre>\n" +
                "\n" +
                "<p>Here, the variable <var>sum</var> is initialized to 0 and <var>i</var> is initialized to 100. In each iteration of while loop, variable <var>sum</var> is assigned <code>sum + i</code>, and the value of <var>i</var> is decreased by 1 until <var>i</var> is equal to 0. For better visualization,</p>\n" +
                "\n" +
                "<pre>\n" +
                "1st iteration: sum = 0+100 = 100, i = 99\n" +
                "2nd iteration: sum = 100+99 = 199, i = 98\n" +
                "3rd iteration: sum = 199+98 = 297, i = 97\n" +
                "... .. ...\n" +
                "... .. ...\n" +
                "99th iteration: sum = 5047+2 = 5049, i = 1\n" +
                "100th iteration: sum = 5049+1 = 5050, i = 0 (then loop terminates)</pre>\n" +
                "\n" +
                "<p>To learn more about test expression and how it is evaluated, visit <a href=\"/kotlin-programming/operators#comparison-equality\" title=\"Kotlin comparison Operators\">comparison</a> and <a href=\"/kotlin-programming/operators#logical\" title=\"Kotlin Logical Operators\">logical operators</a>.</p>\n" +
                "\n" +
                "<hr />\n" +
                "<h2><a id=\"do-while-loop\" name=\"do-while-loop\"></a>Kotlin do...while Loop</h2>\n" +
                "\n" +
                "<p>The <code>do...while</code> loop is similar to <code>while</code> loop with one key difference. The body of <code>do...while</code> loop is executed once&nbsp;before the test expression is checked.</p>\n" +
                "\n" +
                "<p>Its syntax is:</p>\n" +
                "\n" +
                "<pre>\n" +
                "do {\n" +
                "   // codes inside body of do while loop\n" +
                "} while (testExpression);</pre>\n" +
                "\n" +
                "<hr />\n" +
                "<h3><a id=\"do-while-syntax\" name=\"do-while-syntax\"></a>How do...while loop works?</h3>\n" +
                "\n" +
                "<p>The codes inside the body of <code>do</code> construct is executed once (without checking the <var>testExpression</var>). Then, the test expression is checked.</p>\n" +
                "\n" +
                "<p>If the test expression is evaluated to <code>true</code>, codes inside the body of the loop are executed, and test expression is evaluated again. This process goes on until the test expression is evaluated to <code>false</code>.</p>\n" +
                "\n" +
                "<p>When the test expression is evaluated to <code>false</code>, <code>do..while</code> loop terminates.</p>\n" +
                "\n" +
                "<hr />\n" +
                "<h3><a id=\"do-while-example\" name=\"do-while-example\"></a>Example: Kotlin do...while Loop</h3>\n" +
                "\n" +
                "<p>The program below calculates the sum of numbers entered by the user until user enters 0.</p>\n" +
                "\n" +
                "<p>To take input from the user, <code>readline()</code> function is used. <strong>Recommended Reading:</strong> <a href=\"/kotlin-programming/input-output#input\">Kotlin Basic Input</a></p>\n" +
                "\n" +
                "<pre>\n" +
                "<code>fun main(args: Array&lt;String&gt;) {\n" +
                "\n" +
                "    var sum: Int = 0\n" +
                "    var input: String\n" +
                "\n" +
                "    do {\n" +
                "        print(&quot;Enter an integer: &quot;)\n" +
                "        input = readLine()!!\n" +
                "        sum += input.toInt()\n" +
                "\n" +
                "    } while (input != &quot;0&quot;)\n" +
                "\n" +
                "    println(&quot;sum = \$sum&quot;)\n" +
                "}</code></pre>\n" +
                "\n" +
                "<p>When you run the program, the output will be something like:</p>\n" +
                "\n" +
                "<pre>\n" +
                "<samp>Enter an integer: 4\n" +
                "Enter an integer: 3\n" +
                "Enter an integer: 2\n" +
                "Enter an integer: -6\n" +
                "Enter an integer: 0\n" +
                "sum = 3</samp>\n" +
                "</pre>" +
                "<hr />Read the full tutorial about kotlin <a href=\\\"https://www.programiz.com/kotlin-programming#tutorial\\\" title=\\\"Java Keywords and Identifiers\\\">here</a>"
        webView.loadDataWithBaseURL(null, htmlAsString, "text/html", "utf-8", null);
        return v
    }


}
