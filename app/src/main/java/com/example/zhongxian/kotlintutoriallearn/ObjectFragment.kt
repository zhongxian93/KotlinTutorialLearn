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


class ObjectFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val v = inflater.inflate(R.layout.fragment_object, container, false)
        val webView = v.findViewById<View>(R.id.webView_object) as WebView
        var htmlAsString  = "<style>\n" +
                "pre {background-color:#aaa}\n" +
                "code {background-color:#aaa}\n" +
                "</style>" + "<h1>Kotlin Class and Objects</h1><p>Kotlin supports both functional and object-oriented programming.</p>\n" +
                "\n" +
                "<p>Kotlin supports features such as <em>higher-order functions</em>, <em>function types</em> and <em>lambdas</em> which makes it a great choice for working in functional programming style. You will learn about these concept in later chapters. This article will focus on object-oriented style of programming in Kotlin.</p>\n" +
                "\n" +
                "<hr />\n" +
                "<h2><a id=\"oop\" name=\"oop\"></a>Object-oriented Programming (OOP)</h2>\n" +
                "\n" +
                "<p>In object-oriented style of programming, you can divide a complex problem into smaller sets by creating objects.</p>\n" +
                "\n" +
                "<p>These objects share two characteristics:</p>\n" +
                "\n" +
                "<ul>\n" +
                "\t<li>state</li>\n" +
                "\t<li>behavior</li>\n" +
                "</ul>\n" +
                "\n" +
                "<p>Let&#39;s take few examples:</p>\n" +
                "\n" +
                "<ol>\n" +
                "\t<li><var>Lamp</var> is an object\n" +
                "\n" +
                "\t\t<ul>\n" +
                "\t\t\t<li>It can be in <var>on</var> or <var>off</var> state.</li>\n" +
                "\t\t\t<li>You can <code>turn on</code> and <code>turn off</code> lamp (behavior).</li>\n" +
                "\t\t</ul>\n" +
                "\t</li>\n" +
                "\t<li><var>Bicycle</var> is an object\n" +
                "\t\t<ul>\n" +
                "\t\t\t<li>It has <var>current gear</var>, <var>two wheels</var>, <var>number of gear</var> etc. states.</li>\n" +
                "\t\t\t<li>It has <var>braking</var>, <var>accelerating</var>, <var>changing gears</var> etc. behavior.</li>\n" +
                "\t\t</ul>\n" +
                "\t</li>\n" +
                "</ol>\n" +
                "\n" +
                "<p>You will learn about detail features of an object-oriented programming like: <em>data encapsulation</em>, <em>inheritance</em> and <em>polymorphism</em> as we go on. This article will focus on the basics to keep things simple.</p>\n" +
                "\n" +
                "<p><strong>Recommended reading:</strong> <a href=\"https://docs.oracle.com/javase/tutorial/java/concepts/object.html\">What is an object?</a></p>\n" +
                "\n" +
                "<hr />\n" +
                "<h2><a id=\"class\" name=\"class\"></a>Kotlin Class</h2>\n" +
                "\n" +
                "<p>Before you create objects in Kotlin, you need to define a class.</p>\n" +
                "\n" +
                "<p>A class is a blueprint for the object.</p>\n" +
                "\n" +
                "<p>We can think of class as a sketch (prototype) of a house. It contains all the details about the floors, doors, windows etc. Based on these descriptions we build the house. House is the object.</p>\n" +
                "\n" +
                "<p>Since, many houses can be made from the same description, we can create many objects from a class.</p>\n" +
                "\n" +
                "<hr />\n" +
                "<h3><a id=\"define-class\" name=\"define-class\"></a>How to define a class in Kotlin?</h3>\n" +
                "\n" +
                "<p>To define a class in Kotlin, <code>class</code> keyword is used:</p>\n" +
                "\n" +
                "<pre>\n" +
                "class ClassName {\n" +
                "    // property\n" +
                "    // member function\n" +
                "    ... .. ...\n" +
                "}\n" +
                "</pre>\n" +
                "\n" +
                "<p>Here&#39;s an example:</p>\n" +
                "\n" +
                "<pre>\n" +
                "class Lamp {\n" +
                "\n" +
                "    // property (data member)\n" +
                "    private var isOn: Boolean = false\n" +
                "\n" +
                "    // member function\n" +
                "    fun turnOn() {\n" +
                "        isOn = true\n" +
                "    }\n" +
                "\n" +
                "    // member function\n" +
                "    fun turnOff() {\n" +
                "        isOn = false\n" +
                "    }\n" +
                "}</pre>\n" +
                "\n" +
                "<p>Here, we defined a class named <var>Lamp</var>.</p>\n" +
                "\n" +
                "<p>The class has one property <var>isOn</var> (defined in same way as variable), and two member functions <code>turnOn()</code> and <code>turnOff()</code>.</p>\n" +
                "\n" +
                "<p><strong>Recommended Reading:</strong> <a href=\"https://kotlinlang.org/docs/reference/functions.html\" title=\"Kotlin functions\">Kotlin functions</a></p>\n" +
                "\n" +
                "<p>In Kotlin, either the property must be initialized or must be declared <code>abstract</code> (<strong>Visit:</strong> <em>Kotlin Abstract Class</em> to learn more). In the above example, <var>isOn</var> property is initialized to <code>false</code>.</p>\n" +
                "\n" +
                "<hr />\n" +
                "<p><a id=\"access-modifiers\" name=\"access-modifiers\"></a>Classes, objects, properties, member function etc. can have visibility modifiers. For example, the <var>isOn</var> property is private. This means, the <var>isOn</var> property can be changed from only inside the <var>Lamp</var> class.</p>\n" +
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
                "</div><div class=\"clearfix\"></div><p>Other visibility modifiers are:</p>\n" +
                "\n" +
                "<ul>\n" +
                "\t<li><code>private</code> - visible (can be accessed) from inside the class only.</li>\n" +
                "\t<li><code>public</code> - visible everywhere.</li>\n" +
                "\t<li><code>protected</code> - visible to the class and its subclass.</li>\n" +
                "\t<li><code>internal</code> - any client inside the module can access them.</li>\n" +
                "</ul>\n" +
                "\n" +
                "<p>You will learn about <code>protected</code> and <code>internal</code> modifiers later in <a href=\"/kotlin-programming/visibility-modifiers\" title=\"Kotlin visibility modifiers\">Kotlin visibility modifiers</a> article.</p>\n" +
                "\n" +
                "<p>If you do not specify the visibility modifier, it will be <code>public</code> by default.</p>\n" +
                "\n" +
                "<p>In the above program, <code>turnOn()</code> and <code>turnOff()</code> member functions are <code>public</code> whereas, <var>isOn</var> property is private.</p>\n" +
                "\n" +
                "<hr />\n" +
                "<h3><a id=\"objects\" name=\"objects\"></a>Kotlin Objects</h3>\n" +
                "\n" +
                "<p>When class is defined, only the specification for the object is defined; no memory or storage is allocated.</p>\n" +
                "\n" +
                "<p>To access members defined within the class, you need to create objects. Let&#39;s create objects of <var>Lamp</var> class.</p>\n" +
                "\n" +
                "<pre>\n" +
                "<code>class Lamp {\n" +
                "\n" +
                "    // property (data member)\n" +
                "    private var isOn: Boolean = false\n" +
                "\n" +
                "    // member function\n" +
                "    fun turnOn() {\n" +
                "        isOn = true\n" +
                "    }\n" +
                "\n" +
                "    // member function\n" +
                "    fun turnOff() {\n" +
                "        isOn = false\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "fun main(args: Array&lt;String&gt;) {\n" +
                "\n" +
                "    val l1 = Lamp() // create l1 object of Lamp class\n" +
                "    val l2 = Lamp() // create l2 object of Lamp class\n" +
                "}</code></pre>\n" +
                "\n" +
                "<p>This program creates two objects <var>l1</var> and <var>l2</var> of class <var>Lamp</var>. The <var>isOn</var> property for both lamps <var>l1</var> and <var>l2</var> will be <code>false</code>.</p>\n" +
                "\n" +
                "<hr />\n" +
                "<h3><a id=\"access-members\" name=\"access-members\"></a>How to access members?</h3>\n" +
                "\n" +
                "<p>You can access properties and member functions of a class by using <code>.</code> notation. For example,</p>\n" +
                "\n" +
                "<pre>\n" +
                "l1.turnOn()</pre>\n" +
                "\n" +
                "<p>This statement calls <var>turnOn()</var> function for <var>l1</var> object.</p>\n" +
                "\n" +
                "<p>Let&#39;s take another example:</p>\n" +
                "\n" +
                "<pre>\n" +
                "l2.isOn = true</pre>\n" +
                "\n" +
                "<p>Here, we tried to assign <code>true</code> to <var>isOn</var> property of <var>l2</var> object. Note that, <var>isOn</var> property is <code>private</code>,&nbsp;and if you try to access&nbsp;<var>isOn</var> from outside the class, an exception is thrown.</p>\n" +
                "\n" +
                "<hr />\n" +
                "<h3><a id=\"example\" name=\"example\"></a>Example: Kotlin Class and Object</h3>\n" +
                "\n" +
                "<pre>\n" +
                "<code>class Lamp {\n" +
                "\n" +
                "    // property (data member)\n" +
                "    private var isOn: Boolean = false\n" +
                "\n" +
                "    // member function\n" +
                "    fun turnOn() {\n" +
                "        isOn = true\n" +
                "    }\n" +
                "\n" +
                "    // member function\n" +
                "    fun turnOff() {\n" +
                "        isOn = false\n" +
                "    }\n" +
                "\n" +
                "    fun displayLightStatus(lamp: String) {\n" +
                "        if (isOn == true)\n" +
                "            println(&quot;\$lamp lamp is on.&quot;)\n" +
                "        else\n" +
                "            println(&quot;\$lamp lamp is off.&quot;)\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "fun main(args: Array&lt;String&gt;) {\n" +
                "\n" +
                "    val l1 = Lamp() // create l1 object of Lamp class\n" +
                "    val l2 = Lamp() // create l2 object of Lamp class\n" +
                "\n" +
                "    l1.turnOn()\n" +
                "    l2.turnOff()\n" +
                "\n" +
                "    l1.displayLightStatus(&quot;l1&quot;)\n" +
                "    l2.displayLightStatus(&quot;l2&quot;)\n" +
                "}</code></pre>\n" +
                "\n" +
                "<p>When you run the program, the output will be:</p>\n" +
                "\n" +
                "<pre>\n" +
                "<samp>l1 Lamp is on.\n" +
                "l2 Lamp is off.</samp></pre>\n" +
                "\n" +
                "<p>In the above program,</p>\n" +
                "\n" +
                "<ul>\n" +
                "\t<li><code>Lamp</code> class is created.</li>\n" +
                "\t<li>The class has a property <var>isOn</var> and three member functions <code>turnOn()</code>, <code>turnOff()</code> and <code>displayLightStatus()</code>.</li>\n" +
                "\t<li>Two objects <var>l1</var> and <var>l2</var> of <var>Lamp</var> class are created in the <code>main()</code> function.</li>\n" +
                "\t<li>Here, <code>turnOn()</code> function is called using <var>l1</var> object: <code>l1.turnOn()</code>. This method sets <var>isOn</var> instance variable of <var>l1</var> object to <code>true</code>.</li>\n" +
                "\t<li>And, <code>turnOff()</code> function is called using <var>l2</var> object: <code>l1.turnOff()</code>. This method sets <var>isOff</var> instance variable of <var>l2</var> object to <code>false</code>.</li>\n" +
                "\t<li>Then, <code>displayLightStatus()</code> function is called for <var>l1</var> and <var>l2</var> objects which prints appropriate message depending on whether <var>isOn</var> property is <var>true</var> or <code>false</code>.</li>\n" +
                "</ul>\n" +
                "\n" +
                "<p>Notice that, the <var>isOn</var> property is initialized to <code>false</code> inside the class. When an object of the class is created, <var>isOn</var> property for the object is initialized to <code>false</code> automatically. So, it&#39;s not necessary for <var>l2</var> object to call <code>turnOff()</code> to set <var>isOn</var> property to <code>false</code>.</p>\n" +
                "\n" +
                "<p>For example:</p>\n" +
                "\n" +
                "<pre>\n" +
                "<code>class Lamp {\n" +
                "\n" +
                "    // property (data member)\n" +
                "    private var isOn: Boolean = false\n" +
                "\n" +
                "    // member function\n" +
                "    fun turnOn() {\n" +
                "        isOn = true\n" +
                "    }\n" +
                "\n" +
                "    // member function\n" +
                "    fun turnOff() {\n" +
                "        isOn = false\n" +
                "    }\n" +
                "\n" +
                "    fun displayLightStatus() {\n" +
                "        if (isOn == true)\n" +
                "            println(&quot;lamp is on.&quot;)\n" +
                "        else\n" +
                "            println(&quot;lamp is off.&quot;)\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "fun main(args: Array&lt;String&gt;) {\n" +
                "\n" +
                "    val lamp = Lamp()\n" +
                "    lamp.displayLightStatus()\n" +
                "}</code>\n" +
                "</pre>\n" +
                "\n" +
                "<p>When you run the program, the output will be:</p>\n" +
                "\n" +
                "<pre>\n" +
                "<samp>lamp is off.</samp></pre>" +
                "<hr />Read the full tutorial about kotlin <a href=\\\"https://www.programiz.com/kotlin-programming#tutorial\\\" title=\\\"Java Keywords and Identifiers\\\">here</a>"
        webView.loadDataWithBaseURL(null, htmlAsString, "text/html", "utf-8", null);
        return v
    }


}
