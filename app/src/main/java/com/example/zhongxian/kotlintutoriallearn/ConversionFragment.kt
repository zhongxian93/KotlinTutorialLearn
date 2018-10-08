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
class ConversionFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_conversion, container, false)
        val webView = v.findViewById<View>(R.id.webView) as WebView
        var htmlAsString  = "<div id=\"main-wrapper-two-column\" class=\"clearfix\">\n" +
                "\t<div class=\"clearfix\">\n" +
                "\t<div id=\"programiz-main-content\">\n" +
                "\t<section class=\"main-content\">\n" +
                "\t<h1>Kotlin Type Conversion</h1>\n" +
                "\t<p >\n" +
                "\tIn this article, you will learn about type conversion; how to convert a variable of one type to another with the help of example.</p>\n" +
                "\t<p>In Java,</p>\n" +
                "\t\n" +
                "\t<pre style=\"background-color:#aaa\">int number1 = 55;<br/>long number2 = number1;    // Valid code </pre>\n" +
                "\t\n" +
                "\t<p>Here, value of <code style=\"background-color:#aaa\">number1</code>&nbsp;of type&nbsp;<code style=\"background-color:#aaa\">int</code>&nbsp;is automatically converted to type <code style=\"background-color:#aaa\">long</code>, and assigned to variable <var>number2</var>.</p>\n" +
                "\t\n" +
                "\t<p>In Kotlin,</p>\n" +
                "\t\n" +
                "\t<pre style=\"background-color:#aaa\">val number1: Int = 55<br/>" +
                "val number2: Long = number1   // Error: type mismatch.</pre>\n" +
                "\t\n" +
                "\t<p>Though the size of <tt>Long</tt> is larger than <code style=\"background-color:#aaa\">Int</code>, Kotlin doesn't automatically convert <var>Int</var> to <var>Long</var>.&nbsp;</p>\n" +
                "\t<p>Instead, you need to use<code style=\"background-color:#aaa\">&nbsp;toLong()</code>&nbsp;explicitly&nbsp;(to convert to type&nbsp;<var>Long</var>). Kotlin does it for type safety to avoid surprises.</p>\n" +
                "\t<pre style=\"background-color:#aaa\">val number1: Int = 55<br/>val number2: Long = number1.toLong()</pre>\n" +
                "\t<hr>\n" +
                "\t<p></p><div id=\"block-inject-1\" class=\"block-inject block-inject-1\"><div id=\"block-block-123\" class=\"block block-block\">\n" +
                "\t<ul>\n" +
                "\t\t<li><a href=\"https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/to-byte.html\"><code style=\"background-color:#aaa\">toByte()</code></a>&nbsp;</li>\n" +
                "\t\t<li><a href=\"https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/to-short.html\"><code style=\"background-color:#aaa\">toShort()</code></a></li>\n" +
                "\t\t<li><a href=\"https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/to-int.html\"><code style=\"background-color:#aaa\">toInt()</code></a></li>\n" +
                "\t\t<li><a href=\"https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/to-long.html\"><code style=\"background-color:#aaa\">toLong()</code></a></li>\n" +
                "\t\t<li><a href=\"https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/to-float.html\"><code style=\"background-color:#aaa\">toFloat()</code></a></li>\n" +
                "\t\t<li><a href=\"https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/to-double.html\"><code style=\"background-color:#aaa\">toDouble()</code></a></li>\n" +
                "\t\t<li><a href=\"https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/to-char.html\"><code style=\"background-color:#aaa\">toChar()</code></a></li>\n" +
                "\t</ul>\n" +
                "\t\n" +
                "\t<p>Note, there is no conversion for <code style=\"background-color:#aaa\">Boolean</code> types.</p>\n" +
                "\t\n" +
                "\t<hr>\n" +
                "\t<h3><a id=\"larger-smaller\" name=\"larger-smaller\"></a>Conversion from Larger to Smaller Type</h3>\n" +
                "\t\n" +
                "\t<p>The functions mentioned above can be used in both directions (conversion from larger to smaller type and conversion from smaller to larger type).</p>\n" +
                "\t\n" +
                "\t<p>However, conversion from larger to smaller type may truncate the value. For example,</p>\n" +
                "\t\n" +
                "\t<pre class=\"prettyprint prettyprinted\" style=\"\"><span class=\"pln\">fun main</span><span class=\"pun\">(</span><span class=\"pln\">args </span><span class=\"pun\">:</span><span class=\"pln\"> </span><span class=\"typ\">Array</span><span class=\"pun\">&lt;</span><span class=\"typ\">String</span><span class=\"pun\">&gt;)</span><span class=\"pln\"> </span><span class=\"pun\">{</span><span class=\"pln\">\n" +
                "\t\tval number1</span><span class=\"pun\">:</span><span class=\"pln\"> </span><span class=\"typ\">Int</span><span class=\"pln\"> </span><span class=\"pun\">=</span><span class=\"pln\"> </span><span class=\"lit\">545344</span><span class=\"pln\">\n" +
                "\t\tval number2</span><span class=\"pun\">:</span><span class=\"pln\"> </span><span class=\"typ\">Byte</span><span class=\"pln\"> </span><span class=\"pun\">=</span><span class=\"pln\"> number1</span><span class=\"pun\">.</span><span class=\"pln\">toByte</span><span class=\"pun\">()</span><span class=\"pln\">\n" +
                "\t\tprintln</span><span class=\"pun\">(</span><span class=\"str\">\"number1 = number1\"</span><span class=\"pun\">)</span><span class=\"pln\">\n" +
                "\t\tprintln</span><span class=\"pun\">(</span><span class=\"str\">\"number2 = number2\"</span><span class=\"pun\">)</span><span class=\"pln\">\n" +
                "\t</span><span class=\"pun\">}</span></pre>\n" +
                "\t\n" +
                "\t<p>When you run the program, the output will be:</p>\n" +
                "\t\n" +
                "\t<pre style=\"background-color:#aaa\"><samp>number1 = 545344\n" +
                "number2 = 64</samp></pre>\n" +
                "\t\n" +
                "\t<hr>\n" +
                "\t</div>\n" +
                "\t</div>\n" +
                "\t</section>\n" +
                "\t</div>\n" +
                "\n" +
                "\t</div>\n" +
                "\t</div>"+
                "<hr>"+"Read the full tutorial about kotlin <a href=\"https://www.programiz.com/kotlin-programming#tutorial\" title=\"Java Keywords and Identifiers\">here</a>"
        webView.loadDataWithBaseURL(null, htmlAsString, "text/html", "utf-8", null);
        return v
    }


}
