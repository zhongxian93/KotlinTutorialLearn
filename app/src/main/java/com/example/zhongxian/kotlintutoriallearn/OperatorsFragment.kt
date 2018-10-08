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
class OperatorsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_operators, container, false)
        val webView = v.findViewById<View>(R.id.webView) as WebView
        var htmlAsString  = "<h1>Kotlin Operators</h1>"+
                "<p>Kotlin has a set of operators to perform arithmetic, assignment, comparison operators and more. You will learn to use these operators in this article.</p>"+
                "<hr>" +
                "<h2><a id=\"arithmetic\" name=\"arithmetic\"></a>1. Arithmetic Operators</h2>"+
                "<p>Here's a list of arithmetic operators in Kotlin:</p>" +
                "" +
                "<table>" +
                "\t<caption>Kotlin Arithmetic Operators</caption>" +
                "\t<thead>" +
                "\t\t<tr>" +
                "\t\t\t<th scope=\"col\">Operator</th>" +
                "\t\t\t<th scope=\"col\">Meaning</th>" +
                "\t\t</tr>" +
                "\t</thead>" +
                "\t<tbody>" +
                "\t\t<tr>" +
                "\t\t\t<td>+</td>" +
                "\t\t\t<td>Addition (also used for string concatenation)</td>" +
                "\t\t</tr>" +
                "\t\t<tr>" +
                "\t\t\t<td>-</td>" +
                "\t\t\t<td>Subtraction Operator</td>" +
                "\t\t</tr>" +
                "\t\t<tr>" +
                "\t\t\t<td>*</td>" +
                "\t\t\t<td>Multiplication Operator</td>" +
                "\t\t</tr>" +
                "\t\t<tr>" +
                "\t\t\t<td>/</td>" +
                "\t\t\t<td>Division Operator</td>" +
                "\t\t</tr>" +
                "\t\t<tr>" +
                "\t\t\t<td>%</td>" +
                "\t\t\t<td>Modulus Operator</td>" +
                "\t\t</tr>" +
                "\t</tbody>" +
                "</table>"+
                "<hr>" +
                "<h3><a id=\"arithmetic-example\" name=\"arithmetic-example\"></a>Example: Arithmetic Operators</h3>" +
                "" +
                "<pre style=\"background-color:#aaa\"><code style=\"background-color:#aaa\"><span class=\"pln\">fun main</span><span class=\"pun\">(</span><span class=\"pln\">args</span><span class=\"pun\">:</span><span class=\"pln\"> </span><span class=\"typ\">Array</span><span class=\"pun\">&lt;</span><span class=\"typ\">String</span><span class=\"pun\">&gt;)</span><span class=\"pln\"> </span><span class=\"pun\">{</span><span class=\"pln\">" +
                "" +
                "    val number1 </span><span class=\"pun\">=</span><span class=\"pln\"> </span><span class=\"lit\">12.5</span><span class=\"pln\">" +
                "    val number2 </span><span class=\"pun\">=</span><span class=\"pln\"> </span><span class=\"lit\">3.5</span><span class=\"pln\">" +
                "    </span><span class=\"kwd\">var</span><span class=\"pln\"> result</span><span class=\"pun\">:</span><span class=\"pln\"> </span><span class=\"typ\">Double</span><span class=\"pln\">" +
                "    result </span><span class=\"pun\">=</span><span class=\"pln\"> number1 </span><span class=\"pun\">+</span><span class=\"pln\"> number2" +
                "    println</span><span class=\"pun\">(</span><span class=\"str\">\"number1 + number2 = result\"</span><span class=\"pun\">)</span><span class=\"pln\">" +
                "" +
                "    result </span><span class=\"pun\">=</span><span class=\"pln\"> number1 </span><span class=\"pun\">-</span><span class=\"pln\"> number2" +
                "    println</span><span class=\"pun\">(</span><span class=\"str\">\"number1 - number2 = result\"</span><span class=\"pun\">)</span><span class=\"pln\">" +
                "" +
                "    result </span><span class=\"pun\">=</span><span class=\"pln\"> number1 </span><span class=\"pun\">*</span><span class=\"pln\"> number2" +
                "    println</span><span class=\"pun\">(</span><span class=\"str\">\"number1 * number2 = result\"</span><span class=\"pun\">)</span><span class=\"pln\">" +
                "" +
                "    result </span><span class=\"pun\">=</span><span class=\"pln\"> number1 </span><span class=\"pun\">/</span><span class=\"pln\"> number2" +
                "    println</span><span class=\"pun\">(</span><span class=\"str\">\"number1 / number2 = result\"</span><span class=\"pun\">)</span><span class=\"pln\">" +
                "" +
                "    result </span><span class=\"pun\">=</span><span class=\"pln\"> number1 </span><span class=\"pun\">%</span><span class=\"pln\"> number2" +
                "    println</span><span class=\"pun\">(</span><span class=\"str\">\"number1 % number2 = result\"</span><span class=\"pun\">)</span><span class=\"pln\">" +
                "</span><span class=\"pun\">}</span></code>" +
                "</pre>"+
                "<p>When you run the program, the output will be:</p>"+
                "<pre style=\"background-color:#aaa\"><samp>number1 + number2 = 16.0" +
                "number1 - number2 = 9.0" +
                "number1 * number2 = 43.75" +
                "number1 / number2 = 3.5714285714285716" +
                "number1 % number2 = 2.0</samp></pre>" +
                "" +
                "<p>The <code style=\"background-color:#aaa\">+</code> operator is also used for the concatenation of <code style=\"background-color:#aaa\">String</code> values.</p>" +
                "" +
                "<hr>"+
                "<h3>Example: Concatenation of Strings</h3>" +
                "" +
                "<pre style=\"background-color:#aaa\"><code style=\"background-color:#aaa\"><span class=\"pln\">fun main</span><span class=\"pun\">(</span><span class=\"pln\">args</span><span class=\"pun\">:</span><span class=\"pln\"> </span><span class=\"typ\">Array</span><span class=\"pun\">&lt;</span><span class=\"typ\">String</span><span class=\"pun\">&gt;)</span><span class=\"pln\"> </span><span class=\"pun\">{</span><span class=\"pln\">" +
                "" +
                "    val start </span><span class=\"pun\">=</span><span class=\"pln\"> </span><span class=\"str\">\"Talk is cheap. \"</span><span class=\"pln\">" +
                "    val middle </span><span class=\"pun\">=</span><span class=\"pln\"> </span><span class=\"str\">\"Show me the code. \"</span><span class=\"pln\">" +
                "    val </span><span class=\"kwd\">end</span><span class=\"pln\"> </span><span class=\"pun\">=</span><span class=\"pln\"> </span><span class=\"str\">\"- Linus Torvalds\"</span><span class=\"pln\">" +
                "" +
                "    val result </span><span class=\"pun\">=</span><span class=\"pln\"> start </span><span class=\"pun\">+</span><span class=\"pln\"> middle </span><span class=\"pun\">+</span><span class=\"pln\"> </span><span class=\"kwd\">end</span><span class=\"pln\">" +
                "    println</span><span class=\"pun\">(</span><span class=\"pln\">result</span><span class=\"pun\">)</span><span class=\"pln\">" +
                "</span><span class=\"pun\">}</span></code></pre>" +
                "" +
                "<p>When you run the program, the output will be:</p>" +
                "" +
                "<pre style=\"background-color:#aaa\"><samp>Talk is cheap. Show me the code. - Linus Torvalds</samp></pre>" +
                "" +
                "<hr>" +
                "<h3><a id=\"arithmetic-work\" name=\"arithmetic-work\"></a>How arithmetic operators actually work?</h3>" +
                "" +
                "<p>Suppose, you are using <code style=\"background-color:#aaa\">+</code> arithmetic operator to add two numbers <var>a</var> and <var>b</var>.</p>" +
                "" +
                "<p>Under the hood, the expression <code style=\"background-color:#aaa\">a + b</code> calls <code style=\"background-color:#aaa\">a.plus(b)</code> member function. The <code style=\"background-color:#aaa\">plus</code> operator is overloaded to work with <code style=\"background-color:#aaa\">String</code> values and other basic data types (except <a href=\"https://www.programiz.com/kotlin-programming/variable-types#char\" title=\"Kotlin Char Type\">Char</a> and <a href=\"/https://www.programiz.com/kotlin-programming/variable-types#boolean\" title=\"Kotlin Boolean Type\">Boolean</a>).</p>" +
                "" +
                "<pre style=\"background-color:#aaa\">// + operator for basic types" +
                "operator fun plus(other: Byte): Int" +
                "operator fun plus(other: Short): Int" +
                "operator fun plus(other: Int): Int" +
                "operator fun plus(other: Long): Long" +
                "operator fun plus(other: Float): Float" +
                "operator fun plus(other: Double): Double" +
                "" +
                "// for string concatenation" +
                "operator fun String?.plus(other: Any?): String" +
                "</pre>" +
                "" +
                "<p>You can also use <code style=\"background-color:#aaa\">+</code> operator to work with user-defined types (like objects) by overloading <code style=\"background-color:#aaa\">plus()</code> function.</p>" +
                "" +
                "<p><strong>Recommended Reading:</strong> <a href=\"https://www.programiz.com/kotlin-programming/operator-overloading\" title=\"Kotlin Operator Overloading\">Kotlin Operator Overloading</a></p>" +
                "" +
                "<p>Here's a table of arithmetic operators and their corresponding functions:</p>" +
                "" +
                "<table cellspacing=\"1\" cellpadding=\"1\" border=\"1\">" +
                "\t<thead>" +
                "\t\t<tr>" +
                "\t\t\t<th scope=\"col\">Expression</th>" +
                "\t\t\t<th scope=\"col\">Function name</th>" +
                "\t\t\t<th scope=\"col\">Translates to</th>" +
                "\t\t</tr>" +
                "\t</thead>" +
                "\t<tbody>" +
                "\t\t<tr>" +
                "\t\t\t<td>a + b</td>" +
                "\t\t\t<td>plus</td>" +
                "\t\t\t<td>a.plus(b)</td>" +
                "\t\t</tr>" +
                "\t\t<tr>" +
                "\t\t\t<td>a - b</td>" +
                "\t\t\t<td>minus</td>" +
                "\t\t\t<td>a.minus(b)</td>" +
                "\t\t</tr>" +
                "\t\t<tr>" +
                "\t\t\t<td>a * b</td>" +
                "\t\t\t<td>times</td>" +
                "\t\t\t<td>a.times(b)</td>" +
                "\t\t</tr>" +
                "\t\t<tr>" +
                "\t\t\t<td>a / b</td>" +
                "\t\t\t<td>div</td>" +
                "\t\t\t<td>a.div(b)</td>" +
                "\t\t</tr>" +
                "\t\t<tr>" +
                "\t\t\t<td>a % b</td>" +
                "\t\t\t<td>mod</td>" +
                "\t\t\t<td>a.mod(b)</td>" +
                "\t\t</tr>" +
                "\t</tbody>" +
                "</table>" +
                "" +
                "<hr>" +
                "<h2><a id=\"assignment\" name=\"assignment\"></a>2. Assignment Operators</h2>" +
                "" +
                "<p>Assignment operators are used to assign value to a variable. We have already used simple assignment operator <code style=\"background-color:#aaa\">=</code> before.</p>" +
                "" +
                "<pre style=\"background-color:#aaa\">val age = 5</pre>" +
                "" +
                "<p>Here, 5 is assigned to variable <var>age</var> using <code style=\"background-color:#aaa\">=</code> operator.</p>" +
                "" +
                "<p>Here's a list of all assignment operators and their corresponding functions:</p>"+
                "<table cellspacing=\"1\" cellpadding=\"1\" border=\"1\">" +
                "\t<thead>" +
                "\t\t<tr>" +
                "\t\t\t<th scope=\"col\">Expression</th>" +
                "\t\t\t<th scope=\"col\">Equivalent to</th>" +
                "\t\t\t<th scope=\"col\">Translates to</th>" +
                "\t\t</tr>" +
                "\t</thead>" +
                "\t<tbody>" +
                "\t\t<tr>" +
                "\t\t\t<td>a +=b</td>" +
                "\t\t\t<td>a = a + b</td>" +
                "\t\t\t<td>a.plusAssign(b)</td>" +
                "\t\t</tr>" +
                "\t\t<tr>" +
                "\t\t\t<td>a -= b</td>" +
                "\t\t\t<td>a = a - b</td>" +
                "\t\t\t<td>a.minusAssign(b)</td>" +
                "\t\t</tr>" +
                "\t\t<tr>" +
                "\t\t\t<td>a *= b</td>" +
                "\t\t\t<td>a = a * b</td>" +
                "\t\t\t<td>a.timesAssign(b)</td>" +
                "\t\t</tr>" +
                "\t\t<tr>" +
                "\t\t\t<td>a /= b</td>" +
                "\t\t\t<td>a = a / b</td>" +
                "\t\t\t<td>a.divAssign(b)</td>" +
                "\t\t</tr>" +
                "\t\t<tr>" +
                "\t\t\t<td>a %= b</td>" +
                "\t\t\t<td>a = a % b</td>" +
                "\t\t\t<td>a.modAssign(b)</td>" +
                "\t\t</tr>" +
                "\t</tbody>" +
                "</table>"+
                "<hr>" +
                "<h3><a id=\"assignment-example\" name=\"assignment-example\"></a>Example: Assignment Operators</h3>" +
                "" +
                "<pre style=\"background-color:#aaa\"><code style=\"background-color:#aaa\"><span class=\"pln\">fun main</span><span class=\"pun\">(</span><span class=\"pln\">args</span><span class=\"pun\">:</span><span class=\"pln\"> </span><span class=\"typ\">Array</span><span class=\"pun\">&lt;</span><span class=\"typ\">String</span><span class=\"pun\">&gt;)</span><span class=\"pln\"> </span><span class=\"pun\">{</span><span class=\"pln\">" +
                "    </span><span class=\"kwd\">var</span><span class=\"pln\"> number </span><span class=\"pun\">=</span><span class=\"pln\"> </span><span class=\"lit\">12</span><span class=\"pln\">" +
                "" +
                "    number </span><span class=\"pun\">*=</span><span class=\"pln\"> </span><span class=\"lit\">5</span><span class=\"pln\">   </span><span class=\"com\">// number = number*5</span><span class=\"pln\">" +
                "    println</span><span class=\"pun\">(</span><span class=\"str\">\"number  = number\"</span><span class=\"pun\">)</span><span class=\"pln\">" +
                "</span><span class=\"pun\">}</span></code></pre>" +
                "" +
                "<p>When you run the program, the output will be:</p>" +
                "" +
                "<pre style=\"background-color:#aaa\">number = 60</pre>" +
                "" +
                "<p><strong>Recommended Reading:</strong> <em>Overloading assignment operators in Kotlin</em>.</p>" +
                "" +
                "<hr>" +
                "<h2><a id=\"unary\" name=\"unary\"></a>3. Unary prefix and Increment / Decrement Operators</h2>" +
                "" +
                "<p>Here's a table of unary operators, their meaning, and corresponding functions:</p>" +
                "" +
                "<table cellspacing=\"1\" cellpadding=\"1\" border=\"1\">" +
                "\t<thead>" +
                "\t\t<tr>" +
                "\t\t\t<th scope=\"col\">Operator</th>" +
                "\t\t\t<th scope=\"col\">Meaning</th>" +
                "\t\t\t<th scope=\"col\">Expression</th>" +
                "\t\t\t<th scope=\"col\">Translates to</th>" +
                "\t\t</tr>" +
                "\t</thead>" +
                "\t<tbody>" +
                "\t\t<tr>" +
                "\t\t\t<td>+</td>" +
                "\t\t\t<td>Unary plus</td>" +
                "\t\t\t<td>+a</td>" +
                "\t\t\t<td>a.unaryPlus()</td>" +
                "\t\t</tr>" +
                "\t\t<tr>" +
                "\t\t\t<td>-</td>" +
                "\t\t\t<td>Unary minus (inverts sign)</td>" +
                "\t\t\t<td>-a</td>" +
                "\t\t\t<td>a.unaryMinus()</td>" +
                "\t\t</tr>" +
                "\t\t<tr>" +
                "\t\t\t<td>!</td>" +
                "\t\t\t<td>not (inverts value)</td>" +
                "\t\t\t<td>!a</td>" +
                "\t\t\t<td>a.not()</td>" +
                "\t\t</tr>" +
                "\t\t<tr>" +
                "\t\t\t<td>++</td>" +
                "\t\t\t<td>Increment: increases value by1</td>" +
                "\t\t\t<td>++a</td>" +
                "\t\t\t<td>a.inc()</td>" +
                "\t\t</tr>" +
                "\t\t<tr>" +
                "\t\t\t<td>--</td>" +
                "\t\t\t<td>Decrement: decreases value by 1</td>" +
                "\t\t\t<td>--a</td>" +
                "\t\t\t<td>a.dec()</td>" +
                "\t\t</tr>" +
                "\t</tbody>" +
                "</table>" +
                "" +
                "<hr>" +
                "<h3><a id=\"unary-example\" name=\"unary-example\"></a>Example: Unary Operators</h3>"+
                "" +
                "<pre style=\"background-color:#aaa\"><code style=\"background-color:#aaa\"><span class=\"pln\">fun main</span><span class=\"pun\">(</span><span class=\"pln\">args</span><span class=\"pun\">:</span><span class=\"pln\"> </span><span class=\"typ\">Array</span><span class=\"pun\">&lt;</span><span class=\"typ\">String</span><span class=\"pun\">&gt;)</span><span class=\"pln\"> </span><span class=\"pun\">{</span><span class=\"pln\">" +
                "    val a </span><span class=\"pun\">=</span><span class=\"pln\"> </span><span class=\"lit\">1</span><span class=\"pln\">" +
                "    val b </span><span class=\"pun\">=</span><span class=\"pln\"> </span><span class=\"kwd\">true</span><span class=\"pln\">" +
                "    </span><span class=\"kwd\">var</span><span class=\"pln\"> c </span><span class=\"pun\">=</span><span class=\"pln\"> </span><span class=\"lit\">1</span><span class=\"pln\">" +
                "" +
                "    </span><span class=\"kwd\">var</span><span class=\"pln\"> result</span><span class=\"pun\">:</span><span class=\"pln\"> </span><span class=\"typ\">Int</span><span class=\"pln\">" +
                "    </span><span class=\"kwd\">var</span><span class=\"pln\"> booleanResult</span><span class=\"pun\">:</span><span class=\"pln\"> </span><span class=\"typ\">Boolean</span><span class=\"pln\">" +
                "" +
                "    result </span><span class=\"pun\">=</span><span class=\"pln\"> </span><span class=\"pun\">-</span><span class=\"pln\">a" +
                "    println</span><span class=\"pun\">(</span><span class=\"str\">\"-a = result\"</span><span class=\"pun\">)</span><span class=\"pln\">" +
                "" +
                "    booleanResult </span><span class=\"pun\">=</span><span class=\"pln\"> </span><span class=\"pun\">!</span><span class=\"pln\">b" +
                "    println</span><span class=\"pun\">(</span><span class=\"str\">\"!b = booleanResult\"</span><span class=\"pun\">)</span><span class=\"pln\">" +
                "" +
                "    </span><span class=\"pun\">--</span><span class=\"pln\">c" +
                "    println</span><span class=\"pun\">(</span><span class=\"str\">\"--c = c\"</span><span class=\"pun\">)</span><span class=\"pln\">" +
                "</span><span class=\"pun\">}</span></code></pre>" +
                "" +
                "<p>When you run the program, the output will be:</p>" +
                "" +
                "<pre style=\"background-color:#aaa\"><code style=\"background-color:#aaa\"><span class=\"pun\">-</span><span class=\"pln\">a </span><span class=\"pun\">=</span><span class=\"pln\"> </span><span class=\"pun\">-</span><span class=\"lit\">1</span><span class=\"pln\">" +
                "</span><span class=\"pun\">!</span><span class=\"pln\">b </span><span class=\"pun\">=</span><span class=\"pln\"> </span><span class=\"kwd\">false</span><span class=\"pln\">" +
                "</span><span class=\"pun\">--</span><span class=\"pln\">c </span><span class=\"pun\">=</span><span class=\"pln\"> </span><span class=\"lit\">0</span></code></pre>" +
                "" +
                "<p><strong>Recommended Reading:</strong> <em>Overloading Unary Operators</em></p>" +
                "" +
                "<hr>" +
                "<h2><a id=\"comparison-equality\" name=\"comparison-equality\"></a>4. Comparison and Equality Operators</h2>" +
                "" +
                "<p>Here's a table of equality and comparison operators, their meaning, and corresponding functions:</p>"+
                "" +
                "<table cellspacing=\"1\" cellpadding=\"1\" border=\"1\">" +
                "\t<thead>" +
                "\t\t<tr>" +
                "\t\t\t<th scope=\"col\">Operator</th>" +
                "\t\t\t<th scope=\"col\">Meaning</th>" +
                "\t\t\t<th scope=\"col\">Expression</th>" +
                "\t\t\t<th scope=\"col\">Translates to</th>" +
                "\t\t</tr>" +
                "\t</thead>" +
                "\t<tbody>" +
                "\t\t<tr>" +
                "\t\t\t<td>&gt;</td>" +
                "\t\t\t<td>greater than</td>" +
                "\t\t\t<td>a &gt; b</td>" +
                "\t\t\t<td>a.compareTo(b) &gt; 0</td>" +
                "\t\t</tr>" +
                "\t\t<tr>" +
                "\t\t\t<td>&lt;</td>" +
                "\t\t\t<td>less than</td>" +
                "\t\t\t<td>a &lt; b</td>" +
                "\t\t\t<td>a.compareTo(b) &lt; 0</td>" +
                "\t\t</tr>" +
                "\t\t<tr>" +
                "\t\t\t<td>&gt;=</td>" +
                "\t\t\t<td>greater than or equals to</td>" +
                "\t\t\t<td>a &gt;= b</td>" +
                "\t\t\t<td>a.compareTo(b) &gt;= 0</td>" +
                "\t\t</tr>" +
                "\t\t<tr>" +
                "\t\t\t<td>&lt;=</td>" +
                "\t\t\t<td>less than or equals to</td>" +
                "\t\t\t<td>a &lt; = b</td>" +
                "\t\t\t<td>a.compareTo(b) &lt;= 0</td>" +
                "\t\t</tr>" +
                "\t\t<tr>" +
                "\t\t\t<td>==</td>" +
                "\t\t\t<td>is equal to</td>" +
                "\t\t\t<td>a == b</td>" +
                "\t\t\t<td>a?.equals(b) ?: (b === null)</td>" +
                "\t\t</tr>" +
                "\t\t<tr>" +
                "\t\t\t<td>!=</td>" +
                "\t\t\t<td>not equal to</td>" +
                "\t\t\t<td>a != b</td>" +
                "\t\t\t<td>!(a?.equals(b) ?: (b === null))</td>" +
                "\t\t</tr>" +
                "\t</tbody>" +
                "</table>"

        webView.loadDataWithBaseURL(null, htmlAsString, "text/html", "utf-8", null);
        val webView2 = v.findViewById<View>(R.id.webView2) as WebView
        var htmlAsString2  = "<p>Comparison and equality operators are used in control flow such as <em>if expression</em>, <em>when expression</em>, and <em>loops</em>.</p>" +
                "" +
                "<hr>" +
                "<h3><a id=\"comparison-equality-example\" name=\"comparison-equality-example\"></a>Example: Comparison and Equality Operators</h3>" +
                "" +
                "<pre style=\"background-color:#aaa\"><code style=\"background-color:#aaa\"><span class=\"pln\">fun main</span><span class=\"pun\">(</span><span class=\"pln\">args</span><span class=\"pun\">:</span><span class=\"pln\"> </span><span class=\"typ\">Array</span><span class=\"pun\">&lt;</span><span class=\"typ\">String</span><span class=\"pun\">&gt;)</span><span class=\"pln\"> </span><span class=\"pun\">{</span><span class=\"pln\">" +
                "" +
                "    val a </span><span class=\"pun\">=</span><span class=\"pln\"> </span><span class=\"pun\">-</span><span class=\"lit\">12</span><span class=\"pln\">" +
                "    val b </span><span class=\"pun\">=</span><span class=\"pln\"> </span><span class=\"lit\">12</span><span class=\"pln\">" +
                "" +
                "    </span><span class=\"com\">// use of greater than operator</span><span class=\"pln\">" +
                "    val max </span><span class=\"pun\">=</span><span class=\"pln\"> </span><span class=\"kwd\">if</span><span class=\"pln\"> </span><span class=\"pun\">(</span><span class=\"pln\">a </span><span class=\"pun\">&gt;</span><span class=\"pln\"> b</span><span class=\"pun\">)</span><span class=\"pln\"> </span><span class=\"pun\">{</span><span class=\"pln\">" +
                "        println</span><span class=\"pun\">(</span><span class=\"str\">\"a is larger than b.\"</span><span class=\"pun\">)</span><span class=\"pln\">" +
                "        a" +
                "    </span><span class=\"pun\">}</span><span class=\"pln\"> </span><span class=\"kwd\">else</span><span class=\"pln\"> </span><span class=\"pun\">{</span><span class=\"pln\">" +
                "        println</span><span class=\"pun\">(</span><span class=\"str\">\"b is larger than a.\"</span><span class=\"pun\">)</span><span class=\"pln\">" +
                "        b" +
                "    </span><span class=\"pun\">}</span><span class=\"pln\">" +
                "" +
                "    println</span><span class=\"pun\">(</span><span class=\"str\">\"max = max\"</span><span class=\"pun\">)</span><span class=\"pln\">" +
                "</span><span class=\"pun\">}</span></code>" +
                "</pre>" +
                "" +
                "<p></p>" +
                "</div><div class=\"clearfix\"></div><p>When you run the program, the output will be:</p>" +
                "" +
                "<pre style=\"background-color:#aaa\"><samp>b is larger than a." +
                "max = 12</samp>" +
                "</pre>" +
                "" +
                "<p><strong>Recommended Reading:</strong> <em>Overloading of Comparison and Equality Operators in Kotlin</em></p>" +
                "" +
                "<hr>" +
                "<h2><a id=\"logical\" name=\"logical\"></a>5. Logical Operators</h2>" +
                "" +
                "<p>There are two logical operators in Kotlin: <code style=\"background-color:#aaa\">||</code> and <code style=\"background-color:#aaa\">&amp;&amp;</code></p>" +
                "" +
                "<p>Here's a table of logical operators, their meaning, and corresponding functions.</p>"+
                "" +
                "<table style=\"width:500px;\" cellspacing=\"1\" cellpadding=\"1\" border=\"1\">" +
                "\t<thead>" +
                "\t\t<tr>" +
                "\t\t\t<th scope=\"col\">Operator</th>" +
                "\t\t\t<th scope=\"col\">Description</th>" +
                "\t\t\t<th scope=\"col\">Expression</th>" +
                "\t\t\t<th scope=\"col\">Corresponding Function</th>" +
                "\t\t</tr>" +
                "\t</thead>" +
                "\t<tbody>" +
                "\t\t<tr>" +
                "\t\t\t<td>||</td>" +
                "\t\t\t<td><code style=\"background-color:#aaa\">true</code> if either of the Boolean expression is <code style=\"background-color:#aaa\">true</code></td>" +
                "\t\t\t<td><code style=\"background-color:#aaa\">(a&gt;b)||(a&lt;c)</code></td>" +
                "\t\t\t<td><code style=\"background-color:#aaa\">(a&gt;b)or(a&lt;c)</code></td>" +
                "\t\t</tr>" +
                "\t\t<tr>" +
                "\t\t\t<td>&amp;&amp;</td>" +
                "\t\t\t<td>true if all Boolean expressions are <code style=\"background-color:#aaa\">true</code></td>" +
                "\t\t\t<td><code style=\"background-color:#aaa\">(a&gt;b)&amp;&amp;(a&lt;c)</code></td>" +
                "\t\t\t<td><code style=\"background-color:#aaa\">(a&gt;b)and(a&lt;c)</code></td>" +
                "\t\t</tr>" +
                "\t</tbody>" +
                "</table>"+
                "<p>Note that, <code style=\"background-color:#aaa\">or</code> and <code style=\"background-color:#aaa\">and</code> are functions that support <a href=\"https://en.wikipedia.org/wiki/Infix_notation\">infix notation</a>.</p>" +
                "" +
                "<p>Logical operators are used in control flow such as <em>if expression</em>, <em>when expression</em>, and <em>loops</em>.</p>" +
                "" +
                "<hr>" +
                "<h3><a id=\"logical-example\" name=\"logical-example\"></a>Example: Logical Operators</h3>" +
                "" +
                "<pre style=\"background-color:#aaa\"><code style=\"background-color:#aaa\"><span class=\"pln\">fun main</span><span class=\"pun\">(</span><span class=\"pln\">args</span><span class=\"pun\">:</span><span class=\"pln\"> </span><span class=\"typ\">Array</span><span class=\"pun\">&lt;</span><span class=\"typ\">String</span><span class=\"pun\">&gt;)</span><span class=\"pln\"> </span><span class=\"pun\">{</span><span class=\"pln\">" +
                "" +
                "    val a </span><span class=\"pun\">=</span><span class=\"pln\"> </span><span class=\"lit\">10</span><span class=\"pln\">" +
                "    val b </span><span class=\"pun\">=</span><span class=\"pln\"> </span><span class=\"lit\">9</span><span class=\"pln\">" +
                "    val c </span><span class=\"pun\">=</span><span class=\"pln\"> </span><span class=\"pun\">-</span><span class=\"lit\">1</span><span class=\"pln\">" +
                "    val result</span><span class=\"pun\">:</span><span class=\"pln\"> </span><span class=\"typ\">Boolean</span><span class=\"pln\">" +
                "" +
                "    </span><span class=\"com\">// result is true is a is largest</span><span class=\"pln\">" +
                "    result </span><span class=\"pun\">=</span><span class=\"pln\"> </span><span class=\"pun\">(</span><span class=\"pln\">a</span><span class=\"pun\">&gt;</span><span class=\"pln\">b</span><span class=\"pun\">)</span><span class=\"pln\"> </span><span class=\"pun\">&amp;&amp;</span><span class=\"pln\"> </span><span class=\"pun\">(</span><span class=\"pln\">a</span><span class=\"pun\">&gt;</span><span class=\"pln\">c</span><span class=\"pun\">)</span><span class=\"pln\"> </span><span class=\"com\">// result = (a&gt;b) and (a&gt;c)</span><span class=\"pln\">" +
                "    println</span><span class=\"pun\">(</span><span class=\"pln\">result</span><span class=\"pun\">)</span><span class=\"pln\">" +
                "</span><span class=\"pun\">}</span></code></pre>" +
                "" +
                "<p>When you run the program, the output will be:</p>" +
                "" +
                "<pre style=\"background-color:#aaa\">true</pre>" +
                "" +
                "<p><strong>Recommended Reading:</strong> <em>Overloading of Logical&nbsp;Operators in Kotlin</em></p>" +
                "" +
                "<hr>" +
                "<h2><a id=\"in\" name=\"in\"></a>6. in Operator</h2>" +
                "" +
                "<p>The <code style=\"background-color:#aaa\">in</code> operator is used to check whether an object belongs to a collection.</p>"+
                "<table style=\"width:500px;\" cellspacing=\"1\" cellpadding=\"1\" border=\"1\">" +
                "\t<thead>" +
                "\t\t<tr>" +
                "\t\t\t<th scope=\"col\">Operator</th>" +
                "\t\t\t<th scope=\"col\">Expression</th>" +
                "\t\t\t<th scope=\"col\">Translates to</th>" +
                "\t\t</tr>" +
                "\t</thead>" +
                "\t<tbody>" +
                "\t\t<tr>" +
                "\t\t\t<td>in</td>" +
                "\t\t\t<td>a in b</td>" +
                "\t\t\t<td>b.contains(a)</td>" +
                "\t\t</tr>" +
                "\t\t<tr>" +
                "\t\t\t<td>!in</td>" +
                "\t\t\t<td>a !in b</td>" +
                "\t\t\t<td>!b.contains(a)</td>" +
                "\t\t</tr>" +
                "\t</tbody>" +
                "</table>" +
                "" +
                "<hr>" +
                "<h3><a id=\"in-example\" name=\"in-example\"></a>Example: in Operator</h3>"+
                "<pre style=\"background-color:#aaa\"><code style=\"background-color:#aaa\"><span class=\"pln\">fun main</span><span class=\"pun\">(</span><span class=\"pln\">args</span><span class=\"pun\">:</span><span class=\"pln\"> </span><span class=\"typ\">Array</span><span class=\"pun\">&lt;</span><span class=\"typ\">String</span><span class=\"pun\">&gt;)</span><span class=\"pln\"> </span><span class=\"pun\">{</span><span class=\"pln\">"+
                "val numbers </span><span class=\"pun\">=</span><span class=\"pln\"> intArrayOf</span><span class=\"pun\">(</span><span class=\"lit\">1</span><span class=\"pun\">,</span><span class=\"pln\"> </span><span class=\"lit\">4</span><span class=\"pun\">,</span><span class=\"pln\"> </span><span class=\"lit\">42</span><span class=\"pun\">,</span><span class=\"pln\"> </span><span class=\"pun\">-</span><span class=\"lit\">3</span><span class=\"pun\">)</span><span class=\"pln\">" +
                "</span><span class=\"kwd\">if</span><span class=\"pln\"> </span><span class=\"pun\">(</span><span class=\"lit\">4</span><span class=\"pln\"> </span><span class=\"kwd\">in</span><span class=\"pln\"> numbers</span><span class=\"pun\">)</span><span class=\"pln\"> </span><span class=\"pun\">{</span><span class=\"pln\">" +
                "println</span><span class=\"pun\">(</span><span class=\"str\">\"numbers array contains 4.\"</span><span class=\"pun\">)</span><span class=\"pln\">" +
                "</span><span class=\"pun\">}</span><span class=\"pln\">" +
                "</span><span class=\"pun\">}</span></code></pre>"+
                "<p>When you run the program, the output will be:</p>" +
                "" +
                "<pre style=\"background-color:#aaa\"><samp>numbers array contains 4.</samp></pre>" +
                "" +
                "<p><strong>Recommended Reading:</strong> <em>Kotlin in Operator Overloading</em></p>" +
                "" +
                "<hr>" +
                "<h2><a id=\"index-access\" name=\"index-access\"></a>7. Index access Operator</h2>" +
                "" +
                "<p>Here are some expressions using index access operator with corresponding functions in Kotlin.</p>"+
                "<table>" +
                "\t<thead>" +
                "\t\t<tr>" +
                "\t\t\t<th>Expression</th>" +
                "\t\t\t<th>Translated to</th>" +
                "\t\t</tr>" +
                "\t</thead>" +
                "\t<tbody>" +
                "\t\t<tr>" +
                "\t\t\t<td><code style=\"background-color:#aaa\">a[i]</code></td>" +
                "\t\t\t<td><code style=\"background-color:#aaa\">a.get(i)</code></td>" +
                "\t\t</tr>" +
                "\t\t<tr>" +
                "\t\t\t<td><code style=\"background-color:#aaa\">a[i, n]</code></td>" +
                "\t\t\t<td><code style=\"background-color:#aaa\">a.get(i, n)</code></td>" +
                "\t\t</tr>" +
                "\t\t<tr>" +
                "\t\t\t<td><code style=\"background-color:#aaa\">a[i1, i2, ..., in]</code></td>" +
                "\t\t\t<td><code style=\"background-color:#aaa\">a.get(i1, i2, ..., in)</code></td>" +
                "\t\t</tr>" +
                "\t\t<tr>" +
                "\t\t\t<td><code style=\"background-color:#aaa\">a[i] = b</code></td>" +
                "\t\t\t<td><code style=\"background-color:#aaa\">a.set(i, b)</code></td>" +
                "\t\t</tr>" +
                "\t\t<tr>" +
                "\t\t\t<td><code style=\"background-color:#aaa\">a[i, n] = b</code></td>" +
                "\t\t\t<td><code style=\"background-color:#aaa\">a.set(i, n, b)</code></td>" +
                "\t\t</tr>" +
                "\t\t<tr>" +
                "\t\t\t<td><code style=\"background-color:#aaa\">a[i1, i2, ..., in] = b</code></td>" +
                "\t\t\t<td><code style=\"background-color:#aaa\">a.set(i1, i2, ..., in, b)</code></td>" +
                "\t\t</tr>" +
                "\t</tbody>" +
                "</table>"+
                "<h3>Example: Index access Operator</h3>" +
                "" +
                "<pre style=\"background-color:#aaa\"><code style=\"background-color:#aaa\"><span class=\"pln\">fun main</span><span class=\"pun\">(</span><span class=\"pln\">args</span><span class=\"pun\">:</span><span class=\"pln\"> </span><span class=\"typ\">Array</span><span class=\"pun\">&lt;</span><span class=\"typ\">String</span><span class=\"pun\">&gt;)</span><span class=\"pln\"> </span><span class=\"pun\">{</span><span class=\"pln\">" +
                "" +
                "    val a  </span><span class=\"pun\">=</span><span class=\"pln\"> intArrayOf</span><span class=\"pun\">(</span><span class=\"lit\">1</span><span class=\"pun\">,</span><span class=\"pln\"> </span><span class=\"lit\">2</span><span class=\"pun\">,</span><span class=\"pln\"> </span><span class=\"lit\">3</span><span class=\"pun\">,</span><span class=\"pln\"> </span><span class=\"lit\">4</span><span class=\"pun\">,</span><span class=\"pln\"> </span><span class=\"pun\">-</span><span class=\"pln\"> </span><span class=\"lit\">1</span><span class=\"pun\">)</span><span class=\"pln\">" +
                "    println</span><span class=\"pun\">(</span><span class=\"pln\">a</span><span class=\"pun\">[</span><span class=\"lit\">1</span><span class=\"pun\">])</span><span class=\"pln\">   " +
                "    a</span><span class=\"pun\">[</span><span class=\"lit\">1</span><span class=\"pun\">]=</span><span class=\"pln\"> </span><span class=\"lit\">12</span><span class=\"pln\">" +
                "    println</span><span class=\"pun\">(</span><span class=\"pln\">a</span><span class=\"pun\">[</span><span class=\"lit\">1</span><span class=\"pun\">])</span><span class=\"pln\">" +
                "</span><span class=\"pun\">}</span></code>" +
                "</pre>" +
                "<p>When you run the program, the output will be:</p>"+
                "<pre style=\"background-color:#aaa\"><samp>2" +
                "12</samp></pre>" +
                "" +
                "<p><strong>Recommended Reading:</strong> <em>Kotlin Index access operator Overloading</em></p>" +
                "" +
                "<hr>" +
                "<h2><a id=\"invoke\" name=\"invoke\"></a>8. Invoke Operator</h2>" +
                "" +
                "<p>Here are some expressions using invoke operator with corresponding functions in Kotlin.</p>" +
                "" +
                "<table>" +
                "\t<thead>" +
                "\t\t<tr>" +
                "\t\t\t<th>Expression</th>" +
                "\t\t\t<th>Translated to</th>" +
                "\t\t</tr>" +
                "\t</thead>" +
                "\t<tbody>" +
                "\t\t<tr>" +
                "\t\t\t<td><code style=\"background-color:#aaa\">a()</code></td>" +
                "\t\t\t<td><code style=\"background-color:#aaa\">a.invoke()</code></td>" +
                "\t\t</tr>" +
                "\t\t<tr>" +
                "\t\t\t<td><code style=\"background-color:#aaa\">a(i)</code></td>" +
                "\t\t\t<td><code style=\"background-color:#aaa\">a.invoke(i)</code></td>" +
                "\t\t</tr>" +
                "\t\t<tr>" +
                "\t\t\t<td><code style=\"background-color:#aaa\">a(i1, i2, ..., in)</code></td>" +
                "\t\t\t<td><code style=\"background-color:#aaa\">a.inkove(i1, i2, ..., in)</code></td>" +
                "\t\t</tr>" +
                "\t\t<tr>" +
                "\t\t\t<td><code style=\"background-color:#aaa\">a[i] = b</code></td>" +
                "\t\t\t<td><code style=\"background-color:#aaa\">a.set(i, b)</code></td>" +
                "\t\t</tr>" +
                "\t</tbody>" +
                "</table>"+
                "<p>In Kotlin, parenthesis are translated to call <code style=\"background-color:#aaa\">invoke</code> member function.</p>" +
                "" +
                "<p><strong>Recommended Reading:</strong> <em>Invoke Operator Overloading in Kotlin</em></p>" +
                "" +
                "<hr>" +
                "<h3>Bitwise Operation</h3>" +
                "" +
                "<p>Unlike Java, there are no bitwise and bitshift operators in Kotlin. To perform these task, various functions (supporting infix notation) are used:</p>"+
                "" +
                "<ul>" +
                "\t<li><code style=\"background-color:#aaa\">shl</code> - Signed shift left</li>" +
                "\t<li><code style=\"background-color:#aaa\">shr</code> - Signed shift right</li>" +
                "\t<li><code style=\"background-color:#aaa\">ushr</code> - Unsigned shift right</li>" +
                "\t<li><code style=\"background-color:#aaa\">and</code> - Bitwise and</li>" +
                "\t<li><code style=\"background-color:#aaa\">or</code> - Bitwise or</li>" +
                "\t<li><code style=\"background-color:#aaa\">xor</code> - Bitwise xor</li>" +
                "\t<li><code style=\"background-color:#aaa\">inv</code> - Bitwise inversion</li>" +
                "</ul>"+
                "<hr>"+"Read the full tutorial about kotlin <a href=\"https://www.programiz.com/kotlin-programming#tutorial\" title=\"Java Keywords and Identifiers\">here</a>"

        webView2.loadDataWithBaseURL(null, htmlAsString2, "text/html", "utf-8", null);

        return v
    }


}
